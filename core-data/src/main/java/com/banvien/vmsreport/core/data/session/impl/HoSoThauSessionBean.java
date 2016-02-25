package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.entity.HosothauEntity;
import com.banvien.vmsreport.core.data.session.HoSoThauLocalBean;

import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/17/15
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "HoSoThauSessionEJB")
public class HoSoThauSessionBean extends AbstractSessionBean<HosothauEntity, Long> implements HoSoThauLocalBean {
    @Override
    public List<HosothauEntity> findByGoiThau(Long msgoithau) {
        StringBuffer sql = new StringBuffer("FROM HosothauEntity e WHERE e.goithau_nhathau.goithau.msgoithau = :msgoithau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", msgoithau);
        return query.getResultList();
    }

    @Override
    public HosothauEntity findHoSoTrungThauByGoiThau(Long goiThauId) {
        StringBuffer sql = new StringBuffer("FROM HosothauEntity e WHERE e.goithau_nhathau.goithau.msgoithau = :msgoithau");
        sql.append(" AND e.goithau_nhathau.istrungthau = 1");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", goiThauId);
        return (HosothauEntity)query.getSingleResult();
    }

    @Override
    public HosothauEntity findByGoiThauNhaThau(Long gt_nt) {
        StringBuffer sql = new StringBuffer("FROM HosothauEntity e WHERE e.goithau_nhathau.msgoithauNt = :msgoithaunt");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithaunt", gt_nt);
        return (HosothauEntity)query.getSingleResult();

    }

    @Override
    public void deleteHoSoGoiThauNhaThau(Long gt_nt) {
        StringBuffer sql = new StringBuffer("DELETE FROM HosothauEntity e WHERE e.goithau_nhathau.msgoithauNt = :msgoithaunt");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithaunt", gt_nt);
        query.executeUpdate();
    }

    @Override
    public void deteteByGoiThauId(Long goiThauId) {
        StringBuffer sql = new StringBuffer("DELETE FROM HosothauEntity hste WHERE hste.goithau_nhathau.msgoithauNt IN ( SELECT gtnt.msgoithauNt FROM GoithauNhathauEntity gtnt WHERE gtnt.goithau.msgoithau = :goiThauId) ");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }
}
