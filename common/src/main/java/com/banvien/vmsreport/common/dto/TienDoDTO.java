package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TienDoDTO  implements Serializable{

    public TienDoDTO(){

    }

    private Long mstiendo; //
    private BidDTO goithau;     //
    private String tcgSo;     //
    private Timestamp tcgNgay;   //
    private String trinhhsSo;       //
    private Timestamp trinhhsNgay;    //
    private String duyethsSo;          //
    private Timestamp duyethsNgay;      //
    private String trinhdangbaoSo;       //
    private Timestamp trinhdangbaoNgay;    //
    private Timestamp ngaybanhsL1; //
    private Timestamp ngaybanhsL2;  //
    private Timestamp ngaybanhsL3;   //
    private Timestamp ngaymothauL1;  //
    private Timestamp ngaymothauL2;  //
    private Timestamp ngaymothauL3;  //
    private Timestamp ngaydongthauL1;
    private Timestamp ngaydongthauL2;
    private Timestamp ngaydongthauL3;
    private String trinhkqSo;    //
    private Timestamp trinhkqNgay; //
    private String pheduyetkqSo;    //
    private Timestamp pheduyetkqNgay;   //
    private String thongbaokqSo;          //
    private Timestamp thongbaokqNgay;       //
    private String ghichu;             //
    private String creater;
    private Timestamp creatime;
    private String editer;
    private Timestamp edittime;
    private Boolean ishuythau; //
    private String cdtSo;  //
    private Timestamp cdtNgay;     //
    private String baocaodgSo;      //
    private Timestamp baocaodgNgay;  //
    private String trinhtcgSo;        //
    private Timestamp trinhtcgNgay;     //

    private String qdPheDuyetSo;     //
    private Timestamp qdPheDuyetNgay;     //
    private String thamDinhPASo;
    private Timestamp thamDinhPANgay;

    private String dbKeHoachThauSo;
    private Timestamp dbKeHoachThauNgay;

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

    private List<KinhphiDTO> listKinhPhis;

    private boolean changeKP;

    private HoSoThauDTO hoSoThau;

    public HoSoThauDTO getHoSoThau() {
        return hoSoThau;
    }

    public void setHoSoThau(HoSoThauDTO hoSoThau) {
        this.hoSoThau = hoSoThau;
    }

    public boolean isChangeKP() {
        return changeKP;
    }

    public void setChangeKP(boolean changeKP) {
        this.changeKP = changeKP;
    }

    public List<KinhphiDTO> getListKinhPhis() {
        return listKinhPhis;
    }

    public void setListKinhPhis(List<KinhphiDTO> listKinhPhis) {
        this.listKinhPhis = listKinhPhis;
    }

    public String getQdPheDuyetSo() {
        return qdPheDuyetSo;
    }

    public void setQdPheDuyetSo(String qdPheDuyetSo) {
        this.qdPheDuyetSo = qdPheDuyetSo;
    }

    public Timestamp getQdPheDuyetNgay() {
        return qdPheDuyetNgay;
    }

    public void setQdPheDuyetNgay(Timestamp qdPheDuyetNgay) {
        this.qdPheDuyetNgay = qdPheDuyetNgay;
    }

    public String getThamDinhPASo() {
        return thamDinhPASo;
    }

    public void setThamDinhPASo(String thamDinhPASo) {
        this.thamDinhPASo = thamDinhPASo;
    }

    public Timestamp getThamDinhPANgay() {
        return thamDinhPANgay;
    }

    public void setThamDinhPANgay(Timestamp thamDinhPANgay) {
        this.thamDinhPANgay = thamDinhPANgay;
    }

    public String getDbKeHoachThauSo() {
        return dbKeHoachThauSo;
    }

    public void setDbKeHoachThauSo(String dbKeHoachThauSo) {
        this.dbKeHoachThauSo = dbKeHoachThauSo;
    }

    public Timestamp getDbKeHoachThauNgay() {
        return dbKeHoachThauNgay;
    }

    public void setDbKeHoachThauNgay(Timestamp dbKeHoachThauNgay) {
        this.dbKeHoachThauNgay = dbKeHoachThauNgay;
    }

    public String getDbkqLuaChonNhaThauSo() {
        return dbkqLuaChonNhaThauSo;
    }

    public void setDbkqLuaChonNhaThauSo(String dbkqLuaChonNhaThauSo) {
        this.dbkqLuaChonNhaThauSo = dbkqLuaChonNhaThauSo;
    }

    public Timestamp getDbkqLuaChonNhaThauNgay() {
        return dbkqLuaChonNhaThauNgay;
    }

    public void setDbkqLuaChonNhaThauNgay(Timestamp dbkqLuaChonNhaThauNgay) {
        this.dbkqLuaChonNhaThauNgay = dbkqLuaChonNhaThauNgay;
    }

    public String getBaoCaoThamDinhSo() {
        return baoCaoThamDinhSo;
    }

    public void setBaoCaoThamDinhSo(String baoCaoThamDinhSo) {
        this.baoCaoThamDinhSo = baoCaoThamDinhSo;
    }

    public Timestamp getBaoCaoThamDinhNgay() {
        return baoCaoThamDinhNgay;
    }

    public void setBaoCaoThamDinhNgay(Timestamp baoCaoThamDinhNgay) {
        this.baoCaoThamDinhNgay = baoCaoThamDinhNgay;
    }

    public String getThuMoiThuongThaoSo() {
        return thuMoiThuongThaoSo;
    }

    public void setThuMoiThuongThaoSo(String thuMoiThuongThaoSo) {
        this.thuMoiThuongThaoSo = thuMoiThuongThaoSo;
    }

    public Timestamp getThuMoiThuongThaoNgay() {
        return thuMoiThuongThaoNgay;
    }

    public void setThuMoiThuongThaoNgay(Timestamp thuMoiThuongThaoNgay) {
        this.thuMoiThuongThaoNgay = thuMoiThuongThaoNgay;
    }

    public String getBienBanThuongThaoSo() {
        return bienBanThuongThaoSo;
    }

    public void setBienBanThuongThaoSo(String bienBanThuongThaoSo) {
        this.bienBanThuongThaoSo = bienBanThuongThaoSo;
    }

    public Timestamp getBienBanThuongThaoNgay() {
        return bienBanThuongThaoNgay;
    }

    public void setBienBanThuongThaoNgay(Timestamp bienBanThuongThaoNgay) {
        this.bienBanThuongThaoNgay = bienBanThuongThaoNgay;
    }

    public String getBcThamDinhKetQuaSo() {
        return bcThamDinhKetQuaSo;
    }

    public void setBcThamDinhKetQuaSo(String bcThamDinhKetQuaSo) {
        this.bcThamDinhKetQuaSo = bcThamDinhKetQuaSo;
    }

    public Timestamp getBcThamDinhKetQuaNgay() {
        return bcThamDinhKetQuaNgay;
    }

    public void setBcThamDinhKetQuaNgay(Timestamp bcThamDinhKetQuaNgay) {
        this.bcThamDinhKetQuaNgay = bcThamDinhKetQuaNgay;
    }

    public Long getMstiendo() {
        return mstiendo;
    }

    public void setMstiendo(Long mstiendo) {
        this.mstiendo = mstiendo;
    }

    public BidDTO getGoithau() {
        return goithau;
    }

    public void setGoithau(BidDTO goithau) {
        this.goithau = goithau;
    }

    public String getTcgSo() {
        return tcgSo;
    }

    public void setTcgSo(String tcgSo) {
        this.tcgSo = tcgSo;
    }

    public Timestamp getTcgNgay() {
        return tcgNgay;
    }

    public void setTcgNgay(Timestamp tcgNgay) {
        this.tcgNgay = tcgNgay;
    }

    public String getTrinhhsSo() {
        return trinhhsSo;
    }

    public void setTrinhhsSo(String trinhhsSo) {
        this.trinhhsSo = trinhhsSo;
    }

    public Timestamp getTrinhhsNgay() {
        return trinhhsNgay;
    }

    public void setTrinhhsNgay(Timestamp trinhhsNgay) {
        this.trinhhsNgay = trinhhsNgay;
    }

    public String getDuyethsSo() {
        return duyethsSo;
    }

    public void setDuyethsSo(String duyethsSo) {
        this.duyethsSo = duyethsSo;
    }

    public Timestamp getDuyethsNgay() {
        return duyethsNgay;
    }

    public void setDuyethsNgay(Timestamp duyethsNgay) {
        this.duyethsNgay = duyethsNgay;
    }

    public String getTrinhdangbaoSo() {
        return trinhdangbaoSo;
    }

    public void setTrinhdangbaoSo(String trinhdangbaoSo) {
        this.trinhdangbaoSo = trinhdangbaoSo;
    }

    public Timestamp getTrinhdangbaoNgay() {
        return trinhdangbaoNgay;
    }

    public void setTrinhdangbaoNgay(Timestamp trinhdangbaoNgay) {
        this.trinhdangbaoNgay = trinhdangbaoNgay;
    }

    public Timestamp getNgaybanhsL1() {
        return ngaybanhsL1;
    }

    public void setNgaybanhsL1(Timestamp ngaybanhsL1) {
        this.ngaybanhsL1 = ngaybanhsL1;
    }

    public Timestamp getNgaybanhsL2() {
        return ngaybanhsL2;
    }

    public void setNgaybanhsL2(Timestamp ngaybanhsL2) {
        this.ngaybanhsL2 = ngaybanhsL2;
    }

    public Timestamp getNgaybanhsL3() {
        return ngaybanhsL3;
    }

    public void setNgaybanhsL3(Timestamp ngaybanhsL3) {
        this.ngaybanhsL3 = ngaybanhsL3;
    }

    public Timestamp getNgaymothauL1() {
        return ngaymothauL1;
    }

    public void setNgaymothauL1(Timestamp ngaymothauL1) {
        this.ngaymothauL1 = ngaymothauL1;
    }

    public Timestamp getNgaymothauL2() {
        return ngaymothauL2;
    }

    public void setNgaymothauL2(Timestamp ngaymothauL2) {
        this.ngaymothauL2 = ngaymothauL2;
    }

    public Timestamp getNgaymothauL3() {
        return ngaymothauL3;
    }

    public void setNgaymothauL3(Timestamp ngaymothauL3) {
        this.ngaymothauL3 = ngaymothauL3;
    }

    public Timestamp getNgaydongthauL1() {
        return ngaydongthauL1;
    }

    public void setNgaydongthauL1(Timestamp ngaydongthauL1) {
        this.ngaydongthauL1 = ngaydongthauL1;
    }

    public Timestamp getNgaydongthauL2() {
        return ngaydongthauL2;
    }

    public void setNgaydongthauL2(Timestamp ngaydongthauL2) {
        this.ngaydongthauL2 = ngaydongthauL2;
    }

    public Timestamp getNgaydongthauL3() {
        return ngaydongthauL3;
    }

    public void setNgaydongthauL3(Timestamp ngaydongthauL3) {
        this.ngaydongthauL3 = ngaydongthauL3;
    }

    public String getTrinhkqSo() {
        return trinhkqSo;
    }

    public void setTrinhkqSo(String trinhkqSo) {
        this.trinhkqSo = trinhkqSo;
    }

    public Timestamp getTrinhkqNgay() {
        return trinhkqNgay;
    }

    public void setTrinhkqNgay(Timestamp trinhkqNgay) {
        this.trinhkqNgay = trinhkqNgay;
    }

    public String getPheduyetkqSo() {
        return pheduyetkqSo;
    }

    public void setPheduyetkqSo(String pheduyetkqSo) {
        this.pheduyetkqSo = pheduyetkqSo;
    }

    public Timestamp getPheduyetkqNgay() {
        return pheduyetkqNgay;
    }

    public void setPheduyetkqNgay(Timestamp pheduyetkqNgay) {
        this.pheduyetkqNgay = pheduyetkqNgay;
    }

    public String getThongbaokqSo() {
        return thongbaokqSo;
    }

    public void setThongbaokqSo(String thongbaokqSo) {
        this.thongbaokqSo = thongbaokqSo;
    }

    public Timestamp getThongbaokqNgay() {
        return thongbaokqNgay;
    }

    public void setThongbaokqNgay(Timestamp thongbaokqNgay) {
        this.thongbaokqNgay = thongbaokqNgay;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
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

    public Boolean getIshuythau() {
        return ishuythau;
    }

    public void setIshuythau(Boolean ishuythau) {
        this.ishuythau = ishuythau;
    }

    public String getCdtSo() {
        return cdtSo;
    }

    public void setCdtSo(String cdtSo) {
        this.cdtSo = cdtSo;
    }

    public Timestamp getCdtNgay() {
        return cdtNgay;
    }

    public void setCdtNgay(Timestamp cdtNgay) {
        this.cdtNgay = cdtNgay;
    }

    public String getBaocaodgSo() {
        return baocaodgSo;
    }

    public void setBaocaodgSo(String baocaodgSo) {
        this.baocaodgSo = baocaodgSo;
    }

    public Timestamp getBaocaodgNgay() {
        return baocaodgNgay;
    }

    public void setBaocaodgNgay(Timestamp baocaodgNgay) {
        this.baocaodgNgay = baocaodgNgay;
    }

    public String getTrinhtcgSo() {
        return trinhtcgSo;
    }

    public void setTrinhtcgSo(String trinhtcgSo) {
        this.trinhtcgSo = trinhtcgSo;
    }

    public Timestamp getTrinhtcgNgay() {
        return trinhtcgNgay;
    }

    public void setTrinhtcgNgay(Timestamp trinhtcgNgay) {
        this.trinhtcgNgay = trinhtcgNgay;
    }
}
