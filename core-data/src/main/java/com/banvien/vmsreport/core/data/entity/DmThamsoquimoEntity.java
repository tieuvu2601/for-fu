package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_THAMSOQUIMO")
@Entity
public class DmThamsoquimoEntity {
    private Long msthamso;

    @javax.persistence.Column(name = "MSTHAMSO")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_THAMSOHETHONG_SEQ")
    @SequenceGenerator(name="DM_THAMSOHETHONG_SEQ", sequenceName="DM_THAMSOHETHONG_SEQ", allocationSize=1)
    public Long getMsthamso() {
        return msthamso;
    }

    public void setMsthamso(Long msthamso) {
        this.msthamso = msthamso;
    }


    private Integer mstinhchat;

    @javax.persistence.Column(name = "MSTINHCHAT")
    @Basic
    public Integer getMstinhchat() {
        return mstinhchat;
    }

    public void setMstinhchat(Integer mstinhchat) {
        this.mstinhchat = mstinhchat;
    }

    private BigDecimal fromvalue;

    @javax.persistence.Column(name = "FROMVALUE")
    @Basic
    public BigDecimal getFromvalue() {
        return fromvalue;
    }

    public void setFromvalue(BigDecimal fromvalue) {
        this.fromvalue = fromvalue;
    }

    private BigDecimal tovalue;

    @javax.persistence.Column(name = "TOVALUE")
    @Basic
    public BigDecimal getTovalue() {
        return tovalue;
    }

    public void setTovalue(BigDecimal tovalue) {
        this.tovalue = tovalue;
    }

    private Integer msquimo;

    @javax.persistence.Column(name = "MSQUIMO")
    @Basic
    public Integer getMsquimo() {
        return msquimo;
    }

    public void setMsquimo(Integer msquimo) {
        this.msquimo = msquimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmThamsoquimoEntity that = (DmThamsoquimoEntity) o;

        if (msthamso != that.msthamso) return false;
        if (fromvalue != null ? !fromvalue.equals(that.fromvalue) : that.fromvalue != null) return false;
        if (msquimo != null ? !msquimo.equals(that.msquimo) : that.msquimo != null) return false;
        if (mstinhchat != null ? !mstinhchat.equals(that.mstinhchat) : that.mstinhchat != null) return false;
        if (tovalue != null ? !tovalue.equals(that.tovalue) : that.tovalue != null) return false;

        return true;
    }

}
