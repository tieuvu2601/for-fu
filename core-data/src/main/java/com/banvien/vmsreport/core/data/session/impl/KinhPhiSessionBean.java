package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.KinhphiEntity;
import com.banvien.vmsreport.core.data.session.KinhPhiLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "KinhPhiSessionEJB")
public class KinhPhiSessionBean extends AbstractSessionBean<KinhphiEntity, Long> implements KinhPhiLocalBean{
    public KinhPhiSessionBean() {
    }

    @Override
    public List<KinhphiEntity> findByGoiThau(Long msgoithau) {
        StringBuffer sql = new StringBuffer("FROM KinhphiEntity e WHERE e.goithau.msgoithau = :msgoithau");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("msgoithau", msgoithau);
        return query.getResultList();
    }

    @Override
    public void deleteByGoiThauId(Long goiThauId) {
        StringBuffer str = new StringBuffer("DELETE FROM KinhphiEntity kpe WHERE kpe.goithau.msgoithau =:goiThauId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }
}
