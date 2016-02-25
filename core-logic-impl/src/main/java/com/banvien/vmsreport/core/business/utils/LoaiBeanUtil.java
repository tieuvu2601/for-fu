package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.LoaiDTO;
import com.banvien.vmsreport.core.data.entity.DmLoaiEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoaiBeanUtil {
    public static LoaiDTO entity2DTO(DmLoaiEntity entity){
        LoaiDTO dto = new LoaiDTO();
        dto.setTenloai(entity.getTenloai());
        return dto;
    }
}
