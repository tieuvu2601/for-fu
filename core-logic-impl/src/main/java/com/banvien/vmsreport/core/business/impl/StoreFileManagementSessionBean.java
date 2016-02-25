package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.StoreFileDTO;
import com.banvien.vmsreport.core.business.StoreFileManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.entity.StoreFileEntity;
import com.banvien.vmsreport.core.data.session.StoreFileLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/28/16
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "StoreFileManagementSessionEJB")
public class StoreFileManagementSessionBean implements StoreFileManagementLocalBean {
    public StoreFileManagementSessionBean() {
    }

    @EJB
    private StoreFileLocalBean storeFileLocalBean;

    @Override
    public Map<String, String> findMapUrlByMsGoiThau(Long msgoithau){
        List<StoreFileEntity> entities = storeFileLocalBean.findByProperty("goiThau.msgoithau", msgoithau);
        Map<String, String> map = new HashMap<>();
        for (StoreFileEntity entity : entities){
            if (entity.getGoiThau() != null && entity.getGoiThau().getMsgoithau() != null){
                map.put(entity.getGoiThau().getMsgoithau()+entity.getTypeVar(), entity.getFullPath() );
            }
        }
        return map;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<StoreFileDTO> updateAndSave(List<StoreFileDTO> listUrlFile) {
        List<StoreFileDTO> storeFileDTOs = new ArrayList<>();
        try {
            for (StoreFileDTO dto : listUrlFile){
                if (dto.getFullPath() != null){
                    Map<String, Object> properties = buildProperties(dto);
                    StoreFileEntity entity = new StoreFileEntity();
                    List<StoreFileEntity> entities = storeFileLocalBean.findProperties(properties);

                    if (entities != null && entities.size() > 0){
                        entity = entities.get(0);
                        GoithauEntity goithauEntity = new GoithauEntity();
                        goithauEntity.setMsgoithau(dto.getGoiThau().getMsgoithau());
                        entity.setGoiThau(goithauEntity);
                        entity.setTypeVar(dto.getTypeVar());
                        entity.setFullPath(dto.getFullPath());
                        entity.setModifiedTime(new Timestamp(System.currentTimeMillis()));
                        storeFileLocalBean.update(entity);
                    }else {
                        GoithauEntity goithauEntity = new GoithauEntity();
                        goithauEntity.setMsgoithau(dto.getGoiThau().getMsgoithau());
                        entity.setGoiThau(goithauEntity);
                        entity.setTypeVar(dto.getTypeVar());
                        entity.setFullPath(dto.getFullPath());
                        entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
                        storeFileLocalBean.save(entity);
                    }
                }
            }
        } catch (DuplicateKeyException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Map<String, Object> buildProperties(StoreFileDTO dto) {
        Map<String, Object> properties = new HashMap<>();
        if (dto.getGoiThau() != null && dto.getGoiThau().getMsgoithau() != null){
            properties.put("goiThau.msgoithau", dto.getGoiThau().getMsgoithau());
        }
        if (StringUtils.isNotBlank(dto.getTypeVar())){
            properties.put("typeVar", dto.getTypeVar());
        }
        return properties;  //To change body of created methods use File | Settings | File Templates.
    }
}
