package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/31/15
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Report109DTO implements Serializable {
    private static final long serialVersionUID = -8541894953130347271L;

    private UserDTO user;
    private GoithaunhanvienDTO goithaunhanvien;
    private Integer CDT[];
    private Integer CHCT[];
    private Integer DTRR[];
    private Integer MSTT[];
    private Integer CGCT[];
    private Integer total[];
    private Integer totalPlug;
    private Long msNguonVon;
    private Long msLoai;
    private Long msPhong;
    private Long msChuTri;
    private Long msThanhVien;
    private Long msQuiMo;


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public GoithaunhanvienDTO getGoithaunhanvien() {
        return goithaunhanvien;
    }

    public void setGoithaunhanvien(GoithaunhanvienDTO goithaunhanvien) {
        this.goithaunhanvien = goithaunhanvien;
    }

    public Integer[] getCDT() {
        return CDT;
    }

    public void setCDT(Integer[] CDT) {
        this.CDT = CDT;
    }

    public Integer[] getCHCT() {
        return CHCT;
    }

    public void setCHCT(Integer[] CHCT) {
        this.CHCT = CHCT;
    }

    public Integer[] getDTRR() {
        return DTRR;
    }

    public void setDTRR(Integer[] DTRR) {
        this.DTRR = DTRR;
    }

    public Integer[] getMSTT() {
        return MSTT;
    }

    public void setMSTT(Integer[] MSTT) {
        this.MSTT = MSTT;
    }

    public Integer[] getCGCT() {
        return CGCT;
    }

    public void setCGCT(Integer[] CGCT) {
        this.CGCT = CGCT;
    }

    public Integer[] getTotal() {
        return total;
    }

    public void setTotal(Integer[] total) {
        this.total = total;
    }

    public Integer getTotalPlug() {
        return totalPlug;
    }

    public void setTotalPlug(Integer totalPlug) {
        this.totalPlug = totalPlug;
    }

    public Long getMsNguonVon() {
        return msNguonVon;
    }

    public void setMsNguonVon(Long msNguonVon) {
        this.msNguonVon = msNguonVon;
    }

    public Long getMsLoai() {
        return msLoai;
    }

    public void setMsLoai(Long msLoai) {
        this.msLoai = msLoai;
    }

    public Long getMsPhong() {
        return msPhong;
    }

    public void setMsPhong(Long msPhong) {
        this.msPhong = msPhong;
    }

    public Long getMsChuTri() {
        return msChuTri;
    }

    public void setMsChuTri(Long msChuTri) {
        this.msChuTri = msChuTri;
    }

    public Long getMsThanhVien() {
        return msThanhVien;
    }

    public void setMsThanhVien(Long msThanhVien) {
        this.msThanhVien = msThanhVien;
    }

    public Long getMsQuiMo() {
        return msQuiMo;
    }

    public void setMsQuiMo(Long msQuiMo) {
        this.msQuiMo = msQuiMo;
    }
}
