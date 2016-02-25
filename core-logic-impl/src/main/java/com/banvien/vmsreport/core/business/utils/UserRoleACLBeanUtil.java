package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.UserRoleACLDTO;
import com.banvien.vmsreport.core.data.entity.RoleACLEntity;
import com.banvien.vmsreport.core.data.entity.UserRoleACLEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/4/15
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserRoleACLBeanUtil {
    public static UserRoleACLDTO entity2DTO(UserRoleACLEntity entity){
        UserRoleACLDTO dto = new UserRoleACLDTO();
        dto.setUserRoleACLId(entity.getUserRoleACLId());
        dto.setRole(RoleBeanUtil.entity2DTO(entity.getRole()));
        dto.setUser(UserBeanUtil.entity2DTO(entity.getUser()));
        return dto;
    }
}
