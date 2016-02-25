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
public class QuyMoDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msquimo;
    private String tenquimo;
    private BigDecimal stt;
    private String ghichu;
    private Long fromValue;
    private Long toValue;

    public Long getMsquimo() {
        return msquimo;
    }

    public void setMsquimo(Long msquimo) {
        this.msquimo = msquimo;
    }

    public String getTenquimo() {
        return tenquimo;
    }

    public void setTenquimo(String tenquimo) {
        this.tenquimo = tenquimo;
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

    public Long getFromValue() {
        return fromValue;
    }

    public void setFromValue(Long fromValue) {
        this.fromValue = fromValue;
    }

    public Long getToValue() {
        return toValue;
    }

    public void setToValue(Long toValue) {
        this.toValue = toValue;
    }
}
