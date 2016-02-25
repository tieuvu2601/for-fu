package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DANGBAO")
@Entity
public class DangbaoEntity {
    private Long msdangbao;

    @javax.persistence.Column(name = "MSDANGBAO")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DANGBAO_SEQ")
    @SequenceGenerator(name="DANGBAO_SEQ", sequenceName="DANGBAO_SEQ", allocationSize=1)
    public Long getMsdangbao() {
        return msdangbao;
    }

    public void setMsdangbao(Long msdangbao) {
        this.msdangbao = msdangbao;
    }

    private GoithauEntity goithau;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "MSGOITHAU", referencedColumnName = "MSGOITHAU")
    public GoithauEntity getGoithau() {
        return goithau;
    }

    public void setGoithau(GoithauEntity goithau) {
        this.goithau = goithau;
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

    private Timestamp ngaydangbao;

    @javax.persistence.Column(name = "NGAYDANGBAO")
    @Basic
    public Timestamp getNgaydangbao() {
        return ngaydangbao;
    }

    public void setNgaydangbao(Timestamp ngaydangbao) {
        this.ngaydangbao = ngaydangbao;
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

    private BigDecimal sobaobatdau;

    @javax.persistence.Column(name = "SOBAOBATDAU")
    @Basic
    public BigDecimal getSobaobatdau() {
        return sobaobatdau;
    }

    public void setSobaobatdau(BigDecimal sobaobatdau) {
        this.sobaobatdau = sobaobatdau;
    }

    private BigDecimal sokydangbao;

    @javax.persistence.Column(name = "SOKYDANGBAO")
    @Basic
    public BigDecimal getSokydangbao() {
        return sokydangbao;
    }

    public void setSokydangbao(BigDecimal sokydangbao) {
        this.sokydangbao = sokydangbao;
    }

    private String socongvan;

    @javax.persistence.Column(name = "SOCONGVAN")
    @Basic
    public String getSocongvan() {
        return socongvan;
    }

    public void setSocongvan(String socongvan) {
        this.socongvan = socongvan;
    }

    private Timestamp ngaycongvan;

    @javax.persistence.Column(name = "NGAYCONGVAN")
    @Basic
    public Timestamp getNgaycongvan() {
        return ngaycongvan;
    }

    public void setNgaycongvan(Timestamp ngaycongvan) {
        this.ngaycongvan = ngaycongvan;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DangbaoEntity that = (DangbaoEntity) o;

        if (msdangbao != that.msdangbao) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (goithau != null ? !goithau.equals(that.goithau) : that.goithau != null) return false;
        if (loaibao != null ? !loaibao.equals(that.loaibao) : that.loaibao != null) return false;
        if (noidung != null ? !noidung.equals(that.noidung) : that.noidung != null) return false;
        if (ngaycongvan != null ? !ngaycongvan.equals(that.ngaycongvan) : that.ngaycongvan != null) return false;
        if (ngaydangbao != null ? !ngaydangbao.equals(that.ngaydangbao) : that.ngaydangbao != null) return false;
        if (sobaobatdau != null ? !sobaobatdau.equals(that.sobaobatdau) : that.sobaobatdau != null) return false;
        if (socongvan != null ? !socongvan.equals(that.socongvan) : that.socongvan != null) return false;
        if (sokydangbao != null ? !sokydangbao.equals(that.sokydangbao) : that.sokydangbao != null) return false;

        return true;
    }

}
