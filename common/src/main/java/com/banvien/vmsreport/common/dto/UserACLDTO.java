package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserACLDTO implements Serializable{
    private static final long serialVersionUID = 6256265980410777231L;
    private Long userACLId;
    private UserDTO users;
    private PermissionDTO permission;

    public Long getUserACLId() {
        return userACLId;
    }

    public void setUserACLId(Long userACLId) {
        this.userACLId = userACLId;
    }

    public UserDTO getUsers() {
        return users;
    }

    public void setUsers(UserDTO users) {
        this.users = users;
    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }
}
