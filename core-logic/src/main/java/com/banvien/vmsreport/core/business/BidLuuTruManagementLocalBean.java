package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.HosolutruuDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface BidLuuTruManagementLocalBean {
    void updateHoSoLuuTru(Map<Long, HosolutruuDTO> mapBidSaves, Long userId) throws ObjectNotFoundException,DuplicateKeyException;
}
