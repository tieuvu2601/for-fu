package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class HosolutruuDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msluutru;
    private BidDTO goithau;
    private BigDecimal sotu;
    private BigDecimal soke;
    private String ghichu;
    private String creater;
    private Timestamp createtime;
    private String editer;
    private Timestamp edittime;

    public Long getMsluutru() {
        return msluutru;
    }

    public void setMsluutru(Long msluutru) {
        this.msluutru = msluutru;
    }

    public BidDTO getGoithau() {
        return goithau;
    }

    public void setGoithau(BidDTO goithau) {
        this.goithau = goithau;
    }

    public BigDecimal getSotu() {
        return sotu;
    }

    public void setSotu(BigDecimal sotu) {
        this.sotu = sotu;
    }

    public BigDecimal getSoke() {
        return soke;
    }

    public void setSoke(BigDecimal soke) {
        this.soke = soke;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getEditer() {
        return editer;
    }

    public void setEditer(String editer) {
        this.editer = editer;
    }

    public Timestamp getEdittime() {
        return edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }
}
