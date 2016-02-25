package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DangbaoEntity;
import com.banvien.vmsreport.core.data.session.DangBaoLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "DangBaoSessionEJB")
public class DangBaoSessionBean extends AbstractSessionBean<DangbaoEntity,Long> implements DangBaoLocalBean{
    public DangBaoSessionBean(){

    }

    @Override
    public List<DangbaoEntity> findByGoiThau(Long msgoithau) {
        StringBuffer sql = new StringBuffer("FROM DangbaoEntity e WHERE e.goithau.msgoithau = :msgoithau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", msgoithau);
        return query.getResultList();
    }

    @Override
    public void deteteByGoiThauId(Long goiThauId) {
        StringBuffer str = new StringBuffer("DELETE FROM DangbaoEntity td WHERE td.goithau.msgoithau =:goiThauId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }
}
