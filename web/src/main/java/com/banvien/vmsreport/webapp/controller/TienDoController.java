package com.banvien.vmsreport.webapp.controller;

import com.banvien.jcr.api.IJcrContent;
import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.editor.PojoEditor;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.BeanUtils;
import com.banvien.vmsreport.util.ReplaceVariablesUtils;
import com.banvien.vmsreport.util.StringUtil;
import com.banvien.vmsreport.webapp.command.DangBaoCommand;
import com.banvien.vmsreport.webapp.command.KinhPhiCommand;
import com.banvien.vmsreport.webapp.command.TienDoCommand;
import com.banvien.vmsreport.webapp.validator.TienDoValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TienDoController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private TienDoManagementLocalBean tienDoManagementLocalBean;
    @Autowired
    private FormTemplateManagementLocalBean formTemplateManagementLocalBean;
    @Autowired
    private TienDoValidator tienDoValidator;
    @Autowired
    private BidManagementLocalBean bidManagementLocalBean;
    @Autowired
    private LoaiBaoManagementLocalBean loaiBaoManagementLocalBean;
    @Autowired
    private NoiDungManagementLocalBean noidungManagementLocalBean;
    @Autowired
    private KinhPhiManagementLocalBean kinhPhiManagementLocalBean ;
    @Autowired
    private DangBaoManagementLocalBean dangBaoManagementLocalBean;
    @Autowired
    private HoSoThauManagementLocalBean hoSoThauManagementLocalBean;
    @Autowired
    private StoreFileManagementLocalBean storeFileManagementLocalBean;
    @Autowired
    private GoiThauNhanVienManagementLocalBean goiThauNhanVienManagementLocalBean;
    @Autowired
    private GoiThauNhaThauManagementLocalBean goiThauNhaThauManagementLocalBean;
    @Autowired
    private IJcrContent jcrContent;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL("dd/MM/yyyy"));
        binder.registerCustomEditor(TienDoDTO.class, new PojoEditor(TienDoDTO.class, "mstiendo", Long.class));
    }

    @RequestMapping(value={"/admin/tiendo/edit.*", "/normal/tiendo/edit.*"})
    public ModelAndView portalAdminView(@ModelAttribute(value = Constants.FORM_MODEL_KEY)TienDoCommand command,
                                        HttpServletRequest request) throws ObjectNotFoundException, DuplicateKeyException, RemoveException {
        ModelAndView mav = new ModelAndView("/admin/tiendo/edit");
        TienDoDTO pojo = command.getPojo();
//        this.tienDoManagementLocalBean.autoSendMessageForRelativeUser();

        if(pojo != null && pojo.getGoithau() != null && pojo.getGoithau().getMsgoithau() != null && pojo.getGoithau().getMsgoithau() > 0){
            String crudaction = command.getCrudaction();
            if(StringUtils.isNotBlank(crudaction) && "update".equals(crudaction)){
                pojo.setListKinhPhis(reviseListKinhPhi(command.getListkp()));
                BidDTO goithau = this.bidManagementLocalBean.findId(pojo.getGoithau().getMsgoithau());
                if(checkAllowAction(goithau)) {
                    if((pojo.getMstiendo() != null) && (pojo.getMstiendo() > 0)){
                        pojo = this.tienDoManagementLocalBean.updateItem(pojo, SecurityUtils.getLoginUserId(), command.getListkp(), command.getListndb());
                    }else{
                        pojo = this.tienDoManagementLocalBean.addItem(pojo, SecurityUtils.getLoginUserId(), command.getListkp(), command.getListndb());
                    }
                    List<StoreFileDTO> listUrlFile = saveFileJcr(pojo.getGoithau(), request);
                    listUrlFile = this.storeFileManagementLocalBean.updateAndSave(listUrlFile);
                }
                command.setPojo(pojo);
            }

            try{
                BidDTO goithau = this.bidManagementLocalBean.findId(pojo.getGoithau().getMsgoithau());
                pojo.setGoithau(goithau);
                command.setPojo(pojo);
                command.setListkp(getDSKinhPhi(goithau.getMsgoithau()));
                command.setListndb(getDSNgayDangBao(pojo.getGoithau().getMsgoithau()));
                mav.addObject("listHST", getDSHoSoNhaThauDuocChon(this.hoSoThauManagementLocalBean.findByGoiThau(goithau.getMsgoithau())));
                boolean allAction =  checkAllowAction(goithau);
                mav.addObject("allowAction", allAction);

                boolean allowXT = false,
                        allowTD = false;
                if(allAction){
                    if(SecurityUtils.getAuthorities().contains(Constants.XET_THAU) || SecurityUtils.getAuthorities().contains(Constants.GROUP_XETTHAU) || SecurityUtils.getAuthorities().contains(Constants.GROUP_TRUONGPHONG)){
                        allowXT = true;
                    }
                    if(SecurityUtils.getAuthorities().contains(Constants.THAM_DINH) || SecurityUtils.getAuthorities().contains(Constants.GROUP_THAMDINH) || SecurityUtils.getAuthorities().contains(Constants.GROUP_TRUONGPHONG)){
                        allowTD = true;
                    }
                }
                mav.addObject("allowXT", allowXT);
                mav.addObject("allowTD", allowTD);
            }catch (Exception e){

            }
            try{
                pojo = this.tienDoManagementLocalBean.findByGoiThauId(pojo.getGoithau().getMsgoithau());
                command.setPojo(pojo);
            }catch (Exception e){

            }
            mav.addObject("listlb", this.loaiBaoManagementLocalBean.findAll());
            mav.addObject("listnd", this.noidungManagementLocalBean.findAll());
        }
        mav.addObject(Constants.FORM_MODEL_KEY, command);
        referenceData(pojo.getGoithau(),mav);
        return mav;
    }


    private Boolean checkAllowAction(BidDTO goithau) {
        if(SecurityUtils.getAuthorities().contains(Constants.GROUP_TRUONGPHONG)){
            return true;
        }
        if(goithau.getToChuyenGias() != null && goithau.getToChuyenGias().size() > 0){
            for(GoithaunhanvienDTO nhanvien : goithau.getToChuyenGias()){
                if(nhanvien.getUser().getUserId().equals(SecurityUtils.getLoginUserId())){
                    return true;
                }
            }
        }
        if(goithau.getMsnhanvienCvtd() != null && goithau.getMsnhanvienCvtd().getUserId() != null && goithau.getMsnhanvienCvtd().getUserId().equals(SecurityUtils.getLoginUserId())){
            return true;
        }

        return false;
    }

    private List<HoSoThauDTO> getDSHoSoNhaThauDuocChon(List<HoSoThauDTO> listgoithaus) {
        List<HoSoThauDTO> res = new ArrayList<>();
        for(HoSoThauDTO dto : listgoithaus){
            if(dto.getGoithau_nhathau().getNgaynophs() != null) {
                res.add(dto);
            }
        }
        return res;
    }

    private List<DangBaoDTO> getDSNgayDangBao(Long msgoithau) {
        return this.dangBaoManagementLocalBean.findByGoiThau(msgoithau);
    }

    private List<KinhphiDTO> getDSKinhPhi(Long msgoithau) {
        return this.kinhPhiManagementLocalBean.findByGoiThau(msgoithau);
    }

    private List<KinhphiDTO> reviseListKinhPhi(List<KinhphiDTO> listkp) {
        List<KinhphiDTO> res = new ArrayList<>();
        if(listkp != null && listkp.size() > 0){
            for(KinhphiDTO kinhphiDTO : listkp){
                if(kinhphiDTO.getThanhtien() != null){
                    res.add(kinhphiDTO);
                }
            }
        }
        return res;
    }

    @RequestMapping(value = "/ajax/tiendo/newKPDB.html")
    public ModelAndView newKPDB(@ModelAttribute(Constants.FORM_MODEL_KEY) KinhPhiCommand command,
                                @RequestParam(value = "num")Integer num,
                                HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/kinhphi/ajaxNewRow");
        mav.addObject(Constants.FORM_MODEL_KEY, command);
        mav.addObject("listnd", this.noidungManagementLocalBean.findAll());
        mav.addObject("listlb", this.loaiBaoManagementLocalBean.findAll());
        mav.addObject("num", num);
        return mav;
    }

    @RequestMapping(value = "/ajax/tiendo/newNDB.html")
    public ModelAndView newNDB(@ModelAttribute(Constants.FORM_MODEL_KEY) DangBaoCommand command,
                                @RequestParam(value = "num")Integer num,
                                HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/dangbao/ajaxNewRow");
        mav.addObject(Constants.FORM_MODEL_KEY, command);
        mav.addObject("listnd", this.noidungManagementLocalBean.findAll());
        mav.addObject("listlb", this.loaiBaoManagementLocalBean.findAll());
        mav.addObject("num", num);
        return mav;
    }

    private void referenceData(BidDTO goithau, ModelAndView mav) throws ObjectNotFoundException {
        List<FormTemplateDTO> listForm = formTemplateManagementLocalBean.findALL();
        mav.addObject("listForm", listForm);


//        if (SecurityUtils.userHasAuthority("TD,XT")){
//            mav.addObject("listGoiThau", goiThauNhanVienManagementLocalBean.findByUserId(SecurityUtils.getPrincipal().getUserId()));
//        }else if (SecurityUtils.userHasAuthority("NVPBK")){
//            mav.addObject("listGoiThau", bidManagementLocalBean.findByUserId(SecurityUtils.getPrincipal().getUserId()));
//        }else {
//            mav.addObject("listGoiThau", bidManagementLocalBean.findAll());
//        }
        if (goithau != null && goithau.getMsgoithau() != null){
            List<GoithaunhathauDTO> nhaThaus = goiThauNhaThauManagementLocalBean.findByMaGoiThau(goithau.getMagoithau());
            mav.addObject("nhaThaus", nhaThaus);
            Map<String, String> mapStoreFile = storeFileManagementLocalBean.findMapUrlByMsGoiThau(goithau.getMsgoithau());
            mav.addObject(Constants.thamDinhPhuongAn, mapStoreFile.get(goithau.getMsgoithau()+ Constants.thamDinhPhuongAn));
            mav.addObject(Constants.qdPheDuyetPA, mapStoreFile.get(goithau.getMsgoithau()+ Constants.qdPheDuyetPA));
            mav.addObject(Constants.dbKeHoachThau, mapStoreFile.get(goithau.getMsgoithau()+ Constants.dbKeHoachThau));
            mav.addObject(Constants.toTrinhDSTCG, mapStoreFile.get(goithau.getMsgoithau()+ Constants.toTrinhDSTCG));
            mav.addObject(Constants.qdThanhLapTCG, mapStoreFile.get(goithau.getMsgoithau()+ Constants.qdThanhLapTCG));
            mav.addObject(Constants.trinhHSMTHSYC, mapStoreFile.get(goithau.getMsgoithau()+ Constants.trinhHSMTHSYC));
            mav.addObject(Constants.baoCaoThamDinh, mapStoreFile.get(goithau.getMsgoithau()+ Constants.baoCaoThamDinh));
            mav.addObject(Constants.qdPheDuyetHSMTHSYC, mapStoreFile.get(goithau.getMsgoithau()+ Constants.qdPheDuyetHSMTHSYC));
            mav.addObject(Constants.qdTenNhaThauThamGia, mapStoreFile.get(goithau.getMsgoithau()+ Constants.qdTenNhaThauThamGia));
            mav.addObject(Constants.trinhPheDuyetKPDB, mapStoreFile.get(goithau.getMsgoithau()+ Constants.trinhPheDuyetKPDB));
            mav.addObject(Constants.thuMoiThuongThao, mapStoreFile.get(goithau.getMsgoithau()+ Constants.thuMoiThuongThao));
            mav.addObject(Constants.bcDanhGiaHoSo, mapStoreFile.get(goithau.getMsgoithau()+ Constants.bcDanhGiaHoSo));
            mav.addObject(Constants.bienBanThuongThao, mapStoreFile.get(goithau.getMsgoithau()+ Constants.bienBanThuongThao));
            mav.addObject(Constants.trinhKetQua, mapStoreFile.get(goithau.getMsgoithau()+ Constants.trinhKetQua));
            mav.addObject(Constants.bcThamDinhKetQua, mapStoreFile.get(goithau.getMsgoithau()+ Constants.bcThamDinhKetQua));
            mav.addObject(Constants.pheDuyetKetQua, mapStoreFile.get(goithau.getMsgoithau()+ Constants.pheDuyetKetQua));
            mav.addObject(Constants.danhGiaLuaChonNhaThau, mapStoreFile.get(goithau.getMsgoithau()+ Constants.danhGiaLuaChonNhaThau));
            mav.addObject(Constants.thongBaoKet, mapStoreFile.get(goithau.getMsgoithau()+ Constants.thongBaoKet));
        }
    }

    private List<StoreFileDTO> saveFileJcr(BidDTO goithau, HttpServletRequest request) throws ObjectNotFoundException {
        List<StoreFileDTO> listUrlFile = new ArrayList<>();
        Map<String, String> urlFileJcrOld = storeFileManagementLocalBean.findMapUrlByMsGoiThau(goithau.getMsgoithau());
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.thamDinhPhuongAn), Constants.thamDinhPhuongAn, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.qdPheDuyetPA), Constants.qdPheDuyetPA, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.dbKeHoachThau), Constants.dbKeHoachThau, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.toTrinhDSTCG), Constants.toTrinhDSTCG, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.qdThanhLapTCG), Constants.qdThanhLapTCG, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.trinhHSMTHSYC), Constants.trinhHSMTHSYC, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.baoCaoThamDinh), Constants.baoCaoThamDinh, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.qdPheDuyetHSMTHSYC), Constants.qdPheDuyetHSMTHSYC, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.qdTenNhaThauThamGia), Constants.qdTenNhaThauThamGia, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.trinhPheDuyetKPDB), Constants.trinhPheDuyetKPDB, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.thuMoiThuongThao), Constants.thuMoiThuongThao, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.bcDanhGiaHoSo), Constants.bcDanhGiaHoSo, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.bienBanThuongThao), Constants.bienBanThuongThao, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.trinhKetQua), Constants.trinhKetQua, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.bcThamDinhKetQua), Constants.bcThamDinhKetQua, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.pheDuyetKetQua), Constants.pheDuyetKetQua, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.danhGiaLuaChonNhaThau), Constants.danhGiaLuaChonNhaThau, request));
        listUrlFile.add(extractFileUpload(goithau, urlFileJcrOld.get(goithau.getMsgoithau()+ Constants.thongBaoKet), Constants.thongBaoKet, request));

        return listUrlFile;
    }

    private StoreFileDTO extractFileUpload(BidDTO goithau, String urlFileJcrOld, String inputName, HttpServletRequest request){
        StoreFileDTO dto = new StoreFileDTO();
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> map = mRequest.getFileMap();
        if (map.get(inputName)!= null){
            MultipartFile fileUpload = (MultipartFile) map.get(inputName);
            if (fileUpload!= null && fileUpload.getSize() > 0){
                com.banvien.jcr.api.FileItem fileCVPDPA = BeanUtils.multipartFile2FileItem(fileUpload);
                fileCVPDPA.setOriginalFilename(StringUtil.removeBlankSpace(fileCVPDPA.getOriginalFilename().trim()));
                String fpath = goithau.getMagoithau() + "/" + inputName;
                String fpathCheck = goithau.getMagoithau() + "/" + inputName + "/" + fileCVPDPA.getOriginalFilename();
                if (!fpathCheck.equalsIgnoreCase(urlFileJcrOld)){
                    if (urlFileJcrOld != null){
                        jcrContent.removeFileItem(urlFileJcrOld);
                    }
                    dto.setFullPath(jcrContent.writeOrUpdate(fpath, fileCVPDPA));
                    dto.setTypeVar(inputName);
                    dto.setGoiThau(goithau);
                }

            }
        }
        return dto;
    }

}
