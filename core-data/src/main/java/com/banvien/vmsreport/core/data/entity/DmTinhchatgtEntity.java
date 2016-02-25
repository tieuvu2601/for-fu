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
@javax.persistence.Table(name = "DM_TINHCHATGT")
@Entity
public class DmTinhchatgtEntity {
    private Long mstinhchat;

    @javax.persistence.Column(name = "MSTINHCHAT")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_TINHCHATGT_SEQ")
    @SequenceGenerator(name="DM_TINHCHATGT_SEQ", sequenceName="DM_TINHCHATGT_SEQ", allocationSize=1)
    public Long getMstinhchat() {
        return mstinhchat;
    }

    public void setMstinhchat(Long mstinhchat) {
        this.mstinhchat = mstinhchat;
    }

    private String tentinhchat;

    @javax.persistence.Column(name = "TENTINHCHAT")
    @Basic
    public String getTentinhchat() {
        return tentinhchat;
    }

    public void setTentinhchat(String tentinhchat) {
        this.tentinhchat = tentinhchat;
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

        DmTinhchatgtEntity that = (DmTinhchatgtEntity) o;

        if (mstinhchat != that.mstinhchat) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tentinhchat != null ? !tentinhchat.equals(that.tentinhchat) : that.tentinhchat != null) return false;

        return true;
    }

}
