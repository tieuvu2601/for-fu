package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmLoaibieumaufeildFieldEntity;
import com.banvien.vmsreport.core.data.session.BieuMauFieldFieldLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/23/15
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "BieuMauFieldFieldSessionEJB")
public class BieuMauFieldFieldSessionBean extends AbstractSessionBean<DmLoaibieumaufeildFieldEntity, Long> implements BieuMauFieldFieldLocalBean {
    public BieuMauFieldFieldSessionBean() {
    }
}
