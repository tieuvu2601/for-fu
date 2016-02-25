package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CanCuDTO implements Serializable {
    private Long canCuId;
    private String maCanCu;
    private String noiDung;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String ghiChu;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Long getCanCuId() {
        return canCuId;
    }

    public void setCanCuId(Long canCuId) {
        this.canCuId = canCuId;
    }

    public String getMaCanCu() {
        return maCanCu;
    }

    public void setMaCanCu(String maCanCu) {
        this.maCanCu = maCanCu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
