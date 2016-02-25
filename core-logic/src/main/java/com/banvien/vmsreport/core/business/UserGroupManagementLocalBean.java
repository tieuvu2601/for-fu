package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.UserGroupACLDTO;
import com.banvien.vmsreport.common.dto.UserGroupDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/7/15
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserGroupManagementLocalBean {
    Integer deleteItems(String[] checkList);

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    UserGroupDTO updateItem(UserGroupDTO userGroupDTO) throws ObjectNotFoundException, DuplicateKeyException;

    UserGroupDTO addItem(UserGroupDTO userGroupDTO) throws DuplicateKeyException;

    UserGroupDTO findById(Long userGroupId) throws ObjectNotFoundException;

    List<UserGroupDTO> findAll();

    UserGroupDTO findByCode(String code) throws ObjectNotFoundException;

    List<UserGroupACLDTO> searchByUserGroupId(Long userGroupId) throws ObjectNotFoundException;
}
