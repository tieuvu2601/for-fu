package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/9/15
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoithauNhathauBeanUtil {

    public static GoithaunhathauDTO entity2DTO(GoithauNhathauEntity entity){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GoithaunhathauDTO dto = new GoithaunhathauDTO();
        dto.setMsgoithauNt(entity.getMsgoithauNt());
        if (entity.getNhathau() != null){
            dto.setNhathau(NhaThauBeanUtil.entity2DTO(entity.getNhathau()));
        }
        if (entity.getGoithau() != null){
            dto.setGoithau(BidBeanUtil.entity2DTO(entity.getGoithau()));
        }
        dto.setGiathau(entity.getGiathau());
        dto.setIstrungthau(entity.getIstrungthau());
        dto.setNgaymuahs(entity.getNgaymuahs());
        dto.setNgaynophs(entity.getNgaynophs());
        if(entity.getNgaymuahs() != null){
            dto.setStrngaymuahs(simpleDateFormat.format(entity.getNgaymuahs()));
        }
        if(entity.getNgaynophs() != null){
            dto.setStrngaynophs(simpleDateFormat.format(entity.getNgaynophs()));
        }
        return dto;
    }
}
