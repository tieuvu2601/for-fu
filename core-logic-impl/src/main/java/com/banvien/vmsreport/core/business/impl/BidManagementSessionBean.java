package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.BidDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.BidManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.BidBeanUtil;
import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhanvienEntity;
import com.banvien.vmsreport.core.data.entity.UserEntity;
import com.banvien.vmsreport.core.data.session.BidLocalBean;
import com.banvien.vmsreport.core.data.session.GoithauNhanvienLocalBean;
import com.banvien.vmsreport.core.data.session.TinhtrangLocalBean;
import com.banvien.vmsreport.core.data.session.UserLocalBean;
import com.banvien.vmsreport.core.data.session.*;
import com.banvien.vmsreport.mailer.EmailLocalBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless(name = "BidManagementSessionEJB")
public class BidManagementSessionBean implements BidManagementLocalBean {
    private transient final Log log = LogFactory.getLog(getClass());

    public BidManagementSessionBean() {
    }

    @EJB
    private BidLocalBean bidService;
    @EJB
    private GoithauNhanvienLocalBean goithauNhanvienService;
    @EJB
    private GoithauNhathauLocalBean goithauNhathauService;
    @EJB
    private HoSoThauLocalBean hoSoThauService;
    @EJB
    private NoiDungHoSoLocalBean noiDungHoSoService;
    @EJB
    private UserLocalBean userService;
    @EJB
    private TinhtrangLocalBean tinhtrangService;
    @EJB
    private TienDoLocalBean tienDoService;
    @EJB
    private DangBaoLocalBean dangBaoService;
    @EJB
    private KinhPhiLocalBean kinhPhiService;
    @EJB
    private HosoluutruLocalBean hosoluutruService;
    @EJB
    private EmailLocalBean emailLocalBean;

    @Override
    public BidDTO findByCode(String code) throws ObjectNotFoundException {
        return BidBeanUtil.entity2DTO(bidService.findEqualUnique("magoithau", code));
    }

    @Override
    public BidDTO updateItem(BidDTO dto, Long userId, Map<Integer, Long> mapnv, Long isChuTri) throws ObjectNotFoundException, DuplicateKeyException, RemoveException {
        if(dto.getMsgoithauref() != null && StringUtils.isBlank(dto.getMsgoithauref().getTengoithau())){
            dto.setMsgoithauref(null);
        }
        GoithauEntity dbItem = this.bidService.findById(dto.getMsgoithau());
        if(dbItem == null) return null;
        GoithauEntity entity = DozerSingletonMapper.getInstance().map(dto, GoithauEntity.class);
        setNull(entity);
        UserEntity userEntity = this.userService.findById(userId);
        entity.setEditer(userEntity.getUserName());
        entity.setEdittime(new Timestamp(System.currentTimeMillis()));
        nvs(mapnv, isChuTri, entity);
        return DozerSingletonMapper.getInstance().map(this.bidService.update(entity), BidDTO.class);
    }

    private void updateFileUpload(BidDTO dto, List listUrlFile) {
        //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public BidDTO addItem(BidDTO dto, Long userId, Map<Integer, Long> mapnv, Long isChuTri) throws DuplicateKeyException, ObjectNotFoundException, RemoveException {
        if(dto.getMsgoithauref() != null && StringUtils.isBlank(dto.getMsgoithauref().getTengoithau())){
            dto.setMsgoithauref(null);
        }
        GoithauEntity entity = DozerSingletonMapper.getInstance().map(dto, GoithauEntity.class);
        setNull(entity);
        DmTinhtrangEntity tinhtrangEntity = this.tinhtrangService.findByCode(Constants.GOI_THAU_THAM_DINH_PHUONG_AN);
        UserEntity userEntity = this.userService.findById(userId);
        entity.setCreater(userEntity.getUserName());
        entity.setCreatetime(new Timestamp(System.currentTimeMillis()));
        entity.setTinhtrang(tinhtrangEntity);
        nvs(mapnv, isChuTri, entity);
        return DozerSingletonMapper.getInstance().map(this.bidService.save(entity), BidDTO.class);
    }

    private void nvs(Map<Integer, Long> mapnv, Long isChuTri, GoithauEntity goithau) throws DuplicateKeyException, RemoveException, ObjectNotFoundException {
//        this.goithauNhanvienService.deteteByGoiThauId(goithau.getMsgoithau());
        List<GoithauNhanvienEntity> listNhanVien = this.goithauNhanvienService.findByGoiThau(goithau.getMsgoithau());
        Map<Long, GoithauNhanvienEntity> mapNhanVienOld = new HashMap<>();
        for(GoithauNhanvienEntity entity : listNhanVien){
            mapNhanVienOld.put(entity.getUser().getUserId(), entity);
        }
        List<String> listUserSendMessage = new ArrayList<>();
        long ct = 0;
        for(Integer key :  mapnv.keySet()){

            if(mapNhanVienOld.get((Long)mapnv.get(key)) == null){
                GoithauNhanvienEntity entity = new GoithauNhanvienEntity();
                entity.setGoithau(goithau);
                UserEntity user = this.userService.findById(mapnv.get(key));
                entity.setUser(user);
                if(Long.valueOf(ct).equals(isChuTri)){
                  entity.setIschutri(BigInteger.ONE);
                } else{
                    entity.setIschutri(BigInteger.ZERO);
                }
                entity = this.goithauNhanvienService.save(entity);
                if(StringUtils.isNotBlank(user.getEmail())){
                    listUserSendMessage.add(user.getEmail());
                }
            }else{
                GoithauNhanvienEntity entity = mapNhanVienOld.get((Long)mapnv.get(key));
                if(ct == isChuTri){
                    entity.setIschutri(BigInteger.ONE);
                } else{
                    entity.setIschutri(BigInteger.ZERO);
                }
                this.goithauNhanvienService.update(entity);
                mapNhanVienOld.remove(mapnv.get(key));
            }
            ct++;
        }
        for(Long key: mapNhanVienOld.keySet()){
            this.goithauNhanvienService.delete(mapNhanVienOld.get(key).getMsgoithauNv());
        }
        if(listUserSendMessage.size() > 0){
            String sender = "";
            String subject = "Nhac nho he thong";
            String content = "Ban duoc tham gia vao goi thau "+goithau.getMagoithau();
            this.emailLocalBean.sendMessage(listUserSendMessage, null, null, sender, subject, content);
        }
    }

    private void setNull(GoithauEntity entity){
        if(entity.getQuimo() != null && entity.getQuimo().getMsquimo() == null) entity.setQuimo(null);
        if(entity.getNguonvon() != null && entity.getNguonvon().getMsnguonvon() == null) entity.setNguonvon(null);
        if(entity.getLoai() != null && entity.getLoai().getMsloai() == null) entity.setLoai(null);
        if(entity.getDepartment() != null && entity.getDepartment().getDepartmentId() == null) entity.setDepartment(null);
        if(entity.getLanhdao() != null && entity.getLanhdao().getMslanhdao() == null) entity.setLanhdao(null);
        if(entity.getHinhthucgt() != null && entity.getHinhthucgt().getMshinhthuc() == null) entity.setHinhthucgt(null);
        if(entity.getTinhchat() != null && entity.getTinhchat().getMstinhchat() == null) entity.setTinhchat(null);
        if(entity.getTinhtrang() != null && entity.getTinhtrang().getMstinhtrang() == null) entity.setTinhtrang(null);
        if(entity.getMsgoithauref() != null && entity.getMsgoithauref().getMsgoithau() == null) entity.setMsgoithauref(null);
        if(entity.getMsnhanvienCvtd() != null && entity.getMsnhanvienCvtd().getUserId() == null) entity.setMsnhanvienCvtd(null);
    }

    @Override
    public Integer deleteItems(String[] checkList) throws ObjectNotFoundException, RemoveException {
        int numberOfItemExecuted = 0;
        if(checkList != null && checkList.length > 0){
            for (String msgoithau : checkList) {
                Long goithauId = Long.valueOf(msgoithau);
                deleteGoiThauById(goithauId);
                numberOfItemExecuted++;
            }
        }
        return numberOfItemExecuted;
    }

    private void deleteGoiThauById(Long goiThauId){
        try {
            this.kinhPhiService.deleteByGoiThauId(goiThauId);
            this.hosoluutruService.deteteByGoiThauId(goiThauId);
            this.dangBaoService.deteteByGoiThauId(goiThauId);
            this.goithauNhanvienService.deteteByGoiThauId(goiThauId);
            this.hoSoThauService.deteteByGoiThauId(goiThauId);
            this.goithauNhathauService.deteteByGoiThauId(goiThauId);
            this.tienDoService.deteteByGoiThauId(goiThauId);
            this.bidService.delete(goiThauId);
        } catch (RemoveException e) {

        }

    }

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems, String whereClause) {
        Object [] res = bidService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems, whereClause);
        List<BidDTO> dtos = new ArrayList<BidDTO>();
        for (GoithauEntity entity : (List<GoithauEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, BidDTO.class));
        }
        res[1] = dtos;
        return res;
    }


    @Override
    public BidDTO findId(Long bidID) throws ObjectNotFoundException {
        return DozerSingletonMapper.getInstance().map(this.bidService.findById(bidID) , BidDTO.class);
    }

    @Override
    public List<BidDTO> searchAutoComplete(String name, Integer maxResult) {
        List<BidDTO> results = new ArrayList<>();
        try {
            List<GoithauEntity> emspotEntities = bidService.searchAutoComplete(name, maxResult);
            for (GoithauEntity entity : emspotEntities){
                results.add(DozerSingletonMapper.getInstance().map(entity, BidDTO.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public Object[] searchForList(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems){
        Object [] res = bidService.searchForList(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<BidDTO> dtos = new ArrayList<BidDTO>();
        int count = 0;
        for (GoithauEntity entity : (List<GoithauEntity>)res[1]){
            System.out.println("count:" + count);
            count++;
            dtos.add(DozerSingletonMapper.getInstance().map(entity, BidDTO.class));

        }
        res[1] = dtos;
        return res;
    }

    @Override
    public Long findMAX() {
        return this.bidService.findMAX();
    }

    @Override
    public List<BidDTO> findByUserId(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<BidDTO> findAll() {
        List<GoithauEntity> entities = bidService.findAll();
        List<BidDTO> dtoList = new ArrayList<>();
        for (GoithauEntity entity : entities){
            dtoList.add(BidBeanUtil.entity2DTO(entity));
        }
        return dtoList;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
