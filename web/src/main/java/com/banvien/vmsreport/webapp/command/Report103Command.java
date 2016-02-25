package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Report103Command extends AbstractCommand<Report103DTO> {
    public Report103Command(){
        this.pojo = new Report103DTO();
    }

    private LoaiDTO loai;
    private List<Long> checkListTinhTrang = new ArrayList<>();
    private Timestamp fromDate;
    private Timestamp toDate;
    private NguonvonDTO nguonVon;
    private DepartmentDTO department;
    private QuyMoDTO quiMo;

    public LoaiDTO getLoai() {
        return loai;
    }

    public void setLoai(LoaiDTO loai) {
        this.loai = loai;
    }

    public List<Long> getCheckListTinhTrang() {
        return checkListTinhTrang;
    }

    public void setCheckListTinhTrang(List<Long> checkListTinhTrang) {
        this.checkListTinhTrang = checkListTinhTrang;
    }

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

    public NguonvonDTO getNguonVon() {
        return nguonVon;
    }

    public void setNguonVon(NguonvonDTO nguonVon) {
        this.nguonVon = nguonVon;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public QuyMoDTO getQuiMo() {
        return quiMo;
    }

    public void setQuiMo(QuyMoDTO quiMo) {
        this.quiMo = quiMo;
    }
}
