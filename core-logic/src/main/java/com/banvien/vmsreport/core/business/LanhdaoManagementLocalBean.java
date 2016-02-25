package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.LanhdaoDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface LanhdaoManagementLocalBean {
    Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);

    LanhdaoDTO updateItem(LanhdaoDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    LanhdaoDTO addItem(LanhdaoDTO pojo) throws DuplicateKeyException;

    LanhdaoDTO findById(Long id) throws ObjectNotFoundException;

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Integer deleteItems(String[] checkList);
}
