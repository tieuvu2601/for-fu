package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.FormTemplateDTO;
import com.banvien.vmsreport.core.data.entity.DmLoaibieumauEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/14/16
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormBeanUtil {
    public static FormTemplateDTO entity2DTO(DmLoaibieumauEntity entity){
        FormTemplateDTO dto = new FormTemplateDTO();
        dto.setMsBieuMau(entity.getMsbieumau());
        dto.setTenBieuMau(entity.getTenbieumau());
        dto.setBieuMau(entity.getBieuMau());
        dto.setStt(entity.getStt());
        dto.setGhiChu(entity.getGhichu());
        return dto;
    }
}
