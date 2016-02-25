package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.QuyMoDTO;
import com.banvien.vmsreport.core.data.entity.DmQuyMoEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuiMoBeanUtil {
    public static QuyMoDTO entity2DTO(DmQuyMoEntity entity){
        QuyMoDTO dto = new QuyMoDTO();
        dto.setTenquimo(entity.getTenquimo());
        return dto;
    }
}
