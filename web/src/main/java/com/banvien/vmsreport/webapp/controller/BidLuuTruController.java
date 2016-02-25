package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomCurrencyFormatEditor;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.editor.PojoEditor;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.ExcelUtil;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.BidCommand;
import com.banvien.vmsreport.webapp.dto.CellDataType;
import com.banvien.vmsreport.webapp.dto.CellValue;
import com.banvien.vmsreport.webapp.validator.BidValidator;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/18/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BidLuuTruController extends ApplicationObjectSupport{
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
    private BidLuuTruManagementLocalBean bidLuuTruService;

    @Autowired
    private BidValidator bidValidator;

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
    }

    @RequestMapping(value={"/admin/hosoluutru/list.html", "/normal/hosoluutru/list.html"})
    public ModelAndView portalAdminView(@ModelAttribute(Constants.FORM_MODEL_KEY)BidCommand command,
                                        HttpServletRequest request,
                                        RedirectAttributes redirectAttributes, HttpServletResponse response) throws ObjectNotFoundException, DuplicateKeyException {
        ModelAndView mav = new ModelAndView("/admin/bidluutru/list");
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)) {
            Integer totalDeleted = 0;
            try {
                totalDeleted = bidService.deleteItems(command.getCheckList());
                redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.delete.successful", new Object[]{totalDeleted}));
                redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                    return new ModelAndView("redirect:/admin/bidluutru/list.html");
                }else{
                    return new ModelAndView("redirect:/normal/bidluutru/list.html");
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("general.exception.msg"));
                mav.addObject(Constants.ALERT_TYPE, "danger");
            }
        } else{
            if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)) {
                this.bidLuuTruService.updateHoSoLuuTru(command.getMapBidSave(), SecurityUtils.getLoginUserId());
            } else {
                if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_EXPORT)) {
                    try {
                        export2Excel(command, request, response);
                    } catch (Exception e) {
                        log.error(e, e.getCause());
                    }
                }
            }
        }
        executeSearch(command, request);
        referenceData(command, mav);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    private void executeSearch(BidCommand command, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, command);
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
            if(StringUtils.isNotBlank(pojo.getMagoithau())){
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
            if(command.getTuKe() != null){
                properties.put("tuKe", command.getTuKe());
            }
            if(command.getDenKe() != null){
                properties.put("denKe", command.getDenKe());
            }
            if(command.getTuTu() != null){
                properties.put("tuTu", command.getTuTu());
            }
            if(command.getDenKe() != null){
                properties.put("denTu", command.getDenTu());
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

    private void referenceData(BidCommand command, ModelAndView mav){
        mav.addObject("departments", departmentService.search(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("loais", loaiService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("lanhdaos", lanhDaoService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("hinhthucs", hinhThucService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("tinhchats", tinhChatService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("quimos", quiMoService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("tinhtrangs", tinhTrangService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("nguonvons", nguonVonService.searchByProperties(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("users", userService.search(new HashMap<String, Object>(), "", "", -1, -1)[1]);
        mav.addObject("userXetThau", userService.findAllUserWithGroup(Constants.GROUP_XETTHAU));
        mav.addObject("userThamDinh", userService.findAllUserWithGroup(Constants.GROUP_THAMDINH));
        mav.addObject("listNhanVien", userService.findAll());
    }


    private void export2Excel(BidCommand command, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            String ngayXuatBaoCao = df.format(currentTimestamp);
            Map<String, Object> properties = buildProperties(command);
            Object[] resultObject = this.bidService.searchForList(properties, null, null, 0, Integer.MAX_VALUE);
            List<BidDTO> dtoList = (List<BidDTO>)resultObject[1];

            String outputFileName = "/files/temp/danhSachHoSoLuuTru" + ngayXuatBaoCao + ".xls";
            String reportTemplate;
            reportTemplate = request.getSession().getServletContext().getRealPath("/files/temp/danhSachHoSoLuuTruTemplate.xls");
            String export2FileName = request.getSession().getServletContext().getRealPath(outputFileName);
            WorkbookSettings ws = new WorkbookSettings();
            ExcelUtil.setEncoding4Workbook(ws);
            Workbook templateWorkbook = Workbook.getWorkbook(new File(reportTemplate), ws);
            WritableWorkbook workbook = Workbook.createWorkbook(new File(export2FileName), templateWorkbook);
            WritableSheet sheet = workbook.getSheet(0);
            int startRow = 6;

            WritableFont normalFont = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
            normalFont.setColour(Colour.BLACK);

            WritableCellFormat stringCellFormat = new WritableCellFormat(normalFont);
            stringCellFormat.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);

            WritableCellFormat stringNgayBaoCaoCellFormat = new WritableCellFormat(normalFont);
            stringNgayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.NONE);
            stringNgayBaoCaoCellFormat.setAlignment(Alignment.CENTRE);

            WritableCellFormat integerCellFormat = new WritableCellFormat(normalFont);
            integerCellFormat.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
            integerCellFormat.setAlignment(Alignment.CENTRE);

            NumberFormat nf = new NumberFormat("#,###");
            WritableCellFormat doubleCellFormat = new WritableCellFormat(nf);
            doubleCellFormat.setFont(normalFont);
            doubleCellFormat.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
            doubleCellFormat.setAlignment(Alignment.RIGHT);

            WritableFont normalFontGoiThau = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
            normalFontGoiThau.setColour(Colour.WHITE);

            WritableCellFormat stringCellFormatGoiThau = new WritableCellFormat(normalFontGoiThau);
            stringCellFormatGoiThau.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
            stringCellFormatGoiThau.setBackground(Colour.GREEN);


            WritableCellFormat integerCellFormatGoiThau = new WritableCellFormat(normalFontGoiThau);
            integerCellFormatGoiThau.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
            integerCellFormatGoiThau.setAlignment(Alignment.CENTRE);
            integerCellFormatGoiThau.setBackground(Colour.GREEN);


            NumberFormat nfGoiThau = new NumberFormat("#,###");
            WritableCellFormat doubleCellFormatGoiThau = new WritableCellFormat(normalFontGoiThau);
            doubleCellFormatGoiThau.setFont(normalFont);
            doubleCellFormatGoiThau.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
            doubleCellFormatGoiThau.setAlignment(Alignment.RIGHT);
            doubleCellFormatGoiThau.setBackground(Colour.GREEN);

            if(dtoList.size() > 0){
                int indexRow = 1;
                CellValue[] values;
                for(BidDTO dto : dtoList){
                    values = addCellValues(dto, indexRow);
                    ExcelUtil.addRow(sheet, startRow++, values, stringCellFormat, integerCellFormat, doubleCellFormat, null);
                    indexRow++;
                }
            }
            workbook.write();
            workbook.close();
            response.sendRedirect(request.getSession().getServletContext().getContextPath() + outputFileName);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new Exception("Error when export data to excel.\n + details: " + e.getMessage());
        }
    }

    private CellValue[] addCellValues(BidDTO dto, Integer indexRow){
        CellValue[] resValue = new CellValue[TOTAL_COLUMN_EXPORT];
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy");
        int columnIndex = 0;
        resValue[columnIndex++] = new CellValue(CellDataType.INT, indexRow);
        if(dto.getMagoithau() != null && dto.getMagoithau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getMagoithau().toString());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTengoithau() != null && StringUtils.isNotBlank(dto.getTengoithau())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTengoithau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNguonvon() != null && StringUtils.isNotBlank(dto.getNguonvon().getTennguonvon())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNguonvon().getTennguonvon());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getLoai() != null && StringUtils.isNotBlank(dto.getLoai().getTenloai())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getLoai().getTenloai());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getDepartment() != null && StringUtils.isNotBlank(dto.getDepartment().getName())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getDepartment().getName());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getHinhthucgt() != null && StringUtils.isNotBlank(dto.getHinhthucgt().getTenhinhthuc())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getHinhthucgt().getTenhinhthuc());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getHoSoLuuTrus() != null && dto.getHoSoLuuTrus().size() > 0){
            if(dto.getHoSoLuuTrus().get(0).getSotu() != null){
                resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getHoSoLuuTrus().get(0).getSotu().toString());
            }else{
                resValue[columnIndex++] = new CellValue();
            }
            if(dto.getHoSoLuuTrus().get(0).getSoke() != null){
                resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getHoSoLuuTrus().get(0).getSoke().toString());
            }else{
                resValue[columnIndex++] = new CellValue();
            }
            if(!StringUtils.isNotBlank(dto.getHoSoLuuTrus().get(0).getGhichu())){
                resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getHoSoLuuTrus().get(0).getGhichu());
            }else{
                resValue[columnIndex++] = new CellValue();
            }
        }
        return resValue;
    }
}
