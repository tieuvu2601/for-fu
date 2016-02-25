package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class FormTemplateDTO implements Serializable {
    private static final long serialVersionUID = -6979615305210798421L;

    private Long msBieuMau;
    private String tenBieuMau;
    private String bieuMau;
    private Integer stt;
    private String ghiChu;
    private String maGoiThau;
    private String tenGoiThau;
    private Long msNguonVon;
    private String tenNguonVon;
    private Long msLoai;
    private String tenLoai;
    private Long msPhong;
    private String tenPhong;
    private String toChuyenGia;
    private String tenHinhThuc;
    private Long msQuiMo;
    private String tenQuiMo;
    private String tenNhaThau;
    private String tenTinhTrang;
    private Long msThanhVien;
    private String QdPheDuyetSo;
    private Long msChuTri;
    private List<GoithaunhathauDTO> goiThauNhaThaus;
    private List<GoithaunhanvienDTO> goiThauNhanViens;
    public Long getMsBieuMau() {
        return msBieuMau;
    }

    public void setMsBieuMau(Long msBieuMau) {
        this.msBieuMau = msBieuMau;
    }

    public String getTenBieuMau() {
        return tenBieuMau;
    }

    public void setTenBieuMau(String tenBieuMau) {
        this.tenBieuMau = tenBieuMau;
    }

    public String getBieuMau() {
        return bieuMau;
    }

    public void setBieuMau(String bieuMau) {
        this.bieuMau = bieuMau;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaGoiThau() {
        return maGoiThau;
    }

    public void setMaGoiThau(String maGoiThau) {
        this.maGoiThau = maGoiThau;
    }

    public String getTenGoiThau() {
        return tenGoiThau;
    }

    public void setTenGoiThau(String tenGoiThau) {
        this.tenGoiThau = tenGoiThau;
    }

    public String getTenNguonVon() {
        return tenNguonVon;
    }

    public void setTenNguonVon(String tenNguonVon) {
        this.tenNguonVon = tenNguonVon;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getToChuyenGia() {
        return toChuyenGia;
    }

    public void setToChuyenGia(String toChuyenGia) {
        this.toChuyenGia = toChuyenGia;
    }

    public String getTenHinhThuc() {
        return tenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        this.tenHinhThuc = tenHinhThuc;
    }

    public String getTenQuiMo() {
        return tenQuiMo;
    }

    public void setTenQuiMo(String tenQuiMo) {
        this.tenQuiMo = tenQuiMo;
    }

    public String getTenNhaThau() {
        return tenNhaThau;
    }

    public void setTenNhaThau(String tenNhaThau) {
        this.tenNhaThau = tenNhaThau;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public Long getMsNguonVon() {
        return msNguonVon;
    }

    public void setMsNguonVon(Long msNguonVon) {
        this.msNguonVon = msNguonVon;
    }

    public Long getMsLoai() {
        return msLoai;
    }

    public void setMsLoai(Long msLoai) {
        this.msLoai = msLoai;
    }

    public Long getMsPhong() {
        return msPhong;
    }

    public void setMsPhong(Long msPhong) {
        this.msPhong = msPhong;
    }

    public Long getMsQuiMo() {
        return msQuiMo;
    }

    public void setMsQuiMo(Long msQuiMo) {
        this.msQuiMo = msQuiMo;
    }

    public Long getMsThanhVien() {
        return msThanhVien;
    }

    public void setMsThanhVien(Long msThanhVien) {
        this.msThanhVien = msThanhVien;
    }

    public String getQdPheDuyetSo() {
        return QdPheDuyetSo;
    }

    public void setQdPheDuyetSo(String qdPheDuyetSo) {
        QdPheDuyetSo = qdPheDuyetSo;
    }

    public Long getMsChuTri() {
        return msChuTri;
    }

    public void setMsChuTri(Long msChuTri) {
        this.msChuTri = msChuTri;
    }

    public Map<String, String> dto2Map(){
        Map<String, String> map = new HashMap<>();
        return map;
    }

    public List<GoithaunhathauDTO> getGoiThauNhaThaus() {
        return goiThauNhaThaus;
    }

    public void setGoiThauNhaThaus(List<GoithaunhathauDTO> goiThauNhaThaus) {
        this.goiThauNhaThaus = goiThauNhaThaus;
    }

    public List<GoithaunhanvienDTO> getGoiThauNhanViens() {
        return goiThauNhanViens;
    }

    public void setGoiThauNhanViens(List<GoithaunhanvienDTO> goiThauNhanViens) {
        this.goiThauNhanViens = goiThauNhanViens;
    }
}
