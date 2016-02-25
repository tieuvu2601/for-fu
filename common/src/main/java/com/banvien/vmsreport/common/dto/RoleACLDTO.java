package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleACLDTO implements Serializable{
    private static final long serialVersionUID = 8308891515148338298L;
    private Long roleACLId;
    private RoleDTO role;
    private PermissionDTO permission;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

    public Long getRoleACLId() {
        return roleACLId;
    }

    public void setRoleACLId(Long roleACLId) {
        this.roleACLId = roleACLId;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
