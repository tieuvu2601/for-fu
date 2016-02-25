package com.banvien.vmsreport.core.business.utils;

import com.banvien.vmsreport.common.dto.BidDTO;
import com.banvien.vmsreport.common.dto.GoithaunhanvienDTO;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhanvienEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/10/15
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BidBeanUtil {
    public static BidDTO entity2DTO(GoithauEntity entity){
        BidDTO dto = new BidDTO();
        dto.setMsgoithau(entity.getMsgoithau());
        dto.setMagoithau(entity.getMagoithau());
        dto.setTengoithau(entity.getTengoithau());
        if (entity.getNguonvon() != null){
            dto.setNguonvon(NguonVonBeanUtil.entity2DTO(entity.getNguonvon()));
        }
        if (entity.getLoai() != null){
            dto.setLoai(LoaiBeanUtil.entity2DTO(entity.getLoai()));
        }
        if (entity.getDepartment() != null){
            dto.setDepartment(DepartmentBeanUtil.entity2DTO(entity.getDepartment()));
        }

        List<GoithaunhanvienDTO> goithaunhanvienDTOList = new ArrayList<>();
        for (GoithauNhanvienEntity goithauNhanvienEntity : entity.getToChuyenGias()){
            goithaunhanvienDTOList.add(GoiThauNhanVienBeanUtil.entity2DTO(goithauNhanvienEntity));
        }
        dto.setToChuyenGias(goithaunhanvienDTOList);
        if (entity.getHinhthucgt() != null){
            dto.setHinhthucgt(HinhThucBeanUtil.entity2DTO(entity.getHinhthucgt()));
        }
        if (entity.getQuimo() != null){
            dto.setQuimo(QuiMoBeanUtil.entity2DTO(entity.getQuimo()));
        }
        dto.setTenpada(entity.getTenpada());
        return dto;
    }

    public static Map<String, String> dto2Map(BidDTO dto){
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("msgoithau", dto.getMsgoithau().toString());
        map.put("magoithau", dto.getMsgoithau().toString());
        map.put("tengoithau", dto.getMsgoithau().toString());
        map.put("noidung", dto.getMsgoithau().toString());
        map.put("giatrigoithau", dto.getMsgoithau().toString());
        map.put("sonamhd", dto.getMsgoithau().toString());
        map.put("sothanghd", dto.getMsgoithau().toString());
        map.put("songayhd", dto.getMsgoithau().toString());
        map.put("tenpada", dto.getMsgoithau().toString());

        map.put("soqd", dto.getMsgoithau().toString());
        map.put("ngayqd", dto.getMsgoithau().toString());
        map.put("creater", dto.getMsgoithau().toString());
        map.put("createtime", dto.getMsgoithau().toString());
        map.put("editer", dto.getMsgoithau().toString());
        map.put("edittime", dto.getMsgoithau().toString());
        map.put("giabanhsmt", dto.getMsgoithau().toString());
        map.put("baodamduthau", dto.getMsgoithau().toString());
        map.put("ghichu", dto.getMsgoithau().toString());

        map.put("landauthau", dto.getMsgoithau().toString());
        map.put("socvTrinhpd", dto.getMsgoithau().toString());
        map.put("ngaycvTrinhpd", dto.getMsgoithau().toString());
        map.put("createtime", dto.getMsgoithau().toString());
        map.put("editer", dto.getMsgoithau().toString());
        map.put("edittime", dto.getMsgoithau().toString());
        map.put("giabanhsmt", dto.getMsgoithau().toString());
        map.put("baodamduthau", dto.getMsgoithau().toString());
        map.put("ghichu", dto.getMsgoithau().toString());

        return map;
    }
}
