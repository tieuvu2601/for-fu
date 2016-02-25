package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "BOPHAN")
@Entity
public class BophanEntity {
    private Long msbophan;

    @javax.persistence.Column(name = "MSBOPHAN")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOPHAN_SEQ")
    @SequenceGenerator(name="BOPHAN_SEQ", sequenceName="BOPHAN_SEQ", allocationSize=1)
    public Long getMsbophan() {
        return msbophan;
    }

    public void setMsbophan(Long msbophan) {
        this.msbophan = msbophan;
    }

    private String tenbophan;

    @javax.persistence.Column(name = "TENBOPHAN")
    @Basic
    String getTenbophan() {
        return tenbophan;
    }

    void setTenbophan(String tenbophan) {
        this.tenbophan = tenbophan;
    }

    private BigInteger active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    BigInteger getActive() {
        return active;
    }

    void setActive(BigInteger active) {
        this.active = active;
    }

    private String ghichu;

    @javax.persistence.Column(name = "GHICHU")
    @Basic
    String getGhichu() {
        return ghichu;
    }

    void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    private Integer departmentid;

    @javax.persistence.Column(name = "DEPARTMENTID")
    @Basic
    Integer getDepartmentid() {
        return departmentid;
    }

    void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    private String mabophan;

    @javax.persistence.Column(name = "MABOPHAN")
    @Basic
    String getMabophan() {
        return mabophan;
    }

    void setMabophan(String mabophan) {
        this.mabophan = mabophan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BophanEntity that = (BophanEntity) o;

        if (msbophan != that.msbophan) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (departmentid != null ? !departmentid.equals(that.departmentid) : that.departmentid != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (mabophan != null ? !mabophan.equals(that.mabophan) : that.mabophan != null) return false;
        if (tenbophan != null ? !tenbophan.equals(that.tenbophan) : that.tenbophan != null) return false;

        return true;
    }

}
