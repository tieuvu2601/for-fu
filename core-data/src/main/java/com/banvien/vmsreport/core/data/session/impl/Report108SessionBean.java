package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.session.Report108LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/30/15
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report108SessionEJB")
public class Report108SessionBean implements Report108LocalBean {
    public Report108SessionBean() {
    }

    @PersistenceContext(unitName = "core-data")
    protected EntityManager entityManager;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append("  FROM GoiThau gt, DM_HinhThucGT ht, TienDo td, Users u, GoiThau_NhanVien gtnv, DM_TinhTrang tt ")
                .append("   WHERE gt.msHinhThuc = ht.msHinhThuc(+) AND gt.msGoiThau = td.msGoiThau(+) ")
                .append("   AND gt.msGoiThau = gtnv.msGoiThau(+) AND gtnv.isChuTri = 1 AND u.userId = gtnv.userId ")
                .append("   AND gt.msTinhTrang = tt.msTinhTrang ")
                .append("   AND (td.dbkqLuaChonNhaThau_Ngay IS NOT NULL OR td.dbkqLuaChonNhaThau_So IS NOT NULL) ");

        if(properties.get("tenGoiThau") != null){
            mainQuery.append("  AND gt.TenGoiThau like :tenGoiThau ");
        }
        if (properties.get("maGoiThau") != null){
            mainQuery.append("  AND gt.MaGoiThau like :maGoiThau ");
        }
        if(properties.get("fromDate") != null){
            mainQuery.append(" and td.qdPheDuyet_Ngay >= to_date(substr(:fromDate, 1, 10), '").append(Constants.DB_DATE_FORMAT).append("')");
        }
        if(properties.get("toDate") != null){
            mainQuery.append(" and td.qdPheDuyet_Ngay < (to_date(substr(:toDate, 1, 10), '").append(Constants.DB_DATE_FORMAT).append("') + 1)");
        }
        if (properties.get("msNguonVon") != null){
            mainQuery.append("  AND gt.msNguonVon = :msNguonVon ");
        }
        if (properties.get("msLoaiDauTu") != null){
            mainQuery.append("  AND gt.msLoai = :msLoaiDauTu ");
        }
        if (properties.get("msPhong") != null){
            mainQuery.append("  AND gt.departmentId = :msPhong ");
        }
        if (properties.get("msChuTri") != null){
            mainQuery.append("  AND EXISTS (SELECT 1 FROM GoiThau_NhanVien gtnv WHERE gtnv.msGoiThau = gt.msGoiThau AND UserId = :msChuTri AND isChuTri = 1) ");
        }
        if (properties.get("msThanhVien") != null){
            mainQuery.append("  AND EXISTS (SELECT 1 FROM GoiThau_NhanVien gtnv WHERE gtnv.msGoiThau = gt.msGoiThau AND UserId = :msThanhVien) ");
        }
        if (properties.get("msQuiMo") != null){
            mainQuery.append("  AND gt.msQuiMo = :msQuiMo ");
        }
        if (properties.get("checkListHinhThuc") != null && ((List<Long>)properties.get("checkListHinhThuc")).size() > 0){
            mainQuery.append("  AND gt.msHinhThuc IN (:checkListHinhThuc) ");
        }
        if (properties.get("checkListTinhTrang") != null && ((List<Long>)properties.get("checkListTinhTrang")).size() > 0){
            mainQuery.append("  AND gt.msTinhTrang IN (:checkListTinhTrang) ");
        }
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT tenGoiThau, tenHinhThuc, td.qdPheDuyet_Ngay, td.trinhHS_Ngay, td.trinhHS_So, u.userName  ")
                .append(mainQuery)
                .append(" order by u.userName ");

        Query queryClause = entityManager.createNativeQuery(sqlQueryClause.toString());

        queryClause.setFirstResult(firstItem);
        queryClause.setMaxResults(maxPageItems);
        if(properties.get("tenGoiThau") != null){
            queryClause.setParameter("tenGoiThau", "%"+properties.get("tenGoiThau")+"%");
        }
        if (properties.get("maGoiThau") != null){
            queryClause.setParameter("maGoiThau", properties.get("maGoiThau"));
        }
        if(properties.get("fromDate") != null){
            queryClause.setParameter("fromDate", properties.get("fromDate").toString());
        }
        if(properties.get("toDate") != null){
            queryClause.setParameter("toDate", properties.get("toDate").toString());
        }
        if (properties.get("msNguonVon") != null){
            queryClause.setParameter("msNguonVon", properties.get("msNguonVon"));
        }
        if (properties.get("msLoaiDauTu") != null){
            queryClause.setParameter("msLoaiDauTu", properties.get("msLoaiDauTu"));
        }
        if (properties.get("msPhong") != null){
            queryClause.setParameter("msPhong", properties.get("msPhong"));
        }
        if (properties.get("msChuTri") != null){
            queryClause.setParameter("msChuTri", properties.get("msChuTri"));
        }
        if (properties.get("msThanhVien") != null){
            queryClause.setParameter("msThanhVien", properties.get("msThanhVien"));
        }
        if (properties.get("msQuiMo") != null){
            queryClause.setParameter("msQuiMo", properties.get("msQuiMo"));
        }
        if (properties.get("checkListHinhThuc") != null){
            queryClause.setParameter("checkListHinhThuc", properties.get("checkListHinhThuc"));
        }
        if (properties.get("checkListTinhTrang") != null){
            queryClause.setParameter("checkListTinhTrang", properties.get("checkListTinhTrang"));
        }
        List resultList = queryClause.getResultList();

        StringBuilder sqlCount = new StringBuilder();
        sqlCount.append(" SELECT COUNT(gt.MSGoiThau) ").append(mainQuery);
        Query countQuery = entityManager.createNativeQuery(sqlCount.toString());
        if(properties.get("tenGoiThau") != null){
            countQuery.setParameter("tenGoiThau", "%"+properties.get("tenGoiThau")+"%");
        }
        if (properties.get("maGoiThau") != null){
            countQuery.setParameter("maGoiThau", properties.get("maGoiThau"));
        }
        if(properties.get("fromDate") != null){
            countQuery.setParameter("fromDate", properties.get("fromDate").toString());
        }
        if(properties.get("toDate") != null){
            countQuery.setParameter("toDate", properties.get("toDate").toString());
        }
        if (properties.get("msNguonVon") != null){
            countQuery.setParameter("msNguonVon", properties.get("msNguonVon"));
        }
        if (properties.get("msLoaiDauTu") != null){
            countQuery.setParameter("msLoaiDauTu", properties.get("msLoaiDauTu"));
        }
        if (properties.get("msPhong") != null){
            countQuery.setParameter("msPhong", properties.get("msPhong"));
        }
        if (properties.get("msChuTri") != null){
            countQuery.setParameter("msChuTri", properties.get("msChuTri"));
        }
        if (properties.get("msThanhVien") != null){
            countQuery.setParameter("msThanhVien", properties.get("msThanhVien"));
        }
        if (properties.get("msQuiMo") != null){
            countQuery.setParameter("msQuiMo", properties.get("msQuiMo"));
        }
        if (properties.get("checkListHinhThuc") != null && ((List<Long>)properties.get("checkListHinhThuc")).size() > 0){
            countQuery.setParameter("checkListHinhThuc", properties.get("checkListHinhThuc"));
        }
        if (properties.get("checkListTinhTrang") != null && ((List<Long>)properties.get("checkListTinhTrang")).size() > 0){
            countQuery.setParameter("checkListTinhTrang", properties.get("checkListTinhTrang"));
        }
        Long count = Long.valueOf(countQuery.getSingleResult().toString());
        return new Object[]{count, resultList};
    }
}
