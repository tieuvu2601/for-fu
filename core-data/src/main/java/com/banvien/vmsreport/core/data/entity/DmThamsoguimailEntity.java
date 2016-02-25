package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_THAMSOGUIMAIL")
@Entity
public class DmThamsoguimailEntity {
    private Long msthamsoguimail;

    @javax.persistence.Column(name = "MSTHAMSOGUIMAIL")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_THAMSOQUIMO_SEQ")
    @SequenceGenerator(name="DM_THAMSOQUIMO_SEQ", sequenceName="DM_THAMSOQUIMO_SEQ", allocationSize=1)
    public Long getMsthamsoguimail() {
        return msthamsoguimail;
    }

    public void setMsthamsoguimail(Long msthamsoguimail) {
        this.msthamsoguimail = msthamsoguimail;
    }


    private Integer mshinhthuc;

    @javax.persistence.Column(name = "MSHINHTHUC")
    @Basic
    Integer getMshinhthuc() {
        return mshinhthuc;
    }

    void setMshinhthuc(Integer mshinhthuc) {
        this.mshinhthuc = mshinhthuc;
    }

    private Integer msquimo;

    @javax.persistence.Column(name = "MSQUIMO")
    @Basic
    Integer getMsquimo() {
        return msquimo;
    }

    void setMsquimo(Integer msquimo) {
        this.msquimo = msquimo;
    }

    private BigDecimal songayquidinh;

    @javax.persistence.Column(name = "SONGAYQUIDINH")
    @Basic
    BigDecimal getSongayquidinh() {
        return songayquidinh;
    }

    void setSongayquidinh(BigDecimal songayquidinh) {
        this.songayquidinh = songayquidinh;
    }

    private BigDecimal songaydenhan;

    @javax.persistence.Column(name = "SONGAYDENHAN")
    @Basic
    BigDecimal getSongaydenhan() {
        return songaydenhan;
    }

    void setSongaydenhan(BigDecimal songaydenhan) {
        this.songaydenhan = songaydenhan;
    }

    private Integer msgiaidoan;

    @javax.persistence.Column(name = "MSGIAIDOAN")
    @Basic
    Integer getMsgiaidoan() {
        return msgiaidoan;
    }

    void setMsgiaidoan(Integer msgiaidoan) {
        this.msgiaidoan = msgiaidoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmThamsoguimailEntity that = (DmThamsoguimailEntity) o;

        if (msthamsoguimail != that.msthamsoguimail) return false;
        if (msgiaidoan != null ? !msgiaidoan.equals(that.msgiaidoan) : that.msgiaidoan != null) return false;
        if (mshinhthuc != null ? !mshinhthuc.equals(that.mshinhthuc) : that.mshinhthuc != null) return false;
        if (msquimo != null ? !msquimo.equals(that.msquimo) : that.msquimo != null) return false;
        if (songaydenhan != null ? !songaydenhan.equals(that.songaydenhan) : that.songaydenhan != null) return false;
        if (songayquidinh != null ? !songayquidinh.equals(that.songayquidinh) : that.songayquidinh != null)
            return false;

        return true;
    }

}
