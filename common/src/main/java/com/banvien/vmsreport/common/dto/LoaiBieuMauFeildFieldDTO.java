package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoaiBieuMauFeildFieldDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private int msfieldbmfeild;
    private LoaiBieuMauFeildDTO bieumaufield;
    private String type;
    private String getfeild;

    public int getMsfieldbmfeild() {
        return msfieldbmfeild;
    }

    public void setMsfieldbmfeild(int msfieldbmfeild) {
        this.msfieldbmfeild = msfieldbmfeild;
    }

    public LoaiBieuMauFeildDTO getBieumaufield() {
        return bieumaufield;
    }

    public void setBieumaufield(LoaiBieuMauFeildDTO bieumaufield) {
        this.bieumaufield = bieumaufield;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGetfeild() {
        return getfeild;
    }

    public void setGetfeild(String getfeild) {
        this.getfeild = getfeild;
    }
}
