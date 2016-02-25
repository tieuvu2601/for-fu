package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.RoleACLEntity;
import com.banvien.vmsreport.core.data.session.RoleACLLocalBean;

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
@Stateless(name = "RoleACLSessionEJB")
public class RoleACLSessionBean extends AbstractSessionBean<RoleACLEntity, Long> implements RoleACLLocalBean{
    public RoleACLSessionBean() {
    }

    @Override
    public List<RoleACLEntity> findByUser(Long userId) {
        StringBuffer sqlQuery = new StringBuffer();
        sqlQuery.append(" FROM RoleACLEntity ra ")
                .append(" WHERE EXISTS (SELECT 1 FROM UserRoleACLEntity ura WHERE ura.user.userId = :userId AND ra.role.roleId = ura.role.roleId) ");
        Query query = entityManager.createQuery(sqlQuery.toString())
                                .setParameter("userId", userId);
        return (List<RoleACLEntity>)query.getResultList();
    }

    @Override
    public void deleteByRoleId(Long roleID) {
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append("  DELETE FROM RoleACLEntity WHERE role.roleId = :roleId ");
        Query query = entityManager.createQuery(sqlQueryClause.toString());
        query.setParameter("roleId", roleID);
        query.executeUpdate();
    }

    @Override
    public List<Long> findByRoleId(Long roleId) {
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" SELECT permission.permissionId FROM RoleACLEntity WHERE role.roleId = :role_Id ");
        Query query = entityManager.createQuery(sqlQueryClause.toString());
        query.setParameter("role_Id", roleId);
        return query.getResultList();
    }

    @Override
    public void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        StringBuilder sqlQueryClause = new StringBuilder();
        sqlQueryClause.append(" DELETE FROM RoleACLEntity WHERE role.roleId = :role_Id AND permission.permissionId = :permissionId ");
        Query query = entityManager.createQuery(sqlQueryClause.toString());
        query.setParameter("role_Id", roleId);
        query.setParameter("permissionId", permissionId);
        query.executeUpdate();
    }

    @Override
    public void deleteAllByRole(Long roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM RoleACLEntity WHERE role.roleId = :roleId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("roleId", roleId);
        query.executeUpdate();
    }

    @Override
    public List<Long> findIdsByRole(Long roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ra.roleACLId FROM RoleACLEntity ra WHERE ra.role.roleId = :roleId ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("roleId", roleId);
        return (List<Long>)query.getResultList();
    }
}
