package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/1/15
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermissionGroupDTO implements Serializable{
    private static final long serialVersionUID = 3287217858044377204L;
    private Long permissionGroupId;
    private String code;
    private String description;

    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
