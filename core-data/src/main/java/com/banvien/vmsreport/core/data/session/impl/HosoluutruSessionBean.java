package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmLoaiEntity;
import com.banvien.vmsreport.core.data.entity.HosoluutruEntity;
import com.banvien.vmsreport.core.data.session.HosoluutruLocalBean;
import com.banvien.vmsreport.core.data.session.LoaiLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "HosoluutruSessionEJB")
public class HosoluutruSessionBean extends AbstractSessionBean<HosoluutruEntity, Long> implements HosoluutruLocalBean {
    public HosoluutruSessionBean() {
    }

    @Override
    public void deteteByGoiThauId(Long goiThauId) {
        StringBuffer str = new StringBuffer("DELETE FROM HosoluutruEntity td WHERE td.goithau.msgoithau =:goiThauId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }
}
