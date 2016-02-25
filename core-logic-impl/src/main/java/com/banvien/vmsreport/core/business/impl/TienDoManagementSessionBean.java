package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.TienDoBeanUtil;
import com.banvien.vmsreport.core.data.entity.*;
import com.banvien.vmsreport.core.data.session.*;
import com.banvien.vmsreport.mailer.EmailLocalBean;
import org.antlr.stringtemplate.AutoIndentWriter;
import org.apache.commons.lang.StringUtils;

import javax.ejb.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Stateless(name = "TienDoManagementSessionEJB")
public class TienDoManagementSessionBean implements TienDoManagementLocalBean {
    @EJB
    private TienDoLocalBean tienDoService;

    @EJB
    private KinhPhiLocalBean kinhPhiService;

    @EJB
    private DangBaoLocalBean dangBaoService;

    @EJB
    private BidLocalBean bidService;

    @EJB
    private DMTinhTrangLocalBean dmTinhTrangService;

    @EJB
    private GoithauNhathauLocalBean goithauNhathauService;

    @EJB
    private HoSoThauLocalBean hoSoThauService;

    @EJB
    private UserLocalBean userLocalBean;

    @EJB
    private UserACLLocalBean userACLLocalBean;

    @EJB
    private DataActionLocalBean dataActionLocalBean;

    @EJB
    private EmailLocalBean emailLocalBean;

    @Override
    public TienDoDTO updateItem(TienDoDTO dto, Long userId, List<KinhphiDTO> listkp, List<DangBaoDTO> list_ndb) throws ObjectNotFoundException, DuplicateKeyException, RemoveException {
        TiendoEntity entity = this.tienDoService.findById(dto.getMstiendo());
        return DozerSingletonMapper.getInstance().map(saveOrUpdateTienDo(userId, entity, dto, listkp, list_ndb), TienDoDTO.class);
    }

    private void updateNhaThauTrungThau(GoithauEntity entity, HoSoThauDTO hoSoThauDTO) {
        resetNhaThauTrungThau(entity.getMsgoithau());
        if(hoSoThauDTO != null && hoSoThauDTO.getMshosothau() != null && hoSoThauDTO.getMshosothau() > -1l){
            updateTrungThauNhaThau(hoSoThauDTO.getMshosothau());
        }
    }

    private void resetNhaThauTrungThau(Long msgoithau) {
        this.goithauNhathauService.resetNhaThauTrungThau(msgoithau);
    }

    private void updateTrungThauNhaThau(Long msNTTT){
        this.goithauNhathauService.updateTrungThauNhaThau(msNTTT);
    }

    private void updateDSNgayDangBao(TiendoEntity entity, List<DangBaoDTO> list_ndb) throws DuplicateKeyException, RemoveException {
        List<DangbaoEntity> listOldEntities = this.dangBaoService.findByGoiThau(entity.getGoithau().getMsgoithau());
        Map<Long, DangbaoEntity> mapOldNDB = new HashMap<>();
        for(DangbaoEntity dangbaoEntity : listOldEntities){
            mapOldNDB.put(dangbaoEntity.getMsdangbao(), dangbaoEntity);
        }
        if(list_ndb != null && list_ndb.size() > 0){
            for(DangBaoDTO dangBaoDTO : list_ndb){
                if((dangBaoDTO != null) && (dangBaoDTO.getSocongvan() != null)){
                    DangbaoEntity dangbaoEntity = DozerSingletonMapper.getInstance().map(dangBaoDTO, DangbaoEntity.class);
                    dangbaoEntity.setGoithau(entity.getGoithau());
                    if(dangbaoEntity.getMsdangbao() != null){
                        this.dangBaoService.update(dangbaoEntity);
                        mapOldNDB.remove(dangbaoEntity.getMsdangbao());
                    }else{
                        this.dangBaoService.save(dangbaoEntity);
                    }
                }
            }
        }
        for (Long key : mapOldNDB.keySet()) {
            this.dangBaoService.delete(key);
        }
    }

    private void updateDSKinhPhi(TiendoEntity entity, List<KinhphiDTO> listkp) throws DuplicateKeyException, RemoveException {
        List<KinhphiEntity> listOldEntities = this.kinhPhiService.findByGoiThau(entity.getGoithau().getMsgoithau());
        Map<Long, KinhphiEntity> mapOldKp = new HashMap<>();
        for(KinhphiEntity kinhphiEntity : listOldEntities){
            mapOldKp.put(kinhphiEntity.getMskinhphi(), kinhphiEntity);
        }
        if(listkp != null && listkp.size() > 0){
            for(KinhphiDTO kinhphiDTO : listkp){
                if((kinhphiDTO != null) && (kinhphiDTO.getThanhtien() != null)){
                    KinhphiEntity kinhphiEntity = DozerSingletonMapper.getInstance().map(kinhphiDTO, KinhphiEntity.class);
                    kinhphiEntity.setGoithau(entity.getGoithau());
                    if(kinhphiEntity.getMskinhphi() != null){
                        this.kinhPhiService.update(kinhphiEntity);
                        mapOldKp.remove(kinhphiEntity.getMskinhphi());
                    }else{
                        this.kinhPhiService.save(kinhphiEntity);
                    }
                }
            }
        }
        for (Long key : mapOldKp.keySet()) {
            this.kinhPhiService.delete(key);
        }
    }

    @Override
    public TienDoDTO addItem(TienDoDTO dto, Long userId, List<KinhphiDTO> listkp, List<DangBaoDTO> list_ndb) throws ObjectNotFoundException, DuplicateKeyException, RemoveException {
        return DozerSingletonMapper.getInstance().map(saveOrUpdateTienDo(userId, null, dto, listkp, list_ndb), TienDoDTO.class);
    }

    private TiendoEntity saveOrUpdateTienDo(Long userId, TiendoEntity tiendoEntity, TienDoDTO tienDoDTO, List<KinhphiDTO> listkp, List<DangBaoDTO> list_ndb) throws ObjectNotFoundException, RemoveException, DuplicateKeyException {
        TiendoEntity newTienDo = tiendoEntity;
        GoithauEntity goithau = this.bidService.findById(tienDoDTO.getGoithau().getMsgoithau());

        if(isXetThau(userId, goithau)){
            newTienDo = DozerSingletonMapper.getInstance().map(tienDoDTO, TiendoEntity.class);
            newTienDo = resetValueOfThamDinh(newTienDo, tiendoEntity);
            updateStatusGoiThau(newTienDo, goithau);
            if(newTienDo.getMstiendo() == null){
                newTienDo.setEditer("1");
                newTienDo = tienDoService.save(newTienDo);
            }else{
                newTienDo = tienDoService.update(newTienDo);
            }
            updateNhaThauTrungThau(newTienDo.getGoithau(), tienDoDTO.getHoSoThau());
            updateDSKinhPhi(newTienDo, listkp);
            updateDSNgayDangBao(newTienDo, list_ndb);
        }

        if(isThamDinh(userId, goithau)){

            if(newTienDo == null){
                newTienDo = new TiendoEntity();
                newTienDo.setGoithau(goithau);
            }
            newTienDo = setValueOfThamDinh(newTienDo, tienDoDTO);
            updateStatusGoiThau(newTienDo, goithau);
            if(newTienDo.getMstiendo() == null){
                newTienDo.setEditer("1");
                newTienDo = tienDoService.save(newTienDo);
            }else{
                newTienDo = tienDoService.update(newTienDo);
            }
        }
        return newTienDo;
    }

    private TiendoEntity setValueOfThamDinh(TiendoEntity newTienDo, TienDoDTO tienDoDTO) {
        newTienDo.setThamDinhPASo(tienDoDTO.getThamDinhPASo());
        newTienDo.setThamDinhPANgay(tienDoDTO.getThamDinhPANgay());
        newTienDo.setQdPheDuyetSo(tienDoDTO.getQdPheDuyetSo());
        newTienDo.setQdPheDuyetNgay(tienDoDTO.getQdPheDuyetNgay());
        newTienDo.setDbKeHoachThauSo(tienDoDTO.getDbKeHoachThauSo());
        newTienDo.setDbKeHoachThauNgay(tienDoDTO.getDbKeHoachThauNgay());
        newTienDo.setBaoCaoThamDinhSo(tienDoDTO.getBaoCaoThamDinhSo());
        newTienDo.setBaoCaoThamDinhNgay(tienDoDTO.getBaoCaoThamDinhNgay());
        newTienDo.setDuyethsSo(tienDoDTO.getDuyethsSo());
        newTienDo.setDuyethsNgay(tienDoDTO.getDuyethsNgay());
        newTienDo.setBcThamDinhKetQuaSo(tienDoDTO.getBcThamDinhKetQuaSo());
        newTienDo.setBcThamDinhKetQuaNgay(tienDoDTO.getBcThamDinhKetQuaNgay());
        newTienDo.setQdPheDuyetSo(tienDoDTO.getQdPheDuyetSo());
        newTienDo.setQdPheDuyetNgay(tienDoDTO.getQdPheDuyetNgay());
        newTienDo.setDbkqLuaChonNhaThauSo(tienDoDTO.getDbkqLuaChonNhaThauSo());
        newTienDo.setDbkqLuaChonNhaThauNgay(tienDoDTO.getDbkqLuaChonNhaThauNgay());
        return newTienDo;
    }

    private TiendoEntity resetValueOfThamDinh(TiendoEntity newTienDo, TiendoEntity tiendoEntity) {
        if(tiendoEntity == null){
            newTienDo.setThamDinhPASo(null);
            newTienDo.setThamDinhPANgay(null);
            newTienDo.setQdPheDuyetSo(null);
            newTienDo.setQdPheDuyetNgay(null);
            newTienDo.setDbKeHoachThauSo(null);
            newTienDo.setDbKeHoachThauNgay(null);
            newTienDo.setBaoCaoThamDinhSo(null);
            newTienDo.setBaoCaoThamDinhNgay(null);
            newTienDo.setDuyethsSo(null);
            newTienDo.setDuyethsNgay(null);
            newTienDo.setBcThamDinhKetQuaSo(null);
            newTienDo.setBcThamDinhKetQuaNgay(null);
            newTienDo.setQdPheDuyetSo(null);
            newTienDo.setQdPheDuyetNgay(null);
            newTienDo.setDbkqLuaChonNhaThauSo(null);
            newTienDo.setDbkqLuaChonNhaThauNgay(null);
        }else{
            newTienDo.setThamDinhPASo(tiendoEntity.getThamDinhPASo());
            newTienDo.setThamDinhPANgay(tiendoEntity.getThamDinhPANgay());
            newTienDo.setQdPheDuyetSo(tiendoEntity.getQdPheDuyetSo());
            newTienDo.setQdPheDuyetNgay(tiendoEntity.getQdPheDuyetNgay());
            newTienDo.setDbKeHoachThauSo(tiendoEntity.getDbKeHoachThauSo());
            newTienDo.setDbKeHoachThauNgay(tiendoEntity.getDbKeHoachThauNgay());
            newTienDo.setBaoCaoThamDinhSo(tiendoEntity.getBaoCaoThamDinhSo());
            newTienDo.setBaoCaoThamDinhNgay(tiendoEntity.getBaoCaoThamDinhNgay());
            newTienDo.setDuyethsSo(tiendoEntity.getDuyethsSo());
            newTienDo.setDuyethsNgay(tiendoEntity.getDuyethsNgay());
            newTienDo.setBcThamDinhKetQuaSo(tiendoEntity.getBcThamDinhKetQuaSo());
            newTienDo.setBcThamDinhKetQuaNgay(tiendoEntity.getBcThamDinhKetQuaNgay());
            newTienDo.setQdPheDuyetSo(tiendoEntity.getQdPheDuyetSo());
            newTienDo.setQdPheDuyetNgay(tiendoEntity.getQdPheDuyetNgay());
            newTienDo.setDbkqLuaChonNhaThauSo(tiendoEntity.getDbkqLuaChonNhaThauSo());
            newTienDo.setDbkqLuaChonNhaThauNgay(tiendoEntity.getDbkqLuaChonNhaThauNgay());
        }
        return newTienDo;
    }

    private boolean isXetThau(Long userId, GoithauEntity goithau) throws ObjectNotFoundException {
//        UserACLEntity userACLEntity = this.userACLLocalBean.findById(userId);
        UserEntity user = this.userLocalBean.findById(userId);
        if(user.getUserGroup().getCode().equals(Constants.GROUP_TRUONGPHONG)){
            return true;
        }
        if(user.getUserGroup().getCode().equals(Constants.GROUP_XETTHAU)){
            if(goithau.getToChuyenGias() != null && goithau.getToChuyenGias().size() > 0){
                for(GoithauNhanvienEntity goithauNhanvienEntity : goithau.getToChuyenGias()){
                    if(goithauNhanvienEntity.getUser().getUserId().equals(userId)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isThamDinh(Long userId, GoithauEntity goithau) throws ObjectNotFoundException {
//        UserACLEntity userACLEntity = this.userACLLocalBean.findById(userId);
        UserEntity user = this.userLocalBean.findById(userId);
        if(user.getUserGroup().getCode().equals(Constants.GROUP_TRUONGPHONG)){
            return true;
        }
        if(user.getUserGroup().getCode().equals(Constants.GROUP_THAMDINH)){
            if(goithau.getMsnhanvienCvtd() != null && goithau.getMsnhanvienCvtd().getUserId().equals(userId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public TienDoDTO findByGoiThauId(Long goiThauId) {
        TiendoEntity entity = this.tienDoService.findByGoiThauId(goiThauId);
        TienDoDTO dto = DozerSingletonMapper.getInstance().map(entity, TienDoDTO.class);
        try{
           dto.setHoSoThau(DozerSingletonMapper.getInstance().map(this.hoSoThauService.findHoSoTrungThauByGoiThau(goiThauId), HoSoThauDTO.class));
        }catch (Exception e){

        }
        return  dto;
    }

    @Override
    public TinhtrangDTO getTinhTrangFromTienDoAndGoiThau(TienDoDTO tienDo, BidDTO goiThau) throws ObjectNotFoundException {
        DmTinhtrangEntity tinhTrang = this.tienDoService.getTinhTrangFromTienDoAndGoiThau(tienDo.getMstiendo(), goiThau.getMagoithau());
        if(tinhTrang == null) {
            throw new ObjectNotFoundException("Cannot find Tinh Trang of Tien Do " + tienDo.getMstiendo() + " and Goi thau " + goiThau.getMagoithau());
        }
        return DozerSingletonMapper.getInstance().map(tinhTrang, TinhtrangDTO.class);
    }

    @Override
    public void updateTinhTrangForAllGoiThau() throws ObjectNotFoundException, DuplicateKeyException {
        List<TiendoEntity> tienDos = this.tienDoService.findAll();
        for(TiendoEntity entity : tienDos){
            updateStatusGoiThau(entity, entity.getGoithau());
        }
    }

    private void updateStatusGoiThau(TiendoEntity entity, GoithauEntity goithau) throws DuplicateKeyException, ObjectNotFoundException {
        String code = "";

        Timestamp now = new Timestamp(System.currentTimeMillis());
        if(entity.getThongbaokqNgay() != null){
            code = Constants.GOI_THAU_HOAN_TAT;
        } else if(entity.getPheduyetkqNgay() != null){
            code = Constants.GOI_THAU_THONG_BAO_KET_QUA;
        } else if(entity.getBcThamDinhKetQuaNgay() != null){
            code = Constants.GOI_THAU_TRINH_PHE_DUYET_KET_QUA;
        } else if(entity.getTrinhkqNgay() != null){
            code = Constants.GOI_THAU_DANG_THAM_DINH_KET_QUA;
        } else if((entity.getNgaymothauL3() != null && entity.getNgaymothauL3().getTime() > now.getTime()) || (entity.getNgaymothauL2() != null && entity.getNgaymothauL2().getTime() > now.getTime())
                || (entity.getNgaymothauL1() != null && entity.getNgaymothauL1().getTime() > now.getTime())){
            code = Constants.GOI_THAU_DANG_DANH_GIA;
        } else if(goithau.getNgayDangBao() != null && goithau.getNgayDangBao().size() > 0){
            Timestamp ngayDauTienDangBaoMT = null;
            List<DangbaoEntity> listndb = entity.getGoithau().getNgayDangBao();
            if(listndb != null && listndb.size() > 0){
                ngayDauTienDangBaoMT = listndb.get(0).getNgaydangbao();
            }
            if(ngayDauTienDangBaoMT != null){
                code = Constants.GOI_THAU_DANG_MOI_THAU;
            }
        } else if(StringUtils.isNotBlank(entity.getDuyethsSo()) && entity.getDuyethsNgay() != null){
            code = Constants.GOI_THAU_CHUAN_BI_MOI_THAU;
        } else if(StringUtils.isNotBlank(entity.getBaoCaoThamDinhSo()) && entity.getBaoCaoThamDinhNgay() != null){
            code = Constants.GOI_THAU_TRINH_PHE_DUYET_HO_SO;
        } else if(StringUtils.isNotBlank(entity.getTrinhhsSo()) && entity.getTrinhhsNgay() != null){
            if(goithau.getHinhthucgt() != null &&  goithau.getHinhthucgt().getMahinhthuc() != null){
                if (goithau.getHinhthucgt().getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                    code = Constants.GOI_THAU_THAM_DINH_HO_SO_MOI_THAU;
                } else if(goithau.getHinhthucgt().getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                    code = Constants.GOI_THAU_THAM_DINH_HO_SO_MOI_CHAO_GIA_CANH_TRANH;
                } else {
                    code = Constants.GOI_THAU_THAM_DINH_HO_SO_YEU_CAU;
                }
            }
        } else if(StringUtils.isNotBlank(entity.getThamDinhPASo()) && entity.getThamDinhPANgay() != null) {
            code = Constants.GOI_THAU_TRINH_PHE_DUYET_PA;
        }
        if(code.length() > 0){
            this.bidService.updateStatusGoiThau(goithau.getMsgoithau(), this.dmTinhTrangService.findByCode(code).getMstinhtrang());
        }
    }

    @Override
    public void updateTinhTrangForGoiThauDangMoiThau(){
        List<TiendoEntity> tiendos = this.tienDoService.findByTinhTrangGoiThau(getListTinhTrangBeforeDangMoiThau());
        Long now = System.currentTimeMillis();
        DmTinhtrangEntity tinhTrangDMT = this.dmTinhTrangService.findByCode(Constants.GOI_THAU_DANG_MOI_THAU);
        for(TiendoEntity tiendo : tiendos){
            if(tinhTrangDMT != null && tinhTrangDMT.getMstinhtrang() != null && tinhTrangDMT.getMstinhtrang() >0 &&
                    (tiendo.getNgaymothauL3() != null && tiendo.getNgaymothauL3().getTime() > now)
                    || (tiendo.getNgaymothauL2() != null && tiendo.getNgaymothauL2().getTime() > now)
                    || (tiendo.getNgaymothauL2() != null && tiendo.getNgaymothauL2().getTime() > now)){
                GoithauEntity goiThau = tiendo.getGoithau();
                goiThau.setTinhtrang(tinhTrangDMT);
                this.bidService.updateStatusGoiThau(goiThau.getMsgoithau(), tinhTrangDMT.getMstinhtrang());
            }
        }
    }

    @Override
    public TienDoDTO findByMaGoiThau(String maGoiThau) throws ObjectNotFoundException {
        return TienDoBeanUtil.entity2DTO(tienDoService.findEqualUnique("goithau.magoithau", maGoiThau));  //To change body of implemented methods use File | Settings | File Templates.
    }

    private List<String> getListTinhTrangBeforeDangMoiThau(){
        List<String> result = new ArrayList<>();
        result.add(Constants.GOI_THAU_THAM_DINH_PHUONG_AN);
        result.add(Constants.GOI_THAU_TRINH_PHE_DUYET_PA);
        result.add(Constants.GOI_THAU_THAM_DINH_HO_SO_MOI_THAU);
        result.add(Constants.GOI_THAU_THAM_DINH_HO_SO_MOI_CHAO_GIA_CANH_TRANH);
        result.add(Constants.GOI_THAU_THAM_DINH_HO_SO_YEU_CAU);
        result.add(Constants.GOI_THAU_TRINH_PHE_DUYET_HO_SO);
        result.add(Constants.GOI_THAU_CHUAN_BI_MOI_THAU);
        result.add(Constants.GOI_THAU_DANG_MOI_THAU);
        return result;
    }

    @Override
    public void autoSendMessageForRelativeUser(){
        // MAP <UserId, List<Ma GoiThau>
        Map<Long, List<String>> goiThauThamDinhPhuongAn = new HashMap<>();
        Map<Long, List<String>> goiThauTrinhPheDuyetPhuongAn = new HashMap<>();
        Map<Long, List<String>> goiThauThanhLapToChuyenGia = new HashMap<>();
        Map<Long, List<String>> goiThauTrinhPheDuyetHoSo = new HashMap<>();
        Map<Long, List<String>> goiThauThamDinhHoSoMoiThau = new HashMap<>();
        Map<Long, List<String>> goiThauPheDuyetHoSo = new HashMap<>();
        Map<Long, List<String>> goiThauDangMoiThau = new HashMap<>();
        Map<Long, List<String>> goiThauPhatHanhHoSo = new HashMap<>();
        Map<Long, List<String>> goiThauMoThau = new HashMap<>();
        Map<Long, List<String>> goiThauTrinhKetQua = new HashMap<>();
        Map<Long, List<String>> goiThauThamDinhKetQua = new HashMap<>();
        Map<Long, List<String>> goiThauTrinhPheDuyetKetQua = new HashMap<>();
        Map<Long, List<String>> goiThauThongBaoKetQua = new HashMap<>();

        List<UserEntity> listUserRelative = new ArrayList<>();

        List<TiendoEntity> tiendos = this.tienDoService.findListTienDoNotComplete(Constants.GOI_THAU_HOAN_TAT);

        if(tiendos != null && tiendos.size() > 0){
            for(TiendoEntity tiendo : tiendos){
                if(tiendo.getGoithau() != null && tiendo.getGoithau().getMsgoithau() != null && tiendo.getGoithau().getMsgoithau() > 0
                        && tiendo.getGoithau().getHinhthucgt() != null && tiendo.getGoithau().getHinhthucgt().getMshinhthuc() != null
                        && tiendo.getGoithau().getHinhthucgt().getMshinhthuc() > 0){
                    try{
                        getMapGoiThauByHinhThuc(tiendo, listUserRelative, goiThauThamDinhPhuongAn, goiThauTrinhPheDuyetPhuongAn, goiThauThanhLapToChuyenGia,
                                goiThauTrinhPheDuyetHoSo, goiThauThamDinhHoSoMoiThau, goiThauPheDuyetHoSo, goiThauDangMoiThau, goiThauPhatHanhHoSo,
                                goiThauMoThau, goiThauTrinhKetQua, goiThauThamDinhKetQua, goiThauTrinhPheDuyetKetQua, goiThauThongBaoKetQua);
                    }catch (ParseException e) {

                    }

                }
            }
        }

        for(UserEntity user: listUserRelative){
            String emailMessage = "";
            String smsMessage = "";
            List<String> thamDinhPhuongAn = goiThauThamDinhPhuongAn.get(user.getUserId());
            List<String> trinhPheDuyetPhuongAn = goiThauTrinhPheDuyetPhuongAn.get(user.getUserId());
            List<String> thanhLapToChuyenGia = goiThauThanhLapToChuyenGia.get(user.getUserId());
            List<String> trinhPheDuyetHoSo = goiThauTrinhPheDuyetHoSo.get(user.getUserId());
            List<String> thamDinhHoSoMoiThau = goiThauThamDinhHoSoMoiThau.get(user.getUserId());
            List<String> pheDuyetHoSo = goiThauPheDuyetHoSo.get(user.getUserId());
            List<String> dangMoiThau = goiThauDangMoiThau.get(user.getUserId());
            List<String> phatHanhHoSo = goiThauPhatHanhHoSo.get(user.getUserId());
            List<String> moThau = goiThauMoThau.get(user.getUserId());
            List<String> trinhKetQua = goiThauTrinhKetQua.get(user.getUserId());
            List<String> thamDinhKetQua = goiThauThamDinhKetQua.get(user.getUserId());
            List<String> trinhPheDuyetKetQua = goiThauTrinhPheDuyetKetQua.get(user.getUserId());
            List<String> thongBaoKetQua = goiThauThongBaoKetQua.get(user.getUserId());

            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, thamDinhPhuongAn, "Cac goi thau can tham dinh phuong an");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, trinhPheDuyetPhuongAn, "Cac goi thau can trinh phe duyet phuong an");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, thanhLapToChuyenGia, "Cac goi thau can thanh lap to chuyen gia");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, trinhPheDuyetHoSo, "Cac goi thau can trinh phe duyet ho so");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, thamDinhHoSoMoiThau, "Cac goi thau can tham dinh ho so moi thau");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, pheDuyetHoSo, "Cac goi thau can phe duyet ho so moi thau");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, dangMoiThau, "Cac goi thau can dang moi thau");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, phatHanhHoSo, "Cac goi thau can phat hanh ho so");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, moThau, "Cac goi thau can mo thau");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, trinhKetQua, "Cac goi thau can trinh ket qua");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, thamDinhKetQua, "Cac goi thau can tham dinh ket qua");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, trinhPheDuyetKetQua, "Cac goi thau can phe duyet ket qua");
            emailMessage = getMessageFromDanhSachGoiThau(emailMessage, thongBaoKetQua, "Cac goi thau can thong bao ket qua");

            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, thamDinhPhuongAn, "Cac goi thau can tham dinh phuong an");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, trinhPheDuyetPhuongAn, "Cac goi thau can trinh phe duyet phuong an");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, thanhLapToChuyenGia, "Cac goi thau can thanh lap to chuyen gia");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, trinhPheDuyetHoSo, "Cac goi thau can trinh phe duyet ho so");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, thamDinhHoSoMoiThau, "Cac goi thau can tham dinh ho so moi thau");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, pheDuyetHoSo, "Cac goi thau can phe duyet ho so moi thau");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, dangMoiThau, "Cac goi thau can dang moi thau");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, phatHanhHoSo, "Cac goi thau can phat hanh ho so");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, moThau, "Cac goi thau can mo thau");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, trinhKetQua, "Cac goi thau can trinh ket qua");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, thamDinhKetQua, "Cac goi thau can tham dinh ket qua");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, trinhPheDuyetKetQua, "Cac goi thau can phe duyet ket qua");
            smsMessage = getMessageFromDanhSachGoiThau(smsMessage, thongBaoKetQua, "Cac goi thau can thong bao ket qua");
            if(StringUtils.isNotBlank(user.getEmail()) || StringUtils.isNotBlank(user.getPhoneNumber())){
                try{
                    if(StringUtils.isNotBlank(user.getEmail())){
                        List<String> emailTo = new ArrayList<>();
                        emailTo.add("quockhanhqb011@gmail.com"); //emailTo.add(user.getEmail());
                        String sender = "";
                        String subject = "Nhac nho tu he thong";
                        sendNotifyEmail(emailTo, sender, subject, emailMessage);
                    }
                    if(StringUtils.isNotBlank(user.getPhoneNumber())){
                        sendNotifySMS("9234", user.getPhoneNumber(), smsMessage);
                    }
                    saveDataAction(user, smsMessage, emailMessage);
                } catch (ObjectNotFoundException e){

                } catch (DuplicateKeyException e) {

                }
            }
        }
    }

    private void sendNotifySMS(String sender, String receiver, String message){
        try{
            URL yahoo = new URL("http://10.151.70.55:8123/rest/services/otp/sms?sender="+ sender +"&receiver="+ receiver +"&message="+ URLEncoder.encode(message, "UTF-8"));
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        }catch (Exception e){

        }
    }

    private void saveDataAction(UserEntity user, String smsMessage, String emailMessage) throws DuplicateKeyException {
        DmDataActionEntity dataAction = new DmDataActionEntity();
        if(StringUtils.isNotBlank(user.getPhoneNumber())){
            dataAction.setPhoneNumber(user.getPhoneNumber());
            dataAction.setIzSMS(1);
            dataAction.setFlagSMS(1);
            dataAction.setSmsContent(smsMessage);
        } else {
            dataAction.setIzSMS(0);
            dataAction.setFlagSMS(0);
        }

        if(StringUtils.isNotBlank(user.getEmail())){
            dataAction.setEmail(user.getEmail());
            dataAction.setIzEmail(1);
            dataAction.setFlagEmail(1);
            dataAction.setEmailContent(emailMessage);
        }  else {
            dataAction.setIzEmail(0);
            dataAction.setFlagEmail(0);
        }
        dataAction.setActionDate(new Timestamp(System.currentTimeMillis()));
        dataAction.setTenNguoiNhan(user.getDisplayName());
        this.dataActionLocalBean.save(dataAction);
    }

    private String getMessageFromDanhSachGoiThau(String currentMessage, List<String> goiThaus, String prefixMessage){
        if(goiThaus != null && goiThaus.size() > 0){
            if(StringUtils.isNotBlank(currentMessage)){
                currentMessage += "; ";
            }
            currentMessage += prefixMessage;
            for(int i = 0; i <goiThaus.size(); i++){
                String maGoiThau = goiThaus.get(i);
                if(i > 0){
                    currentMessage += ",";
                }
                currentMessage += " " + maGoiThau;
            }
        }
        return currentMessage;
    }

    private Boolean sendNotifyEmail(List<String> emailTo, String sender, String subject, String content) throws ObjectNotFoundException {
        Boolean isSent = Boolean.FALSE;
        emailLocalBean.sendMessage(emailTo, null, null, sender, subject, content);
        isSent = Boolean.TRUE;
        return isSent;
    }

    private void getMapGoiThauByHinhThuc(TiendoEntity entity, List<UserEntity> listUserRelative, Map<Long, List<String>> goiThauThamDinhPhuongAn,
         Map<Long, List<String>> goiThauTrinhPheDuyetPhuongAn, Map<Long, List<String>> goiThauThanhLapToChuyenGia,
         Map<Long, List<String>> goiThauTrinhPheDuyetHoSo, Map<Long, List<String>> goiThauThamDinhHoSoMoiThau,
         Map<Long, List<String>> goiThauPheDuyetHoSo, Map<Long, List<String>> goiThauDangMoiThau,
         Map<Long, List<String>> goiThauPhatHanhHoSo, Map<Long, List<String>> goiThauMoThau,
         Map<Long, List<String>> goiThauTrinhKetQua, Map<Long, List<String>> goiThauThamDinhKetQua,
         Map<Long, List<String>> goiThauTrinhPheDuyetKetQua, Map<Long, List<String>> goiThauThongBaoKetQua) throws ParseException {


        if(entity.getGoithau() != null && entity.getGoithau().getMsgoithau() != null && entity.getGoithau().getMsgoithau() > 0
                && entity.getGoithau().getHinhthucgt() != null && entity.getGoithau().getHinhthucgt().getMshinhthuc() != null
                && entity.getGoithau().getHinhthucgt().getMshinhthuc() > 0){
            DmHinhthucgtEntity hinhThuc = entity.getGoithau().getHinhthucgt();

            Timestamp bcThamDinhKetQuaNgay = entity.getBcThamDinhKetQuaNgay();
            if(bcThamDinhKetQuaNgay != null){
                if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                    if(needToSendMessage(bcThamDinhKetQuaNgay, 5, true)){
                        add2Map(listUserRelative, goiThauThongBaoKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                    }
                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                    if(needToSendMessage(bcThamDinhKetQuaNgay, 5, true)){
                        add2Map(listUserRelative, goiThauThongBaoKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                    }
                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                    if(needToSendMessage(bcThamDinhKetQuaNgay, 5, true)){
                        add2Map(listUserRelative, goiThauThongBaoKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                    }
                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                    if(needToSendMessage(bcThamDinhKetQuaNgay, 5, false)){
                        add2Map(listUserRelative, goiThauThongBaoKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                    }
                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                    if(needToSendMessage(bcThamDinhKetQuaNgay, 5, false)){
                        add2Map(listUserRelative, goiThauThongBaoKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                    }
                }
            } else {
                Timestamp pheduyetkqNgay = entity.getPheduyetkqNgay();
                if(pheduyetkqNgay != null){
                    if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                        if(needToSendMessage(pheduyetkqNgay, 5, true)){
                            add2Map(listUserRelative, goiThauTrinhPheDuyetKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                        }
                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                        if(needToSendMessage(pheduyetkqNgay, 5, true)){
                            add2Map(listUserRelative, goiThauTrinhPheDuyetKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                        }
                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                        if(needToSendMessage(pheduyetkqNgay, 5, true)){
                            add2Map(listUserRelative, goiThauTrinhPheDuyetKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                        }
                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                        if(needToSendMessage(pheduyetkqNgay, 5, true)){
                            add2Map(listUserRelative, goiThauTrinhPheDuyetKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                        }
                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){

                    }
                } else {
                    Timestamp trinhkqNgay = entity.getTrinhkqNgay();
                    if(trinhkqNgay != null){
                        if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                            if(needToSendMessage(trinhkqNgay, 10, false)){
                                add2Map(listUserRelative, goiThauThamDinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                            }
                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                            if(needToSendMessage(trinhkqNgay, 10, false)){
                                add2Map(listUserRelative, goiThauThamDinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                            }
                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                            if(needToSendMessage(trinhkqNgay, 7, true)){
                                add2Map(listUserRelative, goiThauThamDinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                            }
                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                            if(needToSendMessage(trinhkqNgay, 10, false)){
                                add2Map(listUserRelative, goiThauThamDinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                            }
                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                            if(needToSendMessage(trinhkqNgay, 10, true)){
                                add2Map(listUserRelative, goiThauThamDinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                            }
                        }
                    } else {
                        Timestamp ngayDongThau = entity.getNgaymothauL1();
                        if (entity.getNgaymothauL2() != null){
                            ngayDongThau = entity.getNgaymothauL2();
                        }
                        if(entity.getNgaymothauL3() != null){
                            ngayDongThau = entity.getNgaymothauL3();
                        }
                        if(ngayDongThau != null){
                            if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                if(needToSendMessage(ngayDongThau, 20, false)){
                                    add2Map(listUserRelative, goiThauTrinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                }
                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                if(needToSendMessage(ngayDongThau, 20, false)){
                                    add2Map(listUserRelative, goiThauTrinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                }
                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                if(needToSendMessage(ngayDongThau, 15, false)){
                                    add2Map(listUserRelative, goiThauTrinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                }
                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                if(needToSendMessage(ngayDongThau, 20, false)){
                                    add2Map(listUserRelative, goiThauTrinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                }
                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                if(needToSendMessage(ngayDongThau, 20, false)){
                                    add2Map(listUserRelative, goiThauTrinhKetQua, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                }
                            }
                        } else {
                            Timestamp ngaybanhsL1 = entity.getNgaybanhsL1();
                            if(ngaybanhsL1 != null){
                                if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                    if(needToSendMessage(ngaybanhsL1, 10, false)){
                                        add2Map(listUserRelative, goiThauMoThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                    }
                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                    if(needToSendMessage(ngaybanhsL1, 5, false)){
                                        add2Map(listUserRelative, goiThauMoThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                    }
                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                    if(needToSendMessage(ngaybanhsL1, 5, true)){
                                        add2Map(listUserRelative, goiThauMoThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                    }
                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                    if(needToSendMessage(ngaybanhsL1, 5, true)){
                                        add2Map(listUserRelative, goiThauMoThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                    }
                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                    if(needToSendMessage(ngaybanhsL1, 7, true)){
                                        add2Map(listUserRelative, goiThauMoThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                    }
                                }
                            } else {
                                Timestamp ngayDauTienDangBaoMT = null;
                                List<DangbaoEntity> listndb = entity.getGoithau().getNgayDangBao();
                                if(listndb != null && listndb.size() > 0){
                                    ngayDauTienDangBaoMT = listndb.get(0).getNgaydangbao();
                                }

                                if(ngayDauTienDangBaoMT != null){
                                    if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                        if(needToSendMessage(ngayDauTienDangBaoMT, 3, false)){
                                            add2Map(listUserRelative, goiThauPhatHanhHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                        }
                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                        if(needToSendMessage(ngayDauTienDangBaoMT, 3, false)){
                                            add2Map(listUserRelative, goiThauPhatHanhHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                        }
                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){

                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                        if(needToSendMessage(ngaybanhsL1, 5, true)){
                                            add2Map(listUserRelative, goiThauPhatHanhHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                        }
                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                        if(needToSendMessage(ngaybanhsL1, 7, false)){
                                            add2Map(listUserRelative, goiThauMoThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                        }
                                    }
                                }  else {
                                    Timestamp duyethsNgay = entity.getDuyethsNgay();
                                    if(duyethsNgay != null){
                                        if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                            if(needToSendMessage(duyethsNgay, 7, true)){
                                                add2Map(listUserRelative, goiThauDangMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                            }
                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                            if(needToSendMessage(duyethsNgay, 7, true)){
                                                add2Map(listUserRelative, goiThauDangMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                            }
                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                            if(needToSendMessage(duyethsNgay, 7, true)){
                                                add2Map(listUserRelative, goiThauDangMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                            }
                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                            if(needToSendMessage(duyethsNgay, 7, true)){
                                                add2Map(listUserRelative, goiThauDangMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                            }
                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                            if(needToSendMessage(duyethsNgay, 5, true)){
                                                add2Map(listUserRelative, goiThauDangMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                            }
                                        }
                                    }  else {
                                        Timestamp baoCaoThamDinhNgay = entity.getBaoCaoThamDinhNgay();
                                        if(baoCaoThamDinhNgay != null){
                                            if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                                if(needToSendMessage(baoCaoThamDinhNgay, 10, false)){
                                                    add2Map(listUserRelative, goiThauPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                                }
                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                                if(needToSendMessage(baoCaoThamDinhNgay, 10, false)){
                                                    add2Map(listUserRelative, goiThauPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                }
                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                                if(needToSendMessage(baoCaoThamDinhNgay, 10, false)){
                                                    add2Map(listUserRelative, goiThauPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                }
                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                                if(needToSendMessage(baoCaoThamDinhNgay, 10, false)){
                                                    add2Map(listUserRelative, goiThauPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                }
                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                                if(needToSendMessage(baoCaoThamDinhNgay, 5, true)){
                                                    add2Map(listUserRelative, goiThauPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                }
                                            }
                                        } else {
                                            Timestamp trinhHsNgay = entity.getTrinhhsNgay();
                                            if(trinhHsNgay != null){
                                                if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                                    if(needToSendMessage(trinhHsNgay, 10, false)){
                                                        add2Map(listUserRelative, goiThauThamDinhHoSoMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                                    }
                                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                                    if(needToSendMessage(trinhHsNgay, 10, false)){
                                                        add2Map(listUserRelative, goiThauThamDinhHoSoMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                    }
                                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                                    if(needToSendMessage(trinhHsNgay, 10, false)){
                                                        add2Map(listUserRelative, goiThauThamDinhHoSoMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                    }
                                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                                    if(needToSendMessage(trinhHsNgay, 10, false)){
                                                        add2Map(listUserRelative, goiThauThamDinhHoSoMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                    }
                                                } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                                    if(needToSendMessage(trinhHsNgay, 10, true)){
                                                        add2Map(listUserRelative, goiThauThamDinhHoSoMoiThau, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                    }
                                                }
                                            } else {
                                                Timestamp qdPheDuyetNgay = entity.getQdPheDuyetNgay();
                                                if(qdPheDuyetNgay != null){
                                                    if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                                        if(needToSendMessage(qdPheDuyetNgay, 20, false)){
                                                            add2Map(listUserRelative, goiThauTrinhPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau()) ;
                                                        }
                                                        if(needToSendMessage(qdPheDuyetNgay, 5, true)){
                                                            add2Map(listUserRelative, goiThauThanhLapToChuyenGia, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                                        if(needToSendMessage(qdPheDuyetNgay, 15, false)){
                                                            add2Map(listUserRelative, goiThauTrinhPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                        if(needToSendMessage(qdPheDuyetNgay, 5, true)){
                                                            add2Map(listUserRelative, goiThauThanhLapToChuyenGia, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                                        if(needToSendMessage(qdPheDuyetNgay, 15, false)){
                                                            add2Map(listUserRelative, goiThauTrinhPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                        if(needToSendMessage(qdPheDuyetNgay, 5, true)){
                                                            add2Map(listUserRelative, goiThauThanhLapToChuyenGia, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                                        if(needToSendMessage(qdPheDuyetNgay, 15, false)){
                                                            add2Map(listUserRelative, goiThauTrinhPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                        if(needToSendMessage(qdPheDuyetNgay, 5, true)){
                                                            add2Map(listUserRelative, goiThauThanhLapToChuyenGia, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                    } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                                        if(needToSendMessage(qdPheDuyetNgay, 15, true)){
                                                            add2Map(listUserRelative, goiThauTrinhPheDuyetHoSo, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                        if(needToSendMessage(qdPheDuyetNgay, 5, true)){
                                                            add2Map(listUserRelative, goiThauThanhLapToChuyenGia, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                        }
                                                    }
                                                } else {
                                                    Timestamp thamDinhPANgay = entity.getThamDinhPANgay();
                                                    if(thamDinhPANgay != null){
                                                        if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                                            if(needToSendMessage(thamDinhPANgay, 5, true)){
                                                                add2Map(listUserRelative, goiThauTrinhPheDuyetPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                            }
                                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                                            if(needToSendMessage(thamDinhPANgay, 5, true)){
                                                                add2Map(listUserRelative, goiThauTrinhPheDuyetPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                            }
                                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                                            if(needToSendMessage(thamDinhPANgay, 5, true)){
                                                                add2Map(listUserRelative, goiThauTrinhPheDuyetPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                            }
                                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                                            if(needToSendMessage(thamDinhPANgay, 5, true)){
                                                                add2Map(listUserRelative, goiThauTrinhPheDuyetPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                            }
                                                        } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                                            if(needToSendMessage(thamDinhPANgay, 5, true)){
                                                                add2Map(listUserRelative, goiThauTrinhPheDuyetPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                            }
                                                        }
                                                    } else {
                                                        Timestamp ngayCVTrinhPAPA =  entity.getGoithau().getNgaycvTrinhpd();
                                                        if(ngayCVTrinhPAPA != null){
                                                            if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_DAU_THAU_RONG_RAI)){
                                                                if(needToSendMessage(ngayCVTrinhPAPA, 10, false)){
                                                                    add2Map(listUserRelative, goiThauThamDinhPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                                }
                                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_MUA_SAM_TRUC_TIEP)){
                                                                if(needToSendMessage(ngayCVTrinhPAPA, 10, false)){
                                                                    add2Map(listUserRelative, goiThauThamDinhPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                                }
                                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_HANG_CANH_TRANH)){
                                                                if(needToSendMessage(ngayCVTrinhPAPA, 10, false)){
                                                                    add2Map(listUserRelative, goiThauThamDinhPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                                }
                                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHI_DINH_THAU)){
                                                                if(needToSendMessage(ngayCVTrinhPAPA, 10, false)){
                                                                    add2Map(listUserRelative, goiThauThamDinhPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                                }
                                                            } else if(hinhThuc.getMahinhthuc().equals(Constants.HINH_THUC_CHAO_GIA_CANH_TRANH)){
                                                                if(needToSendMessage(ngayCVTrinhPAPA, 10, true)){
                                                                    add2Map(listUserRelative, goiThauThamDinhPhuongAn, entity.getGoithau().getToChuyenGias(), entity.getGoithau().getMagoithau());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void add2Map(List<UserEntity> listUserRelative, Map<Long, List<String>> mapPDPA, List<GoithauNhanvienEntity> toChuyenGias, String magoithau) {
        for(GoithauNhanvienEntity gtnt : toChuyenGias){
            UserEntity user = gtnt.getUser();
            if(mapPDPA.get(user.getUserId()) == null){
                mapPDPA.put(user.getUserId(), new ArrayList<String>());
            }
            mapPDPA.get(user.getUserId()).add(magoithau);

            if(!listUserRelative.contains(user)){
                listUserRelative.add(user);
            }
        }
    }

    private boolean needToSendMessage(Timestamp beginTimeStamp, Integer numberDay, Boolean isNgayLamViec) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date(beginTimeStamp.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(beginDate);

        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date dateCurrentFormat = sdf.parse(sdf.format(new Date(stamp.getTime())));

        Date dateTargetFormat = null;

        if(isNgayLamViec){
            int numDay = numberDay -1;
            while (numDay >=1){
                c.add(Calendar.DATE, 1);
                if(c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
                    numDay--;
                }
            }
        }else{
            c.add(Calendar.DATE, numberDay - 1);
        }
        dateTargetFormat = sdf.parse(sdf.format(c.getTime()));
        int dateCompate = dateCurrentFormat.compareTo(dateTargetFormat);

        System.out.println("dateCurrent : "+sdf.format(dateCurrentFormat));
        System.out.println("dateTarget : "+sdf.format(dateTargetFormat));
        System.out.println("dateCompare : "+ dateCompate);
        if(dateCompate > -1){
            return true;
        }else{
            return false;
        }
    }



}
