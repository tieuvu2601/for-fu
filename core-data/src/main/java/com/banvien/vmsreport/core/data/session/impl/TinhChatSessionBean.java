package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmTinhchatgtEntity;
import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.session.TinhchatLocalBean;
import com.banvien.vmsreport.core.data.session.TinhtrangLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "TinhChatSessionEJB")
public class TinhChatSessionBean extends AbstractSessionBean<DmTinhchatgtEntity, Long> implements TinhchatLocalBean{
    public TinhChatSessionBean() {
    }
}
