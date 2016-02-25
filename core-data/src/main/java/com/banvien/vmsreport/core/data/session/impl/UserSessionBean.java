package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.data.entity.UserEntity;
import com.banvien.vmsreport.core.data.session.UserLocalBean;

import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "UserSessionEJB")
public class UserSessionBean extends AbstractSessionBean<UserEntity, Long> implements UserLocalBean{
    public UserSessionBean() {

    }

    @Override
    public UserEntity findByUsernameOfSite(String username) throws ObjectNotFoundException {
        try{
            StringBuilder queryBuilder = new StringBuilder("FROM UserEntity u WHERE LOWER(u.userName) = :userName");

            Query query = entityManager.createQuery(queryBuilder.toString());
            query.setParameter("userName", username);

            UserEntity result = (UserEntity) query.getSingleResult();
            return result;
        }catch (NoResultException ex) {
            throw new ObjectNotFoundException("Not found user with username " + username + " of site ");
        }
    }

    @Override
    public void updateNull4User(Long departmentId) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE UserEntity SET department.departmentId = null WHERE department.departmentId = :departmentId");
        Query query = entityManager.createQuery(sql.toString())
                                    .setParameter("departmentId", departmentId);
        query.executeUpdate();
    }

    @Override
    public List<UserEntity> findAllUserWithGroup(String codeGroup) {
        StringBuffer sql = new StringBuffer("FROM UserEntity user WHERE user.status = 1 " +
                " AND (user.userGroup.code = :groupTP OR user.userGroup.code = :codegroup)");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("groupTP", Constants.GROUP_TRUONGPHONG)
                .setParameter("codegroup", codeGroup);
        return query.getResultList();
    }
}
