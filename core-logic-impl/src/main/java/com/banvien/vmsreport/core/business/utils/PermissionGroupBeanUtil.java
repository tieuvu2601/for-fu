package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.PermissionGroupDTO;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;
import com.banvien.vmsreport.core.data.entity.PermissionGroupEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/2/15
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PermissionGroupBeanUtil {
    public static PermissionGroupDTO entity2DTO(PermissionGroupEntity entity){
        PermissionGroupDTO dto = new PermissionGroupDTO();
        dto.setPermissionGroupId(entity.getPermissionGroupId());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
