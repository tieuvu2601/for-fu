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
@javax.persistence.Table(name = "DM_LANHDAO")
@Entity
public class DmLanhdaoEntity {
    private Long mslanhdao;

    @javax.persistence.Column(name = "MSLANHDAO")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_LANHDAO_SEQ")
    @SequenceGenerator(name="DM_LANHDAO_SEQ", sequenceName="DM_LANHDAO_SEQ", allocationSize=1)
    public Long getMslanhdao() {
        return mslanhdao;
    }

    public void setMslanhdao(Long mslanhdao) {
        this.mslanhdao = mslanhdao;
    }


    private String tenlanhdao;

    @javax.persistence.Column(name = "TENLANHDAO")
    @Basic
    public String getTenlanhdao() {
        return tenlanhdao;
    }

    public void setTenlanhdao(String tenlanhdao) {
        this.tenlanhdao = tenlanhdao;
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

    private BigInteger active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    private String chucvu;

    @javax.persistence.Column(name = "CHUCVU")
    @Basic
    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmLanhdaoEntity that = (DmLanhdaoEntity) o;

        if (mslanhdao != that.mslanhdao) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (chucvu != null ? !chucvu.equals(that.chucvu) : that.chucvu != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tenlanhdao != null ? !tenlanhdao.equals(that.tenlanhdao) : that.tenlanhdao != null) return false;

        return true;
    }

}
