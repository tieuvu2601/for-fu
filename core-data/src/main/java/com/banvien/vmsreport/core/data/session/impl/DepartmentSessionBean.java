package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DepartmentEntity;
import com.banvien.vmsreport.core.data.session.DepartmentLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "DepartmentSessionEJB")
public class DepartmentSessionBean extends AbstractSessionBean<DepartmentEntity, Long> implements DepartmentLocalBean{
    public DepartmentSessionBean() {
    }

    @Override
    public List<DepartmentEntity> findDepartmentActive() {
        StringBuffer sql = new StringBuffer("FROM DepartmentEntity e WHERE e.active = 1");
        Query query = entityManager.createQuery(sql.toString());
        return query.getResultList();
    }
}
