package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.UserEntity;

import javax.ejb.ObjectNotFoundException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserLocalBean extends GenericSessionBean<UserEntity, Long>{
    UserEntity findByUsernameOfSite(String username) throws ObjectNotFoundException;
    void updateNull4User(Long departmentId);

    List<UserEntity> findAllUserWithGroup(String codeGroup);
}
