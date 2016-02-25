package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.RoleDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.RoleManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.RoleBeanUtil;
import com.banvien.vmsreport.core.data.entity.RoleEntity;
import com.banvien.vmsreport.core.data.session.RoleACLLocalBean;
import com.banvien.vmsreport.core.data.session.RoleLocalBean;
import com.banvien.vmsreport.core.data.session.UserRoleACLLocalBean;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "RoleManagementSessionEJB")
public class RoleManagementSessionBean implements RoleManagementLocalBean{
    @EJB
    private RoleLocalBean roleService;
    @EJB
    private RoleACLLocalBean roleACLService;
    @EJB
    private UserRoleACLLocalBean userRoleACLService;

    public RoleManagementSessionBean() {
    }

    @Override
    public RoleDTO findByCode(String code) throws ObjectNotFoundException {
        RoleEntity dbItem = this.roleService.findEqualUnique("code", code);
        return RoleBeanUtil.entity2DTO(dbItem);
    }

    @Override
    public void deleteItem(Long roleId) throws RemoveException{
        userRoleACLService.deleteByRoleId(roleId);
        roleACLService.deleteByRoleId(roleId);
        roleService.delete(roleId);
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] res = roleService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<RoleDTO> dtos = new ArrayList<RoleDTO>();
        for (RoleEntity entity : (List<RoleEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, RoleDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public RoleDTO addItem(RoleDTO pojo) throws DuplicateKeyException {
        RoleEntity entity = DozerSingletonMapper.getInstance().map(pojo, RoleEntity.class);
        entity = roleService.save(entity);
        return DozerSingletonMapper.getInstance().map(entity, RoleDTO.class);
    }

    @Override
    public RoleDTO updateItem(RoleDTO pojo) throws ObjectNotFoundException, DuplicateKeyException {
        RoleEntity dbItem = roleService.findById(pojo.getRoleId());
        if(dbItem == null) throw new ObjectNotFoundException("Can't not find Role with Id: " + pojo.getRoleId());
        RoleEntity entity = DozerSingletonMapper.getInstance().map(pojo, RoleEntity.class);
        entity = roleService.update(entity);
        return DozerSingletonMapper.getInstance().map(entity, RoleDTO.class);
    }

    @Override
    public RoleDTO findById(Long roleId) throws ObjectNotFoundException {
        RoleEntity dbItem = this.roleService.findById(roleId);
        if(dbItem == null) throw new ObjectNotFoundException("Cant not find Role with Id:" + roleId);
        return DozerSingletonMapper.getInstance().map(dbItem, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> findRolesNotInUser(Long userId, String roleFilterCode, String roleFilterName) {
        List<RoleEntity> entityList = this.roleService.findRolesNotInUser(userId, roleFilterCode, roleFilterName);
        if(entityList != null && entityList.size() > 0){
            List<RoleDTO> dtos = new ArrayList<RoleDTO>();
            for (RoleEntity entity : entityList){
                dtos.add(RoleBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }

    @Override
    public List<RoleDTO> findRolesInUser(Long userId, String roleFilterCode, String roleFilterName) {
        List<RoleEntity> entityList = this.roleService.findRolesInUser(userId, roleFilterCode, roleFilterName);
        if(entityList != null && entityList.size() > 0){
            List<RoleDTO> dtos = new ArrayList<RoleDTO>();
            for (RoleEntity entity : entityList){
                dtos.add(RoleBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }

    @Override
    public List<RoleDTO> findRolesNotInUserGroups(Long userGroupId, String roleFilterCode, String roleFilterName) {
        List<RoleEntity> roleEntities = this.roleService.findRolesNotInUserGroup(userGroupId, roleFilterCode, roleFilterName);
        if(roleEntities!= null && roleEntities.size() > 0){
            List<RoleDTO> dtos = new ArrayList<>();
            for(RoleEntity entity : roleEntities){
                dtos.add(RoleBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }

    @Override
    public List<RoleDTO> findRolesInUserGroups(Long userGroupId, String roleFilterCode, String roleFilterName) {
        List<RoleEntity> roleEntities = this.roleService.findRolesInUserGroup(userGroupId, roleFilterCode, roleFilterName);
        if(roleEntities!= null && roleEntities.size() > 0){
            List<RoleDTO> dtos = new ArrayList<>();
            for(RoleEntity entity : roleEntities){
                dtos.add(RoleBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }


}
