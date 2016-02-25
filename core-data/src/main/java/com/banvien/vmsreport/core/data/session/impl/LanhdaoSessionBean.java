package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmLanhdaoEntity;
import com.banvien.vmsreport.core.data.entity.TiendoEntity;
import com.banvien.vmsreport.core.data.session.LanhdaoLocalBean;
import com.banvien.vmsreport.core.data.session.TienDoLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "LanhdaoSessionEJB")
public class LanhdaoSessionBean extends AbstractSessionBean<DmLanhdaoEntity, Long> implements LanhdaoLocalBean{
    public LanhdaoSessionBean() {
    }
}
