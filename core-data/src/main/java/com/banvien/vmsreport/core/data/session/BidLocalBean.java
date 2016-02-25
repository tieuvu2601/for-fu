package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.GoithauEntity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BidLocalBean extends GenericSessionBean<GoithauEntity, Long>{
    List<GoithauEntity> searchAutoComplete(String name, Integer maxResult);
    Object[] searchForList(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems);

    void updateStatusGoiThau(Long msgoithau, Long mstinhtrang);
    Long findMAX();
}
