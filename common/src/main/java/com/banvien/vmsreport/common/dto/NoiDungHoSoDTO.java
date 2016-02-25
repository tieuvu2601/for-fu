package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/17/15
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class NoiDungHoSoDTO implements Serializable {
    private Long msnoidunghs;
    private String tennoidunghs;
    private BigDecimal stt;
    private BigInteger active;
    private Integer mshinhthuc;
    private BigDecimal isgiathau;

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

    public Double getGiaDuThauSauThue() {
        return giaDuThauSauThue;
    }

    public void setGiaDuThauSauThue(Double giaDuThauSauThue) {
        this.giaDuThauSauThue = giaDuThauSauThue;
    }

    public String getTinhTrangNiemPhong() {
        return tinhTrangNiemPhong;
    }

    public void setTinhTrangNiemPhong(String tinhTrangNiemPhong) {
        this.tinhTrangNiemPhong = tinhTrangNiemPhong;
    }

    public Integer getSoLuongBanGoc() {
        return soLuongBanGoc;
    }

    public void setSoLuongBanGoc(Integer soLuongBanGoc) {
        this.soLuongBanGoc = soLuongBanGoc;
    }

    public Integer getSoLuongBanChup() {
        return soLuongBanChup;
    }

    public void setSoLuongBanChup(Integer soLuongBanChup) {
        this.soLuongBanChup = soLuongBanChup;
    }

    public String getThoiGianCoHieuLuc() {
        return thoiGianCoHieuLuc;
    }

    public void setThoiGianCoHieuLuc(String thoiGianCoHieuLuc) {
        this.thoiGianCoHieuLuc = thoiGianCoHieuLuc;
    }

    public Double getGiaDuThau() {
        return giaDuThau;
    }

    public void setGiaDuThau(Double giaDuThau) {
        this.giaDuThau = giaDuThau;
    }

    public Double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Double giamGia) {
        this.giamGia = giamGia;
    }

    public String getHinhThucGiaTriThoiHan() {
        return hinhThucGiaTriThoiHan;
    }

    public void setHinhThucGiaTriThoiHan(String hinhThucGiaTriThoiHan) {
        this.hinhThucGiaTriThoiHan = hinhThucGiaTriThoiHan;
    }

    public String getThoiGianThucHien() {
        return thoiGianThucHien;
    }

    public void setThoiGianThucHien(String thoiGianThucHien) {
        this.thoiGianThucHien = thoiGianThucHien;
    }

    public String getDieuKienThanhToan() {
        return dieuKienThanhToan;
    }

    public void setDieuKienThanhToan(String dieuKienThanhToan) {
        this.dieuKienThanhToan = dieuKienThanhToan;
    }

    public String getGiayPhepBanHang() {
        return giayPhepBanHang;
    }

    public void setGiayPhepBanHang(String giayPhepBanHang) {
        this.giayPhepBanHang = giayPhepBanHang;
    }

    public String getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public Long getMsnoidunghs() {
        return msnoidunghs;
    }

    public void setMsnoidunghs(Long msnoidunghs) {
        this.msnoidunghs = msnoidunghs;
    }

    public String getTennoidunghs() {
        return tennoidunghs;
    }

    public void setTennoidunghs(String tennoidunghs) {
        this.tennoidunghs = tennoidunghs;
    }

    public BigDecimal getStt() {
        return stt;
    }

    public void setStt(BigDecimal stt) {
        this.stt = stt;
    }

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    public Integer getMshinhthuc() {
        return mshinhthuc;
    }

    public void setMshinhthuc(Integer mshinhthuc) {
        this.mshinhthuc = mshinhthuc;
    }

    public BigDecimal getIsgiathau() {
        return isgiathau;
    }

    public void setIsgiathau(BigDecimal isgiathau) {
        this.isgiathau = isgiathau;
    }
}
