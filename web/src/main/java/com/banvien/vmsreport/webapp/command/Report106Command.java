package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.LoaiDTO;
import com.banvien.vmsreport.common.dto.Report106DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Report106Command extends AbstractCommand<Report106DTO> {
    public Report106Command(){
        this.pojo = new Report106DTO();
    }

    private LoaiDTO loai;
    private List<Long> checkListHinhThuc;
    private List<Long> checkListTinhTrang;
    private Long fromDate;
    private Long toDate;
    private Long chair;

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

    public List<Long> getCheckListHinhThuc() {
        return checkListHinhThuc;
    }

    public void setCheckListHinhThuc(List<Long> checkListHinhThuc) {
        this.checkListHinhThuc = checkListHinhThuc;
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

    public Long getChair() {
        return chair;
    }

    public void setChair(Long chair) {
        this.chair = chair;
    }
}
