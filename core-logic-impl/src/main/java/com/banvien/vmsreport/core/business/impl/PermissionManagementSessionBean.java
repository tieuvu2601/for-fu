package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.PermissionManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.PermissionBeanUtil;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;
import com.banvien.vmsreport.core.data.session.PermissionLocalBean;

import javax.ejb.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "PermissionManagementSessionEJB")
public class PermissionManagementSessionBean implements PermissionManagementLocalBean{
    @EJB
    private PermissionLocalBean permissionService;

    public PermissionManagementSessionBean() {
    }

    @Override
    public PermissionDTO findByCode(String code) throws ObjectNotFoundException {
        PermissionEntity entity = this.permissionService.findEqualUnique("code", code);
        if(entity == null) throw new  ObjectNotFoundException("Not found Permission has code" + code);
        return DozerSingletonMapper.getInstance().map(entity, PermissionDTO.class);
    }

    @Override
    public PermissionDTO findByName(String name) throws ObjectNotFoundException {
        PermissionEntity entity = this.permissionService.findEqualUnique("name", name);
        if(entity == null) throw new  ObjectNotFoundException("Not found Permission has name:" + name);
        return DozerSingletonMapper.getInstance().map(entity, PermissionDTO.class);
    }

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] result = permissionService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<PermissionDTO> dtos = new ArrayList<PermissionDTO>();
        for(PermissionEntity entity : (List<PermissionEntity>)result[1])  {
            dtos.add(DozerSingletonMapper.getInstance().map(entity, PermissionDTO.class));
        }
        result[1] = dtos;
        return result;
    }

    @Override
    public PermissionDTO updateItem(PermissionDTO permission) throws ObjectNotFoundException, DuplicateKeyException {
        PermissionEntity dbItem = permissionService.findById(permission.getPermissionId());
        if(dbItem == null) throw new ObjectNotFoundException("Can not find Permission with ID: " + permission.getPermissionId());
        PermissionEntity entity = DozerSingletonMapper.getInstance().map(permission, PermissionEntity.class);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        entity = permissionService.update(entity);
        return DozerSingletonMapper.getInstance().map(entity, PermissionDTO.class);
    }

    @Override
    public PermissionDTO addItem(PermissionDTO permission) throws DuplicateKeyException {
        PermissionEntity entity = DozerSingletonMapper.getInstance().map(permission, PermissionEntity.class);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        entity = permissionService.save(entity);
        return DozerSingletonMapper.getInstance().map(entity, PermissionDTO.class);
    }

    @Override
    public PermissionDTO findById(Long permissionId) throws ObjectNotFoundException {
        PermissionEntity entity = permissionService.findById(permissionId);
        if (entity == null) throw new ObjectNotFoundException("Can not find Permission with ID: " + permissionId);
        return DozerSingletonMapper.getInstance().map(entity, PermissionDTO.class);
    }

    @Override
    public Integer deleteItems(String[] ids) throws RemoveException {
        int res = 0;
        if (ids != null && ids.length > 0){
            for (String id : ids){
                permissionService.delete(Long.valueOf(id));
                res++;
            }
        }
        return res;
    }

    @Override
    public List<PermissionDTO> findPermissionsNotInUser(Long userId, String permissionFilterCode, String permissionFilterName) {
        List<PermissionEntity> entityList = this.permissionService.findPermissionsNotInUser(userId, permissionFilterCode, permissionFilterName);
        if(entityList != null && entityList.size() > 0){
            List<PermissionDTO> dtos = new ArrayList<PermissionDTO>();
            for (PermissionEntity entity : entityList){
                dtos.add(PermissionBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }

    @Override
    public List<PermissionDTO> findByRole(Long roleId, Long permissionGroupId) {
        List<PermissionEntity> entityList = this.permissionService.findByRole(roleId, permissionGroupId);
        if(entityList != null && entityList.size() > 0){
            List<PermissionDTO> dtoList = new ArrayList<PermissionDTO>();
            for (PermissionEntity entity : entityList){
                dtoList.add(PermissionBeanUtil.entity2DTO(entity));
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PermissionDTO> findNotInRole(Long roleId, Long permissionGroupId) {
        List<PermissionEntity> entityList = this.permissionService.findNotInRole(roleId, permissionGroupId);
        if(entityList != null && entityList.size() > 0){
            List<PermissionDTO> dtoList = new ArrayList<PermissionDTO>();
            for (PermissionEntity entity : entityList){
                dtoList.add(PermissionBeanUtil.entity2DTO(entity));
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PermissionDTO> findPermissionsInUser(Long userId, String permissionFilterCode, String permissionFilterName) {
        List<PermissionEntity> entityList = this.permissionService.findPermissionsInUser(userId, permissionFilterCode, permissionFilterName);
        if(entityList != null && entityList.size() > 0){
            List<PermissionDTO> dtos = new ArrayList<PermissionDTO>();
            for (PermissionEntity entity : entityList){
                dtos.add(PermissionBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }
}
