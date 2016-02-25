package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.session.Report106LocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report106SessionEJB")
public class Report106SessionBean implements Report106LocalBean {
    public Report106SessionBean() {
    }

    @PersistenceContext(unitName = "core-data")
    protected EntityManager entityManager;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append(" FROM    GoithauNhanvienEntity gtnv, HosothauEntity hst, TiendoEntity td, DangbaoEntity db  ")
                .append("  WHERE   gtnv.goithau.msgoithau = hst.goithau_nhathau.goithau.msgoithau ")
                .append("  AND     gtnv.goithau.msgoithau = td.goithau.msgoithau ")
                .append("  AND     gtnv.goithau.msgoithau = db.goithau.msgoithau ");

        if (properties.get("nguonVon") != null) {
            mainQuery.append("  AND gtnv.goithau.nguonvon.msnguonvon = :nguonVon ");
        }
        if (properties.get("loaiDauTu") != null){
            mainQuery.append("  AND gtnv.goithau.loai.msloai = :loaiDauTu ");
        }
        if (properties.get("department") != null){
            mainQuery.append("  AND gtnv.goithau.department.departmentId = :department ");
        }
        if (properties.get("chair") != null){
            mainQuery.append("  AND gtnv.user.userId = :chair AND gtnv.ischutri = :ischutri  ");
        }
        if (properties.get("user") != null){
            mainQuery.append("  AND gtnv.user.userId = :user ");
        }
        if (properties.get("quiMo") != null){
            mainQuery.append("  AND gtnv.goithau.quimo.msquimo = :quiMo ");
        }
        if (properties.get("qdPhuongAnDuAn") != null ) {
            mainQuery.append("  AND td.qdPheDuyetSo = :qdPhuongAnDuAn ");
        }
        if (properties.get("maGoiThau") != null){
            mainQuery.append("  AND gtnv.goithau.magoithau like :maGoiThau ");
        }
        if (properties.get("tenGoiThau") != null){
            mainQuery.append("  AND UPPER(gtnv.goithau.tengoithau) like :tenGoiThau ");
        }
        if (properties.get("hinhThuc") != null){
            mainQuery.append("  AND gtnv.goithau.hinhthucgt.mshinhthuc IN (:hinhThuc) ");
        }
        if (properties.get("tinhTrang") != null){
            mainQuery.append("  AND gtnv.goithau.tinhtrang.mstinhtrang IN (:tinhTrang) ");
        }
        if(properties.get("fromDate") != null){
            mainQuery.append(" and td.qdPheDuyet_Ngay >= to_date(substr(:fromDate, 1, 10), '").append(Constants.DB_DATE_FORMAT).append("')");
        }
        if(properties.get("toDate") != null){
            mainQuery.append(" and td.qdPheDuyet_Ngay < (to_date(substr(:toDate, 1, 10), '").append(Constants.DB_DATE_FORMAT).append("') + 1)");
        }

        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT gtnv.goithau.nguonvon.tennguonvon, ")
                    .append("   gtnv.goithau.department.code, ")
                    .append("   gtnv.goithau.hinhthucgt.mahinhthuc, ")
                    .append("   gtnv.goithau.tinhtrang.maSoTinhTrang, ")
                    .append("   gtnv.user.userName, ")
                    .append("   gtnv.goithau.quimo.tenquimo, ")
                    .append("   gtnv.goithau.magoithau, ")
                    .append("   gtnv.goithau.tengoithau, ")
                    .append("   td.qdPheDuyetSo, ")
                    .append("   td.qdPheDuyetNgay, ")
                    .append("   td.trinhhsSo, ")
                    .append("   td.trinhhsNgay, ")
                    .append("   td.duyethsSo, ")
                    .append("   td.duyethsNgay, ")
                    .append("   td.trinhdangbaoSo, ")
                    .append("   td.trinhdangbaoNgay, ")
                    .append("   td.ngaybanhsL1, ")
                    .append("   td.ngaybanhsL2, ")
                    .append("   td.ngaybanhsL3, ")
                    .append("   td.ngaymothauL1, ")
                    .append("   td.ngaymothauL2, ")
                    .append("   td.ngaymothauL3, ")
                    .append("   td.trinhkqSo, ")
                    .append("   td.trinhkqNgay, ")
                    .append("   td.pheduyetkqSo, ")
                    .append("   td.pheduyetkqNgay, ")
                    .append("   td.dbkqLuaChonNhaThauNgay, ")
                    .append("   hst.noiDungHoSo.giaDuThau, ")
                    .append("   gtnv.goithau.landauthau, ")
                    .append("   (SELECT COUNT(gtnt1.nhathau.msnhathau) ")
                    .append("   FROM GoithauNhathauEntity gtnt1 ")
                    .append("   WHERE gtnt1.goithau.msgoithau = gtnv.goithau.msgoithau ")
                    .append("   AND gtnt1.ngaymuahs  IS NOT NULL ")
                    .append("   ) AS sl_nhaThauMuaHS, ")
                    .append("   (SELECT COUNT(gtnt2.nhathau.msnhathau) ")
                    .append("   FROM GoithauNhathauEntity gtnt2 ")
                    .append("   WHERE gtnt2.goithau.msgoithau = gtnv.goithau.msgoithau ")
                    .append("   AND gtnt2.ngaynophs  IS NOT NULL ")
                    .append("   ) AS sl_nhaThauNopHS, ")
                    .append("   hst.goithau_nhathau.nhathau.tennhathau, ")
                    .append("   hst.goithau_nhathau.nhathau.diachi,  ")
                    .append("   gtnv.goithau.tinhtrang.tentinhtrang, ")
                    .append("   hst.goithau_nhathau.istrungthau, ")
                    .append("   gtnv.ischutri, ")
                    .append("   db.ngaydangbao, ")
                    .append("   hst.goithau_nhathau.ngaymuahs,  ")
                    .append("   hst.goithau_nhathau.ngaynophs,  ")
                    .append("   hst.goithau_nhathau.nhathau.msnhathau,  ")
                    .append("   gtnv.user.userId,  ")
                    .append("   db.msdangbao  ")
                    .append(mainQuery);

        Query queryClause = entityManager.createQuery(sqlQueryClause.toString());

        queryClause.setFirstResult(firstItem);
        queryClause.setMaxResults(maxPageItems);

        if (properties.get("nguonVon") != null) {
            queryClause.setParameter("nguonVon", properties.get("nguonVon"));
        }
        if (properties.get("loaiDauTu") != null){
            queryClause.setParameter("loaiDauTu", properties.get("loaiDauTu"));
        }
        if (properties.get("department") != null){
            queryClause.setParameter("department", properties.get("department"));
        }
        if (properties.get("chair") != null){
            queryClause.setParameter("chair", properties.get("chair"));
            queryClause.setParameter("ischutri", Constants.IS_CHAIR);
        }
        if (properties.get("user") != null){
            queryClause.setParameter("user", properties.get("user"));
        }
        if (properties.get("quiMo") != null){
            queryClause.setParameter("quiMo", properties.get("quiMo"));
        }
        if (properties.get("qdPhuongAnDuAn") != null ) {
            queryClause.setParameter("qdPhuongAnDuAn", properties.get("qdPhuongAnDuAn"));
        }
        if (properties.get("maGoiThau") != null){
            queryClause.setParameter("maGoiThau", properties.get("maGoiThau"));
        }
        if (properties.get("tenGoiThau") != null){
            queryClause.setParameter("tenGoiThau", "'%" + StringUtils.upperCase(properties.get("tenGoiThau").toString()) + "%'");
        }
        if (properties.get("hinhThuc") != null){
            queryClause.setParameter("hinhThuc", properties.get("hinhThuc"));
        }
        if (properties.get("tinhTrang") != null){
            queryClause.setParameter("tinhTrang", properties.get("tinhTrang"));
        }
        if (properties.get("fromDate") !=  null){
            queryClause.setParameter("fromDate", properties.get("fromDate"));
        }
        if (properties.get("toDate") != null){
            queryClause.setParameter("toDate", properties.get("toDate"));
        }

        List resultList = queryClause.getResultList();

        StringBuilder sqlCount = new StringBuilder();
        sqlCount.append(" SELECT COUNT(gtnv.goithau.msgoithau) ").append(mainQuery);

        Query countQuery = entityManager.createQuery(sqlCount.toString());

        if (properties.get("nguonVon") != null) {
            countQuery.setParameter("nguonVon", properties.get("nguonVon"));
        }
        if (properties.get("loaiDauTu") != null){
            countQuery.setParameter("loaiDauTu", properties.get("loaiDauTu"));
        }
        if (properties.get("department") != null){
            countQuery.setParameter("department", properties.get("department"));
        }
        if (properties.get("chair") != null){
            countQuery.setParameter("chair", properties.get("chair"));
            countQuery.setParameter("ischutri", Constants.IS_CHAIR);
        }
        if (properties.get("user") != null){
            countQuery.setParameter("user", properties.get("user"));
        }
        if (properties.get("quiMo") != null){
            countQuery.setParameter("quiMo", properties.get("quiMo"));
        }
        if (properties.get("qdPhuongAnDuAn") != null ) {
            countQuery.setParameter("qdPhuongAnDuAn", properties.get("qdPhuongAnDuAn"));
        }
        if (properties.get("maGoiThau") != null){
            countQuery.setParameter("maGoiThau", properties.get("maGoiThau"));
        }
        if (properties.get("tenGoiThau") != null){
            countQuery.setParameter("tenGoiThau", "'%" + StringUtils.upperCase(properties.get("tenGoiThau").toString()) + "%'");
        }
        if (properties.get("hinhThuc") != null){
            countQuery.setParameter("hinhThuc", properties.get("hinhThuc"));
        }
        if (properties.get("tinhTrang") != null){
            countQuery.setParameter("tinhTrang", properties.get("tinhTrang"));
        }
        if (properties.get("fromDate") !=  null){
            countQuery.setParameter("fromDate", properties.get("fromYear"));
        }
        if (properties.get("toDate") != null){
            countQuery.setParameter("toDate", properties.get("toYear"));
        }
        Long count = Long.valueOf(countQuery.getSingleResult().toString());

        return new Object[]{count, resultList};
    }
}
