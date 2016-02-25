package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.BidDTO;
import com.banvien.vmsreport.common.dto.BidDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.math.BigDecimal;
import java.text.ParseException;
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
public interface BidManagementLocalBean {
    BidDTO findByCode(String code) throws ObjectNotFoundException;

    BidDTO updateItem(BidDTO dto, Long userId, Map<Integer, Long> mapnv, Long isChuTri) throws ObjectNotFoundException, DuplicateKeyException, RemoveException;
    BidDTO addItem(BidDTO dto, Long userId, Map<Integer, Long> mapnv, Long isChuTri) throws DuplicateKeyException, ObjectNotFoundException, RemoveException;
    Integer deleteItems(String[] checkList) throws ObjectNotFoundException, RemoveException;
    Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems, String whereClause);
    Object[] searchForList(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);
    BidDTO findId(Long bidId) throws ObjectNotFoundException;
    List<BidDTO> searchAutoComplete(String name, Integer maxResult);
    Long findMAX();

    List<BidDTO> findByUserId(Long userId);

    List<BidDTO> findAll();
}
