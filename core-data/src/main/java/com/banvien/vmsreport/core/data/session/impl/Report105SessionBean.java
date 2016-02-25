package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.session.Report105LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report105SessionEJB")
public class Report105SessionBean implements Report105LocalBean {
    public Report105SessionBean() {
    }
    @PersistenceContext(unitName = "core-data")
    protected EntityManager entityManager;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append("  FROM department d, dm_nguonVon nv, goiThau gt, dm_hinhThucGT htgt, dm_tinhTrang tt ")
                .append("   WHERE d.departmentId = gt.DEPARTMENTID AND nv.msNguonVon = gt.msNguonVon ")
                .append("   AND htgt.msHinhThuc = gt.msHinhThuc AND tt.msTinhTrang  = gt.msTinhTrang ");

        if(properties.get("checkListTinhTrang") != null){
            mainQuery.append("  AND tt.msTinhTrang IN :checkListTinhTrang ");
        }
        if(properties.get("fromDate") != null){
            mainQuery.append(" and td.qdPheDuyet_Ngay >= to_date(substr(:fromDate, 1, 10), '").append(Constants.DB_DATE_FORMAT).append("')");
        }
        if(properties.get("toDate") != null){
            mainQuery.append(" and td.qdPheDuyet_Ngay < (to_date(substr(:toDate, 1, 10), '").append(Constants.DB_DATE_FORMAT).append("') + 1)");
        }

        mainQuery.append(" GROUP BY d.code, nv.tenNguonVon, htgt.maHinhThuc, tt.MATINHTRANG ");

        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT d.code, nv.tenNguonVon, htgt.maHinhThuc, tt.MATINHTRANG, COUNT(d.code) AS soLuong  ")
                .append(mainQuery)
                .append(" ORDER BY nv.tenNguonVon ");

        Query queryClause = entityManager.createNativeQuery(sqlQueryClause.toString());

        queryClause.setFirstResult(firstItem);
        queryClause.setMaxResults(maxPageItems);
        if(properties.get("checkListTinhTrang") != null){
            queryClause.setParameter("checkListTinhTrang", properties.get("checkListTinhTrang"));
        }
        if(properties.get("fromDate") != null){
            queryClause.setParameter("fromDate", properties.get("fromDate"));
        }
        if(properties.get("toDate") != null){
            queryClause.setParameter("toDate", properties.get("toDate"));
        }
        List resultList = queryClause.getResultList();
        Long count = (long) resultList.size();
        return new Object[]{count, resultList};
    }
}
