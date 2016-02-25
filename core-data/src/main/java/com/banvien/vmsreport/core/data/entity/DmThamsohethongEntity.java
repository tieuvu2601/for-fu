package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_THAMSOHETHONG")
@Entity
public class DmThamsohethongEntity {
    private Long msthamsohethong;

    @javax.persistence.Column(name = "MSTHAMSOHETHONG")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_THAMSOHETHONG_BK_SEQ")
    @SequenceGenerator(name="DM_THAMSOHETHONG_BK_SEQ", sequenceName="DM_THAMSOHETHONG_BK_SEQ", allocationSize=1)
    public Long getMsthamsohethong() {
        return msthamsohethong;
    }

    public void setMsthamsohethong(Long msthamsohethong) {
        this.msthamsohethong = msthamsohethong;
    }

    private String tenthamsohethong;

    @javax.persistence.Column(name = "TENTHAMSOHETHONG")
    @Basic
    public String getTenthamsohethong() {
        return tenthamsohethong;
    }

    public void setTenthamsohethong(String tenthamsohethong) {
        this.tenthamsohethong = tenthamsohethong;
    }

    private String giatri;

    @javax.persistence.Column(name = "GIATRI")
    @Basic
    public String getGiatri() {
        return giatri;
    }

    public void setGiatri(String giatri) {
        this.giatri = giatri;
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

    private BigInteger active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmThamsohethongEntity that = (DmThamsohethongEntity) o;

        if (msthamsohethong != that.msthamsohethong) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (giatri != null ? !giatri.equals(that.giatri) : that.giatri != null) return false;
        if (tenthamsohethong != null ? !tenthamsohethong.equals(that.tenthamsohethong) : that.tenthamsohethong != null)
            return false;

        return true;
    }
}
