package com.banvien.vmsreport.core.data.session.impl;



import com.banvien.vmsreport.core.data.entity.UserGroupACLEntity;
import com.banvien.vmsreport.core.data.entity.UserGroupEntity;
import com.banvien.vmsreport.core.data.session.UserGroupLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/20/15
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserGroupSessionEJB")
public class UserGroupSessionBean extends AbstractSessionBean<UserGroupEntity,Long> implements UserGroupLocalBean {
    public UserGroupSessionBean(){
    }
    @Override
    public List<UserGroupACLEntity> searchPermissionByUserGroupId(Long userGroupId){
        if (userGroupId!= null && userGroupId > 0 ){
            StringBuffer sqlQuery = new StringBuffer(" FROM UserGroupACLEntity ugae WHERE 1 = 1 ");
            sqlQuery.append(" AND ugae.userGroup.userGroupId = :userGroupId ");
            Query query = entityManager.createQuery(sqlQuery.toString());
            query.setParameter("userGroupId", userGroupId);
            return (List<UserGroupACLEntity>)query.getResultList();
        } else {
            return null;
        }
    }
}