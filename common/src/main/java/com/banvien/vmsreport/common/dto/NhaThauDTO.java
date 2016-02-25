package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class NhaThauDTO implements Serializable {

    private Long msnhathau;
    private String tennhathau;
    private String diachi;
    private String dienthoai;
    private String fax;
    private String ghichu;
    private BigDecimal active;
    private String masothue;
    private NhaThauDTO old;
    private String giayPhepKinhDoanh;

    public Long getMsnhathau() {
        return msnhathau;
    }

    public void setMsnhathau(Long msnhathau) {
        this.msnhathau = msnhathau;
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

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public BigDecimal getActive() {
        return active;
    }

    public void setActive(BigDecimal active) {
        this.active = active;
    }

    public String getMasothue() {
        return masothue;
    }

    public void setMasothue(String masothue) {
        this.masothue = masothue;
    }

    public NhaThauDTO getOld() {
        return old;
    }

    public void setOld(NhaThauDTO old) {
        this.old = old;
    }

    public String getGiayPhepKinhDoanh() {
        return giayPhepKinhDoanh;
    }

    public void setGiayPhepKinhDoanh(String giayPhepKinhDoanh) {
        this.giayPhepKinhDoanh = giayPhepKinhDoanh;
    }
}
