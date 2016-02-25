package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;


public class HinhthucgtDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long mshinhthuc;
    private String mahinhthuc;
    private String tenhinhthuc;
    private BigDecimal stt;
    private String ghichu;

    public Long getMshinhthuc() {
        return mshinhthuc;
    }

    public void setMshinhthuc(Long mshinhthuc) {
        this.mshinhthuc = mshinhthuc;
    }

    public String getMahinhthuc() {
        return mahinhthuc;
    }

    public void setMahinhthuc(String mahinhthuc) {
        this.mahinhthuc = mahinhthuc;
    }

    public String getTenhinhthuc() {
        return tenhinhthuc;
    }

    public void setTenhinhthuc(String tenhinhthuc) {
        this.tenhinhthuc = tenhinhthuc;
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
