package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.util.ExcelUtil;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.util.WebCommonUtil;
import com.banvien.vmsreport.webapp.command.Report109Command;
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
 * Date: 12/31/15
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class Report109Controller extends ApplicationObjectSupport{
    private transient final Log log = LogFactory.getLog(this.getClass());
    private static final Integer TOTAL_COLUMN_EXPORT = 15;

    @Autowired
    private Report109ManagementLocalBean report109ManagementLocalBean;
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
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL());
    }

    @RequestMapping(value = {"/admin/report/report109.*", "/normal/report/report109.*"})
    public ModelAndView reprt109(@ModelAttribute(value = Constants.FORM_MODEL_KEY)Report109Command command,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/admin/report/report109");
        String crudaction = command.getCrudaction();
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

    private void referenceData(Report109Command command, ModelAndView mav) {
        List<NguonvonDTO> listNguonVon =  nguonvonManagementLocalBean.findAll();
        mav.addObject("listNguonVon", listNguonVon);

        List<LoaiDTO> listLoai = loaiManagementLocalBean.findAll();
        mav.addObject("listLoai", listLoai);

        List<DepartmentDTO> listDepartment = departmentManagementLocalBean.findALL();
        mav.addObject("listDepartment", listDepartment);

        List<UserDTO> listChuTri = userManagementLocalBean.findAllUserWithGroup(Constants.GROUP_XETTHAU);
        mav.addObject("listChuTri", listChuTri);

        List<UserDTO> listThanhVien = userManagementLocalBean.findAll();
        mav.addObject("listThanhVien", listThanhVien);

        List<QuyMoDTO> listQuiMo = quimoManagementLocalBean.findAll();
        mav.addObject("listQuiMo", listQuiMo);

        List<HinhthucgtDTO> listHinhThuc = hinhthucManagementLocalBean.findAll();
        mav.addObject("hinhthucs", listHinhThuc);

        List<TinhtrangDTO> listTinhTrang = tinhtrangManagementLocalBean.findAll();
        mav.addObject("tinhtrangs", listTinhTrang);
    }

    private void executeSearch(Report109Command command, HttpServletRequest request) {
        RequestUtil.initSearchBean(request,command);
        Map<String, Object> properties = buildProperties(command);
        Object[] results = report109ManagementLocalBean.search(properties, null, null, 0, Integer.MAX_VALUE);
        command.setListResult((List<Report109DTO>) results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(Report109Command command) {
        Map<String, Object> properties = new HashMap<>();
        if (command.getPojo().getGoithaunhanvien() != null && command.getPojo().getGoithaunhanvien().getGoithau() != null && StringUtils.isNotBlank(command.getPojo().getGoithaunhanvien().getGoithau().getTengoithau())){
            properties.put("tenGoiThau", command.getPojo().getGoithaunhanvien().getGoithau().getTengoithau().trim());
        }
        if (command.getPojo().getGoithaunhanvien() != null &&  command.getPojo().getGoithaunhanvien().getGoithau() != null && StringUtils.isNotBlank(command.getPojo().getGoithaunhanvien().getGoithau().getMagoithau())){
            properties.put("maGoiThau", command.getPojo().getGoithaunhanvien().getGoithau().getMagoithau().trim());
        }
        if (command.getFromDate() != null){
            properties.put("fromDate", command.getFromDate());
        }
        if (command.getToDate() != null){
            properties.put("toDate", command.getToDate());
        }
        if (command.getPojo().getMsNguonVon() != null){
            properties.put("msNguonVon", command.getPojo().getMsNguonVon());
        }
        if (command.getPojo().getMsLoai() != null){
            properties.put("msLoaiDauTu", command.getPojo().getMsLoai());
        }
        if (command.getPojo().getMsPhong() != null){
            properties.put("msPhong", command.getPojo().getMsPhong());
        }
        if (command.getPojo().getMsChuTri() != null){
            properties.put("msChuTri", command.getPojo().getMsChuTri());
        }
        if (command.getPojo().getMsThanhVien() != null){
            properties.put("msThanhVien", command.getPojo().getMsThanhVien());
        }
        if (command.getPojo().getMsQuiMo() != null){
            properties.put("msQuiMo", command.getPojo().getMsQuiMo());
        }
        if (command.getCheckListHinhThuc() != null && command.getCheckListHinhThuc().size() > 0 && command.getCheckListHinhThuc().get(0) != -1){
            properties.put("checkListHinhThuc", command.getCheckListHinhThuc());
        }
        if (command.getCheckListTinhTrang() != null && command.getCheckListTinhTrang().size() > 0 && command.getCheckListTinhTrang().get(0) !=  -1){
            properties.put("checkListTinhTrang", command.getCheckListTinhTrang());
        }
        return properties;

    }

    private void export2Excel(Report109Command command, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            String ngayXuatBaoCao = df.format(currentTimestamp);
            Map<String, Object> properties = buildProperties(command);
            Object[] resultObject = this.report109ManagementLocalBean.search(properties, null, null, 0, Integer.MAX_VALUE);
            List<Report109DTO> dtoList = (List<Report109DTO>)resultObject[1];

            String outputFileName = "/files/temp/ThongKeTheoNhanVienThamDinh" + ngayXuatBaoCao + ".xls";
            String reportTemplate;
            reportTemplate = request.getSession().getServletContext().getRealPath("/files/temp/ThongKeTheoNhanVienThamDinh.xls");
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

            addHeader4Report(sheet, command);

            if(dtoList.size() > 0){
                int indexRow = 1;
                CellValue[] values;
                for(Report109DTO dto : dtoList){
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
    private void addHeader4Report(WritableSheet sheet, Report109Command command) throws WriteException{
        int columnIndex = 0;

        WritableFont normalFont = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
        normalFont.setColour(Colour.WHITE);

        WritableCellFormat ngayBaoCaoCellFormat = new WritableCellFormat(normalFont);
        ngayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.NONE);
        ngayBaoCaoCellFormat.setAlignment(Alignment.CENTRE);
        ngayBaoCaoCellFormat.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        ngayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        ngayBaoCaoCellFormat.setBackground(Colour.TEAL2);

        String fromString = command.getFromDate() != null ? command.getFromDate().toString() : "";
        String toString = command.getToDate() != null ? command.getToDate().toString() : "";
        addFilter(this.getMessageSourceAccessor().getMessage("label.from_date"), this.getMessageSourceAccessor().getMessage("label.from_date"),
                fromString, toString, 2, 0, sheet);

        // Add header of report table
        CellValue[] headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.stt"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.cv"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.dangThucHien"));
        columnIndex += 5;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.daHoanTat"));
        columnIndex += 5;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.totalPlug"));

        ExcelUtil.addRow(sheet, 4, headerReportCells_line1, ngayBaoCaoCellFormat, null, null, null);

        headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        columnIndex = 2;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.CDT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.CHCT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.DTRR"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.MSTT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.CGCT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.total"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.CDT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.CHCT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.DTRR"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.MSTT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.CGCT"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.report103.total"));

        ExcelUtil.addRow(sheet, 5, headerReportCells_line1, ngayBaoCaoCellFormat, null, null, null);

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

    private CellValue[] addCellValues(Report109DTO dto, Integer indexRow){
        CellValue[] resValue = new CellValue[TOTAL_COLUMN_EXPORT];
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy");
        int columnIndex = 0;
        resValue[columnIndex++] = new CellValue(CellDataType.INT, indexRow);
        if(dto.getUser() != null && StringUtils.isNotBlank(dto.getUser().getUserName())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getUser().getUserName());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getCDT() != null && dto.getCDT()[0] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getCDT()[0]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getCHCT() != null && dto.getCHCT()[0] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getCHCT()[0]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getDTRR() != null && dto.getDTRR()[0] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getDTRR()[0]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getMSTT() != null && dto.getMSTT()[0] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getMSTT()[0]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getCGCT() != null && dto.getCGCT()[0] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getCGCT()[0]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTotal() != null && dto.getTotal()[0] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getTotal()[0]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getCDT() != null && dto.getCDT()[1] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getCDT()[1]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getCHCT() != null && dto.getCHCT()[1] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getCHCT()[1]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getDTRR() != null && dto.getDTRR()[1] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getDTRR()[1]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getMSTT() != null && dto.getMSTT()[1] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getMSTT()[1]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getCGCT() != null && dto.getCGCT()[1] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getCGCT()[1]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTotal() != null && dto.getTotal()[1] != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getTotal()[1]);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTotalPlug() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getTotalPlug());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        return resValue;
    }
}
