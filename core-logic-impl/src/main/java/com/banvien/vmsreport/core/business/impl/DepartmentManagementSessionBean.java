package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.DepartmentManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.DepartmentBeanUtil;
import com.banvien.vmsreport.core.data.entity.DepartmentEntity;
import com.banvien.vmsreport.core.data.session.DepartmentLocalBean;
import com.banvien.vmsreport.core.data.session.UserLocalBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vietpham
 * Date: 8/20/15
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "DepartmentManagementSessionEJB")
public class DepartmentManagementSessionBean implements DepartmentManagementLocalBean{
    private transient final Log log = LogFactory.getLog(getClass());

    public DepartmentManagementSessionBean() {
    }

    @EJB
    private DepartmentLocalBean departmentService;
    @EJB
    private UserLocalBean userService;

    @Override
    public DepartmentDTO findByCode(String code) throws ObjectNotFoundException {
        return DozerSingletonMapper.getInstance().map(this.departmentService.findEqualUnique("code", code), DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateItem(DepartmentDTO dto) throws ObjectNotFoundException, DuplicateKeyException {
        DepartmentEntity dbItem = this.departmentService.findById(dto.getDepartmentId());
        dbItem.setCode(dto.getCode());
        dbItem.setName(dto.getName());
        return DepartmentBeanUtil.entity2DTO(departmentService.update(dbItem));
    }

    @Override
    public DepartmentDTO addItem(DepartmentDTO dto) throws DuplicateKeyException {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setDepartmentId(dto.getDepartmentId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return DepartmentBeanUtil.entity2DTO(departmentService.save(entity));
    }

    @Override
    public Integer deleteItems(String[] checkList) throws ObjectNotFoundException, RemoveException {
        int numberOfItemExecuted = 0;
        if(checkList != null && checkList.length > 0){
            for (String strDepartmentId : checkList){
                try{
                    Long departmentId = Long.valueOf(strDepartmentId);
                    userService.updateNull4User(departmentId);
                    departmentService.delete(departmentId);
                    numberOfItemExecuted++;
                }catch (Exception e){
                    log.error(e.getMessage(), e);
                }
            }
        }
        return numberOfItemExecuted;
    }

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, Integer firstItem, Integer maxPageItems) {
        Object [] res = departmentService.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<DepartmentDTO> dtos = new ArrayList<DepartmentDTO>();
        for (DepartmentEntity entity : (List<DepartmentEntity>)res[1]){
            dtos.add(DepartmentBeanUtil.entity2DTO(entity));
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public List<DepartmentDTO> findALL() {
        List<DepartmentEntity> departmentEntity = departmentService.findAll();
        List<DepartmentDTO> dtos = new ArrayList<DepartmentDTO>();
        for (DepartmentEntity entity : departmentEntity){
            dtos.add(DepartmentBeanUtil.entity2DTO(entity));
        }
        return  dtos;
    }

    @Override
    public List<DepartmentDTO> findDepartmentActive() {
        List<DepartmentEntity> departmentEntity = departmentService.findDepartmentActive();
        List<DepartmentDTO> dtos = new ArrayList<DepartmentDTO>();
        for (DepartmentEntity entity : departmentEntity){
            dtos.add(DepartmentBeanUtil.entity2DTO(entity));
        }
        return  dtos;
    }

    @Override
    public DepartmentDTO findId(Long departmentId) throws ObjectNotFoundException {
        return DepartmentBeanUtil.entity2DTO(departmentService.findById(departmentId));
    }
}
