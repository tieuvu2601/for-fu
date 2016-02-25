package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.util.NumberUtil;
import com.banvien.vmsreport.util.ReplaceVariablesUtils;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.FormTemplateCommand;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FormTemplateController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(this.getClass());
    static final String resourcesPath = System.getProperty("user.dir") + File.separator + "files//temp";
    static final String docxPath = resourcesPath + "docx" + File.separator;

    @Autowired
    private FormTemplateManagementLocalBean formTemplateManagementLocalBean;
    @Autowired
    private NguonvonManagementLocalBean nguonvonManagementLocalBean;
    @Autowired
    private LoaiManagementLocalBean loaiManagementLocalBean;
    @Autowired
    private DepartmentManagementLocalBean departmentManagementLocalBean;
    @Autowired
    private UserManagementLocalBean userManagementLocalBean;
    @Autowired
    private QuyMoManagementLocalBean quimoManagementLocalBean;
    @Autowired
    private HinhthucManagementLocalBean hinhthucManagementLocalBean;
    @Autowired
    private TinhtrangManagementLocalBean tinhtrangManagementLocalBean;
    @Autowired
    private TienDoManagementLocalBean tienDoManagementLocalBean;
    @Autowired
    private BidManagementLocalBean bidManagementLocalBean;
    @Autowired
    private GoiThauNhanVienManagementLocalBean goiThauNhanVienManagementLocalBean;
    @Autowired
    private GoiThauNhaThauManagementLocalBean goiThauNhaThauManagementLocalBean;
    @Autowired
    private HoSoThauManagementLocalBean hoSoThauManagementLocalBean;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL(Constants.DATE_FORMAT));
    }

    @RequestMapping(value = {"/admin/form/list.*", "/normal/form/list.*"})
    public ModelAndView list(@ModelAttribute(value = Constants.FORM_MODEL_KEY)FormTemplateCommand command,
                             HttpServletRequest request,
                             HttpServletResponse response) throws JAXBException, Docx4JException {
        ModelAndView mav = new ModelAndView("/admin/form/list");
        String crudaction = command.getCrudaction();
        if (StringUtils.isNotBlank(crudaction)){
            if(Constants.ACTION_SEARCH.equalsIgnoreCase(crudaction)){
                executeSearch(request, command);
            }
            if (Constants.ACTION_EXPORT.equalsIgnoreCase(crudaction)){
                export2Form(request, command, response);
            }
        }
        referenceData(command, mav);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value = "/ajax/bieumau/export.html")
    public @ResponseBody
    String exportBieuMau(@RequestParam(value = "bieuMau", required = false)String bieuMau,
                              @RequestParam(value = "goithauid", required = false)Long goithauid,
                              @RequestParam(value = "loaiBao", required = false)String loaiBao,
                              @RequestParam(value = "msNhaThau", required = false)Long msNhaThau,
                              HttpServletRequest request) throws ObjectNotFoundException {

        SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        String ngayXuatBaoCao = df.format(currentTimestamp);
        FormTemplateDTO formTemplateDTO = formTemplateManagementLocalBean.findByBieuMau(bieuMau);

        String outputFileName = "/files/" + formTemplateDTO.getBieuMau() + ngayXuatBaoCao + ".docx";
        String reportTemplate = request.getSession().getServletContext().getRealPath("/files/bieumau/"+ formTemplateDTO.getGhiChu() + "/" + formTemplateDTO.getBieuMau() +".docx");
        String export2FileName = request.getSession().getServletContext().getRealPath(outputFileName);

        export2Word(reportTemplate, export2FileName, goithauid, msNhaThau, formTemplateDTO);
        return outputFileName;
    }

    private void export2Word(String docx, String outputDocx, Long goithauid, Long msNhaThau, FormTemplateDTO formTemplateDTO) {
        try {
            DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            BidDTO goithau = this.bidManagementLocalBean.findId(goithauid);
            TienDoDTO tienDoDTO = tienDoManagementLocalBean.findByGoiThauId(goithauid);
            StringBuffer listNhaCungCapKDC = new StringBuffer();
            HoSoThauDTO hoSoThauDTO = new HoSoThauDTO();
            for (GoithaunhathauDTO goithaunhathauDTO : goithau.getGoiThauNhaThaus()){
                if (Constants.IS_TRUNGTHAU.equals(goithaunhathauDTO.getIstrungthau())){
                    hoSoThauDTO = hoSoThauManagementLocalBean.findByGoiThauNhaThau(goithaunhathauDTO.getMsgoithauNt());
                }else{
                    listNhaCungCapKDC.append(goithaunhathauDTO.getNhathau().getTennhathau()).append(", ");
                }
            }
            if (msNhaThau != null){
                GoithaunhathauDTO goithaunhathauDTO = goiThauNhaThauManagementLocalBean.findByGoiThauAndNhanThau(goithauid, msNhaThau);
                hoSoThauDTO = hoSoThauManagementLocalBean.findByGoiThauNhaThau(goithaunhathauDTO.getMsgoithauNt());
            }

            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(docx));
            VariablePrepare.prepare(wordMLPackage);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            HashMap<String, String> variableMappings = new HashMap<>();
            variableMappings.put("tengoithau", StringUtils.isNotBlank(goithau.getTengoithau()) ? goithau.getTengoithau() : "");
            variableMappings.put("tenpada", StringUtils.isNotBlank(goithau.getTenpada()) ? goithau.getTenpada() : "");
            variableMappings.put("titlePADA", goithau.getNguonvon().getGhichu() != null ? goithau.getNguonvon().getGhichu() : "");
            variableMappings.put("giaDuocDuyet", goithau.getGiatrigoithau() != null ? myFormatter.format(goithau.getGiatrigoithau()) : "");
            if (tienDoDTO.getBienBanThuongThaoSo() != null || tienDoDTO.getBienBanThuongThaoNgay() != null){
                String bienBanThuongThao = "Biên bản thương thảo ngày " + df.format(tienDoDTO.getBienBanThuongThaoNgay());
                variableMappings.put("bienBanThuongThao", bienBanThuongThao);
                if (hoSoThauDTO != null && hoSoThauDTO.getGoithau_nhathau() != null && hoSoThauDTO.getGoithau_nhathau().getNhathau() != null){
                    String nhaThauThuongThao = "và tiến hành thương thảo với nhà thầu " + hoSoThauDTO.getGoithau_nhathau().getNhathau().getTennhathau();
                    variableMappings.put("nhaThauThuongThao", nhaThauThuongThao);
                }
            }else {
                variableMappings.put("bienBanThuongThao", "");
                variableMappings.put("nhaThauThuongThao", "");
            }
            if (hoSoThauDTO != null ){
                if (hoSoThauDTO.getGoithau_nhathau() != null && hoSoThauDTO.getGoithau_nhathau().getNhathau() != null ){
                    variableMappings.put("nhaThauChon", hoSoThauDTO.getGoithau_nhathau().getNhathau().getTennhathau() != null ? hoSoThauDTO.getGoithau_nhathau().getNhathau().getTennhathau() : "");
                    variableMappings.put("nhaThauChonDiaChi", hoSoThauDTO.getGoithau_nhathau().getNhathau().getDiachi() != null ? hoSoThauDTO.getGoithau_nhathau().getNhathau().getDiachi() : "");
                    variableMappings.put("nhaThauChonDT", hoSoThauDTO.getGoithau_nhathau().getNhathau().getDienthoai() != null ? hoSoThauDTO.getGoithau_nhathau().getNhathau().getDienthoai() : "");
                    variableMappings.put("nhaThauChonFAX", hoSoThauDTO.getGoithau_nhathau().getNhathau().getFax() != null ? hoSoThauDTO.getGoithau_nhathau().getNhathau().getFax() : "");
                }
                if (hoSoThauDTO.getNoiDungHoSo() != null){
                    if (hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue() != null){
                        variableMappings.put("giaDeNghiNhaThauso", myFormatter.format(hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue()));
                        variableMappings.put("giaDeNghiNhaThauchu", NumberUtil.formatNumberForRead(hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue()));
                    }else {
                        variableMappings.put("giaDeNghiNhaThauso", "");
                        variableMappings.put("giaDeNghiNhaThauchu", "");
                    }
                    if (hoSoThauDTO.getNoiDungHoSo().getGiaDuThau() != null){
                        variableMappings.put("giaDeNghiNhaThautruocthue", myFormatter.format(hoSoThauDTO.getNoiDungHoSo().getGiaDuThau()));
                    }
                    if (hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue() != null && hoSoThauDTO.getNoiDungHoSo().getGiaDuThau() != null){
                        variableMappings.put("thueVAT", myFormatter.format(hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue() - hoSoThauDTO.getNoiDungHoSo().getGiaDuThau()));
                    }else {
                        variableMappings.put("thueVAT", "");
                    }
                    if (hoSoThauDTO.getNoiDungHoSo().getThoiGianThucHien() != null){
                        variableMappings.put("thoiGianThucHienHD", hoSoThauDTO.getNoiDungHoSo().getThoiGianThucHien());
                    }
                    if (hoSoThauDTO.getNoiDungHoSo().getThoiGianThucHien() != null){
                        variableMappings.put("hinhThucHopDong", hoSoThauDTO.getNoiDungHoSo().getHinhThucGiaTriThoiHan());
                    }
                }

            }
            if (StringUtils.isNotBlank(listNhaCungCapKDC.toString())){
                variableMappings.put("nhaCungCapKDC", listNhaCungCapKDC.toString());
            }
            variableMappings.put("toTrinhDanhSachTCGso", tienDoDTO.getTrinhtcgSo() != null ? tienDoDTO.getTrinhtcgSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getTrinhtcgNgay(), "toTrinhDanhSachTCG");
            variableMappings.put("trinhPheDuyetPADAso", goithau.getSocvTrinhpd() != null ? goithau.getSocvTrinhpd() : "");
            setDate2Map(variableMappings, goithau.getNgaycvTrinhpd(), "trinhPheDuyetPADA");
            variableMappings.put("quyetDinhPheDuyetPADAso", tienDoDTO.getQdPheDuyetSo() != null ? tienDoDTO.getQdPheDuyetSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getQdPheDuyetNgay(), "quyetDinhPheDuyetPADA");
            variableMappings.put("quyetDinhLapTCGso", tienDoDTO.getTcgSo() != null ? tienDoDTO.getTcgSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getTcgNgay(), "quyetDinhLapTCG");
            variableMappings.put("trinhHSMT-HSYCso", tienDoDTO.getTrinhhsSo() != null ? tienDoDTO.getTrinhhsSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getTrinhhsNgay(), "trinhHSMT-HSYC");
            variableMappings.put("DuyetHSMT-HSYCso", tienDoDTO.getDuyethsSo() != null ? tienDoDTO.getDuyethsSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getDuyethsNgay(), "DuyetHSMT-HSYC");
            variableMappings.put("trinhPheDuyetKetQuaso", tienDoDTO.getTrinhkqSo() != null ? tienDoDTO.getTrinhkqSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getTrinhkqNgay(), "trinhPheDuyetKetQua");
            variableMappings.put("QuyetDinhPDKetQuaso", tienDoDTO.getPheduyetkqSo() != null ? tienDoDTO.getPheduyetkqSo() : "");
            setDate2Map(variableMappings, tienDoDTO.getPheduyetkqNgay(), "QuyetDinhPDKetQua");
            setDate2Map(variableMappings, tienDoDTO.getBaocaodgNgay(), "baoCaoDanhGia");
            if (goithau.getDepartment() != null && StringUtils.isNotBlank(goithau.getDepartment().getName())){
                variableMappings.put("phongBan", goithau.getDepartment().getName());
            }else {
                variableMappings.put("phongBan", "");
            }
            int i = 1;
            for (GoithaunhanvienDTO goithaunhanvienDTO : goithau.getToChuyenGias()){
                if (Constants.IS_CHAIR.equals(goithaunhanvienDTO.getIschutri())){
                    variableMappings.put("toTruong", goithaunhanvienDTO.getUser().getHoNhanVien() + " " + goithaunhanvienDTO.getUser().getTenNhanVien());
                }else {
                    variableMappings.put("toVien" + i++, goithaunhanvienDTO.getUser().getHoNhanVien() + " " + goithaunhanvienDTO.getUser().getTenNhanVien());
                }

            }

            Integer slNhaThauNopHSDX = addNhaThauBulletList(goithau.getGoiThauNhaThaus(), wordMLPackage);
            variableMappings.put("slNhaThauNopHSDX", slNhaThauNopHSDX.toString());
            documentPart.variableReplace(variableMappings);

            addToChuyenGia(goithau.getToChuyenGias(), wordMLPackage);
            addNhaThauNhan(goithau.getGoiThauNhaThaus(), wordMLPackage);
            addNhaThauNop(goithau.getGoiThauNhaThaus(), wordMLPackage);
            addColummNhaThau(goithau.getGoiThauNhaThaus(), formTemplateDTO, wordMLPackage);

            wordMLPackage.save(new File(outputDocx));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Integer addNhaThauBulletList(List<GoithaunhathauDTO> nhaThaus, WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {
        String[] labelHeader = new String[]{"nhaThauInHSDX"};
        List<String> listText = new ArrayList<>();
        Integer slNhaThauNopHSDX = 0;
        for (GoithaunhathauDTO  dto : nhaThaus){
            if (dto.getNgaynophs() != null){
                listText.add(dto.getNhathau().getTennhathau());
                slNhaThauNopHSDX++;
            }
        }
        ReplaceVariablesUtils.replaceBulletList(labelHeader[0], listText, wordMLPackage);
        return slNhaThauNopHSDX;
    }

    private void addNhaThauNop(List<GoithaunhathauDTO> nhaThaus, WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {
        String[] labelHeader = new String[]{"STT_NCCNOP", "TENNOP"};
        List<Map<String, String>> listMapText = new ArrayList<>();
        for (GoithaunhathauDTO  dto : nhaThaus){
            Map<String, String> map = new HashMap<>();
            if (dto.getNgaynophs() != null){
                map.put(labelHeader[0], String.valueOf(nhaThaus.indexOf(dto) + 1));
                map.put(labelHeader[1], dto.getNhathau().getTennhathau());
                listMapText.add(map);
            }
        }
        ReplaceVariablesUtils.replaceTable(labelHeader, listMapText, wordMLPackage);
    }

    private void addNhaThauNhan(List<GoithaunhathauDTO> nhaThaus, WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {
        String[] labelHeader = new String[]{"STT_NCCN", "TENNHAN"};
        List<Map<String, String>> listMapText = new ArrayList<>();
        for (GoithaunhathauDTO  dto : nhaThaus){
            Map<String, String> map = new HashMap<>();
            if (dto.getNgaymuahs() != null){
                map.put(labelHeader[0], String.valueOf(nhaThaus.indexOf(dto) + 1));
                map.put(labelHeader[1], dto.getNhathau().getTennhathau());
                listMapText.add(map);
            }
        }
        ReplaceVariablesUtils.replaceTable(labelHeader, listMapText, wordMLPackage);
    }

    private void addColummNhaThau(List<GoithaunhathauDTO> nhaThaus, FormTemplateDTO formTemplateDTO, WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException, ObjectNotFoundException {
        DecimalFormat myFormatter = new DecimalFormat("###,###.###");
        String[] labelHeader;
        labelHeader = new String[]{"NHACUNGCAP", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        List<Map<String, String>> listMapText = new ArrayList<>();
        for (GoithaunhathauDTO  dto : nhaThaus){
            HoSoThauDTO hoSoThauDTO = hoSoThauManagementLocalBean.findByGoiThauNhaThau(dto.getMsgoithauNt());
            Map<String, String> map = new HashMap<>();
            map.put(labelHeader[0], dto.getNhathau().getTennhathau());
            if (hoSoThauDTO.getNoiDungHoSo() != null){
                map.put(labelHeader[1], StringUtils.isNotBlank(hoSoThauDTO.getNoiDungHoSo().getTinhTrangNiemPhong()) ? hoSoThauDTO.getNoiDungHoSo().getTinhTrangNiemPhong() : "");
                Integer soLuongBGBC = 0;
                if (hoSoThauDTO.getNoiDungHoSo().getSoLuongBanGoc() != null){
                    soLuongBGBC = soLuongBGBC + hoSoThauDTO.getNoiDungHoSo().getSoLuongBanGoc();
                }
                if (hoSoThauDTO.getNoiDungHoSo().getSoLuongBanChup() != null){
                    soLuongBGBC = soLuongBGBC + hoSoThauDTO.getNoiDungHoSo().getSoLuongBanChup();
                }
                map.put(labelHeader[2], soLuongBGBC.toString());
                map.put(labelHeader[3], StringUtils.isNotBlank(hoSoThauDTO.getNoiDungHoSo().getThoiGianCoHieuLuc()) ? hoSoThauDTO.getNoiDungHoSo().getThoiGianCoHieuLuc() : "" );
                map.put(labelHeader[4], hoSoThauDTO.getNoiDungHoSo().getGiaDuThau() != null ? myFormatter.format(hoSoThauDTO.getNoiDungHoSo().getGiaDuThau()) : "");
                map.put(labelHeader[5], hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue() != null ? myFormatter.format(hoSoThauDTO.getNoiDungHoSo().getGiaDuThauSauThue()) : "");
                map.put(labelHeader[6], hoSoThauDTO.getNoiDungHoSo().getGiamGia() != null ? myFormatter.format(hoSoThauDTO.getNoiDungHoSo().getGiamGia()) : "");
                map.put(labelHeader[7], StringUtils.isNotBlank(hoSoThauDTO.getNoiDungHoSo().getThoiGianThucHien()) ? hoSoThauDTO.getNoiDungHoSo().getThoiGianThucHien() : "");
                map.put(labelHeader[8], StringUtils.isNotBlank(hoSoThauDTO.getNoiDungHoSo().getDieuKienThanhToan()) ? hoSoThauDTO.getNoiDungHoSo().getDieuKienThanhToan() : "");
                map.put(labelHeader[9], StringUtils.isNotBlank(hoSoThauDTO.getNoiDungHoSo().getBaoHanh()) ? hoSoThauDTO.getNoiDungHoSo().getBaoHanh() : "");
                map.put(labelHeader[10], StringUtils.isNotBlank(hoSoThauDTO.getNoiDungHoSo().getHinhThucGiaTriThoiHan()) ? hoSoThauDTO.getNoiDungHoSo().getHinhThucGiaTriThoiHan() : "");

            }else {
                map.put(labelHeader[1], "");
                map.put(labelHeader[2], "");
                map.put(labelHeader[3], "");
                map.put(labelHeader[4], "");
                map.put(labelHeader[5], "");
                map.put(labelHeader[6], "");
                map.put(labelHeader[7], "");
                map.put(labelHeader[8], "");
                map.put(labelHeader[9], "");
                map.put(labelHeader[10], "");
            }

            listMapText.add(map);
        }
        ReplaceVariablesUtils.AddColumn(labelHeader, listMapText, wordMLPackage);
    }

    private void addToChuyenGia(List<GoithaunhanvienDTO> toChuyenGia, WordprocessingMLPackage wordMLPackage) throws JAXBException, Docx4JException {
        String[] labelHeader = new String[]{"STT_TCG", "HOVATEN", "TRINHDOCHUYENMON", "CHUCDANH"};
        List<Map<String, String>> listMapText = new ArrayList<>();
        for (GoithaunhanvienDTO  dto : toChuyenGia){
            Map<String, String> map = new HashMap<>();
            map.put(labelHeader[0], String.valueOf(toChuyenGia.indexOf(dto) + 1));
            map.put(labelHeader[1], dto.getUser().getHoNhanVien() + " " + dto.getUser().getTenNhanVien());
            map.put(labelHeader[2], dto.getUser().getChuyenNganh());
            map.put(labelHeader[3], Constants.IS_CHAIR.equals(dto.getIschutri()) ? "Tổ trưởng" : "Tổ viên");
            listMapText.add(map);
        }
        ReplaceVariablesUtils.replaceTable(labelHeader, listMapText, wordMLPackage);

    }

    private void referenceDataExport(FormTemplateCommand command) {

    }

    private void referenceData(FormTemplateCommand command, ModelAndView mav) {
        List<NguonvonDTO> listNguonVon =  nguonvonManagementLocalBean.findAll();
        mav.addObject("listNguonVon", listNguonVon);

        List<LoaiDTO> listLoai = loaiManagementLocalBean.findAll();
        mav.addObject("listLoai", listLoai);

        List<DepartmentDTO> listDepartment = departmentManagementLocalBean.findALL();
        mav.addObject("listDepartment", listDepartment);

        List<UserDTO> listChuTri = userManagementLocalBean.findAll();
        mav.addObject("listChuTri", listChuTri);

        List<UserDTO> listThanhVien = userManagementLocalBean.findAll();
        mav.addObject("listThanhVien", listThanhVien);

        List<QuyMoDTO> listQuiMo = quimoManagementLocalBean.findAll();
        mav.addObject("listQuiMo", listQuiMo);

        List<HinhthucgtDTO> listHinhThuc = hinhthucManagementLocalBean.findAll();
        mav.addObject("hinhthucs", listHinhThuc);

        List<TinhtrangDTO> listTinhTrang = tinhtrangManagementLocalBean.findAll();
        mav.addObject("tinhtrangs", listTinhTrang);

        List<FormTemplateDTO> listForm = formTemplateManagementLocalBean.findALL();
        mav.addObject("listForm", listForm);
    }

    private void executeSearch(HttpServletRequest request, FormTemplateCommand command) {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);
        Object[] results = formTemplateManagementLocalBean.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<FormTemplateDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(FormTemplateCommand command) {
        Map<String, Object> properties = new HashMap<>();
        if (command.getPojo().getMsNguonVon() != null){
            properties.put("nguonVon", command.getPojo().getMsNguonVon());
        }
        if (command.getPojo().getMsLoai() != null){
            properties.put("loaiDauTu", command.getPojo().getMsLoai());
        }
        if (command.getPojo().getMsPhong() != null){
            properties.put("department", command.getPojo().getMsPhong());
        }
        if (command.getPojo().getMsChuTri() != null){
            properties.put("chair", command.getPojo().getMsChuTri());
        }
        if (command.getPojo().getMsThanhVien() != null){
            properties.put("user", command.getPojo().getMsThanhVien());
        }
        if (command.getPojo().getMsQuiMo() != null){
            properties.put("quiMo", command.getPojo().getMsQuiMo());
        }
        if (StringUtils.isNotBlank(command.getPojo().getQdPheDuyetSo())) {
            properties.put("qdPhuongAnDuAn", command.getPojo().getQdPheDuyetSo());
        }
        if (StringUtils.isNotBlank(command.getPojo().getMaGoiThau())){
            properties.put("maGoiThau", command.getPojo().getMaGoiThau());
        }
        if (StringUtils.isNotBlank(command.getPojo().getTenGoiThau())){
//            properties.put("tenGoiThau", "sua");
            properties.put("tenGoiThau", command.getPojo().getTenGoiThau());
        }
        if (command.getCheckListHinhThuc() != null && command.getCheckListHinhThuc().size() > 0 && command.getCheckListHinhThuc().get(0) != -1){
            properties.put("hinhThuc", command.getCheckListHinhThuc());
        }
        if (command.getCheckListTinhTrang() != null && command.getCheckListTinhTrang().size() > 0 && command.getCheckListTinhTrang().get(0) != -1){
            properties.put("tinhTrang", command.getCheckListTinhTrang());
        }
        if (command.getFromDate() !=  null){
            properties.put("fromDate", command.getFromDate());
        }
        if (command.getToDate() != null){
            properties.put("toDate", command.getToDate());
        }
        return properties;
    }

    private void export2Form(HttpServletRequest request, FormTemplateCommand command, HttpServletResponse response) throws JAXBException, Docx4JException {
        try {
            DecimalFormat myFormatter = new DecimalFormat("###,###.###");
            List<GoithaunhanvienDTO> goithaunhanvienDTOs = goiThauNhanVienManagementLocalBean.findByMaGoiThau(command.getMaGoiThau());
            List<GoithaunhathauDTO> goithaunhathauDTOs = goiThauNhaThauManagementLocalBean.findByMaGoiThau(command.getMaGoiThau());
            BidDTO bidDTO = bidManagementLocalBean.findByCode(command.getMaGoiThau());
            TienDoDTO tienDoDTO = tienDoManagementLocalBean.findByMaGoiThau(command.getMaGoiThau());
            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            String ngayXuatBaoCao = df.format(currentTimestamp);

            String outputFileName = "/files/"+ command.getPojo().getBieuMau() + ngayXuatBaoCao + ".docx";
            String reportTemplate = request.getSession().getServletContext().getRealPath("/files/bieumau/" + command.getPojo().getBieuMau() +".docx");
            String export2FileName = request.getSession().getServletContext().getRealPath(outputFileName);

            HashMap<String, String> maps = new HashMap<>();
            maps.put("@tenpada", bidDTO.getTenpada() != null ? bidDTO.getTenpada() : "");
            maps.put("@tenGoiThau", bidDTO.getTengoithau() != null ? bidDTO.getTengoithau() : "");
            maps.put("@mucTieu", bidDTO.getNoidung() != null ? bidDTO.getNoidung() : "");
            maps.put("@kinhPhi", bidDTO.getGiatrigoithau() != null ? myFormatter.format(bidDTO.getGiatrigoithau()) : "");

            maps.put("@bcThamDinhSo", tienDoDTO.getBaoCaoThamDinhSo() != null ? tienDoDTO.getBaoCaoThamDinhSo() : "123");
            setDate2Map(maps, tienDoDTO.getBaoCaoThamDinhNgay(), "@bcThamDinh");
            maps.put("@CongVanso", bidDTO.getSocvTrinhpd() != null ? bidDTO.getSocvTrinhpd() : "");
            setDate2Map(maps, bidDTO.getNgaycvTrinhpd(), "@CongVan");
            maps.put("@trinhhsSo", tienDoDTO.getTrinhhsSo() != null ? tienDoDTO.getTrinhhsSo() : "");
            setDate2Map(maps, tienDoDTO.getTrinhhsNgay(), "@trinhhs");
            maps.put("@QuyetDinhPDPAso", tienDoDTO.getTrinhhsNgay() != null ? tienDoDTO.getQdPheDuyetSo() : "");
            setDate2Map(maps, tienDoDTO.getQdPheDuyetNgay(), "@QuyetDinhPDPA");
            maps.put("@QuyetDinhTLTCGso", tienDoDTO.getTcgSo() != null ? tienDoDTO.getTcgSo() : "");
            setDate2Map(maps, tienDoDTO.getTcgNgay(), "@QuyetDinhTLTCG");
            maps.put("@trinhkqso", tienDoDTO.getTrinhkqSo() != null ? tienDoDTO.getTrinhkqSo() : "");
            setDate2Map(maps, tienDoDTO.getTrinhkqNgay(), "@trinhkq");
            maps.put("@bcThamDinhKetQuaSo", tienDoDTO.getBcThamDinhKetQuaSo() != null ? tienDoDTO.getBcThamDinhKetQuaSo() : "");
            setDate2Map(maps, tienDoDTO.getBcThamDinhKetQuaNgay(), "@bcThamDinhKetQua");
            maps.put("@pheduyetkqSo", tienDoDTO.getPheduyetkqSo() != null ? tienDoDTO.getPheduyetkqSo() : "");
            setDate2Map(maps, tienDoDTO.getPheduyetkqNgay(), "@pheduyetkq");
            maps.put("@thongBaoKetQuaso", tienDoDTO.getThongbaokqSo() != null ? tienDoDTO.getThongbaokqSo() : "");
            setDate2Map(maps, tienDoDTO.getThongbaokqNgay(), "@thongBaoKetQua");
            maps.put("@QuyetDinhPheDuyetHSso", tienDoDTO.getDuyethsSo() != null ? tienDoDTO.getDuyethsSo() : "");
            setDate2Map(maps, tienDoDTO.getDuyethsNgay(), "@QuyetDinhPheDuyetHS");

            if (bidDTO.getHinhthucgt() != null && bidDTO.getHinhthucgt().getTenhinhthuc() != null ){
                maps.put("@hinhThuc", bidDTO.getHinhthucgt().getTenhinhthuc());
            }else {
                maps.put("@hinhThuc", "");
            }
            if (bidDTO.getDepartment() != null && bidDTO.getDepartment().getName() != null){
                maps.put("@phongBan",  bidDTO.getDepartment().getName());
            }else {
                maps.put("@phongBan",  "");
            }
            if (bidDTO.getQuimo() != null && bidDTO.getQuimo().getTenquimo() != null){
                maps.put("@quyMo",  bidDTO.getQuimo().getTenquimo());
            }else {
                maps.put("@quyMo",  "");
            }
            if (bidDTO.getNguonvon() != null && bidDTO.getNguonvon().getTennguonvon() != null){
                maps.put("@nguonVon",  bidDTO.getNguonvon().getTennguonvon());
            }else {
                maps.put("@nguonVon",  "");
            }
            if (goithaunhathauDTOs.get(goithaunhathauDTOs.size()-1).getNhathau() != null && StringUtils.isNotBlank(goithaunhathauDTOs.get(goithaunhathauDTOs.size()-1).getNhathau().getTennhathau())){
                maps.put("@nhaThauTrungThau", goithaunhathauDTOs.get(goithaunhathauDTOs.size()-1).getNhathau().getTennhathau());
            }else {
                maps.put("@nhaThauTrungThau", "");
            }

            Object[] resultObject = new Object[4];
            List<String[]> listLabelHeader = new ArrayList<>();
            if (!command.getPojo().getBieuMau().equalsIgnoreCase("15-BienBanMoHSCGCT")){
                listLabelHeader.add(new String[]{"varSTT", "varHOVATEN", "varCHUCDANH"});
            }else {
                listLabelHeader.add(new String[]{"varHOVATEN", "varCHUCDANH"});
            }
            resultObject[0] = createMapTable(listLabelHeader.get(0), goithaunhanvienDTOs, GoithaunhanvienDTO.class);

            listLabelHeader.add(new String[]{"varSTT", "varTENNHATHAU", "varHSMCGCT", "varHSDX"});
            resultObject[1] = createMapTable(listLabelHeader.get(1), goithaunhathauDTOs, GoithaunhathauDTO.class);

            listLabelHeader.add(new String[]{"varSTT", "varTENNHATHAU"});
            resultObject[2] = createMapTable(listLabelHeader.get(2), goithaunhathauDTOs, GoithaunhathauDTO.class);

            listLabelHeader.add(new String[]{"danhSachNT"});
            resultObject[3] = createMapTable(listLabelHeader.get(3), goithaunhathauDTOs, GoithaunhathauDTO.class);

            ReplaceVariablesUtils.replace(reportTemplate, export2FileName, maps, listLabelHeader, resultObject);
            response.sendRedirect(request.getSession().getServletContext().getContextPath() + outputFileName);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private <T> List<Map<String, String>> createMapTable(String[] labelHeader, List<T> listObject, Class<T> dtoClass) {
        List<Map<String, String>> maps = new ArrayList<>();
        GoithaunhanvienDTO goithaunhanvienDTO = new GoithaunhanvienDTO();
        GoithaunhathauDTO goithaunhathauDTO = new GoithaunhathauDTO();
        int labelIndex;
        int index = 1;
        for (T dto : listObject){
            if (dto.getClass() == goithaunhathauDTO.getClass()){
                goithaunhathauDTO = (GoithaunhathauDTO) dto;
            }else if (dto.getClass() == goithaunhanvienDTO.getClass()){
                goithaunhanvienDTO = (GoithaunhanvienDTO) dto;
            }
            labelIndex = 0;
            Map<String, String> map = new HashMap<>();
            
            if (labelIndex < labelHeader.length && Constants.varSTT.equalsIgnoreCase(labelHeader[labelIndex])){
                map.put(labelHeader[labelIndex++], String.valueOf(index++));
            }
            if (labelIndex < labelHeader.length && Constants.varHOVATEN.equalsIgnoreCase(labelHeader[labelIndex])){
                if (goithaunhanvienDTO.getUser() != null && StringUtils.isNotBlank(goithaunhanvienDTO.getUser().getDisplayName())){
                    String gioiTinh = "";
                    if (!ArrayUtils.contains(labelHeader, Constants.varSTT) && goithaunhanvienDTO.getUser().getGioiTinh() != null){
                        gioiTinh = (goithaunhanvienDTO.getUser().getGioiTinh().equals(1) ? "Ông: " : "Bà: ");
                    }
                    map.put(labelHeader[labelIndex++], gioiTinh + goithaunhanvienDTO.getUser().getDisplayName());
                }
            }
            if (labelIndex < labelHeader.length && Constants.varCHUCDANH.equalsIgnoreCase(labelHeader[labelIndex])){
                map.put(labelHeader[labelIndex++], Constants.IS_CHAIR.equals(goithaunhanvienDTO.getIschutri()) ? "Tổ trưởng" : "Tổ viên");
            }
            if (labelIndex < labelHeader.length && Constants.varTENNHATHAU.equalsIgnoreCase(labelHeader[labelIndex])){
                if (goithaunhathauDTO.getNhathau() != null && StringUtils.isNotBlank(goithaunhathauDTO.getNhathau().getTennhathau())){
                    map.put(labelHeader[labelIndex++], goithaunhathauDTO.getNhathau().getTennhathau());
                }
            }
            if (labelIndex < labelHeader.length && Constants.varHSMCGCT.equalsIgnoreCase(labelHeader[labelIndex])){
                map.put(labelHeader[labelIndex++], "");
            }
            if (labelIndex < labelHeader.length && Constants.varHSDX.equalsIgnoreCase(labelHeader[labelIndex])){
                map.put(labelHeader[labelIndex++], "");
            }
            if (labelIndex < labelHeader.length && labelHeader[labelIndex].equalsIgnoreCase("danhSachNT")){
                if (goithaunhathauDTO.getNhathau() != null && StringUtils.isNotBlank(goithaunhathauDTO.getNhathau().getTennhathau())){
                    map.put("0", goithaunhathauDTO.getNhathau().getTennhathau());
                }else {
                    map.put("0", "");
                }
                map.put("1", "");
                map.put("2", "");
                map.put("3", "");
                map.put("4", "");
            }

            maps.add(map);
        }
        return maps;  //To change body of created methods use File | Settings | File Templates.
    }

    private void setDate2Map(HashMap<String, String> maps, Timestamp varDate, String varForm){
        if (varDate != null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(varDate);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            maps.put(varForm + "ngay", String.valueOf(day));
            maps.put(varForm + "thang", String.valueOf(month));
            maps.put(varForm + "nam", String.valueOf(year));
        }else {
            maps.put(varForm + "ngay", "");
            maps.put(varForm + "thang", "");
            maps.put(varForm + "nam", "");
        }
    }
}
