package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.NguonvonDTO;
import com.banvien.vmsreport.core.data.entity.DmNguonvonEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class NguonVonBeanUtil {

    public static NguonvonDTO entity2DTO(DmNguonvonEntity entity){
        NguonvonDTO dto = new NguonvonDTO();
        dto.setMsnguonvon(entity.getMsnguonvon());
        dto.setTennguonvon(entity.getTennguonvon());
        dto.setGhichu(entity.getGhichu());
        dto.setStt(entity.getStt());
        return dto;
    }
}
