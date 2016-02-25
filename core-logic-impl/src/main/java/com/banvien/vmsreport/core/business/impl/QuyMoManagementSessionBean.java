package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.QuyMoDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.QuyMoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmQuyMoEntity;
import com.banvien.vmsreport.core.data.session.QuimoLocalBean;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Stateless(name = "QuyMoManagementSessionEJB")
public class QuyMoManagementSessionBean implements QuyMoManagementLocalBean {
    @EJB
    private QuimoLocalBean quyMoLocalBean;

    @Override
    public Object[] searchByProperties(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = quyMoLocalBean.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<QuyMoDTO> dtos = new ArrayList<QuyMoDTO>();
        for (DmQuyMoEntity entity : (List<DmQuyMoEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, QuyMoDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<QuyMoDTO> findAll() {
        List<DmQuyMoEntity> entities = quyMoLocalBean.findAll();
        List<QuyMoDTO> dtos = new ArrayList<QuyMoDTO>();
        for (DmQuyMoEntity entity : entities){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, QuyMoDTO.class));
        }
        return dtos;
    }

    @Override
    public QuyMoDTO updateItem(QuyMoDTO pojo) throws ObjectNotFoundException, DuplicateKeyException {
        DmQuyMoEntity dbItem = this.quyMoLocalBean.findById(pojo.getMsquimo());
        DmQuyMoEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmQuyMoEntity.class);
        return  DozerSingletonMapper.getInstance().map(this.quyMoLocalBean.update(entity), QuyMoDTO.class);
    }

    @Override
    public QuyMoDTO addItem(QuyMoDTO pojo) throws DuplicateKeyException {
        DmQuyMoEntity entity = DozerSingletonMapper.getInstance().map(pojo, DmQuyMoEntity.class);
        return  DozerSingletonMapper.getInstance().map(this.quyMoLocalBean.save(entity), QuyMoDTO.class);
    }

    @Override
    public QuyMoDTO findById(Long id) throws ObjectNotFoundException {
        return  DozerSingletonMapper.getInstance().map(this.quyMoLocalBean.findById(id), QuyMoDTO.class);
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object [] objs = this.quyMoLocalBean.searchByProperties(properties, sortExpression, sortDirection,firstItem, maxPageItems);
        List<QuyMoDTO> listResult = new ArrayList<QuyMoDTO>();
        for (DmQuyMoEntity entity : (List<DmQuyMoEntity>)objs[1]){
            listResult.add(DozerSingletonMapper.getInstance().map(entity, QuyMoDTO.class));
        }
        return new Object[] {objs[0], listResult};
    }

    @Override
    public Integer deleteItems(String[] checkList) {
        Integer totalDeleted = 0;
        try{
            for(int i = 0; i < checkList.length ; i ++){
                Long id = Long.valueOf(checkList[i]);
                this.quyMoLocalBean.delete(id);
                totalDeleted ++;
            }
        }catch (RemoveException ex){

        }
        return totalDeleted;
    }

    @Override
    public QuyMoDTO findByName(String code) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
