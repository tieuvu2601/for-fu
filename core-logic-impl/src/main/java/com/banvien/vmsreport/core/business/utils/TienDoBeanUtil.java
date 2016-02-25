package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.TienDoDTO;
import com.banvien.vmsreport.core.data.entity.TiendoEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/15/16
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class TienDoBeanUtil {
    public static TienDoDTO entity2DTO(TiendoEntity entity){
        TienDoDTO dto = new TienDoDTO();
        dto.setBaoCaoThamDinhSo(entity.getBaoCaoThamDinhSo());
        dto.setBaoCaoThamDinhNgay(entity.getBaoCaoThamDinhNgay());
        return dto;
    }
}
