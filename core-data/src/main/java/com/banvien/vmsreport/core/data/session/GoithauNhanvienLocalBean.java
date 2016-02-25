package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.GoithauNhanvienEntity;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/10/15
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GoithauNhanvienLocalBean extends GenericSessionBean<GoithauNhanvienEntity, Long> {
    void deleteByNhanVien(Long nhanvienId);
    void deteteByGoiThauId(Long goiThauId);

    List<GoithauNhanvienEntity> findByGoiThau(Long msgoithau);
}
