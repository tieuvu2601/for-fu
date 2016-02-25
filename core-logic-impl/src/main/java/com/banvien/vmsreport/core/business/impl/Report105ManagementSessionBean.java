package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.common.dto.NguonvonDTO;
import com.banvien.vmsreport.common.dto.Report105DTO;
import com.banvien.vmsreport.common.utils.DateUtil;
import com.banvien.vmsreport.core.business.Report105ManagementLocalBean;
import com.banvien.vmsreport.core.data.session.Report105LocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "Report105ManagementSessionEJB")
public class Report105ManagementSessionBean implements Report105ManagementLocalBean {
    public Report105ManagementSessionBean() {
    }

    @EJB
    private Report105LocalBean report105LocalBean;

    @Override
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems) throws ParseException {
        Object[] resultObject = report105LocalBean.search(properties, sortExpression, sortDirection, firstItem, maxPageItems);
        List<Report105DTO> listDTO = new ArrayList<>();
        String lastMission = null;
        Map<String, Integer> mapIndex = new HashMap<String, Integer >();
        for (Object object : (List)resultObject[1]) {
            Object[] tmpArr = (Object[])object;
            String departmentCode = tmpArr[0] != null ? tmpArr[0].toString().trim() : null;
            String capital= tmpArr[1] != null ? tmpArr[1].toString().trim() : null;
            String formName = tmpArr[2] != null ? tmpArr[2].toString().trim() : null;
            String statusCode = tmpArr[3] != null ? tmpArr[3].toString().trim() : null;
            Integer packageNum = tmpArr[4] != null ? Integer.valueOf(tmpArr[4].toString().trim()) : null;
            Report105DTO dto = new Report105DTO();

            assert capital != null;
            if (lastMission == null || !capital.equals(lastMission)) {
                NguonvonDTO nguonvonDTO = new NguonvonDTO();
                nguonvonDTO.setTennguonvon(capital);
                dto.setNguonvon(nguonvonDTO);
                lastMission = capital;
            }
            insertOrUpdateValueList(listDTO, dto, capital, departmentCode, statusCode, formName, packageNum, mapIndex);
        }


        resultObject[0] = listDTO.size();
        resultObject[1] = listDTO;
        return resultObject;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void insertOrUpdateValueList(List<Report105DTO> listDTO, Report105DTO dto, String capital, String departmentCode, String statusCode, String formName, Integer packageNum, Map<String, Integer> mapIndex) {
        Integer index = mapIndex.get(capital+departmentCode);
        if(index != null ){
            dto = listDTO.get(index);
            updateReportDTO(dto, statusCode, formName, packageNum);
        }else {
            writeData4District(dto, departmentCode, statusCode, formName, packageNum);
            mapIndex.put(capital+departmentCode, listDTO.size());
            listDTO.add(dto);
        }
    }

    private void writeData4District(Report105DTO dto, String departmentCode, String statusCode, String formName, Integer packageNum) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setCode(departmentCode);
        dto.setDepartment(departmentDTO);
        insertOrUpdateMonthValueArray(dto, statusCode, formName, packageNum);
    }

    private void updateReportDTO(Report105DTO dto, String statusCode, String formName, Integer packageNum) {
        insertOrUpdateMonthValueArray(dto, statusCode, formName, packageNum);
    }

    private void insertOrUpdateMonthValueArray(Report105DTO dto, String statusCode, String formName, Integer packageNum) {
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

    private Integer[] getMonthValueArrayFromDTO(Report105DTO dto, String formName) {
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

    private void updateMonthValueArray(Integer[] valueArray, String statusCode, Integer packageNum) {
        if (Constants.HT_TYPE.equalsIgnoreCase(statusCode)){
            valueArray[0] = updateArrayVar(valueArray[0], packageNum);
        }else {
            valueArray[1] = updateArrayVar(valueArray[1], packageNum);
        }
    }

    private void setMonthValueArray2DTO(Report105DTO dto, String formName, Integer[] valueArray) {
        if(Constants.CDT_TYPE.equalsIgnoreCase(formName)){
            dto.setCDT(valueArray);
        }else if(Constants.CHCT_TYPE.equalsIgnoreCase(formName)){
            dto.setCHCT(valueArray);
        }else if(Constants.DTRR_TYPE.equalsIgnoreCase(formName)){
            dto.setDTRR(valueArray);
        }else if(Constants.MSTT_TYPE.equalsIgnoreCase(formName)){
            dto.setMSTT(valueArray);
        }else if(Constants.CGCT_TYPE.equalsIgnoreCase(formName)){
            dto.setCGCT(valueArray);
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
