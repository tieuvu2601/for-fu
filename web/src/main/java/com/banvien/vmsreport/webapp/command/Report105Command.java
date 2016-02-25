package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.Report105DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Report105Command extends AbstractCommand<Report105DTO> {
    public Report105Command(){
        this.pojo = new Report105DTO();
    }
    private Timestamp fromDate;
    private Timestamp toDate;
    private List<Long> checkListTinhTrang = new ArrayList<>();

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public List<Long> getCheckListTinhTrang() {
        return checkListTinhTrang;
    }

    public void setCheckListTinhTrang(List<Long> checkListTinhTrang) {
        this.checkListTinhTrang = checkListTinhTrang;
    }
}
