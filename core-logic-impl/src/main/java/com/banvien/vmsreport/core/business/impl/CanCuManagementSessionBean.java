package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.CanCuDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.CanCuManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmCanCuEntity;
import com.banvien.vmsreport.core.data.session.CanCuLocalBean;
import com.banvien.vmsreport.core.data.session.LanhdaoLocalBean;

import javax.ejb.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "CanCuManagementSessionEJB")
public class CanCuManagementSessionBean implements CanCuManagementLocalBean {
    @EJB
    private CanCuLocalBean canCuService;

    @Override
    public CanCuDTO updateItem(CanCuDTO pojo) throws ObjectNotFoundException, DuplicateKeyException {
        DmCanCuEntity dbItem = this.canCuService.findById(pojo.getCanCuId());
        DmCanCuEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmCanCuEntity.class);
        entity.setCreatedDate(dbItem.getCreatedDate());
        entity.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return  DozerSingletonMapper.getInstance().map(this.canCuService.update(entity), CanCuDTO.class);
    }

    @Override
    public CanCuDTO addItem(CanCuDTO pojo) throws DuplicateKeyException {
        DmCanCuEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmCanCuEntity.class);
        entity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return  DozerSingletonMapper.getInstance().map(this.canCuService.save(entity), CanCuDTO.class);
    }

    @Override
    public CanCuDTO findById(Long id) throws ObjectNotFoundException {
        return  DozerSingletonMapper.getInstance().map(this.canCuService.findById(id), CanCuDTO.class);
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object [] objs = this.canCuService.searchByProperties(properties, sortExpression, sortDirection,firstItem, maxPageItems);
        List<CanCuDTO> listResult = new ArrayList<CanCuDTO>();
        for (DmCanCuEntity entity : (List<DmCanCuEntity>)objs[1]){
            listResult.add(DozerSingletonMapper.getInstance().map(entity, CanCuDTO.class));
        }
        return new Object[] {objs[0], listResult};
    }

    @Override
    public Integer deleteItems(String[] checkList) {
        Integer totalDeleted = 0;
        try{
            for(int i = 0; i < checkList.length ; i ++){
                Long id = Long.valueOf(checkList[i]);
                this.canCuService.delete(id);
                totalDeleted ++;
            }
        }catch (RemoveException ex){

        }
        return totalDeleted;
    }

    @Override
    public CanCuDTO findByMaCanCu(String code) {
         return DozerSingletonMapper.getInstance().map(this.canCuService.findByMaCanCu(code), CanCuDTO.class);
    }
}
