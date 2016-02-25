package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.RoleDTO;
import com.banvien.vmsreport.common.dto.UserACLDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserACLManagementLocalBean {
    List<UserACLDTO> findByUser(Long userId, String permissionFilterCode, String permissionFilterName);
    void update(Long userId, Long[] userACLIds) throws RemoveException, DuplicateKeyException;

    void deleteAllByUser(Long userId);

    void insert(Long userId, Long[] permissionIds) throws ObjectNotFoundException, DuplicateKeyException;

    List<UserACLDTO> findByUserName(String username);
}
