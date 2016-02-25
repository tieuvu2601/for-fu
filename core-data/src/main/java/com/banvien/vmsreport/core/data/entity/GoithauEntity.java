package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "GOITHAU")
@Entity
public class GoithauEntity {
    private Long msgoithau;

    @javax.persistence.Column(name = "MSGOITHAU")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOITHAU_SEQ")
    @SequenceGenerator(name="GOITHAU_SEQ", sequenceName="GOITHAU_SEQ", allocationSize=1)
    public Long getMsgoithau() {
        return msgoithau;
    }

    public void setMsgoithau(Long msgoithau) {
        this.msgoithau = msgoithau;
    }

    private String magoithau;

    @javax.persistence.Column(name = "MAGOITHAU")
    @Basic
    public String getMagoithau() {
        return magoithau;
    }

    public void setMagoithau(String magoithau) {
        this.magoithau = magoithau;
    }


    private String tengoithau;

    @javax.persistence.Column(name = "TENGOITHAU")
    @Basic
    public String getTengoithau() {
        return tengoithau;
    }

    public void setTengoithau(String tengoithau) {
        this.tengoithau = tengoithau;
    }

    private String noidung;

    @javax.persistence.Column(name = "NOIDUNG")
    @Basic
    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    private BigDecimal giatrigoithautruocthue;

    @javax.persistence.Column(name = "GIATRIGOITHAUTRUOCTHUE")
    @Basic
    public BigDecimal getGiatrigoithautruocthue() {
        return giatrigoithautruocthue;
    }

    public void setGiatrigoithautruocthue(BigDecimal giatrigoithautruocthue) {
        this.giatrigoithautruocthue = giatrigoithautruocthue;
    }


    private BigDecimal giatrigoithau;

    @javax.persistence.Column(name = "GIATRIGOITHAU")
    @Basic
    public BigDecimal getGiatrigoithau() {
        return giatrigoithau;
    }

    public void setGiatrigoithau(BigDecimal giatrigoithau) {
        this.giatrigoithau = giatrigoithau;
    }

    private BigDecimal sonamhd;

    @javax.persistence.Column(name = "SONAMHD")
    @Basic
    public BigDecimal getSonamhd() {
        return sonamhd;
    }

    public void setSonamhd(BigDecimal sonamhd) {
        this.sonamhd = sonamhd;
    }

    private BigDecimal sothanghd;
    @javax.persistence.Column(name = "SOTHANGHD")
    @Basic
    public BigDecimal getSothanghd() {
        return sothanghd;
    }

    public void setSothanghd(BigDecimal sothanghd) {
        this.sothanghd = sothanghd;
    }


    private BigDecimal songayhd;

    @javax.persistence.Column(name = "SONGAYHD")
    @Basic
    public BigDecimal getSongayhd() {
        return songayhd;
    }

    public void setSongayhd(BigDecimal songayhd) {
        this.songayhd = songayhd;
    }

    private DmQuyMoEntity quimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSQUIMO", referencedColumnName = "MSQUIMO")
    public DmQuyMoEntity getQuimo() {
        return quimo;
    }

    public void setQuimo(DmQuyMoEntity quimo) {
        this.quimo = quimo;
    }


    private DmNguonvonEntity nguonvon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSNGUONVON", referencedColumnName = "MSNGUONVON")
    public DmNguonvonEntity getNguonvon() {
        return nguonvon;
    }

    public void setNguonvon(DmNguonvonEntity nguonvon) {
        this.nguonvon = nguonvon;
    }


    private String tenpada;

    @javax.persistence.Column(name = "TENPADA")
    @Basic
    public String getTenpada() {
        return tenpada;
    }

    public void setTenpada(String tenpada) {
        this.tenpada = tenpada;
    }



    private DepartmentEntity department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENTID", referencedColumnName = "DEPARTMENTID")
    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    private DmLanhdaoEntity lanhdao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSLANHDAO", referencedColumnName = "MSLANHDAO")
    public DmLanhdaoEntity getLanhdao() {
        return lanhdao;
    }

    public void setLanhdao(DmLanhdaoEntity lanhdao) {
        this.lanhdao = lanhdao;
    }

    private DmLoaiEntity loai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSLOAI", referencedColumnName = "MSLOAI")
    public DmLoaiEntity getLoai() {
        return loai;
    }

    public void setLoai(DmLoaiEntity loai) {
        this.loai = loai;
    }

    private DmHinhthucgtEntity hinhthucgt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSHINHTHUC", referencedColumnName = "MSHINHTHUC")
    public DmHinhthucgtEntity getHinhthucgt() {
        return hinhthucgt;
    }

    public void setHinhthucgt(DmHinhthucgtEntity hinhthucgt) {
        this.hinhthucgt = hinhthucgt;
    }

    private DmTinhchatgtEntity tinhchat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSTINHCHAT", referencedColumnName = "MSTINHCHAT")
    public DmTinhchatgtEntity getTinhchat() {
        return tinhchat;
    }

    public void setTinhchat(DmTinhchatgtEntity tinhchat) {
        this.tinhchat = tinhchat;
    }


    private DmTinhtrangEntity tinhtrang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MSTINHTRANG", referencedColumnName = "MSTINHTRANG")
    public DmTinhtrangEntity getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(DmTinhtrangEntity tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    private String soqd;

    @javax.persistence.Column(name = "SOQD")
    @Basic
    public String getSoqd() {
        return soqd;
    }

    public void setSoqd(String soqd) {
        this.soqd = soqd;
    }

    private Timestamp ngayqd;

    @javax.persistence.Column(name = "NGAYQD")
    @Basic
    public Timestamp getNgayqd() {
        return ngayqd;
    }

    public void setNgayqd(Timestamp ngayqd) {
        this.ngayqd = ngayqd;
    }


    private String creater;

    @javax.persistence.Column(name = "CREATER")
    @Basic
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    private Timestamp createtime;

    @javax.persistence.Column(name = "CREATETIME")
    @Basic
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    private String editer;
    @javax.persistence.Column(name = "EDITER")
    @Basic
    public String getEditer() {
        return editer;
    }

    public void setEditer(String editer) {
        this.editer = editer;
    }


    private Timestamp edittime;

    @javax.persistence.Column(name = "EDITTIME")
    @Basic
    public Timestamp getEdittime() {
        return edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }

    private BigDecimal giabanhsmt;

    @javax.persistence.Column(name = "GIABANHSMT")
    @Basic
    public BigDecimal getGiabanhsmt() {
        return giabanhsmt;
    }

    public void setGiabanhsmt(BigDecimal giabanhsmt) {
        this.giabanhsmt = giabanhsmt;
    }

    private BigDecimal baodamduthau;

    @javax.persistence.Column(name = "BAODAMDUTHAU")
    @Basic
    public BigDecimal getBaodamduthau() {
        return baodamduthau;
    }

    public void setBaodamduthau(BigDecimal baodamduthau) {
        this.baodamduthau = baodamduthau;
    }

    private String ghichu;
    @javax.persistence.Column(name = "GHICHU")
    @Basic
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }


    private BigDecimal landauthau;

    @javax.persistence.Column(name = "LANDAUTHAU")
    @Basic
    public BigDecimal getLandauthau() {
        return landauthau;
    }

    public void setLandauthau(BigDecimal landauthau) {
        this.landauthau = landauthau;
    }

    private GoithauEntity msgoithauref;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSGOITHAUREF", referencedColumnName = "msgoithau")
    public GoithauEntity getMsgoithauref() {
        return msgoithauref;
    }

    public void setMsgoithauref(GoithauEntity msgoithauref) {
        this.msgoithauref = msgoithauref;
    }

    private String socvTrinhpd;

    @javax.persistence.Column(name = "SOCV_TRINHPD")
    @Basic
    public String getSocvTrinhpd() {
        return socvTrinhpd;
    }

    public void setSocvTrinhpd(String socvTrinhpd) {
        this.socvTrinhpd = socvTrinhpd;
    }

    private Timestamp ngaycvTrinhpd;

    @javax.persistence.Column(name = "NGAYCV_TRINHPD")
    @Basic
    public Timestamp getNgaycvTrinhpd() {
        return ngaycvTrinhpd;
    }

    public void setNgaycvTrinhpd(Timestamp ngaycvTrinhpd) {
        this.ngaycvTrinhpd = ngaycvTrinhpd;
    }

    private List<GoithauNhanvienEntity> toChuyenGias;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="MSGOITHAU", insertable = false, updatable = false)
    public List<GoithauNhanvienEntity> getToChuyenGias() {
        return toChuyenGias;
    }

    public void setToChuyenGias(List<GoithauNhanvienEntity> toChuyenGias) {
        this.toChuyenGias = toChuyenGias;
    }

    private List<GoithauNhathauEntity> goiThauNhaThaus;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="MSGOITHAU", insertable = false, updatable = false)
    public List<GoithauNhathauEntity> getGoiThauNhaThaus() {
        return goiThauNhaThaus;
    }

    public void setGoiThauNhaThaus(List<GoithauNhathauEntity> goiThauNhaThaus) {
        this.goiThauNhaThaus = goiThauNhaThaus;
    }

    private List<HosoluutruEntity> hoSoLuuTrus;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="MSGOITHAU", insertable = false, updatable = false)
    public List<HosoluutruEntity> getHoSoLuuTrus() {
        return hoSoLuuTrus;
    }

    public void setHoSoLuuTrus(List<HosoluutruEntity> hoSoLuuTrus) {
        this.hoSoLuuTrus = hoSoLuuTrus;
    }

    private List<DangbaoEntity> ngayDangBao;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="MSGOITHAU", insertable = false, updatable = false)
    public List<DangbaoEntity> getNgayDangBao() {
        return ngayDangBao;
    }

    public void setNgayDangBao(List<DangbaoEntity> ngayDangBao) {
        this.ngayDangBao = ngayDangBao;
    }

    private List<KinhphiEntity> kinhphi;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="MSGOITHAU", insertable = false, updatable = false)
    public List<KinhphiEntity> getKinhphi() {
        return kinhphi;
    }

    public void setKinhphi(List<KinhphiEntity> kinhphi) {
        this.kinhphi = kinhphi;
    }

    private UserEntity msnhanvienCvtd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSNHANVIEN_CVTD", referencedColumnName = "USERID")
    public UserEntity getMsnhanvienCvtd() {
        return msnhanvienCvtd;
    }

    public void setMsnhanvienCvtd(UserEntity msnhanvienCvtd) {
        this.msnhanvienCvtd = msnhanvienCvtd;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoithauEntity that = (GoithauEntity) o;

        if (msgoithau != that.msgoithau) return false;
        if (baodamduthau != null ? !baodamduthau.equals(that.baodamduthau) : that.baodamduthau != null) return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null) return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;
        if (editer != null ? !editer.equals(that.editer) : that.editer != null) return false;
        if (edittime != null ? !edittime.equals(that.edittime) : that.edittime != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (giabanhsmt != null ? !giabanhsmt.equals(that.giabanhsmt) : that.giabanhsmt != null) return false;
        if (giatrigoithau != null ? !giatrigoithau.equals(that.giatrigoithau) : that.giatrigoithau != null)
            return false;
        if (landauthau != null ? !landauthau.equals(that.landauthau) : that.landauthau != null) return false;
        if (magoithau != null ? !magoithau.equals(that.magoithau) : that.magoithau != null) return false;
        if (msgoithauref != null ? !msgoithauref.equals(that.msgoithauref) : that.msgoithauref != null) return false;
        if (ngaycvTrinhpd != null ? !ngaycvTrinhpd.equals(that.ngaycvTrinhpd) : that.ngaycvTrinhpd != null)
            return false;
        if (ngayqd != null ? !ngayqd.equals(that.ngayqd) : that.ngayqd != null) return false;
        if (noidung != null ? !noidung.equals(that.noidung) : that.noidung != null) return false;
        if (socvTrinhpd != null ? !socvTrinhpd.equals(that.socvTrinhpd) : that.socvTrinhpd != null) return false;
        if (sonamhd != null ? !sonamhd.equals(that.sonamhd) : that.sonamhd != null) return false;
        if (songayhd != null ? !songayhd.equals(that.songayhd) : that.songayhd != null) return false;
        if (soqd != null ? !soqd.equals(that.soqd) : that.soqd != null) return false;
        if (sothanghd != null ? !sothanghd.equals(that.sothanghd) : that.sothanghd != null) return false;
        if (tengoithau != null ? !tengoithau.equals(that.tengoithau) : that.tengoithau != null) return false;
        if (tenpada != null ? !tenpada.equals(that.tenpada) : that.tenpada != null) return false;

        return true;
    }

}
