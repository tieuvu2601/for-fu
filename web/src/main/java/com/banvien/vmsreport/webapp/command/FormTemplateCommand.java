package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.FormTemplateDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class FormTemplateCommand extends AbstractCommand<FormTemplateDTO> {
    public FormTemplateCommand(){
        this.pojo = new FormTemplateDTO();
    }

    private List<Long> checkListHinhThuc = new ArrayList<>();
    private List<Long> checkListTinhTrang = new ArrayList<>();
    private Long fromDate;
    private Long toDate;
    private String maGoiThau;

    public List<Long> getCheckListHinhThuc() {
        return checkListHinhThuc;
    }

    public void setCheckListHinhThuc(List<Long> checkListHinhThuc) {
        this.checkListHinhThuc = checkListHinhThuc;
    }

    public List<Long> getCheckListTinhTrang() {
        return checkListTinhTrang;
    }

    public void setCheckListTinhTrang(List<Long> checkListTinhTrang) {
        this.checkListTinhTrang = checkListTinhTrang;
    }

    public Long getFromDate() {
        return fromDate;
    }

    public void setFromDate(Long fromDate) {
        this.fromDate = fromDate;
    }

    public Long getToDate() {
        return toDate;
    }

    public void setToDate(Long toDate) {
        this.toDate = toDate;
    }

    public String getMaGoiThau() {
        return maGoiThau;
    }

    public void setMaGoiThau(String maGoiThau) {
        this.maGoiThau = maGoiThau;
    }
}
