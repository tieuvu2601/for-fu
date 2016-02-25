package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.GoithaunhanvienDTO;
import com.banvien.vmsreport.common.dto.Report103DTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.core.business.Report103ManagementLocalBean;
import com.banvien.vmsreport.core.data.session.Report103LocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/22/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report103ManagementSessionEJB")
public class Report103ManagementSessionBean implements Report103ManagementLocalBean {
    public Report103ManagementSessionBean() {
    }

    @EJB
    private Report103LocalBean report103LocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] resultObject = report103LocalBean.search(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<Report103DTO> listDTO = new ArrayList<>();
        List<Report103DTO> otherListDTO = new ArrayList<>();
        BigInteger lastMission = null;
        Map<String, Integer> mapIndex = new HashMap<String, Integer >();
        for (Object object : (List)resultObject[1]) {
            Object[] tmpArr = (Object[])object;
            String userName = tmpArr[0] != null ? tmpArr[0].toString().trim() : null;
            BigInteger isChair= tmpArr[1] != null ? BigInteger.valueOf(Long.parseLong(tmpArr[1].toString().trim())) : null;
            String formName = tmpArr[2] != null ? tmpArr[2].toString().trim() : null;
            String statusCode = tmpArr[3] != null ? tmpArr[3].toString().trim() : null;
            Integer packageNum = tmpArr[4] != null ? Integer.valueOf(tmpArr[4].toString().trim()) : null;
            Report103DTO dto = new Report103DTO();

            assert isChair != null;
            if (lastMission == null || !isChair.equals(lastMission)) {
                GoithaunhanvienDTO goithaunhanvienDTO = new GoithaunhanvienDTO();
                goithaunhanvienDTO.setIschutri(isChair);
                dto.setGoithaunhanvien(goithaunhanvienDTO);
                lastMission = isChair;
            }
            insertOrUpdateValueList(listDTO, dto, isChair, userName, statusCode, formName, packageNum, mapIndex);
            insertOrUpdateValueList(otherListDTO, new Report103DTO(), null, userName, statusCode, formName, packageNum, mapIndex);
        }

        if (otherListDTO.size() > 0){
            GoithaunhanvienDTO goithaunhanvien = new GoithaunhanvienDTO();
            goithaunhanvien.setIschutri(BigInteger.valueOf(2));
            otherListDTO.get(0).setGoithaunhanvien(goithaunhanvien);
            listDTO.addAll(otherListDTO);
        }
        resultObject[0] = listDTO.size();
        resultObject[1] = listDTO;
        return resultObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void insertOrUpdateValueList(List<Report103DTO> listDTO, Report103DTO dto, BigInteger chair, String userName, String statusCode, String formName, Integer packageNum, Map<String, Integer> mapIndex) {
        Integer index = mapIndex.get(chair+userName);
        if(index != null ){
            dto = listDTO.get(index);
            updateReportDTO(dto, userName, statusCode, formName, packageNum, index);
        }else {
            writeData4District(dto, userName, statusCode, formName, packageNum);
            mapIndex.put(chair+userName, listDTO.size());
            listDTO.add(dto);
        }
    }
    /**
     * Find row data in the list which the data belong to and update it.
     */
    private void updateReportDTO(Report103DTO dto, String userName, String statusCode, String formName, Integer packageNum, Integer index){
        insertOrUpdateMonthValueArray(dto, statusCode, formName, packageNum);
    }

    private void writeData4District(Report103DTO dto, String userName, String statusCode, String formName, Integer packageNum){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userName);
        dto.setUser(userDTO);
        insertOrUpdateMonthValueArray(dto, statusCode, formName, packageNum);
    }

    private void insertOrUpdateMonthValueArray(Report103DTO dto, String statusCode, String formName, Integer packageNum){
        Integer[] valueArray = getMonthValueArrayFromDTO(dto, formName);
        if(valueArray == null){
            valueArray = new Integer[2];
        }
        updateMonthValueArray(valueArray, statusCode, packageNum);
        setMonthValueArray2DTO(dto, formName, valueArray);

        Integer[] totalValueArray = dto.getTotal();
        if(totalValueArray == null){
            totalValueArray = new Integer[2];
        }
        updateMonthValueArray(totalValueArray, statusCode, packageNum);
        dto.setTotal(totalValueArray);

        dto.setTotalPlug(updateArrayVar(totalValueArray[0], totalValueArray[1]));
    }

    private void updateMonthValueArray(Integer[] valueArray, String statusCode, Integer packageNum){
        if (Constants.HT_TYPE.equalsIgnoreCase(statusCode)){
            valueArray[0] = updateArrayVar(valueArray[0], packageNum);
        }else {
            valueArray[1] = updateArrayVar(valueArray[1], packageNum);
        }
    }

    private Integer[] getMonthValueArrayFromDTO(Report103DTO dto, String formName){
        if(Constants.CDT_TYPE.equalsIgnoreCase(formName)){
            return dto.getCDT();
        }else if(Constants.CHCT_TYPE.equalsIgnoreCase(formName)){
            return dto.getCHCT();
        }else if(Constants.DTRR_TYPE.equalsIgnoreCase(formName)){
            return dto.getDTRR();
        }else if(Constants.MSTT_TYPE.equalsIgnoreCase(formName)){
            return dto.getMSTT();
        }else if(Constants.CGCT_TYPE.equalsIgnoreCase(formName)){
            return dto.getCGCT();
        }
        return null;
    }

    private void setMonthValueArray2DTO(Report103DTO dto, String formName, Integer[] monthValueArr){
        if(Constants.CDT_TYPE.equalsIgnoreCase(formName)){
            dto.setCDT(monthValueArr);
        }else if(Constants.CHCT_TYPE.equalsIgnoreCase(formName)){
            dto.setCHCT(monthValueArr);
        }else if(Constants.DTRR_TYPE.equalsIgnoreCase(formName)){
            dto.setDTRR(monthValueArr);
        }else if(Constants.MSTT_TYPE.equalsIgnoreCase(formName)){
            dto.setMSTT(monthValueArr);
        }else if(Constants.CGCT_TYPE.equalsIgnoreCase(formName)){
            dto.setCGCT(monthValueArr);
        }
    }
    private Integer updateArrayVar(Integer arrayPlus, Integer arrayVar){
        if (arrayVar != null){
            if (arrayPlus != null){
                arrayPlus += arrayVar;
            }else {
                arrayPlus = arrayVar;
            }
        }
        return arrayPlus;
    }
}
