package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.utils.DateUtil;
import com.banvien.vmsreport.core.business.Report108ManagementLocalBean;
import com.banvien.vmsreport.core.data.session.Report108LocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/30/15
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report108ManagementSessionEJB")
public class Report108ManagementSessionBean implements Report108ManagementLocalBean {
    public Report108ManagementSessionBean() {
    }

    @EJB
    private Report108LocalBean report108LocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) throws ParseException {
        Object[] resultObject = report108LocalBean.search(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<Report108DTO> dtoList = new ArrayList<>();
        for (Object object : (List)resultObject[1]) {
            Object[] tmpArr = (Object[])object;
            Report108DTO dto = new Report108DTO();

            if (tmpArr[0] != null){
                BidDTO bidDTO = new BidDTO();
                bidDTO.setTengoithau(tmpArr[0].toString());
                dto.setGoiThau(bidDTO);
            }
            if (tmpArr[1] != null){
                HinhthucgtDTO hinhthucgtDTO = new HinhthucgtDTO();
                hinhthucgtDTO.setTenhinhthuc(tmpArr[1].toString());
                dto.setHinhthucgt(hinhthucgtDTO);
            }

            if (tmpArr[2]  != null || tmpArr[3] != null || tmpArr[4] != null){
                TienDoDTO tienDoDTO = new TienDoDTO();
                tienDoDTO.setQdPheDuyetNgay(tmpArr[2] != null ? Timestamp.valueOf(tmpArr[2].toString()) : null);
                tienDoDTO.setTrinhhsNgay(tmpArr[3] != null ? Timestamp.valueOf(tmpArr[3].toString()) : null);
                tienDoDTO.setTrinhhsSo(tmpArr[4] != null ? tmpArr[4].toString() : null);
                dto.setTienDo(tienDoDTO);
            }

            if (tmpArr[2]  != null && tmpArr[3] != null){
                dto.setThoiGianThucHien(daysBetween(DateUtil.string2Date(tmpArr[2].toString(), Constants.DBVMS_DATE_FORMAT), DateUtil.string2Date(tmpArr[3].toString(), Constants.DBVMS_DATE_FORMAT)));
            }

            if (tmpArr[5] != null){
                UserDTO userDTO = new UserDTO();
                userDTO.setUserName(tmpArr[5].toString());
                dto.setUser(userDTO);
            }
            dtoList.add(dto);

        }
        resultObject[1] = dtoList;
        return resultObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
