package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.UserDTO;

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
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserManagementLocalBean {
    UserDTO findByUsername(String username) throws ObjectNotFoundException;

    UserDTO findAllAndFetchPermission(String username) throws ObjectNotFoundException;

    UserDTO addItem(UserDTO account) throws DuplicateKeyException, ObjectNotFoundException;

    UserDTO findByEmail(String email) throws ObjectNotFoundException;

    UserDTO updateItem(UserDTO dto) throws ObjectNotFoundException, DuplicateKeyException;

    UserDTO findById(Long userId) throws ObjectNotFoundException;

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Integer deleteItems(String[] checkList) throws RemoveException;

    void updatePasswordUserLDAP(String userName, String rawPassword) throws ObjectNotFoundException, DuplicateKeyException;

    String getAvatarByUserId(Long userID) throws ObjectNotFoundException;

    UserDTO getPermissionListByPermissionSystem(String username) throws ObjectNotFoundException;

    UserDTO updateProfileItem(UserDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    List<UserDTO> findAll();

    List<UserDTO> findAllUserWithGroup(String codeGroup);


}
