package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.StoreFileDTO;

import javax.ejb.ObjectNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/28/16
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StoreFileManagementLocalBean {
    Map<String,String> findMapUrlByMsGoiThau(Long msgoithau) throws ObjectNotFoundException;

    List<StoreFileDTO> updateAndSave(List<StoreFileDTO> listUrlFile);
}
