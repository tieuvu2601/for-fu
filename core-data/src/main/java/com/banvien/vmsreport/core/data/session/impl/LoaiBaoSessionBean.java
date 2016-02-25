package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmLoaibaoEntity;
import com.banvien.vmsreport.core.data.session.LoaiBaoLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/11/15
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "LoaiBaoSessionEJB")
public class LoaiBaoSessionBean extends AbstractSessionBean<DmLoaibaoEntity, Long> implements LoaiBaoLocalBean{
    public LoaiBaoSessionBean(){

    }
}
