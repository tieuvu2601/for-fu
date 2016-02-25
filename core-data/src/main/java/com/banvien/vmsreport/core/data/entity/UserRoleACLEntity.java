package com.banvien.vmsreport.core.data.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "UserRoleACL")
@Entity
public class UserRoleACLEntity {
    private Long userRoleACLId;

    @javax.persistence.Column(name = "UserACLId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERROLEACL_SEQ")
    @SequenceGenerator(name="USERROLEACL_SEQ", sequenceName="USERROLEACL_SEQ", allocationSize=1)
    public Long getUserRoleACLId() {
        return userRoleACLId;
    }

    public void setUserRoleACLId(Long userRoleACLId) {
        this.userRoleACLId = userRoleACLId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleACLEntity that = (UserRoleACLEntity) o;

        if (userRoleACLId != null ? !userRoleACLId.equals(that.userRoleACLId) : that.userRoleACLId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userRoleACLId != null ? userRoleACLId.hashCode() : 0;
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

    private UserEntity user;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "UserId", referencedColumnName = "UserId")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
