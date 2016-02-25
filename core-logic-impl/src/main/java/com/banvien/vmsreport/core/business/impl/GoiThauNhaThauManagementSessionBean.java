package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.GoiThauNhaThauManagementLocalBean;
import com.banvien.vmsreport.core.business.utils.GoithauNhathauBeanUtil;
import com.banvien.vmsreport.core.data.entity.DmNhathauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.entity.HosothauEntity;
import com.banvien.vmsreport.core.data.session.GoithauNhathauLocalBean;
import com.banvien.vmsreport.core.data.session.HoSoThauLocalBean;
import com.banvien.vmsreport.core.data.session.QuanLyNhaThauLocalBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.ejb.*;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/8/15
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "QuanLyNhaThauManagementSessionEJB")
public class GoiThauNhaThauManagementSessionBean implements GoiThauNhaThauManagementLocalBean {
    private transient final Log log = LogFactory.getLog(getClass());
    public GoiThauNhaThauManagementSessionBean() {
    }

    @EJB
    private QuanLyNhaThauLocalBean quanLyNhaThauLocalBean;
    @EJB
    private GoithauNhathauLocalBean goithauNhathauLocalBean;
    @EJB
    private HoSoThauLocalBean hoSoThauLocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {

        Object[] res = goithauNhathauLocalBean.searchByProperties(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<GoithaunhathauDTO> dtos = new ArrayList<GoithaunhathauDTO>();
        List<Long> longs = new ArrayList<>();
        for (GoithauNhathauEntity entity : (List<GoithauNhathauEntity>)res[1]){
            Integer occurrences  = Collections.frequency(longs, entity.getGoithau().getMsgoithau());
            Integer indexNext = longs.indexOf(entity.getGoithau().getMsgoithau()) + occurrences;
            if (indexNext > 0){
                dtos.add(indexNext, GoithauNhathauBeanUtil.entity2DTO(entity));
                longs.add(indexNext, entity.getGoithau().getMsgoithau());
            } else {
                dtos.add(GoithauNhathauBeanUtil.entity2DTO(entity));
                longs.add(entity.getGoithau().getMsgoithau());

            }
        }
        res[1] = dtos;
        return res;
    }

    @Override
    public Integer deleteNhaThau(String[] checkList) throws ObjectNotFoundException, RemoveException {
        int totaldelete = 0;
        for (String msNhaThauGoiThau : checkList){
            GoithauNhathauEntity entity = goithauNhathauLocalBean.findById(Long.valueOf(msNhaThauGoiThau));
            if (entity.getMsgoithauNt() != null) {
                goithauNhathauLocalBean.delete(entity.getMsgoithauNt());
            }
            if (entity.getNhathau() !=null && entity.getNhathau().getMsnhathau() != null){
                quanLyNhaThauLocalBean.delete(entity.getNhathau().getMsnhathau());
                totaldelete++;
            }

        }
        return totaldelete;
    }

    @Override
    public Integer delete(String[] checkList) throws ObjectNotFoundException, RemoveException {
        int totaldelete = 0;
        for (String msNhaThauGoiThau : checkList){
            GoithauNhathauEntity entity = goithauNhathauLocalBean.findById(Long.valueOf(msNhaThauGoiThau));
            if (entity.getMsgoithauNt() != null) {
                goithauNhathauLocalBean.delete(entity.getMsgoithauNt());
                totaldelete++;
            }
        }
        return totaldelete;
    }

    @Override
    public List<GoithaunhathauDTO> findByGoiThau(Long msgoithau) {
        List<GoithauNhathauEntity> listEntities = this.goithauNhathauLocalBean.findByGoiThau(msgoithau);
        List<GoithaunhathauDTO> res = new ArrayList<>();
        for(GoithauNhathauEntity entity : listEntities){
            res.add(DozerSingletonMapper.getInstance().map(entity, GoithaunhathauDTO.class));
        }
        return res;
    }

    @Override
    public void insertOrUpdate(List lazyList, String[] checkList, Long msGoiThau) throws RemoveException, ObjectNotFoundException, DuplicateKeyException {
        if (lazyList != null && lazyList.size() > 0) {
            GoithauNhathauEntity entity;
            for (GoithaunhathauDTO dto : (List<GoithaunhathauDTO>) lazyList) {
                if (dto != null && (StringUtils.isNotBlank(dto.getTennhathau()) || StringUtils.isNotBlank(dto.getDiachi())
                                    || StringUtils.isNotBlank(dto.getDienthoai()) || StringUtils.isNotBlank(dto.getFax()))){
                    DmNhathauEntity nhaThauEntity;
                    if (dto.getNhathau() != null && dto.getNhathau().getMsnhathau() != null){
                        nhaThauEntity = quanLyNhaThauLocalBean.findById(dto.getNhathau().getMsnhathau());
                        nhaThauEntity.setTennhathau(dto.getTennhathau());
                        nhaThauEntity.setDiachi(dto.getDiachi());
                        nhaThauEntity.setDienthoai(dto.getDienthoai());
                        nhaThauEntity.setFax(dto.getFax());
                        nhaThauEntity.setMasothue(dto.getNhathau().getMasothue());
                        nhaThauEntity = quanLyNhaThauLocalBean.update(nhaThauEntity);
                    }else {
                        nhaThauEntity = new DmNhathauEntity();
                        nhaThauEntity.setTennhathau(dto.getTennhathau());
                        nhaThauEntity.setDiachi(dto.getDiachi());
                        nhaThauEntity.setDienthoai(dto.getDienthoai());
                        nhaThauEntity.setFax(dto.getFax());
                        nhaThauEntity.setActive(BigDecimal.valueOf(Constants.ACTIVE));
                        nhaThauEntity.setMasothue(dto.getNhathau().getMasothue());
                        nhaThauEntity = quanLyNhaThauLocalBean.save(nhaThauEntity);
                    }

                    if (dto.getMsgoithauNt() != null) {
                        entity = goithauNhathauLocalBean.findById(dto.getMsgoithauNt());
                        entity.setNhathau(nhaThauEntity);
                        entity.setNgaymuahs(dto.getNgaymuahs());
                        entity.setNgaynophs(dto.getNgaynophs());
                        goithauNhathauLocalBean.update(entity);
                    }else if (msGoiThau != null) {
                        entity = new GoithauNhathauEntity();
                        GoithauEntity goiThauEntity = new GoithauEntity();
                        goiThauEntity.setMsgoithau(msGoiThau);
                        entity.setGoithau(goiThauEntity);
                        entity.setNhathau(nhaThauEntity);
                        entity.setNgaymuahs(dto.getNgaymuahs());
                        entity.setNgaynophs(dto.getNgaynophs());
                        goithauNhathauLocalBean.save(entity);
                    }

                }
            }
        }
        if (checkList != null && checkList.length > 0){
            for (String id : checkList){
                hoSoThauLocalBean.deleteHoSoGoiThauNhaThau(Long.valueOf(id));
                GoithauNhathauEntity goithauNhathauEntity = this.goithauNhathauLocalBean.findById(Long.valueOf(id));
                goithauNhathauLocalBean.delete(goithauNhathauEntity);
            }
        }
    }

    @Override
    public List<GoithaunhathauDTO> findByMaGoiThau(String maGoiThau) {
        List<GoithauNhathauEntity> entities = this.goithauNhathauLocalBean.findByProperty("goithau.magoithau", maGoiThau);
        List<GoithaunhathauDTO> listDTO = new ArrayList<>();
        GoithaunhathauDTO nhaThauTrungThau = new GoithaunhathauDTO();
        for(GoithauNhathauEntity entity : entities){
            listDTO.add(GoithauNhathauBeanUtil.entity2DTO(entity));
//            if (Constants.IS_TRUNGTHAU.equals(entity.getIstrungthau())){
//                nhaThauTrungThau = GoithauNhathauBeanUtil.entity2DTO(entity);
//            }
        }
//        listDTO.add(nhaThauTrungThau);
        return listDTO;
    }

    @Override
    public GoithaunhathauDTO findByGoiThauAndNhanThau(Long goithauid, Long msNhaThau) {
       return GoithauNhathauBeanUtil.entity2DTO(goithauNhathauLocalBean.findByGoiThauAndNhanThau(goithauid, msNhaThau));
    }

}
