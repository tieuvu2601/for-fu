package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.HinhthucgtDTO;
import com.banvien.vmsreport.core.data.entity.DmHinhthucgtEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class HinhThucBeanUtil {
    public static HinhthucgtDTO entity2DTO(DmHinhthucgtEntity entity){
        HinhthucgtDTO dto = new HinhthucgtDTO();
        dto.setTenhinhthuc(entity.getTenhinhthuc());
        return dto;
    }
}
