package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.NhaThauDTO;
import com.banvien.vmsreport.core.data.entity.DmNhathauEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/9/15
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class NhaThauBeanUtil {
    public static NhaThauDTO entity2DTO(DmNhathauEntity entity){
        NhaThauDTO dto = new NhaThauDTO();
        dto.setMsnhathau(entity.getMsnhathau());
        dto.setTennhathau(entity.getTennhathau());
        dto.setDiachi(entity.getDiachi());
        dto.setDienthoai(entity.getDienthoai());
        dto.setFax(entity.getFax());
        dto.setActive(entity.getActive());
        dto.setGhichu(entity.getGhichu());
        dto.setMasothue(entity.getMasothue());
        return dto;
    }
}
