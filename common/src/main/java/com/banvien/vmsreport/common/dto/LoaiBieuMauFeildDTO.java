package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoaiBieuMauFeildDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private int msbieumaufeild;
    private LoaiBieuMauDTO bieumau;
    private String fieldname;
    private String fieldtype;
    private Long columnnum;

    public int getMsbieumaufeild() {
        return msbieumaufeild;
    }

    public void setMsbieumaufeild(int msbieumaufeild) {
        this.msbieumaufeild = msbieumaufeild;
    }

    public LoaiBieuMauDTO getBieumau() {
        return bieumau;
    }

    public void setBieumau(LoaiBieuMauDTO bieumau) {
        this.bieumau = bieumau;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getFieldtype() {
        return fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }

    public Long getColumnnum() {
        return columnnum;
    }

    public void setColumnnum(Long columnnum) {
        this.columnnum = columnnum;
    }
}
