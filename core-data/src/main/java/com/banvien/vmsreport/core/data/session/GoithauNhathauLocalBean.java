package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/10/15
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GoithauNhathauLocalBean extends GenericSessionBean<GoithauNhathauEntity, Long> {
    List<GoithauNhathauEntity> findByGoiThau(Long msgoithau);

    void resetNhaThauTrungThau(Long msgoithau);

    void updateTrungThauNhaThau(Long msNTTT);

    void deteteByGoiThauId(Long goiThauId);

    GoithauNhathauEntity findByGoiThauAndNhanThau(Long goithauid, Long msNhaThau);

}
