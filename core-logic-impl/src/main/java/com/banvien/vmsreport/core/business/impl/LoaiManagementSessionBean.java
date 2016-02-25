package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.LoaiDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.LoaiManagementLocalBean;
import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmLoaiEntity;
import com.banvien.vmsreport.core.data.session.LoaiLocalBean;
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
@Stateless(name = "LoaiManagementSessionEJB")
public class LoaiManagementSessionBean implements LoaiManagementLocalBean {
    @EJB
    private LoaiLocalBean loaiService;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = loaiService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<LoaiDTO> dtos = new ArrayList<LoaiDTO>();
        for (DmLoaiEntity entity : (List<DmLoaiEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, LoaiDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<LoaiDTO> findAll() {
        List<DmLoaiEntity> entities = loaiService.findAll();
        List<LoaiDTO> dtos = new ArrayList<LoaiDTO>();
        for (DmLoaiEntity entity : (List<DmLoaiEntity>)entities){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, LoaiDTO.class));
        }
        return dtos;
    }
}
