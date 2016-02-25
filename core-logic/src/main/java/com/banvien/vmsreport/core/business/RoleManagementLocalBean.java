package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.RoleDTO;
import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface RoleManagementLocalBean {
    RoleDTO findByCode(String code) throws ObjectNotFoundException;

    void deleteItem(Long roleId) throws RemoveException;

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    RoleDTO addItem(RoleDTO pojo) throws DuplicateKeyException;

    RoleDTO updateItem(RoleDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    RoleDTO findById(Long roleId) throws ObjectNotFoundException;

    List<RoleDTO> findRolesNotInUser(Long userId, String roleFilterCode, String roleFilterName);

    List<RoleDTO> findRolesNotInUserGroups(Long userGroupId, String roleFilterCode, String roleFilterName);

    List<RoleDTO> findRolesInUserGroups(Long userGroupId, String roleFilterCode, String roleFilterName);

    List<RoleDTO> findRolesInUser(Long userId, String roleFilterCode, String roleFilterName);
}
