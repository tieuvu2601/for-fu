package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.core.business.NoiDungHoSoManagementLocalBean;
import com.banvien.vmsreport.core.data.session.NoiDungHoSoLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/18/15
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "NoiDungHoSoManagementSessionEJB")
public class NoiDungHoSoSessionBean implements NoiDungHoSoManagementLocalBean {
    @EJB
    private NoiDungHoSoLocalBean noiDungHoSoService;
}
