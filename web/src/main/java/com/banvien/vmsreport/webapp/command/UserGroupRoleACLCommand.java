package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupRoleACLCommand extends AbstractCommand<UserGroupRoleACLDTO> {
    public UserGroupRoleACLCommand(){
        this.pojo = new UserGroupRoleACLDTO();
    }

    Integer roleFilterType = 1;       // 0: is not managing; 1: is managing.
    String roleFilterCode;
    String roleFilterName;
    Long[] userGroupRoleACLIds;
    Long[] roleIds;

    public Integer getRoleFilterType() {
        return roleFilterType;
    }

    public void setRoleFilterType(Integer roleFilterType) {
        this.roleFilterType = roleFilterType;
    }

    public String getRoleFilterCode() {
        return roleFilterCode;
    }

    public void setRoleFilterCode(String roleFilterCode) {
        this.roleFilterCode = roleFilterCode;
    }

    public String getRoleFilterName() {
        return roleFilterName;
    }

    public void setRoleFilterName(String roleFilterName) {
        this.roleFilterName = roleFilterName;
    }

    public Long[] getUserGroupRoleACLIds() {
        return userGroupRoleACLIds;
    }

    public void setUserGroupRoleACLIds(Long[] userGroupRoleACLIds) {
        this.userGroupRoleACLIds = userGroupRoleACLIds;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
}
