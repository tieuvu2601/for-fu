package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmCanCuEntity;
import com.banvien.vmsreport.core.data.session.CanCuLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "CanCuSessionEJB")
public class CanCuSessionBean extends AbstractSessionBean<DmCanCuEntity, Long> implements CanCuLocalBean{
    public CanCuSessionBean() {
    }

    @Override
    public DmCanCuEntity findByMaCanCu(String code) {
        StringBuffer sql = new StringBuffer("FROM DmCanCuEntity e WHERE e.maCanCu = :mcc");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("mcc", code.trim());
        return (DmCanCuEntity)query.getSingleResult();
    }
}
