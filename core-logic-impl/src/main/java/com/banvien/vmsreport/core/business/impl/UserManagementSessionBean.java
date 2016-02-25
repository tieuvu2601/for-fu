package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.common.security.DesEncrypterUtils;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.UserManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.PermissionBeanUtil;
import com.banvien.vmsreport.core.business.utils.UserBeanUtil;
import com.banvien.vmsreport.core.data.entity.*;
import com.banvien.vmsreport.core.data.session.*;

import javax.ejb.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 10:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserManagementSessionEJB")
public class UserManagementSessionBean implements UserManagementLocalBean{
    public UserManagementSessionBean() {
    }

    @EJB
    private UserLocalBean userService;
    @EJB
    private UserACLLocalBean userACLService;
    @EJB
    private UserRoleACLLocalBean userRoleACLService;
    @EJB
    private RoleLocalBean roleService;
    @EJB
    private PermissionLocalBean permissionService;

    @Override
    public UserDTO findByUsername(String username) throws ObjectNotFoundException{
        return UserBeanUtil.entity2DTO(userService.findEqualUnique("userName", username));
    }

    @Override
    public UserDTO findAllAndFetchPermission(String username) throws ObjectNotFoundException{
        UserEntity entity = userService.findByUsernameOfSite(username);
        List<PermissionEntity> permissions = permissionService.findPermissionOfUser(entity.getUserId());
        List<PermissionDTO> permissionDTOs = new ArrayList<PermissionDTO>();
        for (PermissionEntity permissionEntity : permissions) {
            permissionDTOs.add(PermissionBeanUtil.entity2DTO(permissionEntity));
        }
        UserDTO userDTO = UserBeanUtil.entity2DTO(entity);
        userDTO.setPermissions(permissionDTOs);
        return userDTO;
    }

    @Override
    public UserDTO addItem(UserDTO account) throws DuplicateKeyException, ObjectNotFoundException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(account.getUserName());
        userEntity.setPassword(DesEncrypterUtils.getInstance().encrypt(account.getPassword()));
        userEntity.setEmail(account.getEmail());
        userEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userEntity.setStatus(account.getStatus() != null ? account.getStatus() : Constants.USER_INACTIVE);
        userEntity.setDisplayName(account.getDisplayName());
        userEntity.setLDAP(account.getLDAP() != null ? account.getLDAP() : Constants.USER_LOCAL);
        userEntity.setAvatar(account.getAvatar());

        if(account.getDepartment() != null && account.getDepartment().getDepartmentId() != null){
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setDepartmentId(account.getDepartment().getDepartmentId());
            userEntity.setDepartment(departmentEntity);
        }
        if(account.getUserGroup() != null && account.getUserGroup().getUserGroupId() != null){
            UserGroupEntity userGroupEntity = new UserGroupEntity();
            userGroupEntity.setUserGroupId(account.getUserGroup().getUserGroupId());
            userGroupEntity.setCode(account.getUserGroup().getCode());
            userEntity.setUserGroup(userGroupEntity);
        }

        userEntity = userService.save(userEntity);

        if(account.isXt()){
            UserRoleACLEntity userRoleACLEntity = new UserRoleACLEntity();
            userRoleACLEntity.setRole(this.roleService.findById(1l));
            userRoleACLEntity.setUser(userEntity);
            this.userRoleACLService.save(userRoleACLEntity);
        }
        if(account.isTd()){
            UserRoleACLEntity userRoleACLEntity = new UserRoleACLEntity();
            userRoleACLEntity.setRole(this.roleService.findById(2l));
            userRoleACLEntity.setUser(userEntity);
            this.userRoleACLService.save(userRoleACLEntity);
        }

        return UserBeanUtil.entity2DTO(userEntity);
    }

    @Override
    public UserDTO findByEmail(String email) throws ObjectNotFoundException {
        UserEntity entity = userService.findEqualUnique("email", email);
        return UserBeanUtil.entity2DTO(entity);
    }

    @Override
    public UserDTO updateItem(UserDTO dto) throws ObjectNotFoundException, DuplicateKeyException {
        UserEntity dbItem = this.userService.findById(dto.getUserId());

        UserGroupEntity userGroup = new UserGroupEntity();
        userGroup.setUserGroupId(dto.getUserGroup().getUserGroupId());
        userGroup.setCode(dto.getUserGroup().getCode());
        dbItem.setUserGroup(userGroup);

        if (dto.getDepartment() !=null){
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setDepartmentId(dto.getDepartment().getDepartmentId());
            dbItem.setDepartment(departmentEntity);
        }

        dbItem.setUserName(dto.getUserName());
        dbItem.setStatus(dto.getStatus() != null ? dto.getStatus() : Constants.USER_INACTIVE);
        dbItem.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        dbItem.setPassword(DesEncrypterUtils.getInstance().encrypt(dto.getPassword()));
        dbItem.setDisplayName(dto.getDisplayName());
        dbItem.setEmail(dto.getEmail());
        dbItem.setLDAP(dto.getLDAP());
//        dbItem.setAvatar(dto.getAvatar());
        if(dbItem.getCreatedDate() == null){
            dbItem.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        }
        dbItem =  userService.update(dbItem);
        this.userRoleACLService.deleteAllByUser(dbItem.getUserId());

        if(dto.isXt()){
            UserRoleACLEntity userRoleACLEntity = new UserRoleACLEntity();
            userRoleACLEntity.setRole(this.roleService.findById(1l));
            userRoleACLEntity.setUser(dbItem);
            this.userRoleACLService.save(userRoleACLEntity);
        }
        if(dto.isTd()){
            UserRoleACLEntity userRoleACLEntity = new UserRoleACLEntity();
            userRoleACLEntity.setRole(this.roleService.findById(2l));
            userRoleACLEntity.setUser(dbItem);
            this.userRoleACLService.save(userRoleACLEntity);
        }

        return UserBeanUtil.entity2DTO(dbItem);
    }

    @Override
    public UserDTO findById(Long userId) throws ObjectNotFoundException {
        return UserBeanUtil.entity2DTO(userService.findById(userId));
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object [] res = userService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<UserDTO> dtos = new ArrayList<UserDTO>();
        for (UserEntity entity : (List<UserEntity>)res[1]){
            dtos.add(UserBeanUtil.entity2DTO(entity));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public Integer deleteItems(String[] checkList) throws RemoveException{
        Integer res = 0;
        if(checkList != null && checkList.length >= 0){
            for(String id : checkList){
                userRoleACLService.deleteByUserId(Long.valueOf(id.toString()));
                userACLService.deleteByUserId(Long.valueOf(id.toString()));
                userService.delete(Long.valueOf(id.toString()));
                res++;
            }
        }
        return  res;
    }

    @Override
    public void updatePasswordUserLDAP(String userName, String rawPassword) throws ObjectNotFoundException, DuplicateKeyException{
        UserEntity dbItem = this.userService.findEqualUnique("userName", userName);
        dbItem.setPassword(DesEncrypterUtils.getInstance().encrypt(rawPassword));
        userService.update(dbItem);
    }

    @Override
    public String getAvatarByUserId(Long userID) throws ObjectNotFoundException {
        UserEntity dbItem = this.userService.findById(userID);
        return dbItem.getAvatar();
    }

    @Override
    public UserDTO getPermissionListByPermissionSystem(String username) throws ObjectNotFoundException {
        UserEntity entity = userService.findByUsernameOfSite(username);
        List<PermissionEntity> permissions = permissionService.getPermissionListByPermissionSystem(entity.getUserId());
        List<PermissionDTO> permissionDTOs = new ArrayList<PermissionDTO>();
        for (PermissionEntity permissionEntity : permissions) {
            permissionDTOs.add(PermissionBeanUtil.entity2DTO(permissionEntity));
        }
        UserDTO userDTO = UserBeanUtil.entity2DTO(entity);
        userDTO.setPermissions(permissionDTOs);
        return userDTO;
    }

    @Override
    public UserDTO updateProfileItem(UserDTO dto) throws ObjectNotFoundException, DuplicateKeyException {
        UserEntity dbItem = this.userService.findById(dto.getUserId());

        dbItem.setUserName(dto.getUserName());
        dbItem.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        dbItem.setPassword(DesEncrypterUtils.getInstance().encrypt(dto.getPassword()));
        dbItem.setDisplayName(dto.getDisplayName());
        dbItem.setEmail(dto.getEmail());
        dbItem.setAvatar(dto.getAvatar());
        return UserBeanUtil.entity2DTO(userService.update(dbItem));
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> entities = userService.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity entity : entities){
            dtoList.add(UserBeanUtil.entity2DTO(entity));
        }
        return dtoList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<UserDTO> findAllUserWithGroup(String codeGroup) {
        List<UserEntity> listEntities = userService.findAllUserWithGroup(codeGroup);
        List<UserDTO> res = new ArrayList<>();
        for(UserEntity userEntity : listEntities){
            res.add(DozerSingletonMapper.getInstance().map(userEntity, UserDTO.class));
        }
        return res;
    }
}
