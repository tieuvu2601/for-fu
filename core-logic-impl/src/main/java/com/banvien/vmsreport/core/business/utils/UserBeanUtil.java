package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.common.security.DesEncrypterUtils;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;
import com.banvien.vmsreport.core.data.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/2/15
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserBeanUtil {
    public static UserDTO entity2DTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setDisplayName(entity.getDisplayName());
        dto.setEmail(entity.getEmail());
        dto.setStatus(entity.getStatus());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setLastLoginDatTime(entity.getLastLoginDatTime());
        dto.setLDAP(entity.getLDAP());
        dto.setUserGroup(UserGroupBeanUtil.entity2DTO(entity.getUserGroup()));
        dto.setPassword(entity.getPassword());
        dto.setAvatar(entity.getAvatar());
        dto.setGioiTinh(entity.getGioiTinh());
        dto.setTenNhanVien(entity.getTenNhanVien());
        dto.setHoNhanVien(entity.getHoNhanVien());
        dto.setChuyenNganh(entity.getChuyenNganh());
        if (entity.getDepartment() != null){
            dto.setDepartment(DepartmentBeanUtil.entity2DTO(entity.getDepartment()));
        }
        return dto;
    }
}
