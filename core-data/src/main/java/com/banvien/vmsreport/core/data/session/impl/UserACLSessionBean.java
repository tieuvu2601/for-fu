package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.UserACLEntity;
import com.banvien.vmsreport.core.data.session.UserACLLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserACLSessionEJB")
public class UserACLSessionBean extends AbstractSessionBean<UserACLEntity, Long> implements UserACLLocalBean{
    public UserACLSessionBean() {
    }

    @Override
    public void deleteAllByUser(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM UserACLEntity WHERE user.userId = :userId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public List<Long> findIdsByUser(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT uacl.userACLId FROM UserACLEntity uacl WHERE uacl.user.userId = :userId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("userId", userId);
        return (List<Long>)query.getResultList();
    }

    @Override
    public void deleteByUserId(Long userId) {
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append("  DELETE FROM UserACLEntity WHERE user.userId = :userId ");
        Query query = entityManager.createQuery(sqlQueryClause.toString());
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public void deleteByUserIdAndPermissionId(Long userId, Long permissionId) {
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append("  DELETE FROM UserACLEntity WHERE user.userId = :userId AND permission.permissionId = :permissionId");
        Query query = entityManager.createQuery(sqlQueryClause.toString());
        query.setParameter("userId", userId);
        query.setParameter("permissionId", permissionId);
        query.executeUpdate();
    }
}
