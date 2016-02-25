package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.entity.HosothauEntity;

import javax.ejb.ObjectNotFoundException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/17/15
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */
public interface HoSoThauLocalBean extends GenericSessionBean<HosothauEntity, Long> {
    List<HosothauEntity> findByGoiThau(Long msgoithau);

    HosothauEntity findHoSoTrungThauByGoiThau(Long goiThauId);

    HosothauEntity findByGoiThauNhaThau(Long gt_nt);

    void deleteHoSoGoiThauNhaThau(Long gt_nt);

    void deteteByGoiThauId(Long goiThauId);
}
