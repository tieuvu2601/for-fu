package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;
import com.banvien.vmsreport.core.data.entity.UserGroupRoleACLEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/28/15
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupRoleACLBeanUtil {
    public static UserGroupRoleACLDTO entity2DTO(UserGroupRoleACLEntity entity){
        UserGroupRoleACLDTO dto = new UserGroupRoleACLDTO();
        dto.setUserGroupRoleACLId(entity.getUserGroupRoleACLId());
        dto.setUserGroup(UserGroupBeanUtil.entity2DTO(entity.getUsergroup()));
        dto.setRole(RoleBeanUtil.entity2DTO(entity.getRole()));
        return dto;
    }
}
