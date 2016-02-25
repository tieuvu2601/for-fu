package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.dto.NhaThauDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
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
public interface GoiThauNhaThauManagementLocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Integer deleteNhaThau(String[] checkList) throws ObjectNotFoundException, RemoveException;

    Integer delete(String[] checkList) throws ObjectNotFoundException, RemoveException;

    List<GoithaunhathauDTO> findByGoiThau(Long msgoithau);

    void insertOrUpdate(List lazyList, String[] checkList, Long msGoiThau) throws RemoveException, ObjectNotFoundException, DuplicateKeyException;

    List<GoithaunhathauDTO> findByMaGoiThau(String maGoiThau);

    GoithaunhathauDTO findByGoiThauAndNhanThau(Long goithauid, Long msNhaThau);
}

