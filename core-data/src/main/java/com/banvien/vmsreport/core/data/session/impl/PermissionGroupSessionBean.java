package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.PermissionGroupEntity;
import com.banvien.vmsreport.core.data.session.PermissionGroupLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/1/15
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "PermissionGroupSessionEJB")
public class PermissionGroupSessionBean extends AbstractSessionBean<PermissionGroupEntity, Long> implements PermissionGroupLocalBean{
    public PermissionGroupSessionBean() {
    }

    @Override
    public List<PermissionGroupEntity> findAllAndOrder() {
        StringBuilder sql = new StringBuilder();
        sql.append(" FROM PermissionGroupEntity ORDER BY code ");
        Query query = entityManager.createQuery(sql.toString());
        return (List<PermissionGroupEntity>)query.getResultList();
    }
}
