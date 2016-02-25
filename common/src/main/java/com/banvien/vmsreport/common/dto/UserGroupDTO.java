package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/20/15
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupDTO implements Serializable {
    private static final long serialVersionUID = -1054933616366778082L;
    private Long userGroupId;
    private String name;
    private String code;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer isCenter;

    public Integer getCenter() {
        return isCenter;
    }

    public void setCenter(Integer center) {
        isCenter = center;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
