package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.StoreFileDTO;
import com.banvien.vmsreport.core.data.entity.StoreFileEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/28/16
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreFileBeanUtil {
    public static StoreFileDTO entity2DTO(StoreFileEntity entity){
        StoreFileDTO dto = new StoreFileDTO();
        dto.setStoreFileId(entity.getStoreFileId());
        dto.setTypeVar(entity.getTypeVar());
        dto.setGoiThau(BidBeanUtil.entity2DTO(entity.getGoiThau()));
        dto.setFullPath(entity.getFullPath());
        dto.setCreateTime(entity.getCreateTime());
        dto.setModifiedTime(entity.getModifiedTime());
        return dto;
    }
}
