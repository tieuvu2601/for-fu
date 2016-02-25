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
public class LoaiBieuMauDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msbieumau;
    private String tenbieumau;
    private BigDecimal stt;
    private String ghichu;

    public Long getMsbieumau() {
        return msbieumau;
    }

    public void setMsbieumau(Long msbieumau) {
        this.msbieumau = msbieumau;
    }

    public String getTenbieumau() {
        return tenbieumau;
    }

    public void setTenbieumau(String tenbieumau) {
        this.tenbieumau = tenbieumau;
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
