package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "GOITHAU_NHATHAU")
@Entity
public class GoithauNhathauEntity {

    private Long msgoithauNt;
    @javax.persistence.Column(name = "MSGOITHAU_NT")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOITHAU_NHATHAU_SEQ")
    @SequenceGenerator(name="GOITHAU_NHATHAU_SEQ", sequenceName="GOITHAU_NHATHAU_SEQ", allocationSize=1)
    public Long getMsgoithauNt() {
        return msgoithauNt;
    }

    public void setMsgoithauNt(Long msgoithauNt) {
        this.msgoithauNt = msgoithauNt;
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

    private String tennhathau;

    @javax.persistence.Column(name = "TENNHATHAU")
    @Basic
    public String getTennhathau() {
        return tennhathau;
    }

    public void setTennhathau(String tennhathau) {
        this.tennhathau = tennhathau;
    }

    private String diachi;

    @javax.persistence.Column(name = "DIACHI")
    @Basic
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    private String dienthoai;

    @javax.persistence.Column(name = "DIENTHOAI")
    @Basic
    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    private String fax;

    @javax.persistence.Column(name = "FAX")
    @Basic
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    private Timestamp ngaymuahs;

    @javax.persistence.Column(name = "NGAYMUAHS")
    @Basic
    public Timestamp getNgaymuahs() {
        return ngaymuahs;
    }

    public void setNgaymuahs(Timestamp ngaymuahs) {
        this.ngaymuahs = ngaymuahs;
    }

    private Timestamp ngaynophs;

    @javax.persistence.Column(name = "NGAYNOPHS")
    @Basic
    public Timestamp getNgaynophs() {
        return ngaynophs;
    }

    public void setNgaynophs(Timestamp ngaynophs) {
        this.ngaynophs = ngaynophs;
    }

    private BigDecimal giathau;

    @javax.persistence.Column(name = "GIATHAU")
    @Basic
    public BigDecimal getGiathau() {
        return giathau;
    }

    public void setGiathau(BigDecimal giathau) {
        this.giathau = giathau;
    }

    private BigInteger istrungthau;

    @javax.persistence.Column(name = "ISTRUNGTHAU")
    @Basic
    public BigInteger getIstrungthau() {
        return istrungthau;
    }

    public void setIstrungthau(BigInteger istrungthau) {
        this.istrungthau = istrungthau;
    }

    private DmNhathauEntity nhathau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSNHATHAU", referencedColumnName = "MSNHATHAU")
    public DmNhathauEntity getNhathau() {
        return nhathau;
    }

    public void setNhathau(DmNhathauEntity nhathau) {
        this.nhathau = nhathau;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoithauNhathauEntity that = (GoithauNhathauEntity) o;

        if (msgoithauNt != that.msgoithauNt) return false;
        if (diachi != null ? !diachi.equals(that.diachi) : that.diachi != null) return false;
        if (dienthoai != null ? !dienthoai.equals(that.dienthoai) : that.dienthoai != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (giathau != null ? !giathau.equals(that.giathau) : that.giathau != null) return false;
        if (istrungthau != null ? !istrungthau.equals(that.istrungthau) : that.istrungthau != null) return false;
        if (ngaymuahs != null ? !ngaymuahs.equals(that.ngaymuahs) : that.ngaymuahs != null) return false;
        if (ngaynophs != null ? !ngaynophs.equals(that.ngaynophs) : that.ngaynophs != null) return false;
        if (tennhathau != null ? !tennhathau.equals(that.tennhathau) : that.tennhathau != null) return false;

        return true;
    }
}
