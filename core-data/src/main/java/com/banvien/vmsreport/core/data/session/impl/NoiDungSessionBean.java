package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmNoidungEntity;
import com.banvien.vmsreport.core.data.session.NoiDungLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/11/15
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "NoiDungSessionEJB")
public class NoiDungSessionBean extends AbstractSessionBean<DmNoidungEntity, Long> implements NoiDungLocalBean {
    public NoiDungSessionBean(){

    }

}
