package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.NguonvonDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.NguonvonManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.NguonVonBeanUtil;
import com.banvien.vmsreport.core.data.entity.DmNguonvonEntity;
import com.banvien.vmsreport.core.data.session.NguonvonLocalBean;

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
@Stateless(name = "NguonvonManagementSessionEJB")
public class NguonvonManagementSessionBean implements NguonvonManagementLocalBean {
    @EJB
    private NguonvonLocalBean nguonVonService;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = nguonVonService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<NguonvonDTO> dtos = new ArrayList<NguonvonDTO>();
        for (DmNguonvonEntity entity : (List<DmNguonvonEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, NguonvonDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<NguonvonDTO> findAll() {
        List<DmNguonvonEntity> entities = nguonVonService.findAll();
        List<NguonvonDTO> dtoList = new ArrayList<>();
        for (DmNguonvonEntity entity : entities){
            dtoList.add(NguonVonBeanUtil.entity2DTO(entity));
        }
        return dtoList;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
