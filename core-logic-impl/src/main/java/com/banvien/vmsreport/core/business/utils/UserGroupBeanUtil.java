package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.UserGroupDTO;
import com.banvien.vmsreport.core.data.entity.UserGroupEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/2/15
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupBeanUtil {
    public static UserGroupDTO entity2DTO(UserGroupEntity entity){
        UserGroupDTO dto = new UserGroupDTO();
        dto.setUserGroupId(entity.getUserGroupId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setCenter(entity.getCenter());
        return dto;
    }
}
