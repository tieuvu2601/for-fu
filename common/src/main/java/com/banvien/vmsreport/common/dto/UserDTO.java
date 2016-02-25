package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/7/15
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -5342204262785873445L;
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private Integer status;
    private DepartmentDTO department;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String displayName;
    private UserGroupDTO userGroup;
    private Timestamp lastLoginDatTime;
    private Integer isLDAP;
    private List<PermissionDTO> permissions;
    private String avatar;
    private FileItem avatarFileItem;
    private Integer gioiTinh;
    private String hoNhanVien;
    private String tenNhanVien;
    private String chuyenNganh;
    private List<RoleACLDTO> roles ;
    private boolean xt;
    private boolean td;

    public boolean isXt() {
        return xt;
    }

    public void setXt(boolean xt) {
        this.xt = xt;
    }

    public boolean isTd() {
        return td;
    }

    public void setTd(boolean td) {
        this.td = td;
    }

    public List<RoleACLDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleACLDTO> roles) {
        this.roles = roles;
    }

    public Integer getLDAP() {
        return isLDAP;
    }

    public void setLDAP(Integer LDAP) {
        isLDAP = LDAP;
    }

    public Timestamp getLastLoginDatTime() {
        return lastLoginDatTime;
    }

    public void setLastLoginDatTime(Timestamp lastLoginDatTime) {
        this.lastLoginDatTime = lastLoginDatTime;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserGroupDTO getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupDTO userGroup) {
        this.userGroup = userGroup;
    }

    public List<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDTO> permissions) {
        this.permissions = permissions;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public FileItem getAvatarFileItem() {
        return avatarFileItem;
    }

    public void setAvatarFileItem(FileItem avatarFileItem) {
        this.avatarFileItem = avatarFileItem;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
}
