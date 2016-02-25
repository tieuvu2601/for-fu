package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmLoaibieumaufeildEntity;
import com.banvien.vmsreport.core.data.session.BieuMauFieldLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/23/15
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "BieuMauFieldSessionEJB")
public class BieuMauFieldSessionBean extends AbstractSessionBean<DmLoaibieumaufeildEntity, Long> implements BieuMauFieldLocalBean {
    public BieuMauFieldSessionBean() {
    }
}
