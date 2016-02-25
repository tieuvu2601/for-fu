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
public class KinhphiDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long mskinhphi;
    private BidDTO goithau;
    private LoaibaoDTO loaibao;
    private NoidungDTO noidung;
    private BigDecimal soky;
    private BigDecimal chiphi;
    private BigDecimal thanhtien;
    private String khobao;

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

    public LoaibaoDTO getLoaibao() {
        return loaibao;
    }

    public void setLoaibao(LoaibaoDTO loaibao) {
        this.loaibao = loaibao;
    }

    public NoidungDTO getNoidung() {
        return noidung;
    }

    public void setNoidung(NoidungDTO noidung) {
        this.noidung = noidung;
    }

    public BigDecimal getSoky() {
        return soky;
    }

    public void setSoky(BigDecimal soky) {
        this.soky = soky;
    }

    public BigDecimal getChiphi() {
        return chiphi;
    }

    public void setChiphi(BigDecimal chiphi) {
        this.chiphi = chiphi;
    }

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getKhobao() {
        return khobao;
    }

    public void setKhobao(String khobao) {
        this.khobao = khobao;
    }
}
