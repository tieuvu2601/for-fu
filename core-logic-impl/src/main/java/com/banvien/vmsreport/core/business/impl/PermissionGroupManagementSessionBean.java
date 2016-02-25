package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.PermissionGroupDTO;
import com.banvien.vmsreport.core.business.PermissionGroupManagenmentLocalBean;
import com.banvien.vmsreport.core.business.utils.PermissionGroupBeanUtil;
import com.banvien.vmsreport.core.data.entity.PermissionGroupEntity;
import com.banvien.vmsreport.core.data.session.PermissionGroupLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/1/15
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "PermissionGroupManagementSessionEJB")
public class PermissionGroupManagementSessionBean implements PermissionGroupManagenmentLocalBean{
    public PermissionGroupManagementSessionBean() {
    }

    @EJB
    private PermissionGroupLocalBean permissionGroupService;

    @Override
    public List<PermissionGroupDTO> findAll() {
        List<PermissionGroupEntity> entityList = this.permissionGroupService.findAllAndOrder();
        if(entityList != null && entityList.size() > 0){
            List<PermissionGroupDTO> dtoList = new ArrayList<PermissionGroupDTO>();
            for (PermissionGroupEntity entity : entityList){
                dtoList.add(PermissionGroupBeanUtil.entity2DTO(entity));
            }
            return dtoList;
        }
        return null;
    }
}
