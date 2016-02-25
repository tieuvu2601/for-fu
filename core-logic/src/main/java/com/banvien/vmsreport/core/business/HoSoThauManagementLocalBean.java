package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.HoSoThauDTO;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/17/15
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface HoSoThauManagementLocalBean {
    List<HoSoThauDTO> findByGoiThau(Long msgoithau);

    void autoCreateHSNT(Long msgoithau) throws DuplicateKeyException;

    HoSoThauDTO findByGoiThauNhaThau(Long gt_nt) throws ObjectNotFoundException;

    HoSoThauDTO insert(HoSoThauDTO pojo) throws ObjectNotFoundException, DuplicateKeyException;

    HoSoThauDTO update(HoSoThauDTO pojo) throws DuplicateKeyException;
}
