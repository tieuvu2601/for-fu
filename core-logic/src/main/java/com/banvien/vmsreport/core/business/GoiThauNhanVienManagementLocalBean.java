package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.GoithaunhanvienDTO;

import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface GoiThauNhanVienManagementLocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    List<GoithaunhanvienDTO> findByMaGoiThau(String maGoiThau) throws ObjectNotFoundException;

    List<GoithaunhanvienDTO> findByUserId(Long userId);
}

