package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.GoithaunhanvienDTO;
import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.GoiThauNhaThauManagementLocalBean;
import com.banvien.vmsreport.core.business.GoiThauNhanVienManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.GoiThauNhanVienBeanUtil;
import com.banvien.vmsreport.core.business.utils.GoithauNhathauBeanUtil;
import com.banvien.vmsreport.core.data.entity.GoithauNhanvienEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.session.GoithauNhanvienLocalBean;
import com.banvien.vmsreport.core.data.session.GoithauNhathauLocalBean;
import com.banvien.vmsreport.core.data.session.QuanLyNhaThauLocalBean;

import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "GoiThauNhanVienManagementSessionEJB")
public class GoiThauNhanVienManagementSessionBean implements GoiThauNhanVienManagementLocalBean {
    public GoiThauNhanVienManagementSessionBean() {
    }

    @EJB
    private GoithauNhanvienLocalBean goithauNhanvienLocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {

        Object[] res = goithauNhanvienLocalBean.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<GoithaunhanvienDTO> dtos = new ArrayList<GoithaunhanvienDTO>();
        List<Long> longs = new ArrayList<>();
        for (GoithauNhanvienEntity entity : (List<GoithauNhanvienEntity>)res[1]){
            dtos.add(DozerSingletonMapper.getInstance().map(entity, GoithaunhanvienDTO.class));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<GoithaunhanvienDTO> findByMaGoiThau(String maGoiThau) throws ObjectNotFoundException {
        List<GoithauNhanvienEntity> entities = goithauNhanvienLocalBean.findProperty("goithau.magoithau", maGoiThau);
        List<GoithaunhanvienDTO> dtoList = new ArrayList<>();
        for (GoithauNhanvienEntity entity : entities){
            dtoList.add(GoiThauNhanVienBeanUtil.entity2DTO(entity));
        }
        return dtoList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<GoithaunhanvienDTO> findByUserId(Long userId) {
        List<GoithauNhanvienEntity> entities = goithauNhanvienLocalBean.findByProperty("user.userId", userId);
        List<GoithaunhanvienDTO> dtoList = new ArrayList<>();
        for (GoithauNhanvienEntity entity : entities){
            dtoList.add(GoiThauNhanVienBeanUtil.entity2DTO(entity));
        }
        return dtoList;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
