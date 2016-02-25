package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.PermissionGroupEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/1/15
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PermissionGroupLocalBean extends GenericSessionBean<PermissionGroupEntity, Long>{
    List<PermissionGroupEntity> findAllAndOrder();
}
