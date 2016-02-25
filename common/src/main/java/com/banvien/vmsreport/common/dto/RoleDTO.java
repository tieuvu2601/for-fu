package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/18/15
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoleDTO implements Serializable{
    private static final long serialVersionUID = 1462248964364559050L;
    private String code;
    private String name;
    private Long roleId;
    private List<PermissionDTO> permissions;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDTO> permissions) {
        this.permissions = permissions;
    }
}
