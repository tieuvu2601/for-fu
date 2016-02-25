package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.NoidungDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.NoiDungManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmNoidungEntity;
import com.banvien.vmsreport.core.data.session.NoiDungLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/11/15
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="NoiDungManagementSessionEJB")
public class NoiDungManagementSessionBean implements NoiDungManagementLocalBean {

    @EJB
    private NoiDungLocalBean noiDungService;

    @Override
    public List<NoidungDTO> findAll() {
        List<DmNoidungEntity> entities = this.noiDungService.findAll();
        List<NoidungDTO> res = new ArrayList<>();
        for(DmNoidungEntity entity : entities){
            res.add(DozerSingletonMapper.getInstance().map(entity, NoidungDTO.class));
        }
        return res;
    }
}
