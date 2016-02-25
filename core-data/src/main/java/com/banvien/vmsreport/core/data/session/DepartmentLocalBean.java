package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DepartmentEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentLocalBean extends GenericSessionBean<DepartmentEntity, Long>{
    List<DepartmentEntity> findDepartmentActive();
}
