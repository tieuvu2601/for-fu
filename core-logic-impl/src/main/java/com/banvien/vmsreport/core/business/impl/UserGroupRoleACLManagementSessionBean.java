package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;
import com.banvien.vmsreport.core.business.UserGroupRoleACLManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.UserGroupRoleACLBeanUtil;
import com.banvien.vmsreport.core.data.entity.RoleEntity;
import com.banvien.vmsreport.core.data.entity.UserGroupEntity;
import com.banvien.vmsreport.core.data.entity.UserGroupRoleACLEntity;
import com.banvien.vmsreport.core.data.session.UserGroupLocalBean;
import com.banvien.vmsreport.core.data.session.UserGroupRoleACLLocalBean;
import com.banvien.vmsreport.core.data.session.impl.AbstractSessionBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserGroupRoleACLManagementSessionEJB")
public class UserGroupRoleACLManagementSessionBean extends AbstractSessionBean<UserGroupRoleACLEntity, Long> implements UserGroupRoleACLManagementLocalBean {
    public UserGroupRoleACLManagementSessionBean(){

    }
    @EJB
    private UserGroupRoleACLLocalBean userGroupRoleACLService;

    @EJB
    private UserGroupLocalBean userGroupService;

    @Override
    public List<UserGroupRoleACLDTO> findByUserGroupId(Long userGroupId, String roleFilterCode, String roleFilterName) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("usergroup.userGroupId", userGroupId);
        if(StringUtils.isNotBlank(roleFilterCode) && roleFilterCode != null){
            properties.put("role.code", roleFilterCode);
        }
        if(StringUtils.isNotBlank(roleFilterName) && roleFilterName != null){
            properties.put("role.name", roleFilterName);
        }
        List<UserGroupRoleACLEntity> entities = this.userGroupRoleACLService.findProperties(properties);
        if(entities != null && entities.size() > 0){
            List<UserGroupRoleACLDTO> dtos = new ArrayList<>();
            for (UserGroupRoleACLEntity entity : entities){
                dtos.add(UserGroupRoleACLBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }

    @Override
    public void updateRole(Long userGroupId, Long[] userGroupRoleACLId) throws RemoveException, ObjectNotFoundException, DuplicateKeyException {
        List<Long> currentUserRoleACLIds = this.userGroupRoleACLService.findIdsByUserGroup(userGroupId);
        Long[] userRoleACLIds2Delete = findUserRoleACLIdsList2Delete(currentUserRoleACLIds, userGroupRoleACLId);
        if(userRoleACLIds2Delete != null && userRoleACLIds2Delete.length > 0){
            userGroupRoleACLService.delete(userRoleACLIds2Delete);
        }
    }

    private Long[] findUserRoleACLIdsList2Delete(List<Long> currentUserGroupRoleACLIds, Long[] userGroupRoleACLId) {
        List<Long> idList2Delete = new ArrayList<Long>();
        for(Long currentUserGroupRoleACLId : currentUserGroupRoleACLIds){
            boolean matched = false;
            for(Long keepingACLId : userGroupRoleACLId){
                if(keepingACLId.equals(currentUserGroupRoleACLId)){
                    matched = true;
                    break;
                }
            }
            if(!matched){
                idList2Delete.add(currentUserGroupRoleACLId);
            }
        }
        return idList2Delete.toArray(new Long[idList2Delete.size()]);
    }


    @Override
    public void deleteAllByUserGroup(Long userGroupId) {
        this.userGroupRoleACLService.deleteAllByUserGroup(userGroupId);
    }

    @Override
    public void insert(Long userGroupId, Long[] roleIds) throws ObjectNotFoundException, DuplicateKeyException {
        UserGroupEntity userGroupEntity = this.userGroupService.findById(userGroupId);
        for(Long roleId : roleIds){
           UserGroupRoleACLEntity entity = new UserGroupRoleACLEntity();
           entity.setUsergroup(userGroupEntity);
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(roleId);
            entity.setRole(roleEntity);
            userGroupRoleACLService.save(entity);
        }
    }
}
