package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.session.DMTinhTrangLocalBean;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "DMTinhTrangSessionEJB")
public class DMTinhTrangSessionBean extends AbstractSessionBean<DmTinhtrangEntity, Long> implements DMTinhTrangLocalBean {
    public DMTinhTrangSessionBean(){

    }

    @Override
    public DmTinhtrangEntity findByCode(String code) {
        StringBuffer sql = new StringBuffer("FROM DmTinhtrangEntity e WHERE e.maSoTinhTrang = :code");
        Query query = entityManager.createQuery(sql.toString())
                .setParameter("code", code);
        return (DmTinhtrangEntity)query.getSingleResult();
    }
}
