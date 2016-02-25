package com.banvien.vmsreport.core.business.impl;


import com.banvien.vmsreport.common.dto.UserGroupACLDTO;
import com.banvien.vmsreport.common.dto.UserGroupDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.UserGroupManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.UserGroupBeanUtil;
import com.banvien.vmsreport.core.data.entity.UserGroupACLEntity;
import com.banvien.vmsreport.core.data.entity.UserGroupEntity;
import com.banvien.vmsreport.core.data.session.UserGroupLocalBean;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/7/15
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserGroupManagementSessionEJB")
public class UserGroupManagementSessionBean implements UserGroupManagementLocalBean {
    public UserGroupManagementSessionBean() {
    }

    @EJB
    private UserGroupLocalBean userGroupService;

    @Override
    public Integer deleteItems(String[] checkList){
        Integer res = 0;
        if(checkList != null && checkList.length >= 0){
            for(String id : checkList){
                try {
                    userGroupService.delete(Long.parseLong(id));
                    res++;
                } catch (RemoveException e){}
            }
        }
        return  res;
    }

    @Override
    public Object[] search(Map<String,Object> properties,String sortExpression,String sortDirection,int firstItem,int maxPageItems){
        Object[] res = userGroupService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<UserGroupDTO> dtos = new ArrayList<UserGroupDTO>();
        for(UserGroupEntity entity : (List<UserGroupEntity>)res[1])  {
            dtos.add(UserGroupBeanUtil.entity2DTO(entity));
        }
        res[1]=dtos;
        return res;
    }

    @Override
    public UserGroupDTO updateItem(UserGroupDTO userGroupDTO) throws ObjectNotFoundException, DuplicateKeyException {
        UserGroupEntity dbItem = this.userGroupService.findById(userGroupDTO.getUserGroupId());
        if (dbItem==null) throw new ObjectNotFoundException("Not found user group : " + userGroupDTO.getUserGroupId());
        UserGroupEntity pojo = DozerSingletonMapper.getInstance().map(userGroupDTO, UserGroupEntity.class);
        if (pojo.getCenter() == null){
            pojo.setCenter(0);
        }
        return UserGroupBeanUtil.entity2DTO(userGroupService.update(pojo));
    }

    @Override
    public UserGroupDTO addItem(UserGroupDTO userGroupDTO) throws DuplicateKeyException{
        UserGroupEntity entity = new UserGroupEntity();
        entity.setUserGroupId(userGroupDTO.getUserGroupId());
        entity.setCode(userGroupDTO.getCode());
        entity.setName(userGroupDTO.getName());
        if (entity.getCenter() != null){
            entity.setCenter(userGroupDTO.getCenter());
        }else {
            entity.setCenter(0);
        }
        return UserGroupBeanUtil.entity2DTO(userGroupService.save(entity));
    }

    @Override
    public UserGroupDTO findById(Long userGroupId) throws ObjectNotFoundException{
        return UserGroupBeanUtil.entity2DTO(this.userGroupService.findById(userGroupId));
    }

    @Override
    public List<UserGroupDTO> findAll(){
        List<UserGroupDTO> dtoList = new ArrayList<UserGroupDTO>();
        List<UserGroupEntity> entities = this.userGroupService.findAll();
        for (UserGroupEntity entity : entities){
            UserGroupDTO userGroupDTO = UserGroupBeanUtil.entity2DTO(entity);
            dtoList.add(userGroupDTO);
        }
        return dtoList;
    }

    @Override
    public UserGroupDTO findByCode(String code) throws ObjectNotFoundException{

        return UserGroupBeanUtil.entity2DTO(this.userGroupService.findEqualUnique("code", code));
    }

    @Override
    public List<UserGroupACLDTO> searchByUserGroupId(Long userGroupId) throws ObjectNotFoundException{
        List<UserGroupACLDTO> listResult = new ArrayList<UserGroupACLDTO>();
        List<UserGroupACLEntity> entities = this.userGroupService.searchPermissionByUserGroupId(userGroupId);
        for(UserGroupACLEntity entity : entities)     {
           UserGroupACLDTO userGroupACLDTO = DozerSingletonMapper.getInstance().map(entity,UserGroupACLDTO.class);
            listResult.add(userGroupACLDTO);
        }
        return listResult;
    }


}
