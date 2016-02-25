package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.CanCuDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface CanCuManagementLocalBean {
    CanCuDTO updateItem(CanCuDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    CanCuDTO addItem(CanCuDTO pojo) throws DuplicateKeyException;

    CanCuDTO findById(Long id) throws ObjectNotFoundException;

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Integer deleteItems(String[] checkList);

    CanCuDTO findByMaCanCu(String code);
}
