package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.UserGroupACLEntity;
import com.banvien.vmsreport.core.data.entity.UserGroupRoleACLEntity;
import com.banvien.vmsreport.core.data.session.GenericSessionBean;
import com.banvien.vmsreport.core.data.session.UserGroupRoleACLLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="UserGroupRoleACLSessionEJB")
public class UserGroupRoleACLSessionBean extends AbstractSessionBean<UserGroupRoleACLEntity, Long> implements UserGroupRoleACLLocalBean {
    public UserGroupRoleACLSessionBean(){

    }

    @Override
    public List<UserGroupRoleACLEntity> searchRoleByUserGroupId(Long userGroupId){
        if (userGroupId!= null && userGroupId > 0 ){
            StringBuffer sqlQuery = new StringBuffer(" FROM UserGroupACLEntity ugae WHERE 1 = 1 ");
            sqlQuery.append(" AND ugae.userGroup.userGroupId = :userGroupId ");
            Query query = entityManager.createQuery(sqlQuery.toString());
            query.setParameter("userGroupId", userGroupId);
            return (List<UserGroupRoleACLEntity>)query.getResultList();
        } else {
            return null;
        }
    }

    @Override
    public void deleteAllByUserGroup(Long userGroupId) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(" DELETE FROM UserGroupRoleACLEntity WHERE usergroup.userGroupId = :userGroupId");
        Query query = entityManager.createQuery(sqlQuery.toString())
                .setParameter("userGroupId", userGroupId);
        query.executeUpdate();
    }

    @Override
    public List<Long> findIdsByUserGroup(Long userGroupId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ura.userGroupRoleACLId FROM UserGroupRoleACLEntity ura WHERE ura.usergroup.userGroupId = :userGroupId ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("userGroupId", userGroupId);
        return (List<Long>)query.getResultList();

    }

    @Override
    public void deleteByRoleId(Long roleId) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(" DELETE FROM UserGroupRoleACLEntity WHERE role.roleId = :roleId");
        Query query = entityManager.createQuery(sqlQuery.toString())
                .setParameter("roleId", roleId);
        query.executeUpdate();
    }
}
