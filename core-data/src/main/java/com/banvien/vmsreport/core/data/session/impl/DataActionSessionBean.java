package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmDataActionEntity;
import com.banvien.vmsreport.core.data.session.DataActionLocalBean;

import javax.ejb.Stateless;

@Stateless(name = "DataActionSessionEJB")
public class DataActionSessionBean extends AbstractSessionBean<DmDataActionEntity, Long> implements DataActionLocalBean {
    public DataActionSessionBean() {
    }
}
