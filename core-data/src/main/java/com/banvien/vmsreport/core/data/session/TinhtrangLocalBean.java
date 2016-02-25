package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TinhtrangLocalBean extends GenericSessionBean<DmTinhtrangEntity, Long>{
    DmTinhtrangEntity findByCode(String code);
}
