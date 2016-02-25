package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.GoithaunhanvienDTO;
import com.banvien.vmsreport.core.data.entity.GoithauNhanvienEntity;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/5/16
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoiThauNhanVienBeanUtil {
    public static GoithaunhanvienDTO entity2DTO(GoithauNhanvienEntity entity){
        GoithaunhanvienDTO dto = new GoithaunhanvienDTO();
        dto.setUser(UserBeanUtil.entity2DTO(entity.getUser()));
        dto.setIschutri(entity.getIschutri());
//        dto.setGoithau(BidBeanUtil.entity2DTO(entity.getGoithau()));
        return dto;
    }
}
