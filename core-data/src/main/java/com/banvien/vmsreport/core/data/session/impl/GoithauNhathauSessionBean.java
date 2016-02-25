package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.session.GoithauNhathauLocalBean;
import com.banvien.vmsreport.core.data.session.QuanLyNhaThauLocalBean;

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
@Stateless(name = "GoithauNhathauSessionEJB")
public class GoithauNhathauSessionBean extends AbstractSessionBean<GoithauNhathauEntity, Long> implements GoithauNhathauLocalBean {
    public GoithauNhathauSessionBean() {
    }

    @Override
    public List<GoithauNhathauEntity> findByGoiThau(Long msgoithau) {
        StringBuffer sql = new StringBuffer("FROM GoithauNhathauEntity e WHERE e.goithau.msgoithau = :msgoithau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", msgoithau);
        return query.getResultList();
    }

    @Override
    public void resetNhaThauTrungThau(Long msgoithau) {
        StringBuffer sql = new StringBuffer("UPDATE GoithauNhathauEntity e " +
                "SET e.istrungthau = 0 " +
                "WHERE e.goithau.msgoithau = :msgoithau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", msgoithau);
        query.executeUpdate();
    }

    @Override
    public void updateTrungThauNhaThau(Long msNTTT) {
        StringBuffer sql = new StringBuffer("UPDATE GoithauNhathauEntity e " +
                "SET e.istrungthau = 1 " +
                "WHERE e.msgoithauNt = (SELECT hst.goithau_nhathau.msgoithauNt FROM HosothauEntity hst WHERE hst.mshosothau = :msgoithaunt)");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithaunt", msNTTT);
        query.executeUpdate();
    }

    @Override
    public void deteteByGoiThauId(Long goiThauId) {
        StringBuffer str = new StringBuffer("DELETE FROM GoithauNhathauEntity e WHERE e.goithau.msgoithau =:goiThauId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }

    @Override
    public GoithauNhathauEntity findByGoiThauAndNhanThau(Long goithauid, Long msNhaThau) {
        StringBuffer sql = new StringBuffer("FROM GoithauNhathauEntity e WHERE e.goithau.msgoithau = :msgoithau")
                                    .append(" AND e.nhathau.msnhathau = :msNhaThau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", goithauid)
                .setParameter("msNhaThau", msNhaThau);
        return (GoithauNhathauEntity) query.getSingleResult();
    }

}
