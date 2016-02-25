package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DEll
 * Date: 8/26/15
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "PermissionGroup")
@Entity
public class PermissionGroupEntity {
    private Long permissionGroupId;

    @Column(name = "PermissionGroupId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PermissionGroup_SEQ")
    @SequenceGenerator(name="PermissionGroup_SEQ", sequenceName="PermissionGroup_SEQ", allocationSize=1)
    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
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

    private String description;

    @Column(name = "Description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionGroupEntity that = (PermissionGroupEntity) o;

        if (!permissionGroupId.equals(that.permissionGroupId)) return false;
        if (!code.equals(that.code)) return false;
        if (!description.equals(that.description)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionGroupId.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
