package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.UserGroupACLDTO;
import com.banvien.vmsreport.common.dto.UserGroupRoleACLDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/25/15
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserGroupACLManagementLocalBean {

    void updatePermission(Long userGroupId, String[] checkList) throws RemoveException, ObjectNotFoundException, DuplicateKeyException;

    UserGroupACLDTO findId(Long userGroupACLId) throws ObjectNotFoundException;
}
