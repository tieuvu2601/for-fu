package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.RoleDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/18/15
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleCommand extends AbstractCommand<RoleDTO> {
    public RoleCommand(){
        this.pojo = new RoleDTO();
    }

    Integer roleFilterType = 1;    //0: is not managing; 1: is managing
    Long[] permissionIds;
    Long permissionGroupId;

    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public Integer getRoleFilterType() {
        return roleFilterType;
    }

    public void setRoleFilterType(Integer roleFilterType) {
        this.roleFilterType = roleFilterType;
    }

    public Long[] getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Long[] permissionIds) {
        this.permissionIds = permissionIds;
    }
}
