package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.TinhtrangDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.TinhtrangManagementLocalBean;
import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmTinhtrangEntity;
import com.banvien.vmsreport.core.data.session.TinhtrangLocalBean;
import com.banvien.vmsreport.core.data.session.TienDoLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "TinhtrangManagementSessionEJB")
public class TinhtrangManagementSessionBean implements TinhtrangManagementLocalBean {
    @EJB
    private TinhtrangLocalBean tinhTrangService;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = tinhTrangService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<TinhtrangDTO> dtos = new ArrayList<TinhtrangDTO>();
        for (DmTinhtrangEntity entity : (List<DmTinhtrangEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, TinhtrangDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<TinhtrangDTO> findAll() {
        List<DmTinhtrangEntity> entities = tinhTrangService.findAll();
        List<TinhtrangDTO> dtoList = new ArrayList<>();
        for (DmTinhtrangEntity entity : entities){
            dtoList.add(DozerSingletonMapper.getInstance().map(entity, TinhtrangDTO.class));
        }
        return dtoList;
    }
}
