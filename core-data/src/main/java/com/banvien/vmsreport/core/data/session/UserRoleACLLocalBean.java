package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.UserRoleACLEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRoleACLLocalBean extends GenericSessionBean<UserRoleACLEntity, Long>{
    void deleteAllByUser(Long userId);

    List<Long> findIdsByUser(Long userId);
    void deleteByUserId(Long userId);

    void deleteByRoleId(Long roleId);

    void deleteByUserIdAndRoleId(Long userId, Long roleId);
}
