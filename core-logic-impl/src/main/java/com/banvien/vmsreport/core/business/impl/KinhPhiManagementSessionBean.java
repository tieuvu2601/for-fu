package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.KinhphiDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.KinhPhiManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.KinhphiEntity;
import com.banvien.vmsreport.core.data.session.KinhPhiLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "KinhPhiManagementSessionEJB")
public class KinhPhiManagementSessionBean implements KinhPhiManagementLocalBean{
    @EJB
    private KinhPhiLocalBean kinhPhiService;

    @Override
    public List<KinhphiDTO> findByGoiThau(Long msgoithau) {
        List<KinhphiDTO> res = new ArrayList<>();
        List<KinhphiEntity> listEntities = this.kinhPhiService.findByGoiThau(msgoithau);
        for(KinhphiEntity kinhphiEntity : listEntities){
            res.add(DozerSingletonMapper.getInstance().map(kinhphiEntity, KinhphiDTO.class));
        }
        return res;
    }
}
