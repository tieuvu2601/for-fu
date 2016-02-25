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
public class LoaibaoDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msloaibao;
    private String tenloaibao;
    private BigDecimal stt;
    private String ghichu;
    private String maloaibao;

    public Long getMsloaibao() {
        return msloaibao;
    }

    public void setMsloaibao(Long msloaibao) {
        this.msloaibao = msloaibao;
    }

    public String getTenloaibao() {
        return tenloaibao;
    }

    public void setTenloaibao(String tenloaibao) {
        this.tenloaibao = tenloaibao;
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

    public String getMaloaibao() {
        return maloaibao;
    }

    public void setMaloaibao(String maloaibao) {
        this.maloaibao = maloaibao;
    }
}
