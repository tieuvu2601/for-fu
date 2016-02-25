package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.UserRoleACLEntity;
import com.banvien.vmsreport.core.data.session.UserRoleACLLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserRoleACLSessionEJB")
public class UserRoleACLSessionBean extends AbstractSessionBean<UserRoleACLEntity, Long> implements UserRoleACLLocalBean{
    public UserRoleACLSessionBean() {
    }

    @Override
    public void deleteByUserId(Long userId) {
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append("  DELETE FROM UserRoleACLEntity WHERE user.userId = :userId ");
        Query query = entityManager.createQuery(sqlQueryClause.toString());
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM UserRoleACLEntity WHERE role.roleId = :roleId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("roleId", roleId);
        query.executeUpdate();
    }

    @Override
    public void deleteByUserIdAndRoleId(Long userId, Long roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM UserRoleACLEntity WHERE user.userId = :userId AND role.roleId = :roleId")  ;
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("userId", userId)
                                    .setParameter("roleId", roleId);
        query.executeUpdate();
    }

    @Override
    public void deleteAllByUser(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM UserRoleACLEntity WHERE user.userId = :userId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public List<Long> findIdsByUser(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ura.role.roleId FROM UserRoleACLEntity ura WHERE ura.user.userId = :userId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("userId", userId);
        return (List<Long>)query.getResultList();
    }
}
