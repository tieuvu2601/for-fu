package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.RoleACLDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface RoleACLManagementLocalBean {
    List<RoleACLDTO> findByUser(Long userId);

    void addNew(Long roleId, String[] checkList);

    void update(Long roleId, Long[] permissionIds) throws RemoveException, DuplicateKeyException;

    List<RoleACLDTO> searchByRoleId(Long roleId);

    void deleteAllByRole(Long roleId);

    void insert(Long roleId, Long[] permissionIds) throws ObjectNotFoundException, DuplicateKeyException;
}
