package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.NhaThauDTO;
import com.banvien.vmsreport.core.business.NhaThauManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.NhaThauBeanUtil;
import com.banvien.vmsreport.core.data.entity.DmNhathauEntity;
import com.banvien.vmsreport.core.data.session.QuanLyNhaThauLocalBean;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/11/15
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "NhaThauManagementSessionEJB")
public class NhaThauManagementSessionBean implements NhaThauManagementLocalBean {
    public NhaThauManagementSessionBean() {
    }

    @EJB
    private QuanLyNhaThauLocalBean quanLyNhaThauLocalBean;

    @Override
    public NhaThauDTO findbyId(Long msnhathau) throws ObjectNotFoundException {
        DmNhathauEntity entity = quanLyNhaThauLocalBean.findById(msnhathau);
        return NhaThauBeanUtil.entity2DTO(entity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insetOrUpdate(NhaThauDTO pojo) throws DuplicateKeyException {
        DmNhathauEntity entity = new DmNhathauEntity();
        entity.setTennhathau(pojo.getTennhathau());
        entity.setDiachi(pojo.getDiachi());
        entity.setDienthoai(pojo.getDienthoai());
        entity.setFax(pojo.getFax());
        entity.setGhichu(pojo.getGhichu());
        entity.setActive(pojo.getActive());
        entity.setMasothue(pojo.getMasothue());
        if (pojo.getMsnhathau() != null){
            quanLyNhaThauLocalBean.update(entity);
        }else {
            quanLyNhaThauLocalBean.save(entity);
        }
    }

    @Override
    public NhaThauDTO findByMaSoThue(String maSoThue) throws ObjectNotFoundException {
        DmNhathauEntity entity = quanLyNhaThauLocalBean.findEqualUnique("masothue", maSoThue);
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<NhaThauDTO> findByAll() {
        List<DmNhathauEntity> entities = quanLyNhaThauLocalBean.findAll();
        List<NhaThauDTO> dtos = new ArrayList<>();
        for (DmNhathauEntity entity : entities){
            dtos.add(NhaThauBeanUtil.entity2DTO(entity));
        }
        return dtos;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] resultObject = quanLyNhaThauLocalBean.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<NhaThauDTO> dtos = new ArrayList<>();
        for (DmNhathauEntity entity : (List<DmNhathauEntity>)resultObject[1]){
            dtos.add(NhaThauBeanUtil.entity2DTO(entity));
        }
        resultObject[1] = dtos;
        return resultObject;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
