package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoithaunhathauDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msgoithauNt;
    private BidDTO goithau;
    private String tennhathau;
    private String diachi;
    private String dienthoai;
    private String fax;
    private Timestamp ngaymuahs;
    private Timestamp ngaynophs;
    private BigDecimal giathau;
    private BigInteger istrungthau;
    private NhaThauDTO nhathau;

    private String strngaymuahs;
    private String strngaynophs;


    public String getStrngaymuahs() {
        return strngaymuahs;
    }

    public void setStrngaymuahs(String strngaymuahs) {
        this.strngaymuahs = strngaymuahs;
    }

    public String getStrngaynophs() {
        return strngaynophs;
    }

    public void setStrngaynophs(String strngaynophs) {
        this.strngaynophs = strngaynophs;
    }

    public Long getMsgoithauNt() {
        return msgoithauNt;
    }

    public void setMsgoithauNt(Long msgoithauNt) {
        this.msgoithauNt = msgoithauNt;
    }

    public BidDTO getGoithau() {
        return goithau;
    }

    public void setGoithau(BidDTO goithau) {
        this.goithau = goithau;
    }

    public String getTennhathau() {
        return tennhathau;
    }

    public void setTennhathau(String tennhathau) {
        this.tennhathau = tennhathau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Timestamp getNgaymuahs() {
        return ngaymuahs;
    }

    public void setNgaymuahs(Timestamp ngaymuahs) {
        this.ngaymuahs = ngaymuahs;
    }

    public Timestamp getNgaynophs() {
        return ngaynophs;
    }

    public void setNgaynophs(Timestamp ngaynophs) {
        this.ngaynophs = ngaynophs;
    }

    public BigDecimal getGiathau() {
        return giathau;
    }

    public void setGiathau(BigDecimal giathau) {
        this.giathau = giathau;
    }

    public BigInteger getIstrungthau() {
        return istrungthau;
    }

    public void setIstrungthau(BigInteger istrungthau) {
        this.istrungthau = istrungthau;
    }

    public NhaThauDTO getNhathau() {
        return nhathau;
    }

    public void setNhathau(NhaThauDTO nhathau) {
        this.nhathau = nhathau;
    }
}
