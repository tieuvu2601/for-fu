package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_NOIDUNGHOSO")
@Entity
public class DmNoidunghosoEntity {
    private Long msnoidunghs;

    @javax.persistence.Column(name = "MSNOIDUNGHS")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_NOIDUNGHOSO_SEQ")
    @SequenceGenerator(name="DM_NOIDUNGHOSO_SEQ", sequenceName="DM_NOIDUNGHOSO_SEQ", allocationSize=1)
    public Long getMsnoidunghs() {
        return msnoidunghs;
    }

    public void setMsnoidunghs(Long msnoidunghs) {
        this.msnoidunghs = msnoidunghs;
    }

    private String tennoidunghs;

    @javax.persistence.Column(name = "TENNOIDUNGHS")
    @Basic
    public String getTennoidunghs() {
        return tennoidunghs;
    }

    public void setTennoidunghs(String tennoidunghs) {
        this.tennoidunghs = tennoidunghs;
    }

    private BigDecimal stt;

    @javax.persistence.Column(name = "STT")
    @Basic
    public BigDecimal getStt() {
        return stt;
    }

    public void setStt(BigDecimal stt) {
        this.stt = stt;
    }

    private BigInteger active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    private Integer mshinhthuc;

    @javax.persistence.Column(name = "MSHINHTHUC")
    @Basic
    public Integer getMshinhthuc() {
        return mshinhthuc;
    }

    public void setMshinhthuc(Integer mshinhthuc) {
        this.mshinhthuc = mshinhthuc;
    }

    private BigDecimal isgiathau;

    @javax.persistence.Column(name = "ISGIATHAU")
    @Basic
    public BigDecimal getIsgiathau() {
        return isgiathau;
    }

    public void setIsgiathau(BigDecimal isgiathau) {
        this.isgiathau = isgiathau;
    }

    private String tinhTrangNiemPhong;
    private Integer soLuongBanGoc;
    private Integer soLuongBanChup;
    private String thoiGianCoHieuLuc;
    private Double giaDuThau;
    private Double giamGia;
    private String hinhThucGiaTriThoiHan;
    private String thoiGianThucHien;
    private String dieuKienThanhToan;
    private String giayPhepBanHang;
    private String baoHanh;
    private String nhanHieu;
    private Double giaDuThauSauThue;

    @javax.persistence.Column(name = "giaduthausauthue")
    @Basic
    public Double getGiaDuThauSauThue() {
        return giaDuThauSauThue;
    }

    public void setGiaDuThauSauThue(Double giaDuThauSauThue) {
        this.giaDuThauSauThue = giaDuThauSauThue;
    }

    @javax.persistence.Column(name = "tinhtrangniemphong")
    @Basic
    public String getTinhTrangNiemPhong() {
        return tinhTrangNiemPhong;
    }

    public void setTinhTrangNiemPhong(String tinhTrangNiemPhong) {
        this.tinhTrangNiemPhong = tinhTrangNiemPhong;
    }

    @javax.persistence.Column(name = "soluongbangoc")
    @Basic
    public Integer getSoLuongBanGoc() {
        return soLuongBanGoc;
    }

    public void setSoLuongBanGoc(Integer soLuongBanGoc) {
        this.soLuongBanGoc = soLuongBanGoc;
    }

    @javax.persistence.Column(name = "soluongbanchup")
    @Basic
    public Integer getSoLuongBanChup() {
        return soLuongBanChup;
    }

    public void setSoLuongBanChup(Integer soLuongBanChup) {
        this.soLuongBanChup = soLuongBanChup;
    }

    @javax.persistence.Column(name = "thoigiancohieuluc")
    @Basic
    public String getThoiGianCoHieuLuc() {
        return thoiGianCoHieuLuc;
    }

    public void setThoiGianCoHieuLuc(String thoiGianCoHieuLuc) {
        this.thoiGianCoHieuLuc = thoiGianCoHieuLuc;
    }

    @javax.persistence.Column(name = "giaduthau")
    @Basic
    public Double getGiaDuThau() {
        return giaDuThau;
    }

    public void setGiaDuThau(Double giaDuThau) {
        this.giaDuThau = giaDuThau;
    }

    @javax.persistence.Column(name = "giamgia")
    @Basic
    public Double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Double giamGia) {
        this.giamGia = giamGia;
    }

    @javax.persistence.Column(name = "hinhthuc_giatri_thoihan")
    @Basic
    public String getHinhThucGiaTriThoiHan() {
        return hinhThucGiaTriThoiHan;
    }

    public void setHinhThucGiaTriThoiHan(String hinhThucGiaTriThoiHan) {
        this.hinhThucGiaTriThoiHan = hinhThucGiaTriThoiHan;
    }

    @javax.persistence.Column(name = "thoigianthuchien")
    @Basic
    public String getThoiGianThucHien() {
        return thoiGianThucHien;
    }

    public void setThoiGianThucHien(String thoiGianThucHien) {
        this.thoiGianThucHien = thoiGianThucHien;
    }

    @javax.persistence.Column(name = "dieukienthanhtoan")
    @Basic
    public String getDieuKienThanhToan() {
        return dieuKienThanhToan;
    }

    public void setDieuKienThanhToan(String dieuKienThanhToan) {
        this.dieuKienThanhToan = dieuKienThanhToan;
    }

    @javax.persistence.Column(name = "giayphepbanhang")
    @Basic
    public String getGiayPhepBanHang() {
        return giayPhepBanHang;
    }

    public void setGiayPhepBanHang(String giayPhepBanHang) {
        this.giayPhepBanHang = giayPhepBanHang;
    }

    @javax.persistence.Column(name = "baohanh")
    @Basic
    public String getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }

    @javax.persistence.Column(name = "nhanhieu")
    @Basic
    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmNoidunghosoEntity that = (DmNoidunghosoEntity) o;

        if (msnoidunghs != that.msnoidunghs) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (isgiathau != null ? !isgiathau.equals(that.isgiathau) : that.isgiathau != null) return false;
        if (mshinhthuc != null ? !mshinhthuc.equals(that.mshinhthuc) : that.mshinhthuc != null) return false;
        if (stt != null ? !stt.equals(that.stt) : that.stt != null) return false;
        if (tennoidunghs != null ? !tennoidunghs.equals(that.tennoidunghs) : that.tennoidunghs != null) return false;
        if (tinhTrangNiemPhong != null ? !tinhTrangNiemPhong.equals(that.tinhTrangNiemPhong) : that.tinhTrangNiemPhong != null) return false;
        if (soLuongBanGoc != null ? !soLuongBanGoc.equals(that.soLuongBanGoc) : that.soLuongBanGoc != null) return false;
        if (soLuongBanChup != null ? !soLuongBanChup.equals(that.soLuongBanChup) : that.soLuongBanChup != null) return false;
        if (thoiGianCoHieuLuc != null ? !thoiGianCoHieuLuc.equals(that.thoiGianCoHieuLuc) : that.thoiGianCoHieuLuc != null) return false;
        if (giaDuThau != null ? !giaDuThau.equals(that.giaDuThau) : that.giaDuThau != null) return false;
        if (giamGia != null ? !giamGia.equals(that.giamGia) : that.giamGia != null) return false;
        if (hinhThucGiaTriThoiHan != null ? !hinhThucGiaTriThoiHan.equals(that.hinhThucGiaTriThoiHan) : that.hinhThucGiaTriThoiHan != null) return false;
        if (thoiGianThucHien != null ? !thoiGianThucHien.equals(that.thoiGianThucHien) : that.thoiGianThucHien != null) return false;
        if (dieuKienThanhToan != null ? !dieuKienThanhToan.equals(that.dieuKienThanhToan) : that.dieuKienThanhToan != null) return false;
        if (giayPhepBanHang != null ? !giayPhepBanHang.equals(that.giayPhepBanHang) : that.giayPhepBanHang != null) return false;
        if (baoHanh != null ? !baoHanh.equals(that.baoHanh) : that.baoHanh != null) return false;
        if (nhanHieu != null ? !nhanHieu.equals(that.nhanHieu) : that.nhanHieu != null) return false;

        return true;
    }
}
