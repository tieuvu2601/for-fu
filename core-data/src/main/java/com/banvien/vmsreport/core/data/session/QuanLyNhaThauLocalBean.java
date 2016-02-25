package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmNhathauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface QuanLyNhaThauLocalBean extends GenericSessionBean<DmNhathauEntity, Long> {

    List<DmNhathauEntity> findByAllNotGoiThauCur(Long msGoiThau);


}
