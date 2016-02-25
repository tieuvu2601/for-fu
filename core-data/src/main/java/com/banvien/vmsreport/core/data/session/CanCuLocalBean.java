package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmCanCuEntity;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CanCuLocalBean extends GenericSessionBean<DmCanCuEntity, Long>{
    DmCanCuEntity findByMaCanCu(String code);
}
