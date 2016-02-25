package com.banvien.vmsreport.core.business.impl;


import com.banvien.vmsreport.common.dto.UserGroupACLDTO;
import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.UserGroupACLManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.*;
import com.banvien.vmsreport.core.data.session.UserGroupACLLocalBean;
import com.banvien.vmsreport.core.data.session.UserGroupLocalBean;
import com.banvien.vmsreport.core.data.session.UserGroupRoleACLLocalBean;

import javax.ejb.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/25/15
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name= "UserGroupACLManagementSessionEJB")
public class UserGroupACLManagementSessionBean implements UserGroupACLManagementLocalBean {
    public  UserGroupACLManagementSessionBean(){

    }
    @EJB
    private UserGroupACLLocalBean userGroupACLLocalBean;

    @EJB
    private UserGroupLocalBean userGroupLocalBean;



    @Override
    public void updatePermission(Long userGroupId, String[] checkList) throws RemoveException, ObjectNotFoundException, DuplicateKeyException {
        List<UserGroupACLEntity> listOldUserGroupACL = (List<UserGroupACLEntity>)userGroupACLLocalBean.searchPermissionByUserGroupId(userGroupId);
        UserGroupEntity userGroupEntity = this.userGroupLocalBean.findById(userGroupId);
        Map<Long, Long> mapUserGroupACL = new HashMap<>();
        for(UserGroupACLEntity entity : listOldUserGroupACL) {
            mapUserGroupACL.put(entity.getPermission().getPermissionId(), entity.getUserGroupACLId());
        }
        List<Long> listAdd = new ArrayList<>();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if(checkList!=null){
           for(int i = 0 ; i< checkList.length ; i++){
              Long permissionId = Long.valueOf(checkList[i].toString());
                if(mapUserGroupACL.get(permissionId) != null){
                    mapUserGroupACL.remove(permissionId);
                }else{
                    listAdd.add(permissionId);
                }
           }
        }
        Iterator iter = mapUserGroupACL.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry mEntry = (Map.Entry) iter.next();
            Long idGroup = (Long)mEntry.getValue();
            userGroupACLLocalBean.delete(idGroup);
        }
        for(Long permissionId : listAdd){
            UserGroupACLEntity userGroupACLEntity = new UserGroupACLEntity();
            userGroupACLEntity.setUserGroup(userGroupEntity);
            PermissionEntity permissionEntity = new PermissionEntity();
            permissionEntity.setPermissionId(permissionId);
            userGroupACLEntity.setPermission(permissionEntity);
            userGroupACLLocalBean.save(userGroupACLEntity);
        }
    }

    @Override
    public UserGroupACLDTO findId(Long userGroupACLId) throws ObjectNotFoundException{
        return DozerSingletonMapper.getInstance().map(this.userGroupACLLocalBean.findById(userGroupACLId),UserGroupACLDTO.class);
    }

}
