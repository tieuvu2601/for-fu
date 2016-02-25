package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "Role")
@Entity
public class RoleEntity {
    private Long roleId;

    @javax.persistence.Column(name = "RoleId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(name="ROLE_SEQ", sequenceName="ROLE_SEQ", allocationSize=1)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    private String code;

    @javax.persistence.Column(name = "Code")
    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    @javax.persistence.Column(name = "Name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    private List<RoleACLEntity> roleACLList;

    @OneToMany(cascade=CascadeType.REMOVE, orphanRemoval = false)
    @JoinColumn(name="RoleId", insertable = false, updatable = false)
    public List<RoleACLEntity> getRoleACLList() {
        return roleACLList;
    }

    public void setRoleACLList(List<RoleACLEntity> roleACLList) {
        this.roleACLList = roleACLList;
    }
}
