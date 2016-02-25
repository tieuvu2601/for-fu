package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmNhathauEntity;
import com.banvien.vmsreport.core.data.session.QuanLyNhaThauLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "QuanLyNhaThauSessionEJB")
public class QuanLyNhaThauSessionBean extends AbstractSessionBean<DmNhathauEntity, Long> implements QuanLyNhaThauLocalBean {
    public QuanLyNhaThauSessionBean() {
    }

    @Override
    public List<DmNhathauEntity> findByAllNotGoiThauCur(Long msGoiThau) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("FROM DmNhathauEntity nt WHERE NOT EXISTS (SELECT 1 FROM GoithauNhathauEntity gtnt WHERE nt.msnhathau = gtnt.nhathau.msnhathau AND  gtnt.goithau.msgoithau = :msGoiThau)");
        Query query = entityManager.createQuery(sqlQuery.toString());
        query.setParameter("msGoiThau",msGoiThau);
        return query.getResultList();
    }
}
