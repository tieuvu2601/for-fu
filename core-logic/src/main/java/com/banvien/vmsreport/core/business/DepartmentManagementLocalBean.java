package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.core.data.entity.DepartmentEntity;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface DepartmentManagementLocalBean {
    DepartmentDTO findByCode(String code) throws ObjectNotFoundException;

    DepartmentDTO updateItem(DepartmentDTO dto) throws ObjectNotFoundException, DuplicateKeyException;
    DepartmentDTO addItem(DepartmentDTO dto) throws DuplicateKeyException;
    Integer deleteItems(String[] checkList) throws ObjectNotFoundException, RemoveException;
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);

    List<DepartmentDTO> findALL();

    List<DepartmentDTO> findDepartmentActive();

    DepartmentDTO findId(Long departmentId) throws ObjectNotFoundException;
}
