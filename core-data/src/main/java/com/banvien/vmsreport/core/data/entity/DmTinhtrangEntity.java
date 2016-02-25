package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigInteger;

@javax.persistence.Table(name = "DM_TINHTRANG")
@Entity
public class DmTinhtrangEntity {
    private Long mstinhtrang;

    @javax.persistence.Column(name = "MSTINHTRANG")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_TINHTRANG_SEQ")
    @SequenceGenerator(name="DM_TINHTRANG_SEQ", sequenceName="DM_TINHTRANG_SEQ", allocationSize=1)
    public Long getMstinhtrang() {
        return mstinhtrang;
    }

    public void setMstinhtrang(Long mstinhtrang) {
        this.mstinhtrang = mstinhtrang;
    }

    private String tentinhtrang;

    @javax.persistence.Column(name = "TENTINHTRANG")
    @Basic
    public String getTentinhtrang() {
        return tentinhtrang;
    }

    public void setTentinhtrang(String tentinhtrang) {
        this.tentinhtrang = tentinhtrang;
    }

    private BigInteger active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
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

    private String maSoTinhTrang;

    @javax.persistence.Column(name = "MATINHTRANG")
    @Basic
    public String getMaSoTinhTrang() {
        return maSoTinhTrang;
    }

    public void setMaSoTinhTrang(String maSoTinhTrang) {
        this.maSoTinhTrang = maSoTinhTrang;
    }

    private Integer displayOrder;

    @javax.persistence.Column(name = "DISPLAYORDER")
    @Basic
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmTinhtrangEntity that = (DmTinhtrangEntity) o;

        if (mstinhtrang != that.mstinhtrang) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (tentinhtrang != null ? !tentinhtrang.equals(that.tentinhtrang) : that.tentinhtrang != null) return false;
        if (maSoTinhTrang != null ? !maSoTinhTrang.equals(that.maSoTinhTrang) : that.tentinhtrang != null) return false;

        return true;
    }
}
