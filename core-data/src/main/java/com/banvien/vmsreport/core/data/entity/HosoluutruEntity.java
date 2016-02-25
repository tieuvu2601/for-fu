package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "HOSOLUUTRU")
@Entity
public class HosoluutruEntity {
    private Long msluutru;

    @javax.persistence.Column(name = "MSLUUTRU")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSOLUUTRU_SEQ")
    @SequenceGenerator(name="HOSOLUUTRU_SEQ", sequenceName="HOSOLUUTRU_SEQ", allocationSize=1)
    public Long getMsluutru() {
        return msluutru;
    }

    public void setMsluutru(Long msluutru) {
        this.msluutru = msluutru;
    }


    private GoithauEntity goithau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSGOITHAU", referencedColumnName = "MSGOITHAU")
    public GoithauEntity getGoithau() {
        return goithau;
    }

    public void setGoithau(GoithauEntity goithau) {
        this.goithau = goithau;
    }

    private BigDecimal sotu;

    @javax.persistence.Column(name = "SOTU")
    @Basic
    public BigDecimal getSotu() {
        return sotu;
    }

    public void setSotu(BigDecimal sotu) {
        this.sotu = sotu;
    }

    private BigDecimal soke;

    @javax.persistence.Column(name = "SOKE")
    @Basic
    public BigDecimal getSoke() {
        return soke;
    }

    public void setSoke(BigDecimal soke) {
        this.soke = soke;
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

    private String creater;

    @javax.persistence.Column(name = "CREATER")
    @Basic
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    private Timestamp createtime;

    @javax.persistence.Column(name = "CREATETIME")
    @Basic
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    private String editer;

    @javax.persistence.Column(name = "EDITER")
    @Basic
    public String getEditer() {
        return editer;
    }

    public void setEditer(String editer) {
        this.editer = editer;
    }

    private Timestamp edittime;

    @javax.persistence.Column(name = "EDITTIME")
    @Basic
    public Timestamp getEdittime() {
        return edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HosoluutruEntity that = (HosoluutruEntity) o;

        if (msluutru != that.msluutru) return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (editer != null ? !editer.equals(that.editer) : that.editer != null) return false;
        if (edittime != null ? !edittime.equals(that.edittime) : that.edittime != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (soke != null ? !soke.equals(that.soke) : that.soke != null) return false;
        if (sotu != null ? !sotu.equals(that.sotu) : that.sotu != null) return false;

        return true;
    }
}
