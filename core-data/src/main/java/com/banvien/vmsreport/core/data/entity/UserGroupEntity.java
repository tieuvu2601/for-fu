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
@Table(name = "UserGroup")
@Entity
public class UserGroupEntity {
    private Long userGroupId;

    @Column(name = "UserGroupId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERGROUP_SEQ")
    @SequenceGenerator(name="USERGROUP_SEQ", sequenceName="USERGROUP_SEQ", allocationSize=1)
    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    private String code;

    @Column(name = "Code")
    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    @Column(name = "Description")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer isCenter;

    @Column(name = "isCenter")
    @Basic
    public Integer getCenter() {
        return isCenter;
    }

    public void setCenter(Integer center) {
        isCenter = center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupEntity that = (UserGroupEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (userGroupId != null ? !userGroupId.equals(that.userGroupId) : that.userGroupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userGroupId != null ? userGroupId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }
}
