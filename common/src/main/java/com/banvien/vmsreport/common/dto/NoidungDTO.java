package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoidungDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msnoidung;
    private String tennoidung;
    private BigDecimal stt;
    private String ghichu;
    private BigDecimal loai;

    public Long getMsnoidung() {
        return msnoidung;
    }

    public void setMsnoidung(Long msnoidung) {
        this.msnoidung = msnoidung;
    }

    public String getTennoidung() {
        return tennoidung;
    }

    public void setTennoidung(String tennoidung) {
        this.tennoidung = tennoidung;
    }

    public BigDecimal getStt() {
        return stt;
    }

    public void setStt(BigDecimal stt) {
        this.stt = stt;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public BigDecimal getLoai() {
        return loai;
    }

    public void setLoai(BigDecimal loai) {
        this.loai = loai;
    }
}
