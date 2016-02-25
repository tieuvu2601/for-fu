package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.entity.TiendoEntity;
import com.banvien.vmsreport.core.data.session.TienDoLocalBean;


import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "TienDoSessionEJB")
public class TienDoSessionBean extends AbstractSessionBean<TiendoEntity, Long> implements TienDoLocalBean{
    public TienDoSessionBean() {
    }

    @Override
    public TiendoEntity findByGoiThauId(Long goiThauId) {
        StringBuffer sql = new StringBuffer("FROM TiendoEntity td WHERE td.goithau.msgoithau = :goithauId");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("goithauId", goiThauId);
        return (TiendoEntity)query.getSingleResult();
    }

    @Override
    public DmTinhtrangEntity getTinhTrangFromTienDoAndGoiThau(Long mstiendo, String magoithau) {
        StringBuffer sql = new StringBuffer("SELECT td.goithau.tinhtrang FROM TiendoEntity td WHERE td.mstiendo = :mstiendo AND td.goithau.msgoithau = :magoithau");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("mstiendo", mstiendo);
        query.setParameter("magoithau", magoithau);
        return (DmTinhtrangEntity)query.getSingleResult();
    }

    @Override
    public List<TiendoEntity> findByTinhTrangGoiThau(List<String> listTinhTrang) {
        StringBuffer sql = new StringBuffer("FROM TiendoEntity td WHERE td.goithau.tinhtrang.maSoTinhTrang IN(:listTinhTrang) ");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("listTinhTrang", listTinhTrang);
        return (List<TiendoEntity>) query.getResultList();
    }

    @Override
    public List<TiendoEntity> findListTienDoNotComplete(String tinhTrangHoanThanh) {
        StringBuffer sql = new StringBuffer("FROM TiendoEntity td WHERE td.goithau.tinhtrang.maSoTinhTrang <> :tinhTrangHoanThanh ");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("tinhTrangHoanThanh", tinhTrangHoanThanh);
        return (List<TiendoEntity>) query.getResultList();
    }

    @Override
    public void deteteByGoiThauId(Long goiThauId) {
        StringBuffer str = new StringBuffer("DELETE FROM TiendoEntity td WHERE td.goithau.msgoithau =:goiThauId");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter("goiThauId", goiThauId);
        query.executeUpdate();
    }
}
