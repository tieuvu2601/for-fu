package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.UserGroupACLEntity;
import com.banvien.vmsreport.core.data.entity.UserGroupEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/20/15
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserGroupLocalBean extends GenericSessionBean<UserGroupEntity,Long> {

    List<UserGroupACLEntity> searchPermissionByUserGroupId(Long userGroupId);

}
