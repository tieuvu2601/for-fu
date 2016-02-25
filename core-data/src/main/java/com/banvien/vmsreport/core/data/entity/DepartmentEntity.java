package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/6/15
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "Department")
@Entity
public class DepartmentEntity {
    private Long departmentId;

    @javax.persistence.Column(name = "departmentid")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_SEQ")
    @SequenceGenerator(name="DEPARTMENT_SEQ", sequenceName="DEPARTMENT_SEQ", allocationSize=1)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

    private Integer active;

    @javax.persistence.Column(name = "Active")
    @Basic
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
