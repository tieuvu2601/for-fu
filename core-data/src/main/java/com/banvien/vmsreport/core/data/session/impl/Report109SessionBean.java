package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.session.Report109LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/31/15
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report109SessionEJB")
public class Report109SessionBean implements Report109LocalBean{
    public Report109SessionBean() {
    }

    @PersistenceContext(unitName = "core-data")
    protected EntityManager entityManager;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append("  FROM users u, goiThau gt, dm_hinhThucGT htgt, dm_tinhTrang tt ")
                .append("   WHERE u.userId = gt.msNhanVien_CVTD AND htgt.msHinhThuc = gt.msHinhThuc AND tt.msTinhTrang  = gt.msTinhTrang ");

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

        mainQuery.append(" GROUP BY u.userName, htgt.maHinhThuc, tt.maTinhTrang ");

        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT u.userName, htgt.maHinhThuc, tt.maTinhTrang, COUNT(u.userName) AS soLuong  ")
                .append(mainQuery)
                .append(" ORDER BY u.userName, htgt.maHinhThuc, tt.maTinhTrang ");

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
        Long count = (long) resultList.size();
        return new Object[]{count, resultList};
    }
}
