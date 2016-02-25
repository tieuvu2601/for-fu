package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.utils.DateUtil;
import com.banvien.vmsreport.core.data.entity.DepartmentEntity;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.session.BidLocalBean;
import com.banvien.vmsreport.core.data.session.DepartmentLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "BidSessionEJB")
public class BidSessionBean extends AbstractSessionBean<GoithauEntity, Long> implements BidLocalBean {
    public BidSessionBean() {
    }

    @Override
    public List<GoithauEntity> searchAutoComplete(String name, Integer maxResult) {
        StringBuilder sqlClause = new StringBuilder();
        sqlClause.append("FROM GoithauEntity e WHERE upper(e.tengoithau) LIKE :name");
        name = name != null ? name.toUpperCase() : "";
        List<GoithauEntity> emspotEntities = new ArrayList<>();
        try {
            Query query = entityManager.createQuery(sqlClause.toString()).setMaxResults(maxResult);
            query.setParameter("name","%"+name+"%");
            emspotEntities = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return emspotEntities;
    }

    @Override
    public Object[] searchForList(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        StringBuffer stringBuffer = new StringBuffer("FROM GoithauEntity goithau WHERE 1 = 1 ");

        buildWhereClauseSimpleAttributes(properties, stringBuffer);
        buildWhereClauseDatetime(properties, stringBuffer);
        buildWhereClauseReferenceAttributes(properties, stringBuffer);
        buildWhereClauseListAttributes(properties, stringBuffer);
        buildForSort(stringBuffer, sortExpression, sortDirection);

        Query query = entityManager.createQuery(stringBuffer.toString());

        setWhereClauseSimpleAttributes(properties, query);
        setWhereClauseDatetime(properties, query);
        setWhereClauseReferenceAttributes(properties, query);
        setWhereClauseListAttributes(properties, query);
        setForPage(firstItem, maxPageItems, query);
//        setForSort(sortExpression, sortDirection, query);

        List<GoithauEntity> goithaus = query.getResultList();
        return new Object[]{countForList(properties, sortExpression, sortExpression), goithaus };
    }

    @Override
    public void updateStatusGoiThau(Long msgoithau, Long mstinhtrang) {
        StringBuffer sql = new StringBuffer("UPDATE GoithauEntity e SET e.tinhtrang.mstinhtrang = :mstinhtrang ");
        sql.append(" WHERE e.msgoithau = :msgoithau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("mstinhtrang", mstinhtrang)
                .setParameter("msgoithau", msgoithau);
        query.executeUpdate();
    }

    private Integer countForList(Map<String, Object> properties, String sortExpression, String sortDirection) {
        StringBuffer stringBuffer = new StringBuffer("SELECT COUNT(goithau.msgoithau) FROM GoithauEntity goithau WHERE 1 = 1 ");

        buildWhereClauseSimpleAttributes(properties, stringBuffer);
        buildWhereClauseDatetime(properties, stringBuffer);
        buildWhereClauseReferenceAttributes(properties, stringBuffer);
        buildWhereClauseListAttributes(properties, stringBuffer);
//        buildForSort(stringBuffer);

        Query query = entityManager.createQuery(stringBuffer.toString());

        setWhereClauseSimpleAttributes(properties, query);
        setWhereClauseDatetime(properties, query);
        setWhereClauseReferenceAttributes(properties, query);
        setWhereClauseListAttributes(properties, query);
//        setForSort(sortExpression, sortDirection, query);

        return Integer.valueOf(query.getSingleResult().toString());
    }

    private StringBuffer buildWhereClauseSimpleAttributes(Map<String, Object> properties, StringBuffer stringBuffer){
        if(properties.get("soqd") != null){
            stringBuffer.append(" AND goithau.soqd LIKE :soqd ");
        }
        if(properties.get("magoithau") != null){
            stringBuffer.append(" AND goithau.magoithau =:magoithau ");
        }
        if(properties.get("tengoithau") != null){
            stringBuffer.append(" AND goithau.tengoithau LIKE :tengoithau ");
        }

        if(properties.get("msnguonvon") != null){
            stringBuffer.append(" AND goithau.nguonvon.msnguonvon =:msnguonvon ");
        }
        if(properties.get("msloai") != null){
            stringBuffer.append(" AND goithau.loai.msloai =:msloai ");
        }
        if(properties.get("departmentId") != null){
            stringBuffer.append(" AND goithau.department.departmentId =:departmentId ");
        }

        if(properties.get("msquimo") != null){
            stringBuffer.append(" AND goithau.quimo.msquimo =:msquimo ");
        }

        return stringBuffer;
    }

    private StringBuffer buildWhereClauseDatetime(Map<String, Object> properties, StringBuffer stringBuffer){
        if(properties.get("fromDate") != null){
            stringBuffer.append(" AND goithau.ngayqd >= :fromDate ");
        }
        if(properties.get("toDate") != null){
            stringBuffer.append(" AND goithau.ngayqd <= :toDate ");
        }
        return stringBuffer;
    }

    private StringBuffer buildWhereClauseReferenceAttributes(Map<String, Object> properties, StringBuffer stringBuffer){
        if(properties.get("chuTri") != null && Long.valueOf(properties.get("chuTri").toString()) > 0){
            stringBuffer.append(" AND goithau.msgoithau IN ( SELECT goithaunhanvien.goithau.msgoithau FROM GoithauNhanvienEntity goithaunhanvien WHERE goithaunhanvien.user.userId =:chuTri AND goithaunhanvien.ischutri = 1 ) ");
        }
        if(properties.get("nhanvien") != null && Long.valueOf(properties.get("nhanvien").toString()) > 0){
            stringBuffer.append(" AND goithau.msgoithau IN ( SELECT goithaunhanvien.goithau.msgoithau FROM GoithauNhanvienEntity goithaunhanvien WHERE goithaunhanvien.user.userId =:nhanvien ) ");
        }
        if(properties.get("tuKe") != null){
            stringBuffer.append(" AND goithau.msgoithau IN ( SELECT hs.goithau.msgoithau FROM HosoluutruEntity hs WHERE hs.soke >=:tuKe ) ");
        }
        if(properties.get("denKe") != null){
            stringBuffer.append(" AND goithau.msgoithau IN ( SELECT hs.goithau.msgoithau FROM HosoluutruEntity hs WHERE hs.soke <=:denKe ) ");
        }
        if(properties.get("tuTu") != null){
            stringBuffer.append(" AND goithau.msgoithau IN ( SELECT hs.goithau.msgoithau FROM HosoluutruEntity hs WHERE hs.sotu >=:tuTu ) ");
        }
        if(properties.get("denTu") != null){
            stringBuffer.append(" AND goithau.msgoithau IN ( SELECT hs.goithau.msgoithau FROM HosoluutruEntity hs WHERE hs.sotu <=:denTu ) ");
        }
        return stringBuffer;
    }

    private StringBuffer buildWhereClauseListAttributes(Map<String, Object> properties, StringBuffer stringBuffer){
        if(properties.get("listTinhTrangs") != null && ((List<Long>)properties.get("listTinhTrangs")).size() > 0){
            stringBuffer.append(" AND goithau.tinhtrang.mstinhtrang IN (:listTinhTrangs) ");
        }
        if(properties.get("listHinhThucs") != null && ((List<Long>)properties.get("listHinhThucs")).size() > 0){
            stringBuffer.append(" AND goithau.hinhthucgt.mshinhthuc IN (:listHinhThucs) ");
        }
        if(properties.get("tinhTrangs") != null){
            stringBuffer.append(" AND goithau.tinhtrang != NULL ");
        }
        if(properties.get("listHinhThucs") != null){
            stringBuffer.append(" AND goithau.hinhthucgt != NULL ");
        }

        return stringBuffer;
    }

    private void setWhereClauseSimpleAttributes(Map<String, Object> properties, Query query){
        if(properties.get("soqd") != null){
            query.setParameter("soqd", "%" + properties.get("soqd") + "%");
        }
        if(properties.get("magoithau") != null){
            query.setParameter("magoithau", properties.get("magoithau"));
        }
        if(properties.get("tengoithau") != null){
            query.setParameter("tengoithau", "%" + properties.get("tengoithau") + "%");
        }

        if(properties.get("msnguonvon") != null){
            query.setParameter("msnguonvon", properties.get("msnguonvon"));
        }
        if(properties.get("msloai") != null){
            query.setParameter("msloai", properties.get("msloai"));
        }
        if(properties.get("departmentId") != null){
            query.setParameter("departmentId", properties.get("departmentId"));
        }

        if(properties.get("msquimo") != null){
            query.setParameter("msquimo", properties.get("msquimo"));
        }
    }

    private void setWhereClauseDatetime(Map<String, Object> properties, Query query) {
        if(properties.get("fromDate") != null){
            query.setParameter("fromDate", properties.get("fromDate"));
        }
        if(properties.get("toDate") != null){
            query.setParameter("toDate", properties.get("toDate"));
        }
    }

    private void setWhereClauseReferenceAttributes(Map<String, Object> properties, Query query){
        if(properties.get("chuTri") != null && Long.valueOf(properties.get("chuTri").toString()) > 0){
            query.setParameter("chuTri", properties.get("chuTri"));
        }
        if(properties.get("nhanvien") != null && Long.valueOf(properties.get("nhanvien").toString()) > 0){
            query.setParameter("nhanvien", properties.get("nhanvien"));
        }
        if(properties.get("tuKe") != null){
            query.setParameter("tuKe", properties.get("tuKe"));
        }
        if(properties.get("denKe") != null){
            query.setParameter("denKe", properties.get("denKe"));
        }
        if(properties.get("tuTu") != null){
            query.setParameter("tuTu", properties.get("tuTu"));
        }
        if(properties.get("denTu") != null){
            query.setParameter("denTu", properties.get("denTu"));
        }
    }

    private void setWhereClauseListAttributes(Map<String, Object> properties, Query query){
        if(properties.get("listTinhTrangs") != null && ((List<Long>)properties.get("listTinhTrangs")).size() > 0){
            query.setParameter("listTinhTrangs", properties.get("listTinhTrangs"));
        }
        if(properties.get("listHinhThucs") != null && ((List<Long>)properties.get("listHinhThucs")).size() > 0){
            query.setParameter("listHinhThucs", properties.get("listHinhThucs"));
        }
    }

    private void setForPage(Integer firstItem, Integer maxPageItems, Query query){
        query.setFirstResult(firstItem);
        query.setMaxResults(maxPageItems);
    }

    private StringBuffer buildForSort(StringBuffer stringBuffer, String sortExpression, String sortDirection ){
        if(sortExpression != null && sortDirection != null){
            stringBuffer.append(" ORDER BY ");
            stringBuffer.append(" " + sortExpression + " ");
            if(sortDirection.equals("1")){
                stringBuffer.append(" ASC ");
            } else{
                stringBuffer.append(" DESC ");
            }
        }
        return stringBuffer;
    }

    private void setForSort(String sortExpression, String sortDirection, Query query){
        query.setParameter("sortExpression",sortExpression);
        query.setParameter("sortDirection",sortDirection);
    }

    @Override
    public Long findMAX() {
//        StringBuffer stringBuffer = new StringBuffer("SELECT MAX(gt.magoithau) FROM GoithauEntity gt");
//        Query query = entityManager.createQuery(stringBuffer.toString());
//        return (BigDecimal)query.getSingleResult();

        StringBuffer sql = new StringBuffer("select max(magoithau) from goithau");
        Query query = entityManager.createNativeQuery(sql.toString());
        return Long.parseLong(query.getSingleResult().toString()) ;
    }
//    public BigDecimal findMAX() {
//        StringBuffer stringBuffer = new StringBuffer("SELECT MAX(gt.magoithau) FROM GoithauEntity gt");
//        Query query = entityManager.createQuery(stringBuffer.toString());
//        String maxString = query.getSingleResult().toString();
//        if(maxString.charAt(0) != '0'){
//            return BigDecimal.valueOf(Double.valueOf(maxString));
//        }
//        return BigDecimal.valueOf(Double.parseDouble(maxString.substring(1)));
//    }
}
