package com.banvien.vmsreport.webapp.controller;

import com.banvien.jcr.api.*;
import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.dto.FileItem;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomCurrencyFormatEditor;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.editor.FileItemMultipartFileEditor;
import com.banvien.vmsreport.editor.PojoEditor;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.BeanUtils;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.util.StringUtil;
import com.banvien.vmsreport.webapp.command.BidCommand;
import com.banvien.vmsreport.webapp.validator.BidValidator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/18/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BidController extends ApplicationObjectSupport{
    private transient final Log log = LogFactory.getLog(getClass());
    private static final Integer TOTAL_COLUMN_EXPORT = 10;

    @Autowired
    private BidManagementLocalBean bidService;
    @Autowired
    private DepartmentManagementLocalBean departmentService;
    @Autowired
    private UserManagementLocalBean userService;

    @Autowired
    private QuyMoManagementLocalBean quiMoService;
    @Autowired
    private NguonvonManagementLocalBean nguonVonService;
    @Autowired
    private LoaiManagementLocalBean loaiService;
    @Autowired
    private LanhdaoManagementLocalBean lanhDaoService;
    @Autowired
    private HinhthucManagementLocalBean hinhThucService;
    @Autowired
    private TinhchatManagementLocalBean tinhChatService;
    @Autowired
    private TinhtrangManagementLocalBean tinhTrangService;
    @Autowired
    private GoiThauNhanVienManagementLocalBean goiThauNhanVienService;
    @Autowired
    private StoreFileManagementLocalBean storeFileManagementLocalBean;
    @Autowired
    private FormTemplateManagementLocalBean formTemplateManagementLocalBean;
    @Autowired
    private BidValidator bidValidator;
    @Autowired
    private IJcrContent jcrContent;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL("dd/MM/yyyy"));
        binder.registerCustomEditor(Double.class, new CustomCurrencyFormatEditor());
        binder.registerCustomEditor(QuyMoDTO.class, new PojoEditor(QuyMoDTO.class, "msquimo", Long.class));
        binder.registerCustomEditor(NguonvonDTO.class, new PojoEditor(NguonvonDTO.class, "msnguonvon", Long.class));
        binder.registerCustomEditor(LoaiDTO.class, new PojoEditor(LoaiDTO.class, "msloai", Long.class));
        binder.registerCustomEditor(DepartmentDTO.class, new PojoEditor(DepartmentDTO.class, "departmentId", Long.class));
        binder.registerCustomEditor(LanhdaoDTO.class, new PojoEditor(LanhdaoDTO.class, "mslanhdao", Long.class));
        binder.registerCustomEditor(HinhthucgtDTO.class, new PojoEditor(HinhthucgtDTO.class, "mshinhthuc", Long.class));
        binder.registerCustomEditor(TinhchatDTO.class, new PojoEditor(TinhchatDTO.class, "mstinhchat", Long.class));
        binder.registerCustomEditor(TinhtrangDTO.class, new PojoEditor(TinhtrangDTO.class, "mstinhtrang", Long.class));
        binder.registerCustomEditor(BidDTO.class, new PojoEditor(BidDTO.class, "msgoithau", Long.class));
        binder.registerCustomEditor(FileItem.class, new FileItemMultipartFileEditor());
    }

    @RequestMapping(value={"/admin/goithau/add.html", "/normal/goithau/add.html",
            "/admin/goithau/edit.html", "/normal/goithau/edit.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)BidCommand command,
                             BindingResult bindingResult,
                             HttpServletRequest request,
                             RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/bid/edit");
        String crudaction = command.getCrudaction();
        BidDTO pojo = command.getPojo();
        try{
            if (StringUtils.isNotBlank(crudaction) && Constants.INSERT_OR_UPDATE.equals(crudaction)){
                bidValidator.validate(command, bindingResult);
                if(!bindingResult.hasErrors()) {
                    if(pojo.getMsgoithau() != null && pojo.getMsgoithau().compareTo(0L) > 0){
                        pojo = this.bidService.updateItem(command.getPojo(),SecurityUtils.getLoginUserId(), command.getMapnvs(), command.getIdChuTri());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                    } else {
                        pojo = this.bidService.addItem(command.getPojo(), SecurityUtils.getLoginUserId(), command.getMapnvs(), command.getIdChuTri());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    List<StoreFileDTO> listUrlFile = saveFileJcr(command, request);
                    listUrlFile = this.storeFileManagementLocalBean.updateAndSave(listUrlFile);
                    command.setPojo(pojo);
                    mav.addObject(Constants.ALERT_TYPE, "success");
                }
            }
            if(!bindingResult.hasErrors() && command.getPojo().getMsgoithau() != null && command.getPojo().getMsgoithau() != null){
                BidDTO dbItem = this.bidService.findId(command.getPojo().getMsgoithau());
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("goithau.msgoithau", command.getPojo().getMsgoithau());
                mav.addObject("nhanviens", goiThauNhanVienService.search(map, "", "", -1, -1)[1]);
                command.setPojo(dbItem);
            }else{
                mav.addObject("maxId", bidService.findMAX() + 1l);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
            mav.addObject(Constants.ALERT_TYPE, "error");
        }
        referenceData(command, mav);
        return mav;
    }


    @RequestMapping(value={"/admin/goithau/list.html", "normal/goithau/list.html"})
    public ModelAndView portalAdminView(@ModelAttribute(Constants.FORM_MODEL_KEY)BidCommand command,
                                        HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException, ParseException {
        ModelAndView mav = new ModelAndView("/admin/bid/list");
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)) {
            Integer totalDeleted = 0;
            try {
                totalDeleted = bidService.deleteItems(command.getCheckList());
                mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.delete.successful", new Object[]{totalDeleted}));
                mav.addObject(Constants.ALERT_TYPE, "success");
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("general.exception.msg"));
                mav.addObject(Constants.ALERT_TYPE, "danger");
            }
        }
        executeSearch(command, request);
        referenceData(command, mav);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value={"/ajax/admin/goithau/list.html", "/ajax/normal/goithau/list.html"})
    public ModelAndView ajaxListGoiThau(@ModelAttribute(Constants.FORM_MODEL_KEY)BidCommand command,
                                        HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException, ParseException {
        ModelAndView mav = new ModelAndView("/admin/bid/ajaxList");
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_SEARCH)) {
            executeSearchAjax(command, request);
        }
        referenceData(command, mav);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value={"/api/goithau/addtochuyengia.html"})
    private ModelAndView getToChuyenGia(@RequestParam(value = "stt")Integer stt) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/bid/nhanVienRow");
        if (SecurityUtils.userHasAuthority(Constants.USER_PHONG_BAN_KHAC)){
            List<UserDTO> users = new ArrayList<>();
            users.add(userService.findById(SecurityUtils.getLoginUserId()));
            mav.addObject("users", users);
        }else {
            mav.addObject("users", userService.findAllUserWithGroup(Constants.GROUP_XETTHAU));
        }
        mav.addObject("stt", stt);
        return mav;
    }

    @RequestMapping(value = {"/api/goithau/searchautocomplete.html"})
    @ResponseBody
    public List<BidDTO> searchAutoComplete(@RequestParam(value = "name", required = false) String name){
        List<BidDTO> bidDTOs = this.bidService.searchAutoComplete(name, Constants.MAXAUTOCOMPLETESEARCH);
        List<BidDTO> results = new ArrayList<BidDTO>();
        for(BidDTO dto : bidDTOs){
            BidDTO item = new BidDTO();
            item.setMsgoithau(dto.getMsgoithau());
            item.setTengoithau(dto.getTengoithau());
            results.add(item);
        }
        return results;
    }

    private void executeSearch(BidCommand command, HttpServletRequest request) throws ParseException {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);
        Object[] results = this.bidService.searchForList(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<BidDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private void executeSearchAjax(BidCommand command, HttpServletRequest request) throws ParseException {
//        command.setMaxPageItems(5);
        command.setFirstItem((command.getPage() - 1) * command.getMaxPageItems());
        Map<String, Object> properties = buildProperties(command);
        Object[] results = this.bidService.searchForList(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<BidDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(BidCommand command){
        Map<String, Object> properties = new HashMap<String, Object>();
        if(command.getSortDirection() == null || command.getSortExpression() == null){
            command.setSortDirection("1");
            command.setSortExpression("2");
        }
        if(command.getPojo() != null){
            BidDTO pojo = command.getPojo();
            if(StringUtils.isNotBlank(pojo.getSoqd())){
                properties.put("soqd", pojo.getSoqd());
            }
            if(pojo.getMagoithau() != null && StringUtils.isNotBlank(pojo.getMagoithau())){
                properties.put("magoithau", pojo.getMagoithau());
            }
            if(StringUtils.isNotBlank(pojo.getTengoithau())){
                properties.put("tengoithau", pojo.getTengoithau());
            }
            if(pojo.getNguonvon() != null && pojo.getNguonvon().getMsnguonvon() != null){
                properties.put("msnguonvon", pojo.getNguonvon().getMsnguonvon());
            }
            if(pojo.getLoai() != null && pojo.getLoai().getMsloai() != null){
                properties.put("msloai", pojo.getLoai().getMsloai());
            }
            if(pojo.getDepartment() != null && pojo.getDepartment().getDepartmentId() != null){
                properties.put("departmentId", pojo.getDepartment().getDepartmentId());
            }
            if(pojo.getQuimo() != null && pojo.getQuimo().getMsquimo() != null){
                properties.put("msquimo", pojo.getQuimo().getMsquimo());
            }
            if(command.getToDate() != null){
                properties.put("toDate", command.getToDate());
            }
            if(command.getFromDate() != null){
                properties.put("fromDate", command.getFromDate());
            }
            if(command.getIdThanhVien() != null && command.getIdThanhVien() > 0){
                properties.put("nhanvien", command.getIdThanhVien());
            }
            if(command.getIdChuTri() != null && command.getIdChuTri() > 0){
                properties.put("chuTri", command.getIdChuTri());
            }
            if(command.getMapHinhThucs() != null && command.getMapHinhThucs().size() > 0 && command.getMapHinhThucs().get(0) > -1){
                properties.put("listHinhThucs", command.getMapHinhThucs());
            }
            if(command.getMapTinhTrangs() != null && command.getMapTinhTrangs().size() > 0 && command.getMapTinhTrangs().get(0) > -1){
                properties.put("listTinhTrangs", command.getMapTinhTrangs());
            }
        }
        return properties;
    }

    private void referenceData(BidCommand command, ModelAndView mav) throws ObjectNotFoundException {
        Map<String, Object> mapPropertiesDepartment = new HashMap<String, Object>();
        Map<String, Object> properties = new HashMap<String, Object>();

        mapPropertiesDepartment.put("active", 1);
        mav.addObject("departments", departmentService.search(mapPropertiesDepartment, "", "", -1, -1)[1]);
        mav.addObject("loais", loaiService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("lanhdaos", lanhDaoService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);

        if (SecurityUtils.userHasAuthority("NVPBK")){
            properties.put("mahinhthuc", "CGCT");
        }
        mav.addObject("hinhthucs", hinhThucService.searchByProperties(properties, "", "", -1, -1)[1]);
        mav.addObject("tinhchats", tinhChatService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("quimos", quiMoService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("tinhtrangs", tinhTrangService.searchByProperties(new HashMap<String, Object>(), "displayOrder", "", -1, -1)[1]);
        mav.addObject("nguonvons", nguonVonService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("userXetThau", userService.findAllUserWithGroup(Constants.GROUP_XETTHAU));
        mav.addObject("userThamDinh", userService.findAllUserWithGroup(Constants.GROUP_THAMDINH));
        mav.addObject("listNhanVien", userService.findAll());

        List<FormTemplateDTO> listForm = formTemplateManagementLocalBean.findALL();
        mav.addObject("listForm", listForm);

        if (command.getPojo() != null && command.getPojo().getMsgoithau() != null){
            Map<String, String> mapStoreFile = storeFileManagementLocalBean.findMapUrlByMsGoiThau(command.getPojo().getMsgoithau());
            mav.addObject(Constants.fileCongVanPheDuyetPA, mapStoreFile.get(command.getPojo().getMsgoithau()+ Constants.fileCongVanPheDuyetPA));
            Map<String, String> mapUrl = new HashMap<>();
            for (FormTemplateDTO dto : listForm){
                mapUrl.put(dto.getBieuMau(), mapStoreFile.get(command.getPojo().getMsgoithau() + dto.getBieuMau()));
            }
            mav.addObject("mapUrl", mapUrl);
        }
    }

    private List<StoreFileDTO> saveFileJcr(BidCommand command, HttpServletRequest request) throws ObjectNotFoundException {
        List<StoreFileDTO> listUrlFile = new ArrayList<>();
        List<FormTemplateDTO> ListForm = formTemplateManagementLocalBean.findALL();
        Map<String, String> urlFileJcrOld = storeFileManagementLocalBean.findMapUrlByMsGoiThau(command.getPojo().getMsgoithau());
        listUrlFile.add(extractFileUpload(command, urlFileJcrOld.get(command.getPojo().getMsgoithau()+ Constants.fileCongVanPheDuyetPA), Constants.fileCongVanPheDuyetPA, request));
        for (FormTemplateDTO dto : ListForm){
            listUrlFile.add(extractFileUpload(command, urlFileJcrOld.get(command.getPojo().getMsgoithau()+ dto.getBieuMau()), dto.getBieuMau(), request));
        }
        return listUrlFile;
    }

    private StoreFileDTO extractFileUpload(BidCommand command, String urlFileJcrOld, String inputName, HttpServletRequest request){
        StoreFileDTO dto = new StoreFileDTO();
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> map = mRequest.getFileMap();
        if (map.get(inputName)!= null){
            MultipartFile fileUpload = (MultipartFile) map.get(inputName);
            if (fileUpload!= null && fileUpload.getSize() > 0){
                com.banvien.jcr.api.FileItem fileCVPDPA = BeanUtils.multipartFile2FileItem(fileUpload);
                fileCVPDPA.setOriginalFilename(StringUtil.removeBlankSpace(fileCVPDPA.getOriginalFilename().trim()));
                String fpath = command.getPojo().getMagoithau() + "/" + inputName;
                String fpathCheck = command.getPojo().getMagoithau() + "/" + inputName + "/" + fileCVPDPA.getOriginalFilename();
                if (!fpathCheck.equalsIgnoreCase(urlFileJcrOld)){
                    if (urlFileJcrOld != null){
                        jcrContent.removeFileItem(urlFileJcrOld);
                    }
                    dto.setFullPath(jcrContent.writeOrUpdate(fpath, fileCVPDPA));
                    dto.setTypeVar(inputName);
                    dto.setGoiThau(command.getPojo());
                }
            }
        }
        return dto;
    }
}
