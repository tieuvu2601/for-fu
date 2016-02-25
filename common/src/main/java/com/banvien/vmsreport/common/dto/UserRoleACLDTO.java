package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserRoleACLDTO implements Serializable{
    private static final long serialVersionUID = -6625785206997682351L;
    private Long userRoleACLId;
    private UserDTO user;
    private RoleDTO role;
    private List<PermissionDTO> permissionDTOs;

    public Long getUserRoleACLId() {
        return userRoleACLId;
    }

    public void setUserRoleACLId(Long userRoleACLId) {
        this.userRoleACLId = userRoleACLId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public List<PermissionDTO> getPermissionDTOs() {
        return permissionDTOs;
    }

    public void setPermissionDTOs(List<PermissionDTO> permissionDTOs) {
        this.permissionDTOs = permissionDTOs;
    }
}
