package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.FormTemplateDTO;
import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.dto.LoaiBieuMauDTO;

import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface FormTemplateManagementLocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    List<FormTemplateDTO> findALL();

    FormTemplateDTO findByMaGoiThau(String maGoiThau);

    FormTemplateDTO findById(Long msBieuMau) throws ObjectNotFoundException;

    FormTemplateDTO findByBieuMau(String bieuMau) throws ObjectNotFoundException;
}
