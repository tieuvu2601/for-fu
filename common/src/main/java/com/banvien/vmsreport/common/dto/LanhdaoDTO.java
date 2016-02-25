package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LanhdaoDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long mslanhdao;
    private String tenlanhdao;
    private BigDecimal stt;
    private String ghichu;
    private BigInteger active;
    private String chucvu;

    public Long getMslanhdao() {
        return mslanhdao;
    }

    public void setMslanhdao(Long mslanhdao) {
        this.mslanhdao = mslanhdao;
    }

    public String getTenlanhdao() {
        return tenlanhdao;
    }

    public void setTenlanhdao(String tenlanhdao) {
        this.tenlanhdao = tenlanhdao;
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

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
