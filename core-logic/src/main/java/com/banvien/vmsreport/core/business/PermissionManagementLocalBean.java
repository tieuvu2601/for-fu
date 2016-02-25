package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.PermissionDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface PermissionManagementLocalBean {
    PermissionDTO findByCode(String code) throws ObjectNotFoundException;

    PermissionDTO findByName(String name) throws ObjectNotFoundException;

    Object[] searchByProperties(Map<String,Object> properties,String sortExpression,String sortDirection,int firstItem,int maxPageItems);

    PermissionDTO updateItem(PermissionDTO permission) throws ObjectNotFoundException, DuplicateKeyException;

    PermissionDTO addItem(PermissionDTO pojo) throws DuplicateKeyException;

    PermissionDTO findById(Long permissionId) throws ObjectNotFoundException;

    Integer deleteItems(String[] checkList) throws RemoveException;

    List<PermissionDTO> findPermissionsNotInUser(Long userId, String permissionFilterCode, String permissionFilterName);

    List<PermissionDTO> findByRole(Long roleId, Long permissionGroupId);

    List<PermissionDTO> findNotInRole(Long roleId, Long permissionGroupId);

    List<PermissionDTO> findPermissionsInUser(Long userId, String permissionFilterCode, String permissionFilterName);
}
