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
public class TinhchatDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long mstinhchat;
    private String tentinhchat;
    private BigDecimal stt;
    private String ghichu;

    public Long getMstinhchat() {
        return mstinhchat;
    }

    public void setMstinhchat(Long mstinhchat) {
        this.mstinhchat = mstinhchat;
    }

    public String getTentinhchat() {
        return tentinhchat;
    }

    public void setTentinhchat(String tentinhchat) {
        this.tentinhchat = tentinhchat;
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
