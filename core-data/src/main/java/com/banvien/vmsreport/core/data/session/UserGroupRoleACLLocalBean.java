package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.UserGroupRoleACLEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 9/25/15
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserGroupRoleACLLocalBean extends GenericSessionBean<UserGroupRoleACLEntity, Long> {
    List<UserGroupRoleACLEntity> searchRoleByUserGroupId(Long userGroupId);
    void deleteAllByUserGroup(Long userGroupId);
    List<Long> findIdsByUserGroup(Long userGroupId);
    void deleteByRoleId(Long roleId);
}
