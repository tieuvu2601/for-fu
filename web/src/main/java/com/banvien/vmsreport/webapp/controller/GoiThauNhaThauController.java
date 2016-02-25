package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.dto.NhaThauDTO;
import com.banvien.vmsreport.core.business.BidManagementLocalBean;
import com.banvien.vmsreport.core.business.GoiThauNhaThauManagementLocalBean;
import com.banvien.vmsreport.core.business.NhaThauManagementLocalBean;
import com.banvien.vmsreport.editor.CustomDateEditor;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.ExcelUtil;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.util.WebCommonUtil;
import com.banvien.vmsreport.webapp.command.GoiThauNhaThauCommand;
import com.banvien.vmsreport.webapp.command.NhaThauCommand;
import com.banvien.vmsreport.webapp.dto.CellDataType;
import com.banvien.vmsreport.webapp.dto.CellValue;
import com.banvien.vmsreport.webapp.validator.GoiThauNhaThauValidator;
import com.banvien.vmsreport.webapp.validator.NhaThauValidator;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GoiThauNhaThauController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(this.getClass());
    private static final Integer TOTAL_COLUMN_EXPORT = 8;

    @Autowired
    private GoiThauNhaThauManagementLocalBean goiThauNhaThauManagementLocalBean;
    @Autowired
    private NhaThauManagementLocalBean nhaThauManagementLocalBean;
    @Autowired
    private BidManagementLocalBean bidManagementLocalBean;
    @Autowired
    private GoiThauNhaThauValidator goiThauNhaThauValidator;
    @Autowired
    private NhaThauValidator nhaThauValidator;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor());
        binder.registerCustomEditor(Timestamp.class, new CustomDateEditorSQL("dd/MM/yyyy"));
    }
//    @Autowired
//    private GoiThauNhaThauValidator goiThauNhaThauValidator;

    @RequestMapping(value = {"/admin/nhathau/capnhatnhathau.html", "/normal/nhathau/capnhatnhathau.html"})
    public ModelAndView capNhatNhaThau(@ModelAttribute(value = Constants.FORM_MODEL_KEY)GoiThauNhaThauCommand command,
                             BindingResult bindingResult,
                             HttpServletRequest request) throws ObjectNotFoundException, RemoveException {
        ModelAndView mav = new ModelAndView("/admin/nhathau/capnhatnhathau");
        String crudaction = command.getCrudaction();
        try {
            if (Constants.INSERT_OR_UPDATE.equalsIgnoreCase(crudaction)){
                goiThauNhaThauValidator.validate(command, bindingResult);
                if (!bindingResult.hasErrors()){
                    goiThauNhaThauManagementLocalBean.insertOrUpdate(command.getLazyList(), command.getDeleteList(), command.getPojo().getGoithau().getMsgoithau());
                    mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.save.successful"));
                    mav.addObject(Constants.ALERT_TYPE, "success");
                }
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
            mav.addObject(Constants.ALERT_TYPE, "error");
        }
        if (command.getPojo().getGoithau() != null && command.getPojo().getGoithau().getMsgoithau() != null){
            executeSearch(command, request);
            referenceData(command, request, mav);
        }
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value = {"/admin/nhathau/danhsachnhathau.html", "/normal/nhathau/danhsachnhathau.html"})
    public ModelAndView danhSachNhaThau(@ModelAttribute(value = Constants.FORM_MODEL_KEY)GoiThauNhaThauCommand command,
                                       BindingResult bindingResult,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/admin/nhathau/danhsachnhathau");
        String crudaction = command.getCrudaction();
        if (StringUtils.isNotBlank(crudaction)){
            if (Constants.ACTION_DELETE.equalsIgnoreCase(crudaction)){
                Integer totalItemDelete;
//                goiThauNhaThauValidator.validate(command, bindingResult);
                if (!bindingResult.hasErrors()){
                    totalItemDelete = goiThauNhaThauManagementLocalBean.delete(command.getCheckList());
                    mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.delete.successful"));
                    mav.addObject(Constants.ALERT_TYPE, "success");
                }
            }
            if (Constants.ACTION_EXPORT.equalsIgnoreCase(crudaction)){
                export2Excel(command, request, response);
            }
        }
        executeSearch(command, request);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value = {"/admin/nhathau/edit.html", "/normal/nhathau/edit.html",
                                "/admin/nhathau/add.html", "/normal/nhathau/add.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)NhaThauCommand command,
                                        BindingResult bindingResult,
                                        HttpServletRequest request,
                                        RedirectAttributes redirectAttributes) throws ObjectNotFoundException, DuplicateKeyException {
        ModelAndView mav = new ModelAndView("/admin/nhathau/edit");
        String crudaction = command.getCrudaction();
        NhaThauDTO pojo = command.getPojo();
        try {
            if (StringUtils.isNotBlank(crudaction)) {
                if (Constants.INSERT_OR_UPDATE.equalsIgnoreCase(crudaction)) {
                    nhaThauValidator.validate(command, bindingResult);
                    if (!bindingResult.hasErrors()) {
                        nhaThauManagementLocalBean.insetOrUpdate(pojo);
                        redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.add.successful"));
                        if (command.getPojo().getMsnhathau() != null) {
                            redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.update.successful"));
                        }
                        redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                        if (SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)) {
                            return new ModelAndView("redirect:/admin/nhathau/danhsachnhathau.html");
                        } else {
                            return new ModelAndView("redirect:/normal/nhathau/danhsachnhathau.html");
                        }
                    }
                }
            }
            if (command.getPojo().getMsnhathau() != null) {
                pojo = nhaThauManagementLocalBean.findbyId(command.getPojo().getMsnhathau());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
            mav.addObject(Constants.ALERT_TYPE, "error");
        }
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value = {"/ajax/nhathau/listNhaThau.html"})
    public @ResponseBody
    List<GoithaunhathauDTO> ajaxDanhSachNhauThau(
            @RequestParam(value = "page", required = false)Integer page,
            @ModelAttribute(value = Constants.FORM_MODEL_KEY) GoiThauNhaThauCommand command,
                                                        HttpServletRequest request){
        executeSearch(command, request);
        return command.getListResult();
    }

    @RequestMapping(value  = {"/ajax/NhaThau/danhSachNhaThau.html"})
    public ModelAndView ajaxDanhSachNhauThau1(
            @ModelAttribute(value = Constants.FORM_MODEL_KEY)NhaThauCommand command, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/nhathau/nhathau");
        executeSearchNhaThau(command, request);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    private void executeSearchNhaThau(NhaThauCommand command, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildPropertiesNhaThau(command);
        Object[] results = this.nhaThauManagementLocalBean.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<NhaThauDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildPropertiesNhaThau(NhaThauCommand command) {
        Map<String, Object> properties = new HashMap<>();
        if (StringUtils.isNotBlank(command.getPojo().getTennhathau())){
            properties.put("tennhathau", command.getPojo().getTennhathau());
        }
        if (StringUtils.isNotBlank(command.getPojo().getMasothue())){
            properties.put("masothue", command.getPojo().getMasothue());
        }
        if (StringUtils.isNotBlank(command.getPojo().getDiachi())){
            properties.put("diachi", command.getPojo().getDiachi());
        }
        if (StringUtils.isNotBlank(command.getPojo().getDienthoai())){
            properties.put("dienthoai", command.getPojo().getDienthoai());
        }
        if (StringUtils.isNotBlank(command.getPojo().getFax())){
            properties.put("fax", command.getPojo().getFax());
        }
        if (command.getPojo().getActive() != null){
            properties.put("active", command.getPojo().getActive());
        }
        return properties;  //To change body of created methods use File | Settings | File Templates.
    }


    private void referenceData(GoiThauNhaThauCommand command, HttpServletRequest request, ModelAndView mav) throws ObjectNotFoundException {
        if (command.getPojo().getGoithau() != null && command.getPojo().getGoithau().getMsgoithau() != null){
            command.getPojo().setGoithau(bidManagementLocalBean.findId(command.getPojo().getGoithau().getMsgoithau()));
        }
    }

    private void executeSearch(GoiThauNhaThauCommand command, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);
        command.setSortExpression("goithau.magoithau");
        Object[] results = this.goiThauNhaThauManagementLocalBean.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<GoithaunhathauDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(GoiThauNhaThauCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (command.getPojo().getGoithau() != null && command.getPojo().getGoithau().getMsgoithau() != null) {
            properties.put("goithau.msgoithau", command.getPojo().getGoithau().getMsgoithau());
        }
        if (command.getPojo().getGoithau() != null && command.getPojo().getGoithau().getTengoithau() != null) {
            properties.put("goithau.tengoithau", command.getPojo().getGoithau().getTengoithau());
        }
        if (command.getPojo().getIstrungthau() != null) {
            properties.put("istrungthau", command.getPojo().getIstrungthau());
        }
        if (command.getPojo().getNhathau() != null && command.getPojo().getNhathau().getTennhathau() != null) {
            properties.put("nhathau.tennhathau", command.getPojo().getNhathau().getTennhathau());
        }
        return properties;
    }

    private void export2Excel(GoiThauNhaThauCommand command, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            String ngayXuatBaoCao = df.format(currentTimestamp);
            Map<String, Object> properties = buildProperties(command);
            Object[] resultObject = this.goiThauNhaThauManagementLocalBean.search(properties, null, null, 0, Integer.MAX_VALUE);
            List<GoithaunhathauDTO> dtoList = (List<GoithaunhathauDTO>)resultObject[1];

            String outputFileName = "/files/temp/danhSachNhaThau" + ngayXuatBaoCao + ".xls";
            String reportTemplate;
            reportTemplate = request.getSession().getServletContext().getRealPath("/files/temp/danhSachNhaThauTemplate.xls");
            String export2FileName = request.getSession().getServletContext().getRealPath(outputFileName);
            WorkbookSettings ws = new WorkbookSettings();
            ExcelUtil.setEncoding4Workbook(ws);
            Workbook templateWorkbook = Workbook.getWorkbook(new File(reportTemplate), ws);
            WritableWorkbook workbook = Workbook.createWorkbook(new File(export2FileName), templateWorkbook);
            WritableSheet sheet = workbook.getSheet(0);
            int startRow = 8;

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

            addReportTittle(sheet, command);
            addHeader4Report(sheet, command);

            if(dtoList.size() > 0){
                int indexRow = 1;
                String varMaGoiThauOld = null;
                CellValue[] values;
                for(GoithaunhathauDTO dto : dtoList){
                    if (dto.getGoithau().getMagoithau() != varMaGoiThauOld)  {
                        values = addGoiThauCellValues(dto);
                        ExcelUtil.addRow(sheet, startRow++, values, stringCellFormatGoiThau, integerCellFormatGoiThau, doubleCellFormatGoiThau, null);
                        ExcelUtil.mergeCells(sheet, 0, startRow - 1, TOTAL_COLUMN_EXPORT - 1 ,startRow - 1);
                    }
                    values = addCellValues(dto, indexRow);
                    ExcelUtil.addRow(sheet, startRow++, values, stringCellFormat, integerCellFormat, doubleCellFormat, null);
                    indexRow++;
                    varMaGoiThauOld = dto.getGoithau().getMagoithau();
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

    private void addReportTittle(WritableSheet sheet, GoiThauNhaThauCommand command) throws WriteException {
        int startRowTitle = 2;

        WritableFont titleFont = new WritableFont(WritableFont.TIMES, 14, WritableFont.NO_BOLD);
        titleFont.setColour(Colour.BLACK);
        titleFont.setBoldStyle(WritableFont.BOLD);

        WritableCellFormat reportTitleCellFormat = new WritableCellFormat(titleFont);
        reportTitleCellFormat.setAlignment(Alignment.CENTRE);

        // Add report title
        CellValue[] headerReportCells_report_title = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        headerReportCells_report_title[0] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.danhsachnhathau"));
        ExcelUtil.addRow(sheet, startRowTitle, headerReportCells_report_title, reportTitleCellFormat, null, null, null);

        // merge cells for report title
        ExcelUtil.mergeCells(sheet, 0, 2, TOTAL_COLUMN_EXPORT - 1, 2);
    }

    private void addHeader4Report(WritableSheet sheet, GoiThauNhaThauCommand command) throws WriteException{
        int columnIndex = 0;

        WritableFont blackFont = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
        blackFont.setColour(Colour.BLACK);

        WritableFont normalFont = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD);
        normalFont.setColour(Colour.WHITE);

        WritableCellFormat filterCellFormat = new WritableCellFormat(blackFont);
        filterCellFormat.setBorder(Border.ALL, BorderLineStyle.NONE);
        filterCellFormat.setAlignment(Alignment.CENTRE);

        WritableCellFormat ngayBaoCaoCellFormat = new WritableCellFormat(normalFont);
        ngayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.NONE);
        ngayBaoCaoCellFormat.setAlignment(Alignment.CENTRE);
        ngayBaoCaoCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        ngayBaoCaoCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        ngayBaoCaoCellFormat.setBackground(Colour.TEAL2);

        // Add filter
        CellValue[] headerReportCells_filter = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        StringBuilder filterStr = new StringBuilder();
        filterStr.append(this.getMessageSourceAccessor().getMessage("label.nhathau.magoithau")).append(": ")
                .append(command.getPojo().getGoithau().getMagoithau() != null ? command.getPojo().getGoithau().getMagoithau() : this.getMessageSourceAccessor().getMessage("label.all"))
                .append("               ")
                .append(this.getMessageSourceAccessor().getMessage("label.nhathau.tengoithau")).append(": ")
                .append(StringUtils.isNotBlank(command.getPojo().getGoithau().getTengoithau()) ? command.getPojo().getGoithau().getTengoithau() : this.getMessageSourceAccessor().getMessage("label.all"));
        headerReportCells_filter[0] = new CellValue(CellDataType.STRING, filterStr);
        ExcelUtil.addRow(sheet, 4, headerReportCells_filter, filterCellFormat, null, null, null);

        filterStr = new StringBuilder();
        String ketQuaTrungThau = this.getMessageSourceAccessor().getMessage("label.nhathau.khongtrungthau");
        if (command.getPojo().getIstrungthau() != null && command.getPojo().getIstrungthau().intValue() == Constants.ACTIVE){
            ketQuaTrungThau = this.getMessageSourceAccessor().getMessage("label.nhathau.trungthau");
        }
        filterStr.append(this.getMessageSourceAccessor().getMessage("label.nhathau.ketQuaTrungThau")).append(": ")
                .append(command.getPojo().getIstrungthau() != null ? ketQuaTrungThau : this.getMessageSourceAccessor().getMessage("label.all"))
                .append("               ")
                .append(this.getMessageSourceAccessor().getMessage("label.nhathau.ten")).append(": ")
                .append(StringUtils.isNotBlank(command.getPojo().getNhathau().getTennhathau()) ? command.getPojo().getNhathau().getTennhathau() : this.getMessageSourceAccessor().getMessage("label.all"));
        headerReportCells_filter[0] = new CellValue(CellDataType.STRING, filterStr);
        ExcelUtil.addRow(sheet, 5, headerReportCells_filter, filterCellFormat, null, null, null);


        // Add header of report table
        CellValue[] headerReportCells_line1 = WebCommonUtil.addNgayXuatBaoCao(TOTAL_COLUMN_EXPORT);
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.stt"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.ten"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.diachi"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.dienthoai"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.fax"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.ngaymuahs"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.ngaynophs"));
        headerReportCells_line1[columnIndex++] = new CellValue(CellDataType.STRING, this.getMessageSourceAccessor().getMessage("label.nhathau.ketQuaTrungThau"));

        ExcelUtil.addRow(sheet, 7, headerReportCells_line1, ngayBaoCaoCellFormat, null, null, null);


        // merge cell for filter
        ExcelUtil.mergeCells(sheet, 0, 4, TOTAL_COLUMN_EXPORT - 1, 4);
        ExcelUtil.mergeCells(sheet, 0, 5, TOTAL_COLUMN_EXPORT - 1, 5);
    }

    private CellValue[] addCellValues(GoithaunhathauDTO dto, Integer indexRow){
        CellValue[] resValue = new CellValue[TOTAL_COLUMN_EXPORT];
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy");
        int columnIndex = 0;
        resValue[columnIndex++] = new CellValue(CellDataType.INT, indexRow);
        if(dto.getNhathau() != null && StringUtils.isNotBlank(dto.getNhathau().getTennhathau())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhathau().getTennhathau());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNhathau() != null && StringUtils.isNotBlank(dto.getNhathau().getDiachi())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhathau().getDiachi());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNhathau() != null && StringUtils.isNotBlank(dto.getNhathau().getDienthoai())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhathau().getDienthoai());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNhathau() != null && StringUtils.isNotBlank(dto.getNhathau().getFax())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhathau().getFax());
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNgaymuahs() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getNgaymuahs()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getNgaynophs() != null){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, df.format(dto.getNgaynophs()));
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        if(dto.getIstrungthau() != null){
            String ketQuaTrungThau = "";
           if (dto.getIstrungthau() != null && dto.getIstrungthau().intValue() == Constants.ACTIVE){
               ketQuaTrungThau = "x";
           }
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, ketQuaTrungThau);
        }else{
            resValue[columnIndex++] = new CellValue();
        }
        return resValue;
    }
    private CellValue[] addGoiThauCellValues(GoithaunhathauDTO dto) {
        CellValue[] resValue = new CellValue[TOTAL_COLUMN_EXPORT];
        int columnIndex = 0;
        if(dto.getNhathau() != null && StringUtils.isNotBlank(dto.getNhathau().getTennhathau())){
            resValue[columnIndex++] = new CellValue(CellDataType.STRING, dto.getNhathau().getTennhathau());
        }
        return resValue;
    }
}
