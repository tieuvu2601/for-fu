package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "RoleACL")
@Entity
public class RoleACLEntity {
    private Long roleACLId;

    @javax.persistence.Column(name = "roleACLId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLEACL_SEQ")
    @SequenceGenerator(name="ROLEACL_SEQ", sequenceName="ROLEACL_SEQ", allocationSize=1)
    public Long getRoleACLId() {
        return roleACLId;
    }

    public void setRoleACLId(Long roleACLId) {
        this.roleACLId = roleACLId;
    }

    private Timestamp createdDate;

    private Timestamp modifiedDate;

    @javax.persistence.Column(name = "CreatedDate")
    @Basic
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @javax.persistence.Column(name = "ModifiedDate")
    @Basic
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleACLEntity that = (RoleACLEntity) o;

        if (roleACLId != null ? !roleACLId.equals(that.roleACLId) : that.roleACLId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (roleACLId != null ? !roleACLId.equals(that.roleACLId) : that.roleACLId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =  roleACLId != null ? roleACLId.hashCode() : 0;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }

    private PermissionEntity permission;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId", nullable = false)
    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }

    private RoleEntity role;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "RoleId", referencedColumnName = "RoleId", nullable = false)
    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
