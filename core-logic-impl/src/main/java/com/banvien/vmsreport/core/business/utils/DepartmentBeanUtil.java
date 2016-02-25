package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.core.data.entity.DepartmentEntity;
import com.banvien.vmsreport.core.data.entity.UserEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/2/15
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentBeanUtil {
    public static DepartmentDTO entity2DTO(DepartmentEntity entity){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentId(entity.getDepartmentId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        return dto;
    }
}
