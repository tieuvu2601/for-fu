package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class DangBaoDTO implements Serializable {
    public DangBaoDTO(){

    }
    private Long msdangbao;
    private BidDTO goithau;
    private NoidungDTO noidung;
    private Timestamp ngaydangbao;
    private String ghichu;
    private BigDecimal sobaobatdau;
    private BigDecimal sokydangbao;
    private String socongvan;
    private Timestamp ngaycongvan;
    private LoaibaoDTO loaibao;

    public Long getMsdangbao() {
        return msdangbao;
    }

    public void setMsdangbao(Long msdangbao) {
        this.msdangbao = msdangbao;
    }

    public BidDTO getGoithau() {
        return goithau;
    }

    public void setGoithau(BidDTO goithau) {
        this.goithau = goithau;
    }

    public NoidungDTO getNoidung() {
        return noidung;
    }

    public void setNoidung(NoidungDTO noidung) {
        this.noidung = noidung;
    }

    public Timestamp getNgaydangbao() {
        return ngaydangbao;
    }

    public void setNgaydangbao(Timestamp ngaydangbao) {
        this.ngaydangbao = ngaydangbao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public BigDecimal getSobaobatdau() {
        return sobaobatdau;
    }

    public void setSobaobatdau(BigDecimal sobaobatdau) {
        this.sobaobatdau = sobaobatdau;
    }

    public BigDecimal getSokydangbao() {
        return sokydangbao;
    }

    public void setSokydangbao(BigDecimal sokydangbao) {
        this.sokydangbao = sokydangbao;
    }

    public String getSocongvan() {
        return socongvan;
    }

    public void setSocongvan(String socongvan) {
        this.socongvan = socongvan;
    }

    public Timestamp getNgaycongvan() {
        return ngaycongvan;
    }

    public void setNgaycongvan(Timestamp ngaycongvan) {
        this.ngaycongvan = ngaycongvan;
    }

    public LoaibaoDTO getLoaibao() {
        return loaibao;
    }

    public void setLoaibao(LoaibaoDTO loaibao) {
        this.loaibao = loaibao;
    }
}
