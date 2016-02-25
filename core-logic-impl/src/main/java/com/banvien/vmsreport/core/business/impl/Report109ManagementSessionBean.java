package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.Report109DTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.core.business.Report109ManagementLocalBean;
import com.banvien.vmsreport.core.data.session.Report109LocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/31/15
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report109ManagementSessionEJB")
public class Report109ManagementSessionBean implements Report109ManagementLocalBean{
    public Report109ManagementSessionBean() {
    }
    @EJB
    private Report109LocalBean report109LocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) {
        Object[] resultObject =  report109LocalBean.search(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<Report109DTO> listDTO = new ArrayList<>();
        Map<String, Integer> mapIndex = new HashMap<String, Integer >();
        for (Object object : (List)resultObject[1]) {
            Object[] tmpArr = (Object[])object;
            String userName = tmpArr[0] != null ? tmpArr[0].toString().trim() : null;
            String formName = tmpArr[1] != null ? tmpArr[1].toString().trim() : null;
            String statusCode = tmpArr[2] != null ? tmpArr[2].toString().trim() : null;
            Integer packageNum = tmpArr[3] != null ? Integer.valueOf(tmpArr[3].toString().trim()) : null;
            Report109DTO dto = new Report109DTO();

            insertOrUpdateValueList(listDTO, dto,  userName, statusCode, formName, packageNum, mapIndex);
        }

        resultObject[0] = listDTO.size();
        resultObject[1] = listDTO;
        return resultObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void insertOrUpdateValueList(List<Report109DTO> listDTO, Report109DTO dto, String userName, String statusCode, String formName, Integer packageNum, Map<String, Integer> mapIndex) {
        Integer index = mapIndex.get(userName);
        if(index != null ){
            dto = listDTO.get(index);
            updateReportDTO(dto, userName, statusCode, formName, packageNum, index);
        }else {
            writeData4Formality(dto, userName, statusCode, formName, packageNum);
            mapIndex.put(userName, listDTO.size());
            listDTO.add(dto);
        }
    }
    /**
     * Find row data in the list which the data belong to and update it.
     */
    private void updateReportDTO(Report109DTO dto, String userName, String statusCode, String formName, Integer packageNum, Integer index){
        insertOrUpdateMonthValueArray(dto, statusCode, formName, packageNum);
    }

    private void writeData4Formality(Report109DTO dto, String userName, String statusCode, String formName, Integer packageNum){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userName);
        dto.setUser(userDTO);
        insertOrUpdateMonthValueArray(dto, statusCode, formName, packageNum);
    }

    private void insertOrUpdateMonthValueArray(Report109DTO dto, String statusCode, String formName, Integer packageNum){
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

    private Integer[] getMonthValueArrayFromDTO(Report109DTO dto, String formName){
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

    private void setMonthValueArray2DTO(Report109DTO dto, String formName, Integer[] monthValueArr){
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
