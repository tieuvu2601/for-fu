package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmNoidunghosoEntity;
import com.banvien.vmsreport.core.data.session.NoiDungHoSoLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/18/15
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "NoiDungHoSoSessionEJB")
public class NoiDungHoSoSessionBean extends AbstractSessionBean<DmNoidunghosoEntity, Long> implements NoiDungHoSoLocalBean {
}
