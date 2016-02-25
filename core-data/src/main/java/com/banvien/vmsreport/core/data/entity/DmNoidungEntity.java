package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_NOIDUNG")
@Entity
public class DmNoidungEntity {
    private Long msnoidung;

    @javax.persistence.Column(name = "MSNOIDUNG")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_NOIDUNG_SEQ")
    @SequenceGenerator(name="DM_NOIDUNG_SEQ", sequenceName="DM_NOIDUNG_SEQ", allocationSize=1)
    public Long getMsnoidung() {
        return msnoidung;
    }

    public void setMsnoidung(Long msnoidung) {
        this.msnoidung = msnoidung;
    }

    private String tennoidung;

    @javax.persistence.Column(name = "TENNOIDUNG")
    @Basic
    public String getTennoidung() {
        return tennoidung;
    }

    public void setTennoidung(String tennoidung) {
        this.tennoidung = tennoidung;
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

    private BigDecimal loai;

    @javax.persistence.Column(name = "LOAI")
    @Basic
    public BigDecimal getLoai() {
        return loai;
    }

    public void setLoai(BigDecimal loai) {
        this.loai = loai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmNoidungEntity that = (DmNoidungEntity) o;

        if (msnoidung != that.msnoidung) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (loai != null ? !loai.equals(that.loai) : that.loai != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tennoidung != null ? !tennoidung.equals(that.tennoidung) : that.tennoidung != null) return false;

        return true;
    }
}
