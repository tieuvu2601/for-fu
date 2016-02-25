package com.banvien.vmsreport.core.data.session.impl;

import com.banvien.vmsreport.core.data.entity.DmNguonvonEntity;
import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.session.NguonvonLocalBean;
import com.banvien.vmsreport.core.data.session.TinhtrangLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "TinhtrangSessionEJB")
public class TinhtrangSessionBean extends AbstractSessionBean<DmTinhtrangEntity, Long> implements TinhtrangLocalBean{
    public TinhtrangSessionBean() {
    }

    @Override
    public DmTinhtrangEntity findByCode(String code) {
        StringBuffer stringBuffer = new StringBuffer("FROM DmTinhtrangEntity WHERE 1 = 1");
        if(code != null && StringUtils.isNotBlank(code)){
            stringBuffer.append(" AND matinhtrang =:code ");
        }
        Query query = entityManager.createQuery(stringBuffer.toString());
        if(code != null && StringUtils.isNotBlank(code)){
            query.setParameter("code", code);
        }
        List<DmTinhtrangEntity> tinhtrangs = (List<DmTinhtrangEntity>)query.getResultList();
        if(tinhtrangs.size() > 0){
            return tinhtrangs.get(0);
        }
        return null;
    }
}
