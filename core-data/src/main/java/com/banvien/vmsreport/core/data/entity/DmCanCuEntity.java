package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DMCANCU")
@Entity
public class DmCanCuEntity {
    private Long canCuId;
    @javax.persistence.Column(name = "CANCUID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DMCANCU_SEQ")
    @SequenceGenerator(name="DMCANCU_SEQ", sequenceName="DMCANCU_SEQ", allocationSize=1)
    public Long getCanCuId() {
        return canCuId;
    }

    public void setCanCuId(Long canCuId) {
        this.canCuId = canCuId;
    }

    private String maCanCu;
    @javax.persistence.Column(name = "MACANCU")
    @Basic
    public String getMaCanCu() {
        return maCanCu;
    }

    public void setMaCanCu(String maCanCu) {
        this.maCanCu = maCanCu;
    }

    private String noiDung;
    @javax.persistence.Column(name = "NOIDUNG")
    @Basic
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    private Timestamp createdDate;
    @javax.persistence.Column(name = "CREATEDDATE")
    @Basic
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    private Timestamp modifiedDate;
    @javax.persistence.Column(name = "MODIFIEDDATE")
    @Basic
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    private String ghiChu;
    @javax.persistence.Column(name = "GHICHU")
    @Basic
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
