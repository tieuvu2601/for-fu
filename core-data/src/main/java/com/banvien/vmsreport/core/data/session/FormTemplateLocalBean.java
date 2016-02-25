package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmLoaibieumauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface FormTemplateLocalBean extends GenericSessionBean<DmLoaibieumauEntity, Long> {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

    Object[] findByMaGoiThau(String maGoiThau);

    List<DmLoaibieumauEntity> findSortSTT();
}
