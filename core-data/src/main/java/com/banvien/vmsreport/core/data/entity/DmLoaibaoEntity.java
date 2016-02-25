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
@javax.persistence.Table(name = "DM_LOAIBAO")
@Entity
public class DmLoaibaoEntity {
    private Long msloaibao;

    @javax.persistence.Column(name = "MSLOAIBAO")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_LOAIBAO_SEQ")
    @SequenceGenerator(name="DM_LOAIBAO_SEQ", sequenceName="DM_LOAIBAO_SEQ", allocationSize=1)
    public Long getMsloaibao() {
        return msloaibao;
    }

    public void setMsloaibao(Long msloaibao) {
        this.msloaibao = msloaibao;
    }

    private String tenloaibao;

    @javax.persistence.Column(name = "TENLOAIBAO")
    @Basic
    public String getTenloaibao() {
        return tenloaibao;
    }

    public void setTenloaibao(String tenloaibao) {
        this.tenloaibao = tenloaibao;
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

    private String maloaibao;

    @javax.persistence.Column(name = "MALOAIBAO")
    @Basic
    public String getMaloaibao() {
        return maloaibao;
    }

    public void setMaloaibao(String maloaibao) {
        this.maloaibao = maloaibao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmLoaibaoEntity that = (DmLoaibaoEntity) o;

        if (msloaibao != that.msloaibao) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (maloaibao != null ? !maloaibao.equals(that.maloaibao) : that.maloaibao != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tenloaibao != null ? !tenloaibao.equals(that.tenloaibao) : that.tenloaibao != null) return false;

        return true;
    }
}
