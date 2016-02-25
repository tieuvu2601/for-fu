package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.RoleDTO;
import com.banvien.vmsreport.core.data.entity.RoleACLEntity;
import com.banvien.vmsreport.core.data.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/3/15
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class RoleBeanUtil {
    public static RoleDTO entity2DTO(RoleEntity entity){
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        if(entity.getRoleACLList() != null && entity.getRoleACLList().size() > 0){
            List<PermissionDTO> permissionDTOs = new ArrayList<PermissionDTO>();
            for (RoleACLEntity roleACLEntity : entity.getRoleACLList()){
                permissionDTOs.add(PermissionBeanUtil.entity2DTO(roleACLEntity.getPermission()));
            }
            dto.setPermissions(permissionDTOs);
        }
        return dto;
    }
}
