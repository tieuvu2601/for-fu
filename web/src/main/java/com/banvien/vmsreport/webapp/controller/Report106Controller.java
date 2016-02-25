package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.util.ExcelUtil;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.util.WebCommonUtil;
import com.banvien.vmsreport.webapp.command.Report106Command;
import com.banvien.vmsreport.webapp.dto.CellDataType;
import com.banvien.vmsreport.webapp.dto.CellValue;
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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class Report106Controller extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(this.getClass());
    private static final Integer TOTAL_COLUMN_EXPORT = 43;

    @Autowired
    private Report106ManagementLocalBean report106ManagementLocalBean;
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


    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL(Constants.DATE_FORMAT));
    }
    
    @RequestMapping(value = {"/admin/report/report106.*", "/normal/report/report106.*"})
    public ModelAndView report106(@ModelAttribute(value = Constants.FORM_MODEL_KEY)Report106Command command,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/admin/report/report106");
        String crudaction =command.getCrudaction();
        if (StringUtils.isNotBlank(crudaction)){
            if (Constants.ACTION_EXPORT.equalsIgnoreCase(crudaction)){
                export2Excel(command, request, response);
            }
        }

        executeSearch(command, request);
        referenceData(command, mav);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    private void referenceData(Report106Command command, ModelAndView mav) {
        List<NguonvonDTO> listNguonVon =  nguonvonManagementLocalBean.findAll();
        mav.addObject("listNguonVon", listNguonVon);

        List<LoaiDTO> listLoai = loaiManagementLocalBean.findAll();
        mav.addObject("listLoai", listLoai);

        List<DepartmentDTO> listDepartment = departmentManagementLocalBean.findALL();
        mav.addObject("listDepartment", listDepartment);

        List<UserDTO> listChuTri = userManagementLocalBean.findAllUserWithGroup(Constants.GROUP_XETTHAU);
        mav.addObject("listChuTri", listChuTri);

        List<UserDTO> listThanhVien = userManagementLocalBean.findAllUserWithGroup(Constants.GROUP_THAMDINH);
        mav.addObject("listThanhVien", listThanhVien);

        List<QuyMoDTO> listQuiMo = quimoManagementLocalBean.findAll();
        mav.addObject("listQuiMo", listQuiMo);

        List<HinhthucgtDTO> listHinhThuc = hinhthucManagementLocalBean.findAll();
        mav.addObject("hinhthucs", listHinhThuc);

        List<TinhtrangDTO> listTinhTrang = tinhtrangManagementLocalBean.findAll();
        mav.addObject("tinhtrangs", listTinhTrang);
    }

    private void executeSearch(Report106Command command, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);
        Object[] results = report106ManagementLocalBean.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<Report106DTO>) results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(Report106Command command) {
        Map<String, Object> properties = new HashMap<>();
        if (command.getPojo().getNguonvon() != null && command.getPojo().getNguonvon().getMsnguonvon() != null){
            properties.put("nguonVon", command.getPojo().getNguonvon().getMsnguonvon());
        }
        if (command.getLoai() != null && command.getLoai().getMsloai() != null){
            properties.put("loaiDauTu", command.getLoai().getMsloai());
        }
        if (command.getPojo().getDepartment() != null && command.getPojo().getDepartment().getDepartmentId() != null){
            properties.put("department", command.getPojo().getDepartment().getDepartmentId());
        }
        if (command.getChair() != null){
            properties.put("chair", command.getChair());
        }
        if (command.getPojo().getUser() != null && command.getPojo().getUser().getUserId() != null){
            properties.put("user", command.getPojo().getUser().getUserId());
        }
        if (command.getPojo().getQuimo() != null && command.getPojo().getQuimo().getMsquimo() != null){
            properties.put("quiMo", command.getPojo().getQuimo().getMsquimo());
        }
        if (command.getPojo().getTienDo() != null && StringUtils.isNotBlank(command.getPojo().getTienDo().getQdPheDuyetSo())) {
            properties.put("qdPhuongAnDuAn", command.getPojo().getTienDo().getQdPheDuyetSo());
        }
        if (command.getPojo().getBid() != null && command.getPojo().getBid().getMagoithau() != null){
            properties.put("maGoiThau", command.getPojo().getBid().getMagoithau());
        }
        if (command.getPojo().getBid() != null && StringUtils.isNotBlank(command.getPojo().getBid().getTengoithau())){
//            properties.put("tenGoiThau", "sua");
            properties.put("tenGoiThau", command.getPojo().getBid().getTengoithau());
        }
        if (command.getCheckListHinhThuc() != null && command.getCheckListHinhThuc().size() > 0 && command.getCheckListHinhThuc().get(0) != -1){
            properties.put("hinhThuc", command.getCheckListHinhThuc());
        }
        if (command.getCheckListTinhTrang() != null && command.getCheckListTinhTrang().size() > 0 && command.getCheckListTinhTrang().get(0) != -1){
            properties.put("tinhTrang", command.getCheckListTinhTrang());
        }
        if (command.getFromDate() !=  null){
            properties.put("fromYear", command.getFromDate());
        }
        if (command.getToDate() != null){
            properties.put("toYear", command.getToDate());
        }
        return properties;
    }

    private void export2Excel(Report106Command command, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            String ngayXuatBaoCao = df.format(currentTimestamp);
            Map<String, Object> properties = buildProperties(command);
            Object[] resultObject = this.report106ManagementLocalBean.search(properties, null, null, 0, Integer.MAX_VALUE);
            List<Report106DTO> dtoList = (List<Report106DTO>)resultObject[1];

            String outputFileName = "/files/temp/TinhHinhThucHienGoiThau" + ngayXuatBaoCao + ".xls";
            String reportTemplate;
            reportTemplate = request.getSession().getServletContext().getRealPath("/files/temp/TinhHinhThucHienGoiThau.xls");
            String export2FileName = request.getSession().getServletContext().getRealPath(outputFileName);
            WorkbookSettings ws = new WorkbookSettings();
            ExcelUtil.setEncoding4Workbook(ws);
            Workbook templateWorkbook = Workbook.getWorkbook(new File(reportTemplate), ws);
            WritableWorkbook workbook = Workbook.createWorkbook(new File(export2FileName), templateWorkbook);
            WritableSheet sheet = workbook.getSheet(0);
            int startRow = 7;

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

            addHeader4Report(sheet, command);

            if(dtoList.size() > 0){
                int indexRow = 1;
                CellValue[] values;
                for(Report106DTO dto : dtoList){
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

    private void addHeader4Report(WritableSheet sheet, Report106Command command) throws WriteException{
        int columnIndex = 0;

        WritableFont normalFont = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
        normalFont.setColour(Colour.WHITE);

        WritableCellFormat ngayBaoCaoCellFormat = new WritableCellFormat(normalFont);
        ngayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.NONE);
        ngayBaoCaoCellFormat.setAlignment(Alignment.CENTRE);
        ngayBaoCaoCellFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        ngayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        ngayBaoCaoCellFormat.setBackground(Colour.TEAL2);
        ngayBaoCaoCellFormat.setWrap(true);

//        String fromString = command.getFromYear() != null ? command.getFromYear().toString() : "";
//        String toString = command.getToYear() != null ? command.getToYear().toString() : "";
//        addFilter(this.getMessageSourceAccessor().getMessage("label.from_date"), this.getMessageSourceAccessor().getMessage("label.from_date"),
//                fromString, toString, 2, 0, sheet);

        // Add header of report table
        CellValue[] headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.stt"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report105.nguonVon"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report105.department"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.chuTri"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("bid.goithau.tochuyengia.thanhvien"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.hinhThuc"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("bid.goithau.quimo"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.magoithau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.tengoithau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.qdPheDuyet"));
        columnIndex ++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.trinhhs.mtyc"));
        columnIndex ++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.tongngaylapHSMT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.songaydenhan"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.songaydachuyendautu"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.qdpdHSMT.HSYC"));
        columnIndex++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.congVanDangBao"));
        columnIndex++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.ngaydangbao"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.ngayphatbanhs"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.ngaymothau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.trinhketqua"));
        columnIndex++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.tongngaylapHSMT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.songaydenhan"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.songaydachuyendautu"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.quyetdinhpheduyetketqua"));
        columnIndex++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.ngaydangketquabaodauthau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.giaduocduyet"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.giatrungthau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.tietkiem"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.landauthau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.soluongnhathaumuahs"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.danhsachnhathaumuaHS"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.soluongnhathaunophs"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.danhsachnhathaunopHS"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.tennhathau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.diachi"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.ketquavatiendo"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report106.ghiChu"));

        ExcelUtil.addRow(sheet, 5, headerReportCells_line1, ngayBaoCaoCellFormat, null, null, null);

        headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        columnIndex = 9;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.ngay"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.ngay"));
        columnIndex += 3;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.ngay"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.ngay"));
        columnIndex += 3;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.ngay"));
        columnIndex += 3;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.ngay"));


        ExcelUtil.addRow(sheet, 6, headerReportCells_line1, ngayBaoCaoCellFormat, null, null, null);

    }

    private void addFilter(String label1, String label2, String value1, String value2, Integer row, Integer col, WritableSheet sheet) throws WriteException {

        WritableFont blackFont = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
        blackFont.setColour(Colour.BLACK);

        WritableCellFormat filterCellFormat = new WritableCellFormat(blackFont);
        filterCellFormat.setBorder(Border.ALL, BorderLineStyle.NONE);
        filterCellFormat.setAlignment(Alignment.CENTRE);

        // Add filter
        CellValue[] headerReportCells_filter = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        StringBuilder filterStr = new StringBuilder();
        filterStr.append(label1).append(": ").append(StringUtils.isNotBlank(value1) ? value1 : this.getMessageSourceAccessor().getMessage("label.all")).append("      ")
                .append(label2).append(": ").append(StringUtils.isNotBlank(value2) ? value2 : this.getMessageSourceAccessor().getMessage("label.all"));
        headerReportCells_filter[col] = new CellValue(CellDataType.STRING, filterStr);
        ExcelUtil.addRow(sheet, row, headerReportCells_filter, filterCellFormat, null, null, null);

        // merge cell for filter
//        ExcelUtil.mergeCells(sheet, 0, 4, TOTAL_COLUMN_EXPORT - 1, 4);
    }

    private CellValue[] addCellValues(Report106DTO dto, Integer indexRow){
        CellValue[] resValue = new CellValue[TOTAL_COLUMN_EXPORT];
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy");
        int columnIndex = 0;
        resValue[columnIndex++] = new CellValue(CellDataType.INT, indexRow);
        if(dto.getNguonvon() != null && dto.getNguonvon().getTennguonvon() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNguonvon().getTennguonvon());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getDepartment() != null && StringUtils.isNotBlank(dto.getDepartment().getCode())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getDepartment().getCode());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getUser() != null && dto.getUser().getUserName() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getUser().getUserName());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getThanhVien() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getThanhVien());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getHinhthucgt() != null && dto.getHinhthucgt().getMahinhthuc() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getHinhthucgt().getMahinhthuc());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getQuimo() != null && dto.getQuimo().getTenquimo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getQuimo().getTenquimo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getBid() != null && dto.getBid().getMagoithau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getBid().getMagoithau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getBid() != null && dto.getBid().getTengoithau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getBid().getTengoithau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getQdPheDuyetSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getQdPheDuyetSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getQdPheDuyetNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getQdPheDuyetNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhhsSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhhsSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhhsNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getTrinhhsNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getQdPheDuyetSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getQdPheDuyetSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getQdPheDuyetSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(dto.getTienDo() != null && dto.getTienDo().getDuyethsSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getDuyethsSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getDuyethsNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getDuyethsNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhdangbaoSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhdangbaoSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhdangbaoNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getTrinhdangbaoNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhdangbaoNgay());
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(dto.getTienDo() != null && dto.getTienDo().getNgaybanhsL3() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getNgaybanhsL3());
        }else if(dto.getTienDo() != null && dto.getTienDo().getNgaybanhsL2() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getNgaybanhsL2());
        }else if(dto.getTienDo() != null && dto.getTienDo().getNgaybanhsL1() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getNgaybanhsL1());
        }else {
            resValue[columnIndex++] = new CellValue();
        }

        if(dto.getTienDo() != null && dto.getTienDo().getNgaymothauL3() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getNgaymothauL3());
        }else if(dto.getTienDo() != null && dto.getTienDo().getNgaymothauL2() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getNgaymothauL2());
        }else if(dto.getTienDo() != null && dto.getTienDo().getNgaymothauL1() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getNgaymothauL1());
        }else {
            resValue[columnIndex++] = new CellValue();
        }

        if(dto.getTienDo() != null && dto.getTienDo().getTrinhkqSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhkqSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhkqNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getTrinhkqNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhdangbaoNgay());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhdangbaoNgay());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(false){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhdangbaoNgay());
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(dto.getTienDo() != null && dto.getTienDo().getPheduyetkqSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getPheduyetkqSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getPheduyetkqNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getPheduyetkqNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getDbkqLuaChonNhaThauNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getDbkqLuaChonNhaThauNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNoiDungHoSo() != null && dto.getNoiDungHoSo().getGiaDuThau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.DOUBLE, dto.getNoiDungHoSo().getGiaDuThau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNoiDungHoSo() != null && dto.getNoiDungHoSo().getGiaDuThau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.DOUBLE, dto.getNoiDungHoSo().getGiaDuThau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNoiDungHoSo() != null && dto.getNoiDungHoSo().getGiaDuThau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.DOUBLE, (dto.getNoiDungHoSo().getGiaDuThau()/dto.getNoiDungHoSo().getGiaDuThau()) * 100);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getBid() != null && dto.getBid().getLandauthau() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getBid().getLandauthau().intValue());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getSlNhaThauMuaHS() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getSlNhaThauMuaHS());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(StringUtils.isNotBlank(dto.getDanhSachNhaThauMuaHS())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getDanhSachNhaThauMuaHS());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getSlNhaThauNopHS() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getSlNhaThauNopHS());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(StringUtils.isNotBlank(dto.getDanhSachNhaThauNopHS())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getDanhSachNhaThauNopHS());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNhaThau() != null && StringUtils.isNotBlank(dto.getNhaThau().getTennhathau())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhaThau().getTennhathau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNhaThau() != null && StringUtils.isNotBlank(dto.getNhaThau().getDiachi())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhaThau().getDiachi());
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(dto.getTinhtrang() != null && StringUtils.isNotBlank(dto.getTinhtrang().getTentinhtrang())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTinhtrang().getTentinhtrang());
        }else{
            resValue[columnIndex++] = new CellValue();
        }

        if(StringUtils.isNotBlank(dto.getGhiChu())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getGhiChu());
        }else{
            resValue[columnIndex++] = new CellValue();
        }


        return resValue;
    }
}
