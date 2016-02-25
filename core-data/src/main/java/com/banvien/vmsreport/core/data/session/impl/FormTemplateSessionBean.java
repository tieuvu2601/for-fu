package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.entity.DmLoaibieumauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.session.FormTemplateLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "FormTemplateSessionEJB")
public class FormTemplateSessionBean extends AbstractSessionBean<DmLoaibieumauEntity, Long> implements FormTemplateLocalBean{
    public FormTemplateSessionBean() {
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        List<Long> listHinhThuc = new ArrayList<>();
        List<Long> listTinhTrang = new ArrayList<>();
        if (properties.get("hinhThuc") != null){
            String[] hinhThucs = (String[]) properties.get("hinhThuc");
            for (String hinhThuc: hinhThucs) {
                listHinhThuc.add(Long.valueOf(hinhThuc));
            }
        }
        if (properties.get("tinhTrang") != null){
            String[] tinhTrangs = (String[]) properties.get("tinhTrang");
            for (String tinhTrang: tinhTrangs) {
                listTinhTrang.add(Long.valueOf(tinhTrang));
            }
        }
        StringBuilder mainQuery = new StringBuilder();
        mainQuery.append(" FROM GoithauNhanvienEntity gtnv ")
                .append("  RIGHT JOIN gtnv.goithau gt ")
                .append("  WHERE 1 = 1 ");

        if (properties.get("nguonVon") != null) {
            mainQuery.append("  AND gt.nguonvon.msnguonvon = :nguonVon ");
        }
        if (properties.get("loaiDauTu") != null){
            mainQuery.append("  AND gt.loai.msloai = :loaiDauTu ");
        }
        if (properties.get("department") != null){
            mainQuery.append("  AND gt.department.departmentId = :department ");
        }
        if (properties.get("chair") != null){
            mainQuery.append("  AND gtnv.user.userId = :chair AND gtnv.ischutri = :ischutri ");
        }
        if (properties.get("user") != null){
            mainQuery.append("  AND gtnv.user.userId = :user ");
        }
        if (properties.get("quiMo") != null){
            mainQuery.append("  AND gt.quimo.msquimo = :quiMo ");
        }
        if (properties.get("qdPhuongAnDuAn") != null ) {
            mainQuery.append("  AND td.qdPheDuyetSo = :qdPhuongAnDuAn ");
        }
        if (properties.get("maGoiThau") != null){
            mainQuery.append("  AND gt.magoithau like :maGoiThau ");
        }
        if (properties.get("tenGoiThau") != null){
            mainQuery.append("  AND UPPER(gt.tengoithau) like :tenGoiThau ");
        }
        if (properties.get("hinhThuc") != null){
            mainQuery.append("  AND gt.hinhthucgt.mshinhthuc IN (:hinhThuc) ");
        }
        if (properties.get("tinhTrang") != null){
            mainQuery.append("  AND gt.tinhtrang.mstinhtrang IN (:tinhTrang) ");
        }
        if(properties.get("fromYear") != null){
            mainQuery.append(" AND gt.sonamhd >= :fromYear  ");
        }
        if(properties.get("toYear") != null){
            mainQuery.append(" AND gt.sonamhd <= :toYear  ");
        }
        mainQuery.append("  ORDER BY gt.magoithau   ");

        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT  ")
                .append("  gt.magoithau  ")
                .append("  ,gt.tengoithau ")
                .append("  ,(SELECT nv.tennguonvon FROM DmNguonvonEntity nv WHERE nv.msnguonvon = gt.nguonvon.msnguonvon) ")
                .append("  ,(SELECT l.tenloai FROM DmLoaiEntity l WHERE l.msloai = gt.loai.msloai) ")
                .append("  ,(SELECT d.name FROM DepartmentEntity d WHERE d.departmentId = gt.department.departmentId) ")
                .append("  ,gtnv.user.userName ")
                .append("  ,(SELECT ht.tenhinhthuc FROM DmHinhthucgtEntity ht WHERE ht.mshinhthuc = gt.hinhthucgt.mshinhthuc) ")
                .append("  ,(SELECT qm.tenquimo FROM DmQuyMoEntity qm WHERE qm.msquimo = gt.quimo.msquimo) ")
                .append("  ,(SELECT gtnt1.nhathau.tennhathau FROM GoithauNhathauEntity gtnt1 WHERE gtnt1.goithau.msgoithau = gt.msgoithau AND gtnt1.istrungthau = :istrungthau) ")
                .append("  ,(SELECT tt.tentinhtrang FROM DmTinhtrangEntity tt WHERE tt.mstinhtrang = gt.tinhtrang.mstinhtrang) ")
                .append("  ,gtnv.user.userId  ")
                .append(mainQuery);

        Query queryClause = entityManager.createQuery(sqlQueryClause.toString())
                .setParameter("istrungthau", Constants.IS_TRUNGTHAU);

//        queryClause.setFirstResult(firstItem);
//        queryClause.setMaxResults(maxPageItems);

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
            queryClause.setParameter("hinhThuc", listHinhThuc);
        }
        if (properties.get("tinhTrang") != null){
            queryClause.setParameter("tinhTrang", listTinhTrang);
        }
        if (properties.get("fromYear") !=  null){
            queryClause.setParameter("fromYear", BigDecimal.valueOf((Long) properties.get("fromYear")));
        }
        if (properties.get("toYear") != null){
            queryClause.setParameter("toYear", BigDecimal.valueOf((Long) properties.get("toYear")));
        }

        List resultList = queryClause.getResultList();

        StringBuilder sqlCount = new StringBuilder();
        sqlCount.append("  SELECT COUNT(gt.magoithau) ").append(mainQuery);

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
            countQuery.setParameter("hinhThuc", listHinhThuc);
        }
        if (properties.get("tinhTrang") != null){
            countQuery.setParameter("tinhTrang", listTinhTrang);
        }
        if (properties.get("fromYear") !=  null){
            countQuery.setParameter("fromYear", BigDecimal.valueOf((Long) properties.get("fromYear")));
        }
        if (properties.get("toYear") != null){
            countQuery.setParameter("toYear", BigDecimal.valueOf((Long) properties.get("toYear")));
        }

        Long count = Long.valueOf(countQuery.getSingleResult().toString());
        return new Object[]{count, resultList};
    }

    @Override
    public Object[] findByMaGoiThau(String maGoiThau) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(" SELECT gtnt FROM GoithauNhathauEntity gtnt  WHERE gtnt.istrungthau = :istrungthau AND gtnt.goithau.magoithau = :maGoiThau ");
        Query queryClause = entityManager.createQuery(sqlQuery.toString())
                .setParameter("istrungthau", Constants.IS_TRUNGTHAU)
                .setParameter("maGoiThau", maGoiThau);
        return new Object[]{queryClause.getSingleResult()};
    }

    @Override
    public List<DmLoaibieumauEntity> findSortSTT() {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(" SELECT lbm FROM DmLoaibieumauEntity lbm  WHERE lbm.ghichu IS NOT NULL ORDER BY lbm.stt ");
        Query queryClause = entityManager.createQuery(sqlQuery.toString());
        return (List<DmLoaibieumauEntity>) queryClause.getResultList();
    }
}
