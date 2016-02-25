package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.DangBaoDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.DangBaoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DangbaoEntity;
import com.banvien.vmsreport.core.data.session.DangBaoLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "DangBaoManagementSessionEJB")
public class DangBaoManagementSessionBean implements DangBaoManagementLocalBean {
    @EJB
    private DangBaoLocalBean dangBaoService;

    @Override
    public List<DangBaoDTO> findByGoiThau(Long msgoithau) {
        List<DangbaoEntity> listEntities = this.dangBaoService.findByGoiThau(msgoithau);
        List<DangBaoDTO> res = new ArrayList<>();
        for(DangbaoEntity entity : listEntities){
            res.add(DozerSingletonMapper.getInstance().map(entity, DangBaoDTO.class));
        }
        return res;
    }
}
