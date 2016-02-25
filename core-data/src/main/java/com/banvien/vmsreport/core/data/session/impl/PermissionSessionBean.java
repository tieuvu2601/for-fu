package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;
import com.banvien.vmsreport.core.data.session.PermissionLocalBean;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DEll
 * Date: 8/18/15
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "PermissionSessionEJB")
public class PermissionSessionBean extends AbstractSessionBean<PermissionEntity, Long> implements PermissionLocalBean {
//    @Override
//    public List<PermissionEntity> findPermissionsNotInUser(Long userId, String permissionFilterCode, String permissionFilterName) {
//        StringBuilder sql = new StringBuilder();
//        sql.append("  FROM PermissionEntity p ")
//            .append(" WHERE NOT EXISTS (SELECT ua.userACLId FROM UserACLEntity ua ")
//            .append("                   WHERE ua.user.userId = :userId AND ua.permission.permissionId = p.permissionId) ")
//            .append("       AND NOT EXISTS (SELECT racl.roleACLId FROM RoleACLEntity racl ")
//            .append("                       WHERE racl.permission.permissionId = p.permissionId ")
//            .append("                               AND EXISTS (SELECT ura.userRoleACLId FROM UserRoleACLEntity ura ")
//            .append("                                           WHERE ura.role.roleId = racl.role.roleId AND ura.user.userId = :userId)) ");
//        if(StringUtils.isNotBlank(permissionFilterCode)){
//            sql.append("    AND p.code like :code ");
//        }
//        if(StringUtils.isNotBlank(permissionFilterName)){
//            sql.append("    AND p.name like :name ");
//        }
//        sql.append(" ORDER BY p.code ");
//        Query query = entityManager.createQuery(sql.toString())
//                                    .setParameter("userId", userId);
//        if(StringUtils.isNotBlank(permissionFilterCode)){
//            query.setParameter("code", "%" + permissionFilterCode + "%");
//        }
//        if(StringUtils.isNotBlank(permissionFilterName)){
//            query.setParameter("name", "%" + permissionFilterName + "%");
//        }
//        return (List<PermissionEntity>) query.getResultList();
//    }

    @Override
    public List<PermissionEntity> findPermissionsNotInUser(Long userId, String permissionFilterCode, String permissionFilterName) {
        StringBuilder sql = new StringBuilder();
        sql.append("  FROM PermissionEntity p ")
                .append("       WHERE NOT EXISTS(SELECT ugracl.userGroupRoleACLId FROM UserGroupRoleACLEntity ugracl, UserEntity u, RoleACLEntity r  ")
                .append("                       WHERE ugracl.usergroup.userGroupId = u.userGroup.userGroupId AND u.userId = :userId and ugracl.role.roleId = r.role.roleId ")
                .append("                        AND r.permission.permissionId = p.permissionId )")
                .append("       AND NOT EXISTS (SELECT ua.userACLId FROM UserACLEntity ua ")
                .append("                   WHERE ua.user.userId = :userId AND ua.permission.permissionId = p.permissionId) ");

        if(StringUtils.isNotBlank(permissionFilterCode)){
            sql.append("    AND p.code like :code ");
        }
        if(StringUtils.isNotBlank(permissionFilterName)){
            sql.append("    AND p.name like :name ");
        }
        sql.append(" ORDER BY p.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("userId", userId);
        if(StringUtils.isNotBlank(permissionFilterCode)){
            query.setParameter("code", "%" + permissionFilterCode + "%");
        }
        if(StringUtils.isNotBlank(permissionFilterName)){
            query.setParameter("name", "%" + permissionFilterName + "%");
        }
        return (List<PermissionEntity>) query.getResultList();
    }

    @Override
    public List<PermissionEntity> findPermissionsInUser(Long userId, String permissionFilterCode, String permissionFilterName) {
        StringBuilder sql = new StringBuilder();
        sql.append("  FROM PermissionEntity p ")
                .append("       WHERE  (EXISTS(SELECT ugracl.userGroupRoleACLId FROM UserGroupRoleACLEntity ugracl, UserEntity u, RoleACLEntity r  ")
                .append("                       WHERE ugracl.usergroup.userGroupId = u.userGroup.userGroupId AND u.userId = :userId and ugracl.role.roleId = r.role.roleId ")
                .append("                        AND r.permission.permissionId = p.permissionId )")
                .append("       OR EXISTS (SELECT ua.userACLId FROM UserACLEntity ua ")
                .append("                   WHERE ua.user.userId = :userId AND ua.permission.permissionId = p.permissionId)) ");

        if(StringUtils.isNotBlank(permissionFilterCode)){
            sql.append("    AND p.code like :code ");
        }
        if(StringUtils.isNotBlank(permissionFilterName)){
            sql.append("    AND p.name like :name ");
        }
        sql.append(" ORDER BY p.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("userId", userId);
        if(StringUtils.isNotBlank(permissionFilterCode)){
            query.setParameter("code", "%" + permissionFilterCode + "%");
        }
        if(StringUtils.isNotBlank(permissionFilterName)){
            query.setParameter("name", "%" + permissionFilterName + "%");
        }
        return (List<PermissionEntity>) query.getResultList();
    }

    @Override
    public List<PermissionEntity> findByRole(Long roleId, Long permissionGroupId) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT p FROM PermissionEntity p ")
            .append(" WHERE 1 = 1 ");
        if(permissionGroupId != null){
            sql.append("    AND p.permissionGroup.permissionGroupId = :permissionGroupId ");
        }
        sql.append("        AND EXISTS (SELECT ra.roleACLId FROM RoleACLEntity ra ")
            .append("               WHERE ra.role.roleId = :roleId AND ra.permission.permissionId = p.permissionId) ORDER BY p.permissionGroup.code, p.code ");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("roleId", roleId);
        if(permissionGroupId != null){
            query.setParameter("permissionGroupId", permissionGroupId);
        }
        return (List<PermissionEntity>)query.getResultList();
    }

    @Override
    public List<Long> findIdsByRole(Long roleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT p.permissionId FROM PermissionEntity p ")
                .append(" WHERE EXISTS (SELECT ra.roleACLId FROM RoleACLEntity ra ")
                .append("               WHERE ra.role.roleId = :roleId AND ra.permission.permissionId = p.permissionId) ORDER BY p.permissionGroup.code, p.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("roleId", roleId);
        return (List<Long>)query.getResultList();
    }

    @Override
    public List<PermissionEntity> findNotInRole(Long roleId, Long permissionGroupId) {
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT p FROM PermissionEntity p ")
            .append(" WHERE 1 = 1 ");
        if(permissionGroupId != null){
            sql.append("    AND p.permissionGroup.permissionGroupId = :permissionGroupId ");
        }
        sql.append("        AND NOT EXISTS (SELECT ra.roleACLId FROM RoleACLEntity ra ")
            .append("               WHERE ra.role.roleId = :roleId AND ra.permission.permissionId = p.permissionId) ORDER BY p.permissionGroup.code, p.code ");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("roleId", roleId);
        if(permissionGroupId != null){
            query.setParameter("permissionGroupId", permissionGroupId);
        }
        return (List<PermissionEntity>)query.getResultList();
    }

    @Override
    public List<PermissionEntity> findPermissionOfUser(Long userId) {

        StringBuilder sqlQuery = new StringBuilder("SELECT p FROM PermissionEntity p WHERE EXISTS(SELECT userACLId FROM UserACLEntity uacl WHERE uacl.user.userId = :userId AND uacl.permission.permissionId = p.permissionId)");
        sqlQuery.append(" OR EXISTS(SELECT uracl.userRoleACLId FROM UserRoleACLEntity uracl, RoleACLEntity r WHERE uracl.role.roleId = r.role.roleId AND uracl.user.userId = :userId and r.permission.permissionId = p.permissionId)");
        sqlQuery.append(" OR EXISTS(SELECT ugracl.userGroupRoleACLId FROM UserGroupRoleACLEntity ugracl, UserEntity u, RoleACLEntity r WHERE ugracl.usergroup.userGroupId = u.userGroup.userGroupId AND u.userId = :userId and ugracl.role.roleId = r.role.roleId ")
                .append(" AND r.permission.permissionId = p.permissionId )");

        Query query = entityManager.createQuery(sqlQuery.toString());
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<PermissionEntity> getPermissionListByPermissionSystem(Long userId) {
        List<String> permissionSystems = new ArrayList<>();
        StringBuilder sqlQuery = new StringBuilder("SELECT p FROM PermissionEntity p WHERE ");
        sqlQuery.append(" EXISTS(SELECT 1 FROM PermissionGroupEntity pge WHERE pge.permissionGroupId = p.permissionGroup.permissionGroupId AND pge.code in (:permissionSystem) ) ");
        sqlQuery.append(" AND (EXISTS(SELECT userACLId FROM UserACLEntity uacl WHERE uacl.user.userId = :userId AND uacl.permission.permissionId = p.permissionId) ");
        sqlQuery.append(" OR EXISTS(SELECT uracl.userRoleACLId FROM UserRoleACLEntity uracl, RoleACLEntity r WHERE uracl.role.roleId = r.role.roleId AND uracl.user.userId = :userId and r.permission.permissionId = p.permissionId)");
        sqlQuery.append(" OR EXISTS(SELECT ugracl.userGroupRoleACLId FROM UserGroupRoleACLEntity ugracl, UserEntity u, RoleACLEntity r WHERE ugracl.usergroup.userGroupId = u.userGroup.userGroupId AND u.userId = :userId and ugracl.role.roleId = r.role.roleId ")
                .append(" AND r.permission.permissionId = p.permissionId ))");

        Query query = entityManager.createQuery(sqlQuery.toString());
        query.setParameter("userId", userId);

        permissionSystems.add(Constants.MANAGE_USER);
        permissionSystems.add(Constants.MANAGE_TEAM);
        permissionSystems.add(Constants.MANAGE_PACKAGE_TYPE);
        permissionSystems.add(Constants.MANAGE_PACKAGE_GROUP);
        permissionSystems.add(Constants.MANAGE_ROLE);
        permissionSystems.add(Constants.MANAGE_USERGROUP);
        query.setParameter("permissionSystem", permissionSystems);
        return query.getResultList();
    }



}
