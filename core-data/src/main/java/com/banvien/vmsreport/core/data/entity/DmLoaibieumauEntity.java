package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_LOAIBIEUMAU")
@Entity
public class DmLoaibieumauEntity {
    private Long msbieumau;

    @javax.persistence.Column(name = "MSBIEUMAU")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_LOAIBIEUMAU_SEQ")
    @SequenceGenerator(name="DM_LOAIBIEUMAU_SEQ", sequenceName="DM_LOAIBIEUMAU_SEQ", allocationSize=1)
    public Long getMsbieumau() {
        return msbieumau;
    }

    public void setMsbieumau(Long msbieumau) {
        this.msbieumau = msbieumau;
    }

    private String tenbieumau;

    @javax.persistence.Column(name = "TENBIEUMAU")
    @Basic
    public String getTenbieumau() {
        return tenbieumau;
    }

    public void setTenbieumau(String tenbieumau) {
        this.tenbieumau = tenbieumau;
    }

    private Integer stt;

    @javax.persistence.Column(name = "STT")
    @Basic
    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
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


    private String bieuMau;

    @javax.persistence.Column(name = "BIEUMAU")
    @Basic
    public String getBieuMau() {
        return bieuMau;
    }

    public void setBieuMau(String bieuMau) {
        this.bieuMau = bieuMau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmLoaibieumauEntity that = (DmLoaibieumauEntity) o;

        if (msbieumau != that.msbieumau) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tenbieumau != null ? !tenbieumau.equals(that.tenbieumau) : that.tenbieumau != null) return false;
        if (bieuMau != null ? !bieuMau.equals(that.bieuMau) : that.bieuMau != null) return false;

        return true;
    }

}
