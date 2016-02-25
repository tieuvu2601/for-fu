package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_QUIMO")
@Entity
public class DmQuyMoEntity {
    private Long msquimo;

    @javax.persistence.Column(name = "MSQUIMO")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_THAMSOHETHONG_SEQ")
    @SequenceGenerator(name="DM_THAMSOHETHONG_SEQ", sequenceName="DM_THAMSOHETHONG_SEQ", allocationSize=1)
    public Long getMsquimo() {
        return msquimo;
    }

    public void setMsquimo(Long msquimo) {
        this.msquimo = msquimo;
    }

    private String tenquimo;

    @javax.persistence.Column(name = "TENQUIMO")
    @Basic
    public String getTenquimo() {
        return tenquimo;
    }

    public void setTenquimo(String tenquimo) {
        this.tenquimo = tenquimo;
    }

    private BigDecimal stt;

    @javax.persistence.Column(name = "STT")
    @Basic
    public BigDecimal getStt() {
        return stt;
    }

    public void setStt(BigDecimal stt) {
        this.stt = stt;
    }

    private String ghichu;

    @javax.persistence.Column(name = "GHICHU")
    @Basic
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmQuyMoEntity that = (DmQuyMoEntity) o;

        if (msquimo != that.msquimo) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tenquimo != null ? !tenquimo.equals(that.tenquimo) : that.tenquimo != null) return false;

        return true;
    }

    private Long fromValue;

    private Long toValue;

    @javax.persistence.Column(name = "FROMVALUE")
    @Basic
    public Long getFromValue() {
        return fromValue;
    }

    public void setFromValue(Long fromValue) {
        this.fromValue = fromValue;
    }

    @javax.persistence.Column(name = "TOVALUE")
    @Basic
    public void setToValue(Long toValue) {
        this.toValue = toValue;
    }

    public Long getToValue() {
        return toValue;
    }

}
