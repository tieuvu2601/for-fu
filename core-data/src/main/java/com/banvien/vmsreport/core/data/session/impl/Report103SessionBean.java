package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.session.Report103LocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/22/15
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report103SessionEJB")
public class Report103SessionBean implements Report103LocalBean {
    public Report103SessionBean() {
    }

    @PersistenceContext(unitName = "core-data")
    protected EntityManager entityManager;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append("  FROM  GoithauNhanvienEntity gtnv ")
                .append("   WHERE 1 = 1 ");

        if (properties.get("nguonVon") != null) {
            mainQuery.append("  AND gtnv.goithau.nguonvon.msnguonvon = :nguonVon ");
        }
        if (properties.get("loaiDauTu") != null){
            mainQuery.append("  AND gtnv.goithau.loai.msloai = :loaiDauTu ");
        }
        if (properties.get("department") != null){
            mainQuery.append("  AND gtnv.goithau.department.departmentId = :department ");
        }
        if (properties.get("quiMo") != null){
            mainQuery.append("  AND gtnv.goithau.quimo.msquimo = :quiMo ");
        }
        if (properties.get("tinhTrang") != null){
            mainQuery.append("  AND gtnv.goithau.tinhtrang.mstinhtrang IN (:tinhTrang) ");
        }
        if(properties.get("fromYear") != null){
            mainQuery.append(" AND gtnv.goithau.sonamhd >= :fromYear  ");
        }
        if(properties.get("toYear") != null){
            mainQuery.append(" AND gtnv.goithau.sonamhd <= :toYear  ");
        }
        mainQuery.append(" GROUP BY gtnv.user.userName, gtnv.ischutri, gtnv.goithau.hinhthucgt.mahinhthuc, gtnv.goithau.tinhtrang.maSoTinhTrang ");

        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT gtnv.user.userName, gtnv.ischutri, gtnv.goithau.hinhthucgt.mahinhthuc, gtnv.goithau.tinhtrang.maSoTinhTrang, COUNT(gtnv.user.userName) as soLuong  ")
                .append(mainQuery)
                .append(" order by gtnv.ischutri desc ");

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
        if (properties.get("quiMo") != null){
            queryClause.setParameter("quiMo", properties.get("quiMo"));
        }
        if (properties.get("tinhTrang") != null){
            queryClause.setParameter("tinhTrang", (List<Long>)properties.get("tinhTrang"));
        }
        if(properties.get("fromYear") != null){
            queryClause.setParameter("fromYear", properties.get("fromYear"));
        }
        if(properties.get("toYear") != null){
            queryClause.setParameter("toYear", properties.get("toYear"));
        }
        List resultList = queryClause.getResultList();
        Long count = (long) resultList.size();
        return new Object[]{count, resultList};
    }
}
