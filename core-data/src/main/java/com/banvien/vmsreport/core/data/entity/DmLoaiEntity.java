package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_LOAI")
@Entity
public class DmLoaiEntity {
    private Long msloai;

    @javax.persistence.Column(name = "MSLOAI")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_LOAI_SEQ")
    @SequenceGenerator(name="DM_LOAI_SEQ", sequenceName="DM_LOAI_SEQ", allocationSize=1)
    public Long getMsloai() {
        return msloai;
    }

    public void setMsloai(Long msloai) {
        this.msloai = msloai;
    }

    private String tenloai;

    @javax.persistence.Column(name = "TENLOAI")
    @Basic
    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
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

    private Integer active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    private String maloai;

    @javax.persistence.Column(name = "MALOAI")
    @Basic
    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmLoaiEntity that = (DmLoaiEntity) o;

        if (msloai != that.msloai) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (maloai != null ? !maloai.equals(that.maloai) : that.maloai != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tenloai != null ? !tenloai.equals(that.tenloai) : that.tenloai != null) return false;

        return true;
    }

}
