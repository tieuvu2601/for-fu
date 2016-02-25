package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class Report106DTO implements Serializable {
    private static final long serialVersionUID = 8355553556762816432L;

    private NguonvonDTO nguonvon;
    private DepartmentDTO department;
    private UserDTO user;
    private HinhthucgtDTO hinhthucgt;
    private TinhtrangDTO tinhtrang;
    private QuyMoDTO quimo;
    private BidDTO bid;
    private TienDoDTO tienDo;
    private NoiDungHoSoDTO noiDungHoSo;
    private NhaThauDTO nhaThau;
    private Integer slNhaThauMuaHS;
    private Integer slNhaThauNopHS;
    private String ghiChu;
    private String thanhVien;
    private List<Timestamp> ngayDangBao;
    private String danhSachNhaThauMuaHS;
    private String danhSachNhaThauNopHS;

    public NguonvonDTO getNguonvon() {
        return nguonvon;
    }

    public void setNguonvon(NguonvonDTO nguonvon) {
        this.nguonvon = nguonvon;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public HinhthucgtDTO getHinhthucgt() {
        return hinhthucgt;
    }

    public void setHinhthucgt(HinhthucgtDTO hinhthucgt) {
        this.hinhthucgt = hinhthucgt;
    }

    public TinhtrangDTO getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(TinhtrangDTO tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public QuyMoDTO getQuimo() {
        return quimo;
    }

    public void setQuimo(QuyMoDTO quimo) {
        this.quimo = quimo;
    }

    public BidDTO getBid() {
        return bid;
    }

    public void setBid(BidDTO bid) {
        this.bid = bid;
    }

    public TienDoDTO getTienDo() {
        return tienDo;
    }

    public void setTienDo(TienDoDTO tienDo) {
        this.tienDo = tienDo;
    }

    public NoiDungHoSoDTO getNoiDungHoSo() {
        return noiDungHoSo;
    }

    public void setNoiDungHoSo(NoiDungHoSoDTO noiDungHoSo) {
        this.noiDungHoSo = noiDungHoSo;
    }

    public NhaThauDTO getNhaThau() {
        return nhaThau;
    }

    public void setNhaThau(NhaThauDTO nhaThau) {
        this.nhaThau = nhaThau;
    }

    public Integer getSlNhaThauMuaHS() {
        return slNhaThauMuaHS;
    }

    public void setSlNhaThauMuaHS(Integer slNhaThauMuaHS) {
        this.slNhaThauMuaHS = slNhaThauMuaHS;
    }

    public Integer getSlNhaThauNopHS() {
        return slNhaThauNopHS;
    }

    public void setSlNhaThauNopHS(Integer slNhaThauNopHS) {
        this.slNhaThauNopHS = slNhaThauNopHS;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(String thanhVien) {
        this.thanhVien = thanhVien;
    }

    public String getDanhSachNhaThauMuaHS() {
        return danhSachNhaThauMuaHS;
    }

    public void setDanhSachNhaThauMuaHS(String danhSachNhaThauMuaHS) {
        this.danhSachNhaThauMuaHS = danhSachNhaThauMuaHS;
    }

    public String getDanhSachNhaThauNopHS() {
        return danhSachNhaThauNopHS;
    }

    public void setDanhSachNhaThauNopHS(String danhSachNhaThauNopHS) {
        this.danhSachNhaThauNopHS = danhSachNhaThauNopHS;
    }

    public List<Timestamp> getNgayDangBao() {
        return ngayDangBao;
    }

    public void setNgayDangBao(List<Timestamp> ngayDangBao) {
        this.ngayDangBao = ngayDangBao;
    }
}
