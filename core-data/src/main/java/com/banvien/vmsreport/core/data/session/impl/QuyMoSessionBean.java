package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmQuyMoEntity;
import com.banvien.vmsreport.core.data.session.QuimoLocalBean;

import javax.ejb.Stateless;

@Stateless(name = "QuyMoSessionEJB")
public class QuyMoSessionBean extends AbstractSessionBean<DmQuyMoEntity, Long> implements QuimoLocalBean {
    public QuyMoSessionBean() {
    }
}
