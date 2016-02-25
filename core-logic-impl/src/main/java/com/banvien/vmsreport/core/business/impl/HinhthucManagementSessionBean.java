package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.HinhthucgtDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.HinhthucManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmHinhthucgtEntity;
import com.banvien.vmsreport.core.data.session.HinhthucLocalBean;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Stateless(name = "HinhthucManagementSessionEJB")
public class HinhthucManagementSessionBean implements HinhthucManagementLocalBean {
    @EJB
    private HinhthucLocalBean hinhThucService;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = hinhThucService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<HinhthucgtDTO> dtos = new ArrayList<HinhthucgtDTO>();
        for (DmHinhthucgtEntity entity : (List<DmHinhthucgtEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, HinhthucgtDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<HinhthucgtDTO> findAll() {
        List<DmHinhthucgtEntity> entities = hinhThucService.findAll();
        List<HinhthucgtDTO> dtos = new ArrayList<HinhthucgtDTO>();
        for (DmHinhthucgtEntity entity : entities){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, HinhthucgtDTO.class));
        }
        return dtos;
    }

    @Override
    public HinhthucgtDTO findByCode(String code) throws ObjectNotFoundException {
        DmHinhthucgtEntity dbItem = this.hinhThucService.findEqualUnique("mahinhthuc", code);
        return DozerSingletonMapper.getInstance().map(dbItem, HinhthucgtDTO.class);
    }

    @Override
    public HinhthucgtDTO addItem(HinhthucgtDTO pojo) throws DuplicateKeyException {
        DmHinhthucgtEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmHinhthucgtEntity.class);
        return  DozerSingletonMapper.getInstance().map(this.hinhThucService.save(entity), HinhthucgtDTO.class);
    }

    @Override
    public HinhthucgtDTO updateItem(HinhthucgtDTO pojo) throws ObjectNotFoundException, DuplicateKeyException {
        DmHinhthucgtEntity dbItem = this.hinhThucService.findById(pojo.getMshinhthuc());
        DmHinhthucgtEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmHinhthucgtEntity.class);
        return  DozerSingletonMapper.getInstance().map(this.hinhThucService.update(entity), HinhthucgtDTO.class);
    }

    @Override
    public HinhthucgtDTO findById(Long mshinhthuc) throws ObjectNotFoundException {
        return  DozerSingletonMapper.getInstance().map(this.hinhThucService.findById(mshinhthuc), HinhthucgtDTO.class);
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object [] objs = this.hinhThucService.searchByProperties(properties, sortExpression, sortDirection,firstItem, maxPageItems);
        List<HinhthucgtDTO> listResult = new ArrayList<HinhthucgtDTO>();
        for (DmHinhthucgtEntity entity : (List<DmHinhthucgtEntity>)objs[1]){
            listResult.add(DozerSingletonMapper.getInstance().map(entity, HinhthucgtDTO.class));
        }
        return new Object[] {objs[0], listResult};
    }


    @Override
    public Integer deleteItems(String[] checkList) {
        Integer totalDeleted = 0;
        try{
            for(int i = 0; i < checkList.length ; i ++){
                Long id = Long.valueOf(checkList[i]);
                this.hinhThucService.delete(id);
                totalDeleted ++;
            }
        }catch (RemoveException ex){

        }
        return totalDeleted;
    }
}
