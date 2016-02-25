package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.LanhdaoDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.LanhdaoManagementLocalBean;
import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmLanhdaoEntity;
import com.banvien.vmsreport.core.data.session.LanhdaoLocalBean;
import com.banvien.vmsreport.core.data.session.TienDoLocalBean;

import javax.ejb.*;
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
@Stateless(name = "LanhdaoManagementSessionEJB")
public class LanhdaoManagementSessionBean implements LanhdaoManagementLocalBean {
    @EJB
    private LanhdaoLocalBean lanhDaoService;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = lanhDaoService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<LanhdaoDTO> dtos = new ArrayList<LanhdaoDTO>();
        for (DmLanhdaoEntity entity : (List<DmLanhdaoEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, LanhdaoDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public LanhdaoDTO updateItem(LanhdaoDTO pojo) throws ObjectNotFoundException, DuplicateKeyException {
        DmLanhdaoEntity dbItem = this.lanhDaoService.findById(pojo.getMslanhdao());
        DmLanhdaoEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmLanhdaoEntity.class);
        return  DozerSingletonMapper.getInstance().map(this.lanhDaoService.update(entity), LanhdaoDTO.class);
    }

    @Override
    public LanhdaoDTO addItem(LanhdaoDTO pojo) throws DuplicateKeyException {
        DmLanhdaoEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmLanhdaoEntity.class);
        return  DozerSingletonMapper.getInstance().map(this.lanhDaoService.save(entity), LanhdaoDTO.class);
    }

    @Override
    public LanhdaoDTO findById(Long id) throws ObjectNotFoundException {
        return  DozerSingletonMapper.getInstance().map(this.lanhDaoService.findById(id), LanhdaoDTO.class);
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object [] objs = this.lanhDaoService.searchByProperties(properties, sortExpression, sortDirection,firstItem, maxPageItems);
        List<LanhdaoDTO> listResult = new ArrayList<LanhdaoDTO>();
        for (DmLanhdaoEntity entity : (List<DmLanhdaoEntity>)objs[1]){
            listResult.add(DozerSingletonMapper.getInstance().map(entity, LanhdaoDTO.class));
        }
        return new Object[] {objs[0], listResult};
    }

    @Override
    public Integer deleteItems(String[] checkList) {
        Integer totalDeleted = 0;
        try{
            for(int i = 0; i < checkList.length ; i ++){
                Long id = Long.valueOf(checkList[i]);
                this.lanhDaoService.delete(id);
                totalDeleted ++;
            }
        }catch (RemoveException ex){

        }
        return totalDeleted;
    }


}
