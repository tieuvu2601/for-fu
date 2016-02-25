package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermissionDTO implements Serializable{
    private static final long serialVersionUID = -5178314320908070221L;
    private Long permissionId;
    private String code;
    private String name;
    private PermissionGroupDTO permissionGroup;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionGroupDTO getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(PermissionGroupDTO permissionGroup) {
        this.permissionGroup = permissionGroup;
    }
}
