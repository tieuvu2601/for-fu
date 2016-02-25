package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/23/15
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupACLDTO implements Serializable {
    private static final long serialVersionUID = 5401360974663465015L;
    private Long userGroupACLId;
    private PermissionDTO permission;
    private UserGroupDTO userGroup;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

    public Long getUserGroupACLId() {
        return userGroupACLId;
    }

    public void setUserGroupACLId(Long userGroupACLId) {
        this.userGroupACLId = userGroupACLId;
    }

    public PermissionDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionDTO permission) {
        this.permission = permission;
    }

    public UserGroupDTO getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupDTO userGroup) {
        this.userGroup = userGroup;
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
