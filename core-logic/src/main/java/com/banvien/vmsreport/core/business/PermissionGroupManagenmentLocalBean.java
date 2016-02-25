package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.PermissionGroupDTO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 9/1/15
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface PermissionGroupManagenmentLocalBean {
    List<PermissionGroupDTO> findAll();
}
