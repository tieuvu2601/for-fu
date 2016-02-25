package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BidDTO implements Serializable{
    private static final long serialVersionUID = 2680974559686096185L;
    private Long msgoithau;
    private String magoithau;
    private String tengoithau;
    private String noidung;
    private BigDecimal giatrigoithautruocthue;
    private BigDecimal giatrigoithau;
    private BigDecimal sonamhd;
    private BigDecimal sothanghd;
    private BigDecimal songayhd;
    private QuyMoDTO quimo;           //
    private NguonvonDTO nguonvon;       //
    private LoaiDTO loai;                //
    private String tenpada;
    private DepartmentDTO department;    //
    private LanhdaoDTO lanhdao;          //
    private HinhthucgtDTO hinhthucgt;     //
    private TinhchatDTO tinhchat;         //
    private TinhtrangDTO tinhtrang;       //
    private String soqd;
    private Timestamp ngayqd;
    private String creater;
    private Timestamp createtime;
    private String editer;
    private Timestamp edittime;
    private BigDecimal giabanhsmt;
    private BigDecimal baodamduthau;
    private String ghichu;
    private BigDecimal landauthau;
    private String socvTrinhpd;
    private Timestamp ngaycvTrinhpd;       //
    private BidDTO msgoithauref;           //
    private UserDTO msnhanvienCvtd;
    private List<GoithaunhanvienDTO> toChuyenGias;    //
    private List<GoithaunhathauDTO> goiThauNhaThaus;  //
    private List<HosolutruuDTO> hoSoLuuTrus;          //
    public Long getMsgoithau() {
        return msgoithau;
    }

    public void setMsgoithau(Long msgoithau) {
        this.msgoithau = msgoithau;
    }

    public String getMagoithau() {
        return magoithau;
    }

    public void setMagoithau(String magoithau) {
        this.magoithau = magoithau;
    }

    public String getTengoithau() {
        return tengoithau;
    }

    public void setTengoithau(String tengoithau) {
        this.tengoithau = tengoithau;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public BigDecimal getGiatrigoithau() {
        return giatrigoithau;
    }

    public void setGiatrigoithau(BigDecimal giatrigoithau) {
        this.giatrigoithau = giatrigoithau;
    }

    public BigDecimal getSonamhd() {
        return sonamhd;
    }

    public void setSonamhd(BigDecimal sonamhd) {
        this.sonamhd = sonamhd;
    }

    public BigDecimal getSothanghd() {
        return sothanghd;
    }

    public void setSothanghd(BigDecimal sothanghd) {
        this.sothanghd = sothanghd;
    }

    public BigDecimal getSongayhd() {
        return songayhd;
    }

    public void setSongayhd(BigDecimal songayhd) {
        this.songayhd = songayhd;
    }

    public QuyMoDTO getQuimo() {
        return quimo;
    }

    public void setQuimo(QuyMoDTO quimo) {
        this.quimo = quimo;
    }

    public NguonvonDTO getNguonvon() {
        return nguonvon;
    }

    public void setNguonvon(NguonvonDTO nguonvon) {
        this.nguonvon = nguonvon;
    }

    public String getTenpada() {
        return tenpada;
    }

    public void setTenpada(String tenpada) {
        this.tenpada = tenpada;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public LanhdaoDTO getLanhdao() {
        return lanhdao;
    }

    public void setLanhdao(LanhdaoDTO lanhdao) {
        this.lanhdao = lanhdao;
    }

    public HinhthucgtDTO getHinhthucgt() {
        return hinhthucgt;
    }

    public void setHinhthucgt(HinhthucgtDTO hinhthucgt) {
        this.hinhthucgt = hinhthucgt;
    }

    public TinhchatDTO getTinhchat() {
        return tinhchat;
    }

    public void setTinhchat(TinhchatDTO tinhchat) {
        this.tinhchat = tinhchat;
    }

    public TinhtrangDTO getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(TinhtrangDTO tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getSoqd() {
        return soqd;
    }

    public void setSoqd(String soqd) {
        this.soqd = soqd;
    }

    public Timestamp getNgayqd() {
        return ngayqd;
    }

    public void setNgayqd(Timestamp ngayqd) {
        this.ngayqd = ngayqd;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getEditer() {
        return editer;
    }

    public void setEditer(String editer) {
        this.editer = editer;
    }

    public Timestamp getEdittime() {
        return edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }

    public BigDecimal getGiabanhsmt() {
        return giabanhsmt;
    }

    public void setGiabanhsmt(BigDecimal giabanhsmt) {
        this.giabanhsmt = giabanhsmt;
    }

    public BigDecimal getBaodamduthau() {
        return baodamduthau;
    }

    public void setBaodamduthau(BigDecimal baodamduthau) {
        this.baodamduthau = baodamduthau;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public BigDecimal getLandauthau() {
        return landauthau;
    }

    public void setLandauthau(BigDecimal landauthau) {
        this.landauthau = landauthau;
    }

    public BidDTO getMsgoithauref() {
        return msgoithauref;
    }

    public void setMsgoithauref(BidDTO msgoithauref) {
        this.msgoithauref = msgoithauref;
    }

    public String getSocvTrinhpd() {
        return socvTrinhpd;
    }

    public void setSocvTrinhpd(String socvTrinhpd) {
        this.socvTrinhpd = socvTrinhpd;
    }

    public Timestamp getNgaycvTrinhpd() {
        return ngaycvTrinhpd;
    }

    public void setNgaycvTrinhpd(Timestamp ngaycvTrinhpd) {
        this.ngaycvTrinhpd = ngaycvTrinhpd;
    }

    public LoaiDTO getLoai() {
        return loai;
    }

    public void setLoai(LoaiDTO loai) {
        this.loai = loai;
    }

    public List<GoithaunhanvienDTO> getToChuyenGias() {
        return toChuyenGias;
    }

    public void setToChuyenGias(List<GoithaunhanvienDTO> toChuyenGias) {
        this.toChuyenGias = toChuyenGias;
    }

    public List<GoithaunhathauDTO> getGoiThauNhaThaus() {
        return goiThauNhaThaus;
    }

    public void setGoiThauNhaThaus(List<GoithaunhathauDTO> goiThauNhaThaus) {
        this.goiThauNhaThaus = goiThauNhaThaus;
    }

    public List<HosolutruuDTO> getHoSoLuuTrus() {
        return hoSoLuuTrus;
    }

    public void setHoSoLuuTrus(List<HosolutruuDTO> hoSoLuuTrus) {
        this.hoSoLuuTrus = hoSoLuuTrus;
    }

    public UserDTO getMsnhanvienCvtd() {
        return msnhanvienCvtd;
    }

    public void setMsnhanvienCvtd(UserDTO msnhanvienCvtd) {
        this.msnhanvienCvtd = msnhanvienCvtd;
    }

    public BigDecimal getGiatrigoithautruocthue() {
        return giatrigoithautruocthue;
    }

    public void setGiatrigoithautruocthue(BigDecimal giatrigoithautruocthue) {
        this.giatrigoithautruocthue = giatrigoithautruocthue;
    }
}
