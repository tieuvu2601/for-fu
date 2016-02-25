package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class NguonvonDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msnguonvon;
    private String tennguonvon;
    private BigDecimal stt;
    private String ghichu;

    public Long getMsnguonvon() {
        return msnguonvon;
    }

    public void setMsnguonvon(Long msnguonvon) {
        this.msnguonvon = msnguonvon;
    }

    public String getTennguonvon() {
        return tennguonvon;
    }

    public void setTennguonvon(String tennguonvon) {
        this.tennguonvon = tennguonvon;
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
}
