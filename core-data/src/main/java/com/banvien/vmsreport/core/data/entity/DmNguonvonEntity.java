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
@Table(name = "DM_NGUONVON")
@Entity
public class DmNguonvonEntity {
    private Long msnguonvon;

    @Column(name = "MSNGUONVON")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_NGUONVON_SEQ")
    @SequenceGenerator(name="DM_NGUONVON_SEQ", sequenceName="DM_NGUONVON_SEQ", allocationSize=1)
    public Long getMsnguonvon() {
        return msnguonvon;
    }

    public void setMsnguonvon(Long msnguonvon) {
        this.msnguonvon = msnguonvon;
    }

    private String tennguonvon;

    @Column(name = "TENNGUONVON")
    @Basic
    public String getTennguonvon() {
        return tennguonvon;
    }

    public void setTennguonvon(String tennguonvon) {
        this.tennguonvon = tennguonvon;
    }

    private BigDecimal stt;

    @Column(name = "STT")
    @Basic
    public BigDecimal getStt() {
        return stt;
    }

    public void setStt(BigDecimal stt) {
        this.stt = stt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmNguonvonEntity that = (DmNguonvonEntity) o;

        if (msnguonvon != that.msnguonvon) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tennguonvon != null ? !tennguonvon.equals(that.tennguonvon) : that.tennguonvon != null) return false;

        return true;
    }

}
