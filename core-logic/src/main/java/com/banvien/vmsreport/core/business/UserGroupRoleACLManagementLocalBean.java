package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserGroupRoleACLManagementLocalBean {

    void updateRole(Long userGroupId, Long[] userGroupRoleACLId) throws RemoveException, ObjectNotFoundException, DuplicateKeyException;

    List<UserGroupRoleACLDTO> findByUserGroupId(Long userGroupId, String roleFilterCode, String roleFilterName);

    void deleteAllByUserGroup(Long userGroupId);

    void insert(Long userGroupId, Long[] roleIds) throws ObjectNotFoundException, DuplicateKeyException;
}
