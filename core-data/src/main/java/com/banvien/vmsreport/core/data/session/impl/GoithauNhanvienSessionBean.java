package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.GoithauNhanvienEntity;
import com.banvien.vmsreport.core.data.session.GoithauNhanvienLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/10/15
 * Time: 9:25 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "GoithauNhanvienSessionEJB")
public class GoithauNhanvienSessionBean extends AbstractSessionBean<GoithauNhanvienEntity, Long> implements GoithauNhanvienLocalBean {
    public GoithauNhanvienSessionBean() {
    }

    @Override
    public void deleteByNhanVien(Long nhanvienId) {
        StringBuffer str = new StringBuffer("DELETE FROM GoithauNhanvienEntity gn WHERE gn.user.userId =:nhanvienId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("nhanvienId", nhanvienId);
        query.executeUpdate();
    }

    @Override
    public void deteteByGoiThauId(Long goiThauId) {
        StringBuffer str = new StringBuffer("DELETE FROM GoithauNhanvienEntity gn WHERE gn.goithau.msgoithau =:goiThauId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }

    @Override
    public List<GoithauNhanvienEntity> findByGoiThau(Long msgoithau) {
        StringBuffer sql = new StringBuffer("FROM GoithauNhanvienEntity e WHERE e.goithau.msgoithau = :goithauid");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("goithauid", msgoithau);
        return query.getResultList() ;
    }


}
