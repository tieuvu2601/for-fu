package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.RoleACLEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleACLLocalBean extends GenericSessionBean<RoleACLEntity, Long>{
    List<RoleACLEntity> findByUser(Long userId);

    void deleteByRoleId(Long roleID);

    List<Long> findByRoleId(Long roleId);

    void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId);

    void deleteAllByRole(Long roleId);

    List<Long> findIdsByRole(Long roleId);
}
