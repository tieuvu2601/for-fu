package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.UserACLDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 9/1/15
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserACLCommand extends AbstractCommand<UserACLDTO> {
    public UserACLCommand(){
        this.pojo = new UserACLDTO();
    }

    Long[] userACLIds;
    Long[] userRoleACLIds;
    String[] userAreaACLIds;
    Long[] roleIds;
    Long[] permissionIds;
    String[] districtCodes;
    Integer roleFilterType = 1;       // 0: is not managing; 1: is managing.
    Integer permissionFilterType = 1; // 0: is not managing; 1: is managing.
    Integer districtFilterType = 1;
    String roleFilterCode;
    String roleFilterName;
    String permissionFilterCode;
    String permissionFilterName;
    String districtCode;

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Long[] permissionIds) {
        this.permissionIds = permissionIds;
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

    public String getPermissionFilterCode() {
        return permissionFilterCode;
    }

    public void setPermissionFilterCode(String permissionFilterCode) {
        this.permissionFilterCode = permissionFilterCode;
    }

    public String getPermissionFilterName() {
        return permissionFilterName;
    }

    public void setPermissionFilterName(String permissionFilterName) {
        this.permissionFilterName = permissionFilterName;
    }

    public Integer getRoleFilterType() {
        return roleFilterType;
    }

    public void setRoleFilterType(Integer roleFilterType) {
        this.roleFilterType = roleFilterType;
    }

    public Integer getPermissionFilterType() {
        return permissionFilterType;
    }

    public void setPermissionFilterType(Integer permissionFilterType) {
        this.permissionFilterType = permissionFilterType;
    }

    public Long[] getUserACLIds() {
        return userACLIds;
    }

    public void setUserACLIds(Long[] userACLIds) {
        this.userACLIds = userACLIds;
    }

    public Long[] getUserRoleACLIds() {
        return userRoleACLIds;
    }

    public void setUserRoleACLIds(Long[] userRoleACLIds) {
        this.userRoleACLIds = userRoleACLIds;
    }

    public Integer getDistrictFilterType() {
        return districtFilterType;
    }

    public void setDistrictFilterType(Integer districtFilterType) {
        this.districtFilterType = districtFilterType;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String[] getUserAreaACLIds() {
        return userAreaACLIds;
    }

    public void setUserAreaACLIds(String[] userAreaACLIds) {
        this.userAreaACLIds = userAreaACLIds;
    }

    public String[] getDistrictCodes() {
        return districtCodes;
    }

    public void setDistrictCodes(String[] districtCodes) {
        this.districtCodes = districtCodes;
    }
}
