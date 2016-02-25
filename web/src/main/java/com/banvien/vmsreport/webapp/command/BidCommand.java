package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.BidDTO;
import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.dto.HosolutruuDTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 8/21/15
 * Time: 8:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class BidCommand extends AbstractCommand<BidDTO> {
    public BidCommand() {
        this.pojo = new BidDTO();
    }
    Map<Integer, Long> mapnvs = new HashMap<Integer, Long>();
    private Long idChuTri;
    private Long idThanhVien;
    private Timestamp toDate;
    private Timestamp fromDate;
    private List<Long> mapHinhThucs = new ArrayList();
    private List<Long> mapTinhTrangs = new ArrayList();
    private Map<Long, HosolutruuDTO> mapBidSave = new HashMap<Long, HosolutruuDTO>();
    private BigDecimal tuKe;
    private BigDecimal denKe;
    private BigDecimal tuTu;
    private BigDecimal denTu;


    public Map<Integer, Long> getMapnvs() {
        return mapnvs;
    }

    public void setMapnvs(Map<Integer, Long> mapnvs) {
        this.mapnvs = mapnvs;
    }

    public Long getIdChuTri() {
        return idChuTri;
    }

    public void setIdChuTri(Long idChuTri) {
        this.idChuTri = idChuTri;
    }

    public Long getIdThanhVien() {
        return idThanhVien;
    }

    public void setIdThanhVien(Long idThanhVien) {
        this.idThanhVien = idThanhVien;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public List<Long> getMapHinhThucs() {
        return mapHinhThucs;
    }

    public void setMapHinhThucs(List<Long> mapHinhThucs) {
        this.mapHinhThucs = mapHinhThucs;
    }

    public List<Long> getMapTinhTrangs() {
        return mapTinhTrangs;
    }

    public void setMapTinhTrangs(List<Long> mapTinhTrangs) {
        this.mapTinhTrangs = mapTinhTrangs;
    }

    public Map<Long, HosolutruuDTO> getMapBidSave() {
        return mapBidSave;
    }

    public void setMapBidSave(Map<Long, HosolutruuDTO> mapBidSave) {
        this.mapBidSave = mapBidSave;
    }

    public BigDecimal getTuKe() {
        return tuKe;
    }

    public void setTuKe(BigDecimal tuKe) {
        this.tuKe = tuKe;
    }

    public BigDecimal getDenKe() {
        return denKe;
    }

    public void setDenKe(BigDecimal denKe) {
        this.denKe = denKe;
    }

    public BigDecimal getTuTu() {
        return tuTu;
    }

    public void setTuTu(BigDecimal tuTu) {
        this.tuTu = tuTu;
    }

    public BigDecimal getDenTu() {
        return denTu;
    }

    public void setDenTu(BigDecimal denTu) {
        this.denTu = denTu;
    }
}
