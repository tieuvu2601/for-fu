package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmHinhthucgtEntity;
import com.banvien.vmsreport.core.data.entity.DmLanhdaoEntity;
import com.banvien.vmsreport.core.data.session.HinhthucLocalBean;
import com.banvien.vmsreport.core.data.session.LanhdaoLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "HinhthucSessionEJB")
public class HinhthucSessionBean extends AbstractSessionBean<DmHinhthucgtEntity, Long> implements HinhthucLocalBean{
    public HinhthucSessionBean() {
    }
}
