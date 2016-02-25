package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmLoaiEntity;
import com.banvien.vmsreport.core.data.entity.DmNguonvonEntity;
import com.banvien.vmsreport.core.data.session.LoaiLocalBean;
import com.banvien.vmsreport.core.data.session.NguonvonLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "LoaiSessionEJB")
public class LoaiSessionBean extends AbstractSessionBean<DmLoaiEntity, Long> implements LoaiLocalBean {
    public LoaiSessionBean() {
    }
}
