package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "DM_GIAIDOAN")
@Entity
public class DmGiaidoanEntity {
    private Long msgiaidoan;

    @Column(name = "MSGIAIDOAN")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_GIAIDOAN_SEQ")
    @SequenceGenerator(name="DM_GIAIDOAN_SEQ", sequenceName="DM_GIAIDOAN_SEQ", allocationSize=1)
    public Long getMsgiaidoan() {
        return msgiaidoan;
    }

    public void setMsgiaidoan(Long msgiaidoan) {
        this.msgiaidoan = msgiaidoan;
    }


    private String tengiaidoan;

    @Column(name = "TENGIAIDOAN")
    @Basic
    String getTengiaidoan() {
        return tengiaidoan;
    }

    void setTengiaidoan(String tengiaidoan) {
        this.tengiaidoan = tengiaidoan;
    }

    private BigDecimal stt;

    @Column(name = "STT")
    @Basic
    BigDecimal getStt() {
        return stt;
    }

    void setStt(BigDecimal stt) {
        this.stt = stt;
    }

    private String ghichu;

    @Column(name = "GHICHU")
    @Basic
    String getGhichu() {
        return ghichu;
    }

    void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmGiaidoanEntity that = (DmGiaidoanEntity) o;

        if (msgiaidoan != that.msgiaidoan) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tengiaidoan != null ? !tengiaidoan.equals(that.tengiaidoan) : that.tengiaidoan != null) return false;

        return true;
    }
}
