package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.KinhphiEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */
public interface KinhPhiLocalBean extends GenericSessionBean<KinhphiEntity, Long>{
    List<KinhphiEntity> findByGoiThau(Long msgoithau);

    void deleteByGoiThauId(Long goiThauId);
}
