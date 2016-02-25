package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.FormTemplateManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.FormBeanUtil;
import com.banvien.vmsreport.core.business.utils.GoithauNhathauBeanUtil;
import com.banvien.vmsreport.core.data.entity.DmLoaibieumauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.session.FormTemplateLocalBean;
import com.banvien.vmsreport.core.data.session.GoithauNhathauLocalBean;

import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "FormTemplateManagementSessionEJB")
public class FormTemplateManagementSessionBean implements FormTemplateManagementLocalBean {
    public FormTemplateManagementSessionBean() {
    }

    @EJB
    private FormTemplateLocalBean formTemplateLocalBean;
    @EJB
    private GoithauNhathauLocalBean goithauNhathauLocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] resultObject = formTemplateLocalBean.search(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<FormTemplateDTO> listDTO = new ArrayList<>();
        Map<String, Integer> mapIndex = new HashMap<>();
        Map<Long, Integer> mapChuyenGia = new HashMap<>();
        for (Object object : (List) resultObject[1]){
            Object[] tmpArr = (Object[])object;
            FormTemplateDTO dto = new FormTemplateDTO();

            String maGoiThau = tmpArr[0] != null ? tmpArr[0].toString() : null;
            String tenGoiThau = tmpArr[1] != null ? tmpArr[1].toString() : null;
            String tenNguonVon = tmpArr[2] != null ? tmpArr[2].toString() : null;
            String tenLoai = tmpArr[3] != null ? tmpArr[3].toString() : null;
            String tenPhong = tmpArr[4] != null ? tmpArr[4].toString() : null;
            String tenChuyenGia = tmpArr[5] != null ? tmpArr[5].toString() : null;
            String tenHinhThuc = tmpArr[6] != null ? tmpArr[6].toString() : null;
            String tenQuiMo = tmpArr[7] != null ? tmpArr[7].toString() : null;
            String tenNhaThau = tmpArr[8] != null ? tmpArr[8].toString() : null;
            String tenTinhTrang = tmpArr[9] != null ? tmpArr[9].toString() : null;
            Long userId = tmpArr[10] != null ? Long.valueOf(tmpArr[10].toString()) : null;


            Integer index = mapIndex.get(maGoiThau);
            if (index != null){
                if (listDTO.size() > 0 && listDTO.get(index) != null){
                    if (mapChuyenGia.get(userId) == null){
                        String tenChuyenGiatmp = listDTO.get(index).getToChuyenGia();
                        tenChuyenGiatmp = tenChuyenGiatmp + ", " + tenChuyenGia;
                        listDTO.get(index).setToChuyenGia(tenChuyenGiatmp.trim());
                        mapChuyenGia.put(userId, 1);
                    }
                }
            }else {
                dto.setMaGoiThau(maGoiThau);
                dto.setTenGoiThau(tenGoiThau);
                dto.setTenNguonVon(tenNguonVon);
                dto.setTenLoai(tenLoai);
                dto.setTenPhong(tenPhong);
                dto.setToChuyenGia(tenChuyenGia);
                dto.setTenHinhThuc(tenHinhThuc);
                dto.setTenQuiMo(tenQuiMo);
                dto.setTenNhaThau(tenNhaThau);
                dto.setTenTinhTrang(tenTinhTrang);
                listDTO.add(dto);
                mapIndex.put(maGoiThau, listDTO.size() - 1);
                mapChuyenGia.put(userId, 1);
            }
        }
        resultObject[0] = listDTO.size();
        resultObject[1] = listDTO;
        return resultObject;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public List<FormTemplateDTO> findALL() {
        List<DmLoaibieumauEntity> entities = formTemplateLocalBean.findSortSTT();
        List<FormTemplateDTO> dtos = new ArrayList<>();
        for(DmLoaibieumauEntity entity : entities ){
            dtos.add(FormBeanUtil.entity2DTO(entity));
        }
        return dtos;
    }

    @Override
    public FormTemplateDTO findByMaGoiThau(String maGoiThau) {
        Object[] resultObject = formTemplateLocalBean.findByMaGoiThau(maGoiThau);
        return null;
    }

    @Override
    public FormTemplateDTO findById(Long msBieuMau) throws ObjectNotFoundException {
        return FormBeanUtil.entity2DTO(formTemplateLocalBean.findById(msBieuMau));
    }

    @Override
    public FormTemplateDTO findByBieuMau(String bieuMau) throws ObjectNotFoundException {
        return FormBeanUtil.entity2DTO(formTemplateLocalBean.findEqualUnique("bieuMau", bieuMau));
    }
}
