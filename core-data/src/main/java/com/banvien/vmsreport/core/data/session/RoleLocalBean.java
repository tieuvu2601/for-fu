package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.RoleEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/19/15
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleLocalBean extends GenericSessionBean<RoleEntity, Long>{

    List<RoleEntity> findRolesNotInUser(Long userId, String roleFilterCode, String roleFilterName);

    List<RoleEntity> findRolesNotInUserGroup(Long userGroupId, String roleFilterCode, String roleFilterName);

    List<RoleEntity> findRolesInUserGroup(Long userGroupId, String roleFilterCode, String roleFilterName);

    List<RoleEntity> findRolesInUser(Long userId, String roleFilterCode, String roleFilterName);
}
