package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "USERGROUPROLEACL")
@Entity
public class UserGroupRoleACLEntity {
    private Long userGroupRoleACLId;

    @Column(name = "userGroupRoleACLId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserGroupRoleACL_SEQ")
    @SequenceGenerator(name="UserGroupRoleACL_SEQ", sequenceName="UserGroupRoleACL_SEQ", allocationSize=1)

    public Long getUserGroupRoleACLId() {
        return userGroupRoleACLId;
    }

    public void setUserGroupRoleACLId(Long userGroupRoleACLId) {
        this.userGroupRoleACLId = userGroupRoleACLId;
    }

    private UserGroupEntity usergroup;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "UserGroupId", referencedColumnName = "UserGroupId", nullable = false)
    public UserGroupEntity getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(UserGroupEntity usergroup) {
        this.usergroup = usergroup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroupRoleACLEntity)) return false;

        UserGroupRoleACLEntity that = (UserGroupRoleACLEntity) o;

        if (!role.equals(that.role)) return false;
        if (!userGroupRoleACLId.equals(that.userGroupRoleACLId)) return false;
        if (!usergroup.equals(that.usergroup)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userGroupRoleACLId.hashCode();
        result = 31 * result + usergroup.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
