package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "TIENDO")
@Entity
public class TiendoEntity {

    public TiendoEntity(){

    }

    private Long mstiendo;

    @javax.persistence.Column(name = "MSTIENDO")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIENDO_SEQ")
    @SequenceGenerator(name="TIENDO_SEQ", sequenceName="TIENDO_SEQ", allocationSize=1)
    public Long getMstiendo() {
        return mstiendo;
    }

    public void setMstiendo(Long mstiendo) {
        this.mstiendo = mstiendo;
    }

    private GoithauEntity goithau;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "msgoithau", referencedColumnName = "msgoithau")
    public GoithauEntity getGoithau() {
        return goithau;
    }

    public void setGoithau(GoithauEntity goithau) {
        this.goithau = goithau;
    }

    private String tcgSo;

    @javax.persistence.Column(name = "TCG_SO")
    @Basic
    public String getTcgSo() {
        return tcgSo;
    }

    public void setTcgSo(String tcgSo) {
        this.tcgSo = tcgSo;
    }

    private Timestamp tcgNgay;

    @javax.persistence.Column(name = "TCG_NGAY")
    @Basic
    public Timestamp getTcgNgay() {
        return tcgNgay;
    }

    public void setTcgNgay(Timestamp tcgNgay) {
        this.tcgNgay = tcgNgay;
    }

    private String trinhhsSo;

    @javax.persistence.Column(name = "TRINHHS_SO")
    @Basic
    public String getTrinhhsSo() {
        return trinhhsSo;
    }

    public void setTrinhhsSo(String trinhhsSo) {
        this.trinhhsSo = trinhhsSo;
    }

    private Timestamp trinhhsNgay;

    @javax.persistence.Column(name = "TRINHHS_NGAY")
    @Basic
    public Timestamp getTrinhhsNgay() {
        return trinhhsNgay;
    }

    public void setTrinhhsNgay(Timestamp trinhhsNgay) {
        this.trinhhsNgay = trinhhsNgay;
    }

    private String duyethsSo;

    @javax.persistence.Column(name = "DUYETHS_SO")
    @Basic
    public String getDuyethsSo() {
        return duyethsSo;
    }

    public void setDuyethsSo(String duyethsSo) {
        this.duyethsSo = duyethsSo;
    }

    private Timestamp duyethsNgay;

    @javax.persistence.Column(name = "DUYETHS_NGAY")
    @Basic
    public Timestamp getDuyethsNgay() {
        return duyethsNgay;
    }

    public void setDuyethsNgay(Timestamp duyethsNgay) {
        this.duyethsNgay = duyethsNgay;
    }

    private String trinhdangbaoSo;

    @javax.persistence.Column(name = "TRINHDANGBAO_SO")
    @Basic
    public String getTrinhdangbaoSo() {
        return trinhdangbaoSo;
    }

    public void setTrinhdangbaoSo(String trinhdangbaoSo) {
        this.trinhdangbaoSo = trinhdangbaoSo;
    }

    private Timestamp trinhdangbaoNgay;

    @javax.persistence.Column(name = "TRINHDANGBAO_NGAY")
    @Basic
    public Timestamp getTrinhdangbaoNgay() {
        return trinhdangbaoNgay;
    }

    public void setTrinhdangbaoNgay(Timestamp trinhdangbaoNgay) {
        this.trinhdangbaoNgay = trinhdangbaoNgay;
    }

    private Timestamp ngaybanhsL1;

    @javax.persistence.Column(name = "NGAYBANHS_L1")
    @Basic
    public Timestamp getNgaybanhsL1() {
        return ngaybanhsL1;
    }

    public void setNgaybanhsL1(Timestamp ngaybanhsL1) {
        this.ngaybanhsL1 = ngaybanhsL1;
    }

    private Timestamp ngaybanhsL2;

    @javax.persistence.Column(name = "NGAYBANHS_L2")
    @Basic
    public Timestamp getNgaybanhsL2() {
        return ngaybanhsL2;
    }

    public void setNgaybanhsL2(Timestamp ngaybanhsL2) {
        this.ngaybanhsL2 = ngaybanhsL2;
    }

    private Timestamp ngaybanhsL3;

    @javax.persistence.Column(name = "NGAYBANHS_L3")
    @Basic
    public Timestamp getNgaybanhsL3() {
        return ngaybanhsL3;
    }

    public void setNgaybanhsL3(Timestamp ngaybanhsL3) {
        this.ngaybanhsL3 = ngaybanhsL3;
    }

    private Timestamp ngaymothauL1;

    @javax.persistence.Column(name = "NGAYMOTHAU_L1")
    @Basic
    public Timestamp getNgaymothauL1() {
        return ngaymothauL1;
    }

    public void setNgaymothauL1(Timestamp ngaymothauL1) {
        this.ngaymothauL1 = ngaymothauL1;
    }

    private Timestamp ngaymothauL2;

    @javax.persistence.Column(name = "NGAYMOTHAU_L2")
    @Basic
    public Timestamp getNgaymothauL2() {
        return ngaymothauL2;
    }

    public void setNgaymothauL2(Timestamp ngaymothauL2) {
        this.ngaymothauL2 = ngaymothauL2;
    }

    private Timestamp ngaymothauL3;

    @javax.persistence.Column(name = "NGAYMOTHAU_L3")
    @Basic
    public Timestamp getNgaymothauL3() {
        return ngaymothauL3;
    }

    public void setNgaymothauL3(Timestamp ngaymothauL3) {
        this.ngaymothauL3 = ngaymothauL3;
    }

    private Timestamp ngaydongthauL1;

    @javax.persistence.Column(name = "NGAYDONGTHAU_L1")
    @Basic
    public Timestamp getNgaydongthauL1() {
        return ngaydongthauL1;
    }

    public void setNgaydongthauL1(Timestamp ngaydongthauL1) {
        this.ngaydongthauL1 = ngaydongthauL1;
    }

    private Timestamp ngaydongthauL2;

    @javax.persistence.Column(name = "NGAYDONGTHAU_L2")
    @Basic
    public Timestamp getNgaydongthauL2() {
        return ngaydongthauL2;
    }

    public void setNgaydongthauL2(Timestamp ngaydongthauL2) {
        this.ngaydongthauL2 = ngaydongthauL2;
    }

    private Timestamp ngaydongthauL3;

    @javax.persistence.Column(name = "NGAYDONGTHAU_L3")
    @Basic
    public Timestamp getNgaydongthauL3() {
        return ngaydongthauL3;
    }

    public void setNgaydongthauL3(Timestamp ngaydongthauL3) {
        this.ngaydongthauL3 = ngaydongthauL3;
    }

    private String trinhkqSo;

    @javax.persistence.Column(name = "TRINHKQ_SO")
    @Basic
    public String getTrinhkqSo() {
        return trinhkqSo;
    }

    public void setTrinhkqSo(String trinhkqSo) {
        this.trinhkqSo = trinhkqSo;
    }

    private Timestamp trinhkqNgay;

    @javax.persistence.Column(name = "TRINHKQ_NGAY")
    @Basic
    public Timestamp getTrinhkqNgay() {
        return trinhkqNgay;
    }

    public void setTrinhkqNgay(Timestamp trinhkqNgay) {
        this.trinhkqNgay = trinhkqNgay;
    }

    private String pheduyetkqSo;

    @javax.persistence.Column(name = "PHEDUYETKQ_SO")
    @Basic
    public String getPheduyetkqSo() {
        return pheduyetkqSo;
    }

    public void setPheduyetkqSo(String pheduyetkqSo) {
        this.pheduyetkqSo = pheduyetkqSo;
    }

    private Timestamp pheduyetkqNgay;

    @javax.persistence.Column(name = "PHEDUYETKQ_NGAY")
    @Basic
    public Timestamp getPheduyetkqNgay() {
        return pheduyetkqNgay;
    }

    public void setPheduyetkqNgay(Timestamp pheduyetkqNgay) {
        this.pheduyetkqNgay = pheduyetkqNgay;
    }

    private String thongbaokqSo;

    @javax.persistence.Column(name = "THONGBAOKQ_SO")
    @Basic
    public String getThongbaokqSo() {
        return thongbaokqSo;
    }

    public void setThongbaokqSo(String thongbaokqSo) {
        this.thongbaokqSo = thongbaokqSo;
    }

    private Timestamp thongbaokqNgay;

    @javax.persistence.Column(name = "THONGBAOKQ_NGAY")
    @Basic
    public Timestamp getThongbaokqNgay() {
        return thongbaokqNgay;
    }

    public void setThongbaokqNgay(Timestamp thongbaokqNgay) {
        this.thongbaokqNgay = thongbaokqNgay;
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

    private String creater;

    @javax.persistence.Column(name = "CREATER")
    @Basic
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    private Timestamp creatime;

    @javax.persistence.Column(name = "CREATIME")
    @Basic
    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
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

    private Boolean ishuythau;

    @javax.persistence.Column(name = "ISHUYTHAU")
    @Basic
    public Boolean getIshuythau() {
        return ishuythau;
    }

    public void setIshuythau(Boolean ishuythau) {
        this.ishuythau = ishuythau;
    }

    private String cdtSo;

    @javax.persistence.Column(name = "CDT_SO")
    @Basic
    public String getCdtSo() {
        return cdtSo;
    }

    public void setCdtSo(String cdtSo) {
        this.cdtSo = cdtSo;
    }

    private Timestamp cdtNgay;

    @javax.persistence.Column(name = "CDT_NGAY")
    @Basic
    public Timestamp getCdtNgay() {
        return cdtNgay;
    }

    public void setCdtNgay(Timestamp cdtNgay) {
        this.cdtNgay = cdtNgay;
    }

    private String baocaodgSo;

    @javax.persistence.Column(name = "BAOCAODG_SO")
    @Basic
    public String getBaocaodgSo() {
        return baocaodgSo;
    }

    public void setBaocaodgSo(String baocaodgSo) {
        this.baocaodgSo = baocaodgSo;
    }

    private Timestamp baocaodgNgay;

    @javax.persistence.Column(name = "BAOCAODG_NGAY")
    @Basic
    public Timestamp getBaocaodgNgay() {
        return baocaodgNgay;
    }

    public void setBaocaodgNgay(Timestamp baocaodgNgay) {
        this.baocaodgNgay = baocaodgNgay;
    }

    private String trinhtcgSo;

    @javax.persistence.Column(name = "TRINHTCG_SO")
    @Basic
    public String getTrinhtcgSo() {
        return trinhtcgSo;
    }

    public void setTrinhtcgSo(String trinhtcgSo) {
        this.trinhtcgSo = trinhtcgSo;
    }

    private Timestamp trinhtcgNgay;

    @javax.persistence.Column(name = "TRINHTCG_NGAY")
    @Basic
    public Timestamp getTrinhtcgNgay() {
        return trinhtcgNgay;
    }

    public void setTrinhtcgNgay(Timestamp trinhtcgNgay) {
        this.trinhtcgNgay = trinhtcgNgay;
    }

    private String qdPheDuyetSo;
    @javax.persistence.Column(name = "QDPHEDUYET_SO")
    @Basic
    public String getQdPheDuyetSo() {
        return qdPheDuyetSo;
    }

    public void setQdPheDuyetSo(String qdPheDuyetSo) {
        this.qdPheDuyetSo = qdPheDuyetSo;
    }

    private Timestamp qdPheDuyetNgay;
    @javax.persistence.Column(name = "QDPHEDUYET_NGAY")
    @Basic
    public Timestamp getQdPheDuyetNgay() {
        return qdPheDuyetNgay;
    }

    public void setQdPheDuyetNgay(Timestamp qdPheDuyetNgay) {
        this.qdPheDuyetNgay = qdPheDuyetNgay;
    }

    private String thamDinhPASo;
    @javax.persistence.Column(name = "THAMDINHPA_SO")
    @Basic
    public String getThamDinhPASo() {
        return thamDinhPASo;
    }

    public void setThamDinhPASo(String thamDinhPASo) {
        this.thamDinhPASo = thamDinhPASo;
    }

    private Timestamp thamDinhPANgay;
    @javax.persistence.Column(name = "THAMDINHPA_NGAY")
    @Basic
    public Timestamp getThamDinhPANgay() {
        return thamDinhPANgay;
    }

    public void setThamDinhPANgay(Timestamp thamDinhPANgay) {
        this.thamDinhPANgay = thamDinhPANgay;
    }

    private String dbkqLuaChonNhaThauSo;
    private Timestamp dbkqLuaChonNhaThauNgay;

    private String baoCaoThamDinhSo;
    private Timestamp baoCaoThamDinhNgay;

    private String thuMoiThuongThaoSo;
    private Timestamp thuMoiThuongThaoNgay;

    private String bienBanThuongThaoSo;
    private Timestamp bienBanThuongThaoNgay;

    private String bcThamDinhKetQuaSo;
    private Timestamp bcThamDinhKetQuaNgay;

    private String dbKeHoachThauSo;

    @javax.persistence.Column(name = "dbkehoachthau_so")
    @Basic
    public String getDbKeHoachThauSo() {
        return dbKeHoachThauSo;
    }

    public void setDbKeHoachThauSo(String dbKeHoachThauSo) {
        this.dbKeHoachThauSo = dbKeHoachThauSo;
    }

    private Timestamp dbKeHoachThauNgay;

    @javax.persistence.Column(name = "dbkehoachthau_ngay")
    @Basic
    public Timestamp getDbKeHoachThauNgay() {
        return dbKeHoachThauNgay;
    }

    public void setDbKeHoachThauNgay(Timestamp dbKeHoachThauNgay) {
        this.dbKeHoachThauNgay = dbKeHoachThauNgay;
    }

    @javax.persistence.Column(name = "dbkqluachonnhathau_so")
    @Basic
    public String getDbkqLuaChonNhaThauSo() {
        return dbkqLuaChonNhaThauSo;
    }

    public void setDbkqLuaChonNhaThauSo(String dbkqLuaChonNhaThauSo) {
        this.dbkqLuaChonNhaThauSo = dbkqLuaChonNhaThauSo;
    }

    @javax.persistence.Column(name = "dbkqluachonnhathau_ngay")
    @Basic
    public Timestamp getDbkqLuaChonNhaThauNgay() {
        return dbkqLuaChonNhaThauNgay;
    }

    public void setDbkqLuaChonNhaThauNgay(Timestamp dbkqLuaChonNhaThauNgay) {
        this.dbkqLuaChonNhaThauNgay = dbkqLuaChonNhaThauNgay;
    }

    @javax.persistence.Column(name = "baocaothamdinh_so")
    @Basic
    public String getBaoCaoThamDinhSo() {
        return baoCaoThamDinhSo;
    }

    public void setBaoCaoThamDinhSo(String baoCaoThamDinhSo) {
        this.baoCaoThamDinhSo = baoCaoThamDinhSo;
    }

    @javax.persistence.Column(name = "baocaothamdinh_ngay")
    @Basic
    public Timestamp getBaoCaoThamDinhNgay() {
        return baoCaoThamDinhNgay;
    }

    public void setBaoCaoThamDinhNgay(Timestamp baoCaoThamDinhNgay) {
        this.baoCaoThamDinhNgay = baoCaoThamDinhNgay;
    }

    @javax.persistence.Column(name = "thumoithuongthao_so")
    @Basic
    public String getThuMoiThuongThaoSo() {
        return thuMoiThuongThaoSo;
    }

    public void setThuMoiThuongThaoSo(String thuMoiThuongThaoSo) {
        this.thuMoiThuongThaoSo = thuMoiThuongThaoSo;
    }

    @javax.persistence.Column(name = "thumoithuongthao_ngay")
    @Basic
    public Timestamp getThuMoiThuongThaoNgay() {
        return thuMoiThuongThaoNgay;
    }

    public void setThuMoiThuongThaoNgay(Timestamp thuMoiThuongThaoNgay) {
        this.thuMoiThuongThaoNgay = thuMoiThuongThaoNgay;
    }

    @javax.persistence.Column(name = "bienbanthuongthao_so")
    @Basic
    public String getBienBanThuongThaoSo() {
        return bienBanThuongThaoSo;
    }

    public void setBienBanThuongThaoSo(String bienBanThuongThaoSo) {
        this.bienBanThuongThaoSo = bienBanThuongThaoSo;
    }

    @javax.persistence.Column(name = "bienbanthuongthao_ngay")
    @Basic
    public Timestamp getBienBanThuongThaoNgay() {
        return bienBanThuongThaoNgay;
    }

    public void setBienBanThuongThaoNgay(Timestamp bienBanThuongThaoNgay) {
        this.bienBanThuongThaoNgay = bienBanThuongThaoNgay;
    }

    @javax.persistence.Column(name = "bcthamdinhketqua_so")
    @Basic
    public String getBcThamDinhKetQuaSo() {
        return bcThamDinhKetQuaSo;
    }

    public void setBcThamDinhKetQuaSo(String bcThamDinhKetQuaSo) {
        this.bcThamDinhKetQuaSo = bcThamDinhKetQuaSo;
    }

    @javax.persistence.Column(name = "bcthamdinhketqua_ngay")
    @Basic
    public Timestamp getBcThamDinhKetQuaNgay() {
        return bcThamDinhKetQuaNgay;
    }

    public void setBcThamDinhKetQuaNgay(Timestamp bcThamDinhKetQuaNgay) {
        this.bcThamDinhKetQuaNgay = bcThamDinhKetQuaNgay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TiendoEntity that = (TiendoEntity) o;

        if (mstiendo != that.mstiendo) return false;
        if (baocaodgNgay != null ? !baocaodgNgay.equals(that.baocaodgNgay) : that.baocaodgNgay != null) return false;
        if (baocaodgSo != null ? !baocaodgSo.equals(that.baocaodgSo) : that.baocaodgSo != null) return false;
        if (cdtNgay != null ? !cdtNgay.equals(that.cdtNgay) : that.cdtNgay != null) return false;
        if (cdtSo != null ? !cdtSo.equals(that.cdtSo) : that.cdtSo != null) return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null) return false;
        if (creatime != null ? !creatime.equals(that.creatime) : that.creatime != null) return false;
        if (duyethsNgay != null ? !duyethsNgay.equals(that.duyethsNgay) : that.duyethsNgay != null) return false;
        if (duyethsSo != null ? !duyethsSo.equals(that.duyethsSo) : that.duyethsSo != null) return false;
        if (editer != null ? !editer.equals(that.editer) : that.editer != null) return false;
        if (edittime != null ? !edittime.equals(that.edittime) : that.edittime != null) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (ishuythau != null ? !ishuythau.equals(that.ishuythau) : that.ishuythau != null) return false;
        if (goithau != null ? !goithau.equals(that.goithau) : that.goithau != null) return false;
        if (ngaybanhsL1 != null ? !ngaybanhsL1.equals(that.ngaybanhsL1) : that.ngaybanhsL1 != null) return false;
        if (ngaybanhsL2 != null ? !ngaybanhsL2.equals(that.ngaybanhsL2) : that.ngaybanhsL2 != null) return false;
        if (ngaybanhsL3 != null ? !ngaybanhsL3.equals(that.ngaybanhsL3) : that.ngaybanhsL3 != null) return false;
        if (ngaydongthauL1 != null ? !ngaydongthauL1.equals(that.ngaydongthauL1) : that.ngaydongthauL1 != null)
            return false;
        if (ngaydongthauL2 != null ? !ngaydongthauL2.equals(that.ngaydongthauL2) : that.ngaydongthauL2 != null)
            return false;
        if (ngaydongthauL3 != null ? !ngaydongthauL3.equals(that.ngaydongthauL3) : that.ngaydongthauL3 != null)
            return false;
        if (ngaymothauL1 != null ? !ngaymothauL1.equals(that.ngaymothauL1) : that.ngaymothauL1 != null) return false;
        if (ngaymothauL2 != null ? !ngaymothauL2.equals(that.ngaymothauL2) : that.ngaymothauL2 != null) return false;
        if (ngaymothauL3 != null ? !ngaymothauL3.equals(that.ngaymothauL3) : that.ngaymothauL3 != null) return false;
        if (pheduyetkqNgay != null ? !pheduyetkqNgay.equals(that.pheduyetkqNgay) : that.pheduyetkqNgay != null)
            return false;
        if (pheduyetkqSo != null ? !pheduyetkqSo.equals(that.pheduyetkqSo) : that.pheduyetkqSo != null) return false;
        if (tcgNgay != null ? !tcgNgay.equals(that.tcgNgay) : that.tcgNgay != null) return false;
        if (tcgSo != null ? !tcgSo.equals(that.tcgSo) : that.tcgSo != null) return false;
        if (thongbaokqNgay != null ? !thongbaokqNgay.equals(that.thongbaokqNgay) : that.thongbaokqNgay != null)
            return false;
        if (thongbaokqSo != null ? !thongbaokqSo.equals(that.thongbaokqSo) : that.thongbaokqSo != null) return false;
        if (trinhdangbaoNgay != null ? !trinhdangbaoNgay.equals(that.trinhdangbaoNgay) : that.trinhdangbaoNgay != null)
            return false;
        if (trinhdangbaoSo != null ? !trinhdangbaoSo.equals(that.trinhdangbaoSo) : that.trinhdangbaoSo != null)
            return false;
        if (trinhhsNgay != null ? !trinhhsNgay.equals(that.trinhhsNgay) : that.trinhhsNgay != null) return false;
        if (trinhhsSo != null ? !trinhhsSo.equals(that.trinhhsSo) : that.trinhhsSo != null) return false;
        if (trinhkqNgay != null ? !trinhkqNgay.equals(that.trinhkqNgay) : that.trinhkqNgay != null) return false;
        if (trinhkqSo != null ? !trinhkqSo.equals(that.trinhkqSo) : that.trinhkqSo != null) return false;
        if (trinhtcgNgay != null ? !trinhtcgNgay.equals(that.trinhtcgNgay) : that.trinhtcgNgay != null) return false;
        if (trinhtcgSo != null ? !trinhtcgSo.equals(that.trinhtcgSo) : that.trinhtcgSo != null) return false;

        return true;
    }
}
