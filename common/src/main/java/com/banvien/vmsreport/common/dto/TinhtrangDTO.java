package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TinhtrangDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long mstinhtrang;
    private String tentinhtrang;
    private BigInteger active;
    private String ghichu;
    private String maSoTinhTrang;
    private Integer displayOrder;

    public Long getMstinhtrang() {
        return mstinhtrang;
    }

    public void setMstinhtrang(Long mstinhtrang) {
        this.mstinhtrang = mstinhtrang;
    }

    public String getTentinhtrang() {
        return tentinhtrang;
    }

    public void setTentinhtrang(String tentinhtrang) {
        this.tentinhtrang = tentinhtrang;
    }

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getMaSoTinhTrang() {
        return maSoTinhTrang;
    }

    public void setMaSoTinhTrang(String maSoTinhTrang) {
        this.maSoTinhTrang = maSoTinhTrang;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
