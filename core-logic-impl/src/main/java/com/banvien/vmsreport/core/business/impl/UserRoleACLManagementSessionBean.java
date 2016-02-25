package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.UserRoleACLDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.UserRoleACLManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.UserRoleACLBeanUtil;
import com.banvien.vmsreport.core.data.entity.RoleEntity;
import com.banvien.vmsreport.core.data.entity.UserEntity;
import com.banvien.vmsreport.core.data.entity.UserRoleACLEntity;
import com.banvien.vmsreport.core.data.session.UserLocalBean;
import com.banvien.vmsreport.core.data.session.UserRoleACLLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserRoleACLManagementSessionEJB")
public class UserRoleACLManagementSessionBean implements UserRoleACLManagementLocalBean{
    public UserRoleACLManagementSessionBean() {
    }

    @EJB
    private UserRoleACLLocalBean userRoleACLService;

    @EJB
    private UserLocalBean userService;

    @Override
    public List<UserRoleACLDTO> findByUser(Long userId, String roleFilterCode, String roleFilterName) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("user.userId", userId);
        if(StringUtils.isNotBlank(roleFilterCode) && roleFilterCode != null){
           properties.put("role.code",roleFilterCode);
        }
        if(StringUtils.isNotBlank(roleFilterName) && roleFilterName != null){
           properties.put("role.name", roleFilterName);
        }
        List<UserRoleACLEntity> entityList = this.userRoleACLService.findProperties(properties);
        if(entityList != null && entityList.size() > 0){
            List<UserRoleACLDTO> userRoleACLs = new ArrayList<UserRoleACLDTO>();
            for (UserRoleACLEntity entity : entityList){
                userRoleACLs.add(DozerSingletonMapper.getInstance().map(entity, UserRoleACLDTO.class));
            }
            return userRoleACLs;
        }
        return null;
    }

    @Override
    public void deleteAllByUser(Long userId) {
        this.userRoleACLService.deleteAllByUser(userId);
    }

    @Override
    public void insert(Long userId, Long[] roleIds) throws ObjectNotFoundException, DuplicateKeyException {
        UserEntity userEntity = this.userService.findById(userId);
        for (Long roleId : roleIds){
            UserRoleACLEntity entity = new UserRoleACLEntity();
            entity.setUser(userEntity);
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(roleId);
            entity.setRole(roleEntity);
            userRoleACLService.save(entity);
        }
    }

    @Override
    public void update(Long userId, Long[] userRoleACLIds) throws RemoveException, DuplicateKeyException{
        List<Long> currentUserRoleACLIds = this.userRoleACLService.findIdsByUser(userId);
        Long[] userRoleACLIds2Delete = findUserRoleACLIdsList2Delete(currentUserRoleACLIds, userRoleACLIds);
        if(userRoleACLIds2Delete != null && userRoleACLIds2Delete.length > 0){
            for(Long roleId : userRoleACLIds2Delete){
                userRoleACLService.deleteByUserIdAndRoleId(userId, roleId);
            }
        }
    }

    @Override
    public List<UserRoleACLDTO> findByUserName(String username){
        List<UserRoleACLEntity> entityList = this.userRoleACLService.findProperty("user.userName", username);
        List<UserRoleACLDTO> dtos = new ArrayList<UserRoleACLDTO>();
        for (UserRoleACLEntity entity : entityList){
            dtos.add(UserRoleACLBeanUtil.entity2DTO(entity));
        }
        return dtos;
    }

    private Long[] findUserRoleACLIdsList2Delete(List<Long> currentUserRoleACLIds, Long[] userRoleACLIds){
        List<Long> idList2Delete = new ArrayList<Long>();
        for(Long currentUserRoleACLId : currentUserRoleACLIds){
            boolean matched = false;
            for(Long keepingACLId : userRoleACLIds){
                if(keepingACLId.equals(currentUserRoleACLId)){
                    matched = true;
                    break;
                }
            }
            if(!matched){
                idList2Delete.add(currentUserRoleACLId);
            }
        }
        return idList2Delete.toArray(new Long[idList2Delete.size()]);
    }
}
