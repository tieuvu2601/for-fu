package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupRoleACLDTO implements Serializable {
    private Long userGroupRoleACLId;
    private UserGroupDTO userGroup;
    private RoleDTO role;

    public Long getUserGroupRoleACLId() {
        return userGroupRoleACLId;
    }

    public void setUserGroupRoleACLId(Long userGroupRoleACLId) {
        this.userGroupRoleACLId = userGroupRoleACLId;
    }

    public UserGroupDTO getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupDTO userGroup) {
        this.userGroup = userGroup;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
