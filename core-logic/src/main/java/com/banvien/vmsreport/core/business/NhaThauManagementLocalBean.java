package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.NhaThauDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/11/15
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface NhaThauManagementLocalBean {
    NhaThauDTO findbyId(Long msnhathau) throws ObjectNotFoundException;

    void insetOrUpdate(NhaThauDTO pojo) throws DuplicateKeyException;

    NhaThauDTO findByMaSoThue(String maSoThue) throws ObjectNotFoundException;

    List<NhaThauDTO> findByAll();

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);
}
