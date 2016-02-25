package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "UserGroupACL")
@Entity
public class UserGroupACLEntity {
    private Long userGroupACLId;

    @Column(name = "UserGroupACLId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERGROUPACL_SEQ")
    @SequenceGenerator(name="USERGROUPACL_SEQ", sequenceName="USERGROUPACL_SEQ", allocationSize=1)
    public Long getUserGroupACLId() {
        return userGroupACLId;
    }

    public void setUserGroupACLId(Long userGroupACLId) {
        this.userGroupACLId = userGroupACLId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupACLEntity that = (UserGroupACLEntity) o;

        if (userGroupACLId != null ? !userGroupACLId.equals(that.userGroupACLId) : that.userGroupACLId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userGroupACLId != null ? userGroupACLId.hashCode() : 0;
        return result;
    }

    private PermissionEntity permission;

    @ManyToOne
    @JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId", nullable = false)
    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }

    private UserGroupEntity userGroup;

    @ManyToOne
    @JoinColumn(name = "UserGroupId", referencedColumnName = "UserGroupId", nullable = false)
    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
    }
}
