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
public class GoithaunhanvienDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long mskinhphi;
    private BidDTO goithau;
    private UserDTO user;
    private BigInteger ischutri;

    public Long getMskinhphi() {
        return mskinhphi;
    }

    public void setMskinhphi(Long mskinhphi) {
        this.mskinhphi = mskinhphi;
    }

    public BidDTO getGoithau() {
        return goithau;
    }

    public void setGoithau(BidDTO goithau) {
        this.goithau = goithau;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BigInteger getIschutri() {
        return ischutri;
    }

    public void setIschutri(BigInteger ischutri) {
        this.ischutri = ischutri;
    }
}
