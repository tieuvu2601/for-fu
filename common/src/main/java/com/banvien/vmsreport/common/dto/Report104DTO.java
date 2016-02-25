package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class Report104DTO implements Serializable {
    private static final long serialVersionUID = -6366252295070999881L;

    private BidDTO GoiThau;
    private HinhthucgtDTO hinhthucgt;
    private TienDoDTO tienDo;
    private UserDTO user;
    private Integer thoiGianThucHien;
    private Long msNguonVon;
    private Long msLoai;
    private Long msPhong;
    private Long msChuTri;
    private Long msThanhVien;
    private Long msQuiMo;

    public BidDTO getGoiThau() {
        return GoiThau;
    }

    public void setGoiThau(BidDTO goiThau) {
        GoiThau = goiThau;
    }

    public HinhthucgtDTO getHinhthucgt() {
        return hinhthucgt;
    }

    public void setHinhthucgt(HinhthucgtDTO hinhthucgt) {
        this.hinhthucgt = hinhthucgt;
    }

    public TienDoDTO getTienDo() {
        return tienDo;
    }

    public void setTienDo(TienDoDTO tienDo) {
        this.tienDo = tienDo;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Integer getThoiGianThucHien() {
        return thoiGianThucHien;
    }

    public void setThoiGianThucHien(Integer thoiGianThucHien) {
        this.thoiGianThucHien = thoiGianThucHien;
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

    public Long getMsChuTri() {
        return msChuTri;
    }

    public void setMsChuTri(Long msChuTri) {
        this.msChuTri = msChuTri;
    }

    public Long getMsThanhVien() {
        return msThanhVien;
    }

    public void setMsThanhVien(Long msThanhVien) {
        this.msThanhVien = msThanhVien;
    }

    public Long getMsQuiMo() {
        return msQuiMo;
    }

    public void setMsQuiMo(Long msQuiMo) {
        this.msQuiMo = msQuiMo;
    }
}
