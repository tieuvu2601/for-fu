package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.RoleEntity;
import com.banvien.vmsreport.core.data.session.RoleLocalBean;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/19/15
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "RoleSessionEJB")
public class RoleSessionBean extends AbstractSessionBean<RoleEntity, Long> implements RoleLocalBean{
    public RoleSessionBean() {
    }

    @Override
    public List<RoleEntity> findRolesNotInUser(Long userId, String roleFilterCode, String roleFilterName) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT r FROM RoleEntity r ")
            .append(" WHERE NOT EXISTS (SELECT ur.userRoleACLId FROM UserRoleACLEntity ur WHERE ur.role.roleId = r.roleId AND ur.user.userId = :userId) ")
            .append(" AND NOT EXISTS (SELECT ugr.userGroupRoleACLId FROM UserGroupRoleACLEntity ugr, UserEntity u  WHERE ugr.role.roleId = r.roleId ")
            .append(" AND ugr.usergroup.userGroupId = u.userGroup.userGroupId  AND u.userId = :userId) ") ;
        if(StringUtils.isNotBlank(roleFilterCode)){
            sql.append("    AND r.code like :code ");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            sql.append("    AND r.name like :name ");
        }
        sql.append(" ORDER BY r.code ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("userId", userId);
        if(StringUtils.isNotBlank(roleFilterCode)){
            query.setParameter("code", "%" + roleFilterCode + "%");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            query.setParameter("name", "%" + roleFilterName+ "%");
        }
        return (List<RoleEntity>)query.getResultList();
    }

    @Override
    public List<RoleEntity> findRolesInUser(Long userId, String roleFilterCode, String roleFilterName) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT r FROM RoleEntity r ")
                .append(" WHERE (EXISTS (SELECT ur.userRoleACLId FROM UserRoleACLEntity ur WHERE ur.role.roleId = r.roleId AND ur.user.userId = :userId) ")
                .append(" OR EXISTS (SELECT ugr.userGroupRoleACLId FROM UserGroupRoleACLEntity ugr, UserEntity u  WHERE ugr.role.roleId = r.roleId ")
                .append(" AND ugr.usergroup.userGroupId = u.userGroup.userGroupId  AND u.userId = :userId)) ") ;
        if(StringUtils.isNotBlank(roleFilterCode)){
            sql.append("    AND r.code like :code ");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            sql.append("    AND r.name like :name ");
        }
        sql.append(" ORDER BY r.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("userId", userId);
        if(StringUtils.isNotBlank(roleFilterCode)){
            query.setParameter("code", "%" + roleFilterCode + "%");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            query.setParameter("name", "%" + roleFilterName+ "%");
        }
        return (List<RoleEntity>)query.getResultList();
    }

    @Override
    public List<RoleEntity> findRolesNotInUserGroup(Long userGroupId, String roleFilterCode, String roleFilterName) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT r FROM RoleEntity r ")
                .append(" WHERE NOT EXISTS (SELECT ugr.userGroupRoleACLId FROM UserGroupRoleACLEntity ugr WHERE ugr.role.roleId = r.roleId AND ugr.usergroup.userGroupId = :userGroupId) ");
        if(StringUtils.isNotBlank(roleFilterCode)){
            sql.append("  AND r.code like :code ");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            sql.append("  AND r.name like :name ");
        }
        sql.append(" ORDER BY r.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("userGroupId", userGroupId);
        if(StringUtils.isNotBlank(roleFilterCode)){
            query.setParameter("code", "%" + roleFilterCode + "%");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            query.setParameter("name", "%" + roleFilterName+ "%");
        }
        return (List<RoleEntity>)query.getResultList();
    }

    @Override
    public List<RoleEntity> findRolesInUserGroup(Long userGroupId, String roleFilterCode, String roleFilterName) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT r FROM RoleEntity r ")
                .append(" WHERE EXISTS (SELECT ugr.userGroupRoleACLId FROM UserGroupRoleACLEntity ugr WHERE ugr.role.roleId = r.roleId AND ugr.usergroup.userGroupId = :userGroupId) ");
        if(StringUtils.isNotBlank(roleFilterCode)){
            sql.append("  AND r.code like :code ");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            sql.append("  AND r.name like :name ");
        }
        sql.append(" ORDER BY r.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("userGroupId", userGroupId);
        if(StringUtils.isNotBlank(roleFilterCode)){
            query.setParameter("code", "%" + roleFilterCode + "%");
        }
        if(StringUtils.isNotBlank(roleFilterName)){
            query.setParameter("name", "%" + roleFilterName+ "%");
        }
        return (List<RoleEntity>)query.getResultList();
    }


}
