package com.banvien.vmsreport.core.data.session;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.entity.HosoluutruEntity;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface HosoluutruLocalBean extends GenericSessionBean<HosoluutruEntity, Long>{
    void deteteByGoiThauId(Long goiThauId);
}
