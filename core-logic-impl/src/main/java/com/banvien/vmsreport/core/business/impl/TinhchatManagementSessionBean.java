package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.TinhchatDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.TinhchatManagementLocalBean;
import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmTinhchatgtEntity;
import com.banvien.vmsreport.core.data.session.TinhchatLocalBean;
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
@Stateless(name = "TinhchatManagementSessionEJB")
public class TinhchatManagementSessionBean implements TinhchatManagementLocalBean {
    @EJB
    private TinhchatLocalBean tinhChatService;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = tinhChatService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<TinhchatDTO> dtos = new ArrayList<TinhchatDTO>();
        for (DmTinhchatgtEntity entity : (List<DmTinhchatgtEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, TinhchatDTO.class));
        }
        res[1] = dtos;
        return res;
    }
}
