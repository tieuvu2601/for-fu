package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "UserACL")
@Entity
public class UserACLEntity {
    private Long userACLId;

    @javax.persistence.Column(name = "UserACLId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERACL_SEQ")
    @SequenceGenerator(name="USERACL_SEQ", sequenceName="USERACL_SEQ", allocationSize=1)
    public Long getUserACLId() {
        return userACLId;
    }

    public void setUserACLId(Long userACLId) {
        this.userACLId = userACLId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserACLEntity that = (UserACLEntity) o;

        if (userACLId != null ? !userACLId.equals(that.userACLId) : that.userACLId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userACLId != null ? userACLId.hashCode() : 0;
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

    private UserEntity user;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
