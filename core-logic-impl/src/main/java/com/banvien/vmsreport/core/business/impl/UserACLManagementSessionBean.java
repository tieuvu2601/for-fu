package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.UserACLDTO;
import com.banvien.vmsreport.core.business.UserACLManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.UserACLBeanUtil;
import com.banvien.vmsreport.core.data.entity.PermissionEntity;
import com.banvien.vmsreport.core.data.entity.UserACLEntity;
import com.banvien.vmsreport.core.data.entity.UserEntity;
import com.banvien.vmsreport.core.data.session.UserACLLocalBean;
import com.banvien.vmsreport.core.data.session.UserLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserACLManagementSessionEJB")
public class UserACLManagementSessionBean implements UserACLManagementLocalBean{
    public UserACLManagementSessionBean() {
    }

    @EJB
    private UserACLLocalBean userACLService;
    @EJB
    private UserLocalBean userService;

    @Override
    public List<UserACLDTO> findByUser(Long userId, String permissionFilterCode, String permissionFilterName) {
        Map<String, Object> properties = new HashMap<>();
            properties.put("user.userId", userId);
        if(StringUtils.isNotBlank(permissionFilterCode) && permissionFilterCode != null){
            properties.put("permission.code", permissionFilterCode);
        }
        if(StringUtils.isNotBlank(permissionFilterName) && permissionFilterName != null){
            properties.put("permission.name", permissionFilterName);
        }
        List<UserACLEntity> entityList = this.userACLService.findProperties(properties);
        if(entityList != null && entityList.size() > 0){
            List<UserACLDTO> dtoList = new ArrayList<UserACLDTO>();
            for(UserACLEntity entity : entityList){
                dtoList.add(UserACLBeanUtil.entity2DTO(entity));
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public void update(Long userId, Long[] userACLIds) throws RemoveException, DuplicateKeyException {
        List<Long> currentUserACLIds = this.userACLService.findIdsByUser(userId);
        Long[] userACLIds2Delete = findUserACLIdsList2Delete(currentUserACLIds, userACLIds);
        if(userACLIds2Delete != null && userACLIds2Delete.length > 0){
            for(Long permissionId : userACLIds2Delete){
                userACLService.deleteByUserIdAndPermissionId(userId, permissionId);
            }
        }
    }

    private Long[] findUserACLIdsList2Delete(List<Long> currentUserACLIds, Long[] userACLIds){
        List<Long> idList2Delete = new ArrayList<Long>();
        for(Long currentUserACLId : currentUserACLIds){
            boolean matched = false;
            for(Long keepingACLId : userACLIds){
                if(keepingACLId.equals(currentUserACLId)){
                    matched = true;
                    break;
                }
            }
            if(!matched){
                idList2Delete.add(currentUserACLId);
            }
        }
        return idList2Delete.toArray(new Long[idList2Delete.size()]);
    }

    @Override
    public void deleteAllByUser(Long userId) {
        this.userACLService.deleteAllByUser(userId);
    }

    @Override
    public void insert(Long userId, Long[] permissionIds) throws ObjectNotFoundException, DuplicateKeyException {
        UserEntity userEntity = this.userService.findById(userId);
        for(Long permissionId : permissionIds){
            UserACLEntity entity = new UserACLEntity();
            entity.setUser(userEntity);
            PermissionEntity permissionEntity = new PermissionEntity();
            permissionEntity.setPermissionId(permissionId);
            entity.setPermission(permissionEntity);
            userACLService.save(entity);
        }
    }

    @Override
    public List<UserACLDTO> findByUserName(String username){
        List<UserACLEntity> entityList = this.userACLService.findProperty("user.userName", username);
        if(entityList != null && entityList.size() > 0){
            List<UserACLDTO> dtos = new ArrayList<UserACLDTO>();
            for (UserACLEntity entity : entityList){
                dtos.add(UserACLBeanUtil.entity2DTO(entity));
            }
            return dtos;
        }
        return null;
    }
}
