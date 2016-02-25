package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.StoreFileEntity;
import com.banvien.vmsreport.core.data.session.StoreFileLocalBean;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/28/16
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "StoreFileSessionEJB")
public class StoreFileSessionBean extends AbstractSessionBean<StoreFileEntity, Long> implements StoreFileLocalBean {
    public StoreFileSessionBean() {
    }
}
