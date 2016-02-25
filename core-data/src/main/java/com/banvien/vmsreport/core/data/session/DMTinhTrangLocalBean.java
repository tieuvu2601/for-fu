package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DMTinhTrangLocalBean extends GenericSessionBean<DmTinhtrangEntity, Long>{

    DmTinhtrangEntity findByCode(String code);
}
