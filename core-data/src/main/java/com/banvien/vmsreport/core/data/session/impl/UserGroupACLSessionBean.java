package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.UserGroupACLEntity;
import com.banvien.vmsreport.core.data.session.UserGroupACLLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/25/15
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="UserGroupACLSessionEJB")
public class UserGroupACLSessionBean extends AbstractSessionBean<UserGroupACLEntity,Long> implements UserGroupACLLocalBean {
    public UserGroupACLSessionBean(){

    }

    @Override
    public void deletePermissionByUserGroupId(Long userGroupId, Long permissionId){
        StringBuffer sqlQuery = new StringBuffer();
        sqlQuery.append("DELETE FROM UserGroupACLEntity WHERE userGroup.userGroupId =: userGroup_Id AND permission.permissionId = : permission_Id");
        Query query = entityManager.createQuery(sqlQuery.toString());
        query.setParameter("userGroup_Id",userGroupId);
        query.setParameter("permission_Id",permissionId);
        query.executeUpdate();
    }

    @Override
    public List<Long> searchPermissionByUserGroupId(Long userGroupId){
        if (userGroupId!= null && userGroupId > 0 ){
            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append("FROM UserGroupACLEntity WHERE userGroup.userGroupId = :userGroup_Id");
            Query query = entityManager.createQuery(sqlQuery.toString());
            query.setParameter("userGroup_Id",userGroupId);
            return query.getResultList();
        } else {
            return null;
        }
    }
}
