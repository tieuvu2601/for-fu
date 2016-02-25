package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 10/13/15
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAreaACLDTO implements Serializable {
    private Long userAreaACLId;
    private UserDTO user;
    private String Code;
    private Integer flag;


    public Long getUserAreaACLId() {
        return userAreaACLId;
    }

    public void setUserAreaACLId(Long userAreaACLId) {
        this.userAreaACLId = userAreaACLId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
