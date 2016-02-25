package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.UserACLEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserACLLocalBean extends GenericSessionBean<UserACLEntity, Long>{
    void deleteAllByUser(Long userId);

    List<Long> findIdsByUser(Long userId);
    
    void deleteByUserId(Long userId);

    void deleteByUserIdAndPermissionId(Long userId, Long permissionId);
}
