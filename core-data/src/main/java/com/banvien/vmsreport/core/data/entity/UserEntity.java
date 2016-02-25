package com.banvien.vmsreport.core.data.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@javax.persistence.Table(name = "Users")
@Entity
public class UserEntity {
    private Long userId;

    @javax.persistence.Column(name = "UserId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name="USERS_SEQ", sequenceName="USERS_SEQ", allocationSize=1)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String userName;

    @javax.persistence.Column(name = "UserName")
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String email;

    @javax.persistence.Column(name = "Email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String phoneNumber;

    @javax.persistence.Column(name = "DIENTHOAIDD")
    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String password;

    @javax.persistence.Column(name = "Password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String displayName;

    @javax.persistence.Column(name = "DisplayName")
    @Basic
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private Integer status;

    @javax.persistence.Column(name = "Status")
    @Basic
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "createdDate")
    @Basic
    private Timestamp createdDate;

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    private Timestamp modifiedDate;

    @Column(name = "ModifiedDate")
    @Basic
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    private DepartmentEntity department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId")
    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }


    private UserGroupEntity userGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @javax.persistence.JoinColumn(name = "UserGroupId", referencedColumnName = "UserGroupId")
    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
    }

    private Timestamp lastLoginDatTime;

    @Column(name = "LastLoginDatTime")
    @Basic
    public Timestamp getLastLoginDatTime() {
        return lastLoginDatTime;
    }

    public void setLastLoginDatTime(Timestamp lastLoginDatTime) {
        this.lastLoginDatTime = lastLoginDatTime;
    }

    private Integer isLDAP;

    @Column(name = "IsLDAP")
    @Basic
    public Integer getLDAP() {
        return isLDAP;
    }

    public void setLDAP(Integer LDAP) {
        isLDAP = LDAP;
    }

    private String avatar;

    @Column(name = "Avatar")
    @Basic
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private Integer gioiTinh;

    @Column(name = "GioiTinh")
    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    private String tenNhanVien;

    @Column(name = "TenNhanVien")
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    private String hoNhanVien;

    @Column(name = "HoNhanVien")
    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    private String chuyenNganh;

    @Column(name = "ChuyenNganh")
    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (lastLoginDatTime != null ? !lastLoginDatTime.equals(that.lastLoginDatTime) : that.lastLoginDatTime != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;
        if (gioiTinh != null ? !gioiTinh.equals(that.gioiTinh) : that.gioiTinh != null) return false;
        if (tenNhanVien != null ? !tenNhanVien.equals(that.tenNhanVien) : that.tenNhanVien != null) return false;
        if (hoNhanVien != null ? !hoNhanVien.equals(that.hoNhanVien) : that.hoNhanVien != null) return false;
        if (chuyenNganh != null ? !chuyenNganh.equals(that.chuyenNganh) : that.chuyenNganh != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (lastLoginDatTime != null ? lastLoginDatTime.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (gioiTinh != null ? gioiTinh.hashCode() : 0);
        result = 31 * result + (tenNhanVien != null ? tenNhanVien.hashCode() : 0);
        result = 31 * result + (hoNhanVien != null ? hoNhanVien.hashCode() : 0);
        result = 31 * result + (chuyenNganh != null ? chuyenNganh.hashCode() : 0);
        return result;
    }
}
