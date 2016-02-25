package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/2/15
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class PermissionBeanUtil {
    public static PermissionDTO entity2DTO(PermissionEntity entity){
        PermissionDTO dto = new PermissionDTO();
        dto.setPermissionId(entity.getPermissionId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setPermissionGroup(PermissionGroupBeanUtil.entity2DTO(entity.getPermissionGroup()));
        return dto;
    }
}
