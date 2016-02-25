package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.Report104DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class Report104Command extends AbstractCommand<Report104DTO> {
    public Report104Command(){
        this.pojo = new Report104DTO();
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
