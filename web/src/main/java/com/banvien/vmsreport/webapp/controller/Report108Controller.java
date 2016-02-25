package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.util.ExcelUtil;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.util.WebCommonUtil;
import com.banvien.vmsreport.webapp.command.Report108Command;
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

import javax.ejb.Init;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/30/15
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class Report108Controller extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(this.getClass());
    private static final Integer TOTAL_COLUMN_EXPORT = 8;

    @Autowired
    private Report108ManagementLocalBean report108ManagementLocalBean;
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

    @RequestMapping(value = {"/admin/report/report108.*", "/normal/report/report108.*"})
    public ModelAndView report108(@ModelAttribute(value = Constants.FORM_MODEL_KEY)Report108Command command,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/admin/report/report108");
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

    private void referenceData(Report108Command command, ModelAndView mav) {
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

    private void executeSearch(Report108Command command, HttpServletRequest request) throws ParseException {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);
        Object[] results = report108ManagementLocalBean.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<Report108DTO>) results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(Report108Command command) {
        Map<String, Object> properties = new HashMap<>();

        return properties;  //To change body of created methods use File | Settings | File Templates.
    }
    private void export2Excel(Report108Command command, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            String ngayXuatBaoCao = df.format(currentTimestamp);
            Map<String, Object> properties = buildProperties(command);
            Object[] resultObject = this.report108ManagementLocalBean.search(properties, null, null, 0, Integer.MAX_VALUE);
            List<Report108DTO> dtoList = (List<Report108DTO>)resultObject[1];

            String outputFileName = "/files/temp/ThongKeGoiThauDaThamDinh" + ngayXuatBaoCao + ".xls";
            String reportTemplate;
            reportTemplate = request.getSession().getServletContext().getRealPath("/files/temp/ThongKeGoiThauDaThamDinh.xls");
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
                for(Report108DTO dto : dtoList){
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

    private void addHeader4Report(WritableSheet sheet, Report108Command command) throws WriteException{
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


        String fromString = command.getFromDate() != null ? command.getFromDate().toString().substring(0,10) : "";
        String toString = command.getToDate() != null ? command.getToDate().toString().substring(0,10) : "";
        addFilter(this.getMessageSourceAccessor().getMessage("label.from_date"), this.getMessageSourceAccessor().getMessage("label.from_date"),
                fromString, toString, 1, 0, sheet);

        // Add header of report table
        CellValue[] headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.stt"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.tengoithau"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.hinhThuc.tenHinhThuc"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.tienDo.ngayQDDAPA"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.tienDo.ngayTrinhHs"));
        columnIndex++;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.hinhThuc.thoiGianLap"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.hinhThuc.nvChuTri"));

        ExcelUtil.addRow(sheet, 5, headerReportCells_line1, ngayBaoCaoCellFormat, null, null, null);

        // Add header of report table
        headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        columnIndex=4;
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.ngay"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("tiendo.label.so"));

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

    private CellValue[] addCellValues(Report108DTO dto, Integer indexRow){
        CellValue[] resValue = new CellValue[TOTAL_COLUMN_EXPORT];
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy");
        int columnIndex = 0;
        resValue[columnIndex++] = new CellValue(CellDataType.INT, indexRow);
        if(dto.getGoiThau() != null && StringUtils.isNotBlank(dto.getGoiThau().getTengoithau())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getGoiThau().getTengoithau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getHinhthucgt() != null && StringUtils.isNotBlank(dto.getHinhthucgt().getTenhinhthuc())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getHinhthucgt().getTenhinhthuc());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getQdPheDuyetNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getQdPheDuyetNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhhsNgay() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getTienDo().getTrinhhsNgay()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getTienDo() != null && dto.getTienDo().getTrinhhsSo() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getTienDo().getTrinhhsSo());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getThoiGianThucHien() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.INT, dto.getThoiGianThucHien());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getUser() != null && StringUtils.isNotBlank(dto.getUser().getUserName())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getUser().getUserName());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        return resValue;
    }
}
