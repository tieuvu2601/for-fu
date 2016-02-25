package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.LoaiDTO;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface LoaiManagementLocalBean {
    Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);

    List<LoaiDTO> findAll();
}
