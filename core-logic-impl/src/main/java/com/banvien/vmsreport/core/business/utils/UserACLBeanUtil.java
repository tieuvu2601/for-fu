package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.UserACLDTO;
import com.banvien.vmsreport.core.data.entity.UserACLEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/3/15
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserACLBeanUtil {
    public static UserACLDTO entity2DTO(UserACLEntity entity){
        UserACLDTO dto = new UserACLDTO();
        dto.setUserACLId(entity.getUserACLId());
        dto.setUsers(UserBeanUtil.entity2DTO(entity.getUser()));
        dto.setPermission(PermissionBeanUtil.entity2DTO(entity.getPermission()));
        return dto;
    }
}
