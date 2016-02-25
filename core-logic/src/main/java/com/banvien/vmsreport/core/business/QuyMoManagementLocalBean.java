package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.HinhthucgtDTO;
import com.banvien.vmsreport.common.dto.QuyMoDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

@Local
public interface QuyMoManagementLocalBean {
    Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);

    List<QuyMoDTO> findAll();

    QuyMoDTO updateItem(QuyMoDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    QuyMoDTO addItem(QuyMoDTO pojo) throws DuplicateKeyException;

    QuyMoDTO findById(Long id) throws ObjectNotFoundException;

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Integer deleteItems(String[] checkList);

    QuyMoDTO findByName(String code);
}
