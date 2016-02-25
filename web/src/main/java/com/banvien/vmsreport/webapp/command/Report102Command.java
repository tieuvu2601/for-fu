package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.Report102DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/21/15
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Report102Command extends AbstractCommand<Report102DTO> {
    public Report102Command(){
        this.pojo = new Report102DTO();
    }

    private Timestamp fromDate;
    private Timestamp toDate;
    private List<Long> checkListTinhTrang = new ArrayList<>();
    private List<Long> checkListHinhThuc = new ArrayList<>();

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public List<Long> getCheckListTinhTrang() {
        return checkListTinhTrang;
    }

    public void setCheckListTinhTrang(List<Long> checkListTinhTrang) {
        this.checkListTinhTrang = checkListTinhTrang;
    }

    public List<Long> getCheckListHinhThuc() {
        return checkListHinhThuc;
    }

    public void setCheckListHinhThuc(List<Long> checkListHinhThuc) {
        this.checkListHinhThuc = checkListHinhThuc;
    }
}
