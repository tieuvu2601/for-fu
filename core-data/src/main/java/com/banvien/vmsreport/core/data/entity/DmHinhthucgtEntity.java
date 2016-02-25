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
@javax.persistence.Table(name = "DM_HINHTHUCGT")
@Entity
public class DmHinhthucgtEntity {
    private Long mshinhthuc;

    @javax.persistence.Column(name = "MSHINHTHUC")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_HINHTHUCGT_SEQ")
    @SequenceGenerator(name="DM_HINHTHUCGT_SEQ", sequenceName="DM_HINHTHUCGT_SEQ", allocationSize=1)
    public Long getMshinhthuc() {
        return mshinhthuc;
    }

    public void setMshinhthuc(Long mshinhthuc) {
        this.mshinhthuc = mshinhthuc;
    }


    private String mahinhthuc;

    @javax.persistence.Column(name = "MAHINHTHUC")
    @Basic
    public String getMahinhthuc() {
        return mahinhthuc;
    }

    public void setMahinhthuc(String mahinhthuc) {
        this.mahinhthuc = mahinhthuc;
    }

    private String tenhinhthuc;

    @javax.persistence.Column(name = "TENHINHTHUC")
    @Basic
    public String getTenhinhthuc() {
        return tenhinhthuc;
    }

    public void setTenhinhthuc(String tenhinhthuc) {
        this.tenhinhthuc = tenhinhthuc;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmHinhthucgtEntity that = (DmHinhthucgtEntity) o;

        if (mshinhthuc != that.mshinhthuc) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (mahinhthuc != null ? !mahinhthuc.equals(that.mahinhthuc) : that.mahinhthuc != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tenhinhthuc != null ? !tenhinhthuc.equals(that.tenhinhthuc) : that.tenhinhthuc != null) return false;

        return true;
    }
}
