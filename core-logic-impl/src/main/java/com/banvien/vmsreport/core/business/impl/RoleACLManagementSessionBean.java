package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.RoleACLDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.RoleACLManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;
import com.banvien.vmsreport.core.data.entity.RoleACLEntity;
import com.banvien.vmsreport.core.data.entity.RoleEntity;
import com.banvien.vmsreport.core.data.session.PermissionLocalBean;
import com.banvien.vmsreport.core.data.session.RoleACLLocalBean;
import com.banvien.vmsreport.core.data.session.RoleLocalBean;

import javax.ejb.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "RoleACLManagementSessionEJB")
public class RoleACLManagementSessionBean implements RoleACLManagementLocalBean{
    public RoleACLManagementSessionBean() {
    }

    @EJB
    private RoleACLLocalBean roleACLService;
    @EJB
    private PermissionLocalBean permissionService;
    @EJB
    private RoleLocalBean roleService;

    @Override
    public List<RoleACLDTO> findByUser(Long userId) {
        List<RoleACLEntity> entityList = this.roleACLService.findByUser(userId);
        if(entityList != null && entityList.size() > 0){
            List<RoleACLDTO> roleACLs = new ArrayList<RoleACLDTO>();
            for (RoleACLEntity entity : entityList){
                roleACLs.add(DozerSingletonMapper.getInstance().map(entity, RoleACLDTO.class));
            }
        }
        return null;
    }

    @Override
    public void addNew(Long roleId, String[] checkList) {
        for(String complexStr : checkList){
            Long permissionId = Long.valueOf(complexStr.split("\\_")[0].toString());
            RoleACLEntity entity = new RoleACLEntity();

            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(roleId);
            entity.setRole(roleEntity);

            PermissionEntity permissionEntity = new PermissionEntity();
            permissionEntity.setPermissionId(permissionId);
            entity.setPermission(permissionEntity);

            try {
                roleACLService.save(entity);
            } catch (DuplicateKeyException e) {}
        }
    }

    @Override
    public void update(Long roleId, Long[] permissionIds) throws RemoveException, DuplicateKeyException {
        List<Long> currentPermissionIds = permissionService.findIdsByRole(roleId);
        Long[] permissionIds2Delete = findPermissionIds2Delete(currentPermissionIds, permissionIds);
        if(permissionIds2Delete != null && permissionIds2Delete.length > 0){
            for (Long permissionId : permissionIds2Delete){
                roleACLService.deleteByRoleIdAndPermissionId(roleId, permissionId);
            }
        }
    }

    private Long[] findPermissionIds2Delete(List<Long> currentRoleACLIds, Long[] roleACLIds){
        List<Long> roleACLIds2Delete = new ArrayList<Long>();
        for (Long currentRoleACLId : currentRoleACLIds){
            boolean matched = false;
            for(Long roleACLId : roleACLIds){
                if(roleACLId.equals(currentRoleACLId)){
                    matched = true;
                    break;
                }
            }
            if(!matched){
                roleACLIds2Delete.add(currentRoleACLId);
            }
        }
        return roleACLIds2Delete.toArray(new Long[roleACLIds2Delete.size()]);
    }

    @Override
    public List<RoleACLDTO> searchByRoleId(Long roleId) {
        List<RoleACLEntity> roleACLEntitys = roleACLService.findByProperty("role.roleId", roleId);
        List<RoleACLDTO> roleACLDTOs = new ArrayList<>();
        for (RoleACLEntity entity : roleACLEntitys){

            RoleACLDTO roleACLDTO = new RoleACLDTO();
            roleACLDTO.setRoleACLId(entity.getRoleACLId());
            if (entity.getPermission() != null && entity.getPermission().getPermissionId() != null){
                PermissionDTO permissionDTO = new PermissionDTO();
                permissionDTO.setPermissionId(entity.getPermission().getPermissionId());
                roleACLDTO.setPermission(permissionDTO);
            }
            roleACLDTOs.add(roleACLDTO);
        }
        return roleACLDTOs;
    }

    @Override
    public void deleteAllByRole(Long roleId) {
        this.roleACLService.deleteAllByRole(roleId);
    }

    @Override
    public void insert(Long roleId, Long[] permissionIds) throws ObjectNotFoundException, DuplicateKeyException {
        RoleEntity roleEntity = this.roleService.findById(roleId);
        for (Long permissionId : permissionIds){
            RoleACLEntity roleACLEntity = new RoleACLEntity();
            roleACLEntity.setRole(roleEntity);
            PermissionEntity permissionEntity = new PermissionEntity();
            permissionEntity.setPermissionId(permissionId);
            roleACLEntity.setPermission(permissionEntity);
            roleACLEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            roleACLService.save(roleACLEntity);
        }
    }
}
