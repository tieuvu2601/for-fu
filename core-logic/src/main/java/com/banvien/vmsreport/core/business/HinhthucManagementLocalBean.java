package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.HinhthucgtDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

@Local
public interface HinhthucManagementLocalBean {
    Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);

    List<HinhthucgtDTO> findAll();

    HinhthucgtDTO findByCode(String code) throws ObjectNotFoundException;

    HinhthucgtDTO updateItem(HinhthucgtDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    HinhthucgtDTO addItem(HinhthucgtDTO pojo) throws DuplicateKeyException;

    HinhthucgtDTO findById(Long mshinhthuc) throws ObjectNotFoundException;

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Integer deleteItems(String[] checkList);
}
