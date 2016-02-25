package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.UserGroupACLEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/25/15
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserGroupACLLocalBean extends GenericSessionBean<UserGroupACLEntity,Long>{
    List searchPermissionByUserGroupId(Long userGroupId);
    void deletePermissionByUserGroupId(Long userGroupId, Long permissionId);

}
