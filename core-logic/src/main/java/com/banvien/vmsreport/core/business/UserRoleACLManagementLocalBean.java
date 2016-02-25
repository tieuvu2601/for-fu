package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.UserRoleACLDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserRoleACLManagementLocalBean {
    List<UserRoleACLDTO> findByUser(Long userId, String roleFilterCode, String roleFilterName);

    void deleteAllByUser(Long userId);

    void insert(Long userId, Long[] roleIds) throws ObjectNotFoundException, DuplicateKeyException;

    void update(Long userId, Long[] userRoleACLIds) throws RemoveException, DuplicateKeyException;

    List<UserRoleACLDTO> findByUserName(String username);

}
