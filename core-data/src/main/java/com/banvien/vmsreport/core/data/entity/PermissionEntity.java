package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "Permission")
@Entity
public class PermissionEntity {
    private Long permissionId;

    @javax.persistence.Column(name = "PermissionId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSION_SEQ")
    @SequenceGenerator(name="PERMISSION_SEQ", sequenceName="PERMISSION_SEQ", allocationSize=1)
    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    private String code;

    @javax.persistence.Column(name = "code")
    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private PermissionGroupEntity permissionGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PermissionGroupId", referencedColumnName = "PermissionGroupId")
    public PermissionGroupEntity getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(PermissionGroupEntity permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionEntity that = (PermissionEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId != null ? permissionId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
