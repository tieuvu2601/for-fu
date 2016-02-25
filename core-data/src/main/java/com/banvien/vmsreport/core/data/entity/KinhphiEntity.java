package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "KINHPHI")
@Entity
public class KinhphiEntity {
    private Long mskinhphi;

    @javax.persistence.Column(name = "MSKINHPHI")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KINHPHI_SEQ")
    @SequenceGenerator(name="KINHPHI_SEQ", sequenceName="KINHPHI_SEQ", allocationSize=1)
    public Long getMskinhphi() {
        return mskinhphi;
    }

    public void setMskinhphi(Long mskinhphi) {
        this.mskinhphi = mskinhphi;
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

    private DmLoaibaoEntity loaibao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSLOAIBAO", referencedColumnName = "MSLOAIBAO")
    public DmLoaibaoEntity getLoaibao() {
        return loaibao;
    }

    public void setLoaibao(DmLoaibaoEntity loaibao) {
        this.loaibao = loaibao;
    }

    private DmNoidungEntity noidung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSNOIDUNG", referencedColumnName = "MSNOIDUNG")
    public DmNoidungEntity getNoidung() {
        return noidung;
    }

    public void setNoidung(DmNoidungEntity noidung) {
        this.noidung = noidung;
    }

    private BigDecimal soky;

    @javax.persistence.Column(name = "SOKY")
    @Basic
    public BigDecimal getSoky() {
        return soky;
    }

    public void setSoky(BigDecimal soky) {
        this.soky = soky;
    }

    private BigDecimal chiphi;

    @javax.persistence.Column(name = "CHIPHI")
    @Basic
    public BigDecimal getChiphi() {
        return chiphi;
    }

    public void setChiphi(BigDecimal chiphi) {
        this.chiphi = chiphi;
    }

    private BigDecimal thanhtien;

    @javax.persistence.Column(name = "THANHTIEN")
    @Basic
    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

    private String khobao;

    @javax.persistence.Column(name = "KHOBAO")
    @Basic
    public String getKhobao() {
        return khobao;
    }

    public void setKhobao(String khobao) {
        this.khobao = khobao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KinhphiEntity that = (KinhphiEntity) o;

        if (mskinhphi != that.mskinhphi) return false;
        if (chiphi != null ? !chiphi.equals(that.chiphi) : that.chiphi != null) return false;
        if (khobao != null ? !khobao.equals(that.khobao) : that.khobao != null) return false;
        if (soky != null ? !soky.equals(that.soky) : that.soky != null) return false;
        if (thanhtien != null ? !thanhtien.equals(that.thanhtien) : that.thanhtien != null) return false;

        return true;
    }
}
