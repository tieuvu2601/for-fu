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
@Table(name = "DM_NHATHAU")
@Entity
public class DmNhathauEntity {
    private Long msnhathau;

    @Column(name = "MSNHATHAU")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_NHATHAU_SEQ")
    @SequenceGenerator(name="DM_NHATHAU_SEQ", sequenceName="DM_NHATHAU_SEQ", allocationSize=1)
    public Long getMsnhathau() {
        return msnhathau;
    }

    public void setMsnhathau(Long msnhathau) {
        this.msnhathau = msnhathau;
    }

    private String tennhathau;

    @Column(name = "TENNHATHAU")
    @Basic
    public String getTennhathau() {
        return tennhathau;
    }

    public void setTennhathau(String tennhathau) {
        this.tennhathau = tennhathau;
    }

    private String diachi;

    @Column(name = "DIACHI")
    @Basic
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    private String dienthoai;

    @Column(name = "DIENTHOAI")
    @Basic
    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    private String fax;

    @Column(name = "FAX")
    @Basic
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    private String ghichu;

    @Column(name = "GHICHU")
    @Basic
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    private BigDecimal active;

    @Column(name = "ACTIVE")
    @Basic
    public BigDecimal getActive() {
        return active;
    }

    public void setActive(BigDecimal active) {
        this.active = active;
    }

    private String masothue;

    @Column(name = "MASOTHUE")
    @Basic
    public String getMasothue() {
        return masothue;
    }

    public void setMasothue(String masothue) {
        this.masothue = masothue;
    }

    private DmNhathauEntity old;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OLDID", referencedColumnName = "MSNHATHAU")
    public DmNhathauEntity getOld() {
        return old;
    }

    public void setOld(DmNhathauEntity old) {
        this.old = old;
    }

    private String giayPhepKinhDoanh;

    @Column(name = "GIAYPHEPKINHDOANH")
    @Basic
    public String getGiayPhepKinhDoanh() {
        return giayPhepKinhDoanh;
    }

    public void setGiayPhepKinhDoanh(String giayPhepKinhDoanh) {
        this.giayPhepKinhDoanh = giayPhepKinhDoanh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmNhathauEntity that = (DmNhathauEntity) o;

        if (msnhathau != that.msnhathau) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (diachi != null ? !diachi.equals(that.diachi) : that.diachi != null) return false;
        if (dienthoai != null ? !dienthoai.equals(that.dienthoai) : that.dienthoai != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (masothue != null ? !masothue.equals(that.masothue) : that.masothue != null) return false;
        if (tennhathau != null ? !tennhathau.equals(that.tennhathau) : that.tennhathau != null) return false;

        return true;
    }

}
