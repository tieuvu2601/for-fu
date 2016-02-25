package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.dto.NhaThauDTO;
import com.banvien.vmsreport.core.business.NhaThauManagementLocalBean;
import com.banvien.vmsreport.webapp.command.GoiThauNhaThauCommand;
import com.banvien.vmsreport.webapp.command.NhaThauCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.ejb.ObjectNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/11/15
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class NhaThauValidator extends ApplicationObjectSupport implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Autowired
    private NhaThauManagementLocalBean nhaThauManagementLocalBean;

    @Override
    public void validate(Object o, Errors errors) {
        NhaThauCommand command = (NhaThauCommand)o;
        trimingRoleField(command);
        checkRequiredFields(command, errors);
        checkUniqueNhaThauCode(command, errors);
    }

    private void checkUniqueNhaThauCode(NhaThauCommand command, Errors errors) {
        String maSoThue = command.getPojo().getMasothue();
        if(StringUtils.isNotBlank(maSoThue)){
            try {
                NhaThauDTO dto = nhaThauManagementLocalBean.findByMaSoThue(maSoThue);
                if(command.getPojo().getMsnhathau() != null){
                    if(!dto.getMsnhathau().equals(command.getPojo().getMsnhathau())){
                        errors.rejectValue("pojo.masothue", "label.nhathau.duplicated_msthue", new String[] {this.getMessageSourceAccessor().getMessage("label.nhathau.msthue")}, "Ma so thue has been existed!");
                    }
                }else{
                    errors.rejectValue("pojo.masothue", "label.nhathau.duplicated_msthue", new String[] {this.getMessageSourceAccessor().getMessage("label.nhathau.msthue")}, "Ma so thue has been existed!");
                }
            } catch (ObjectNotFoundException oe){}
        }

    }

    private void checkRequiredFields(NhaThauCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.tennhathau", "errors.required",
                new Object[]{this.getMessageSourceAccessor().getMessage("label.nhauthau.ten")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.masothue", "errors.required",
                new Object[]{this.getMessageSourceAccessor().getMessage("label.nhathau.msthue")}, "non-empty value required.");
    }

    private void trimingRoleField(NhaThauCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getTennhathau())){
            command.getPojo().setTennhathau(command.getPojo().getTennhathau().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getDiachi())){
            command.getPojo().setDiachi(command.getPojo().getDiachi().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getDienthoai())){
            command.getPojo().setDienthoai(command.getPojo().getDienthoai().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getFax())){
            command.getPojo().setFax(command.getPojo().getFax().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getGhichu())){
            command.getPojo().setGhichu(command.getPojo().getGhichu().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getMasothue())){
            command.getPojo().setMasothue(command.getPojo().getMasothue().trim());
        }
    }
}
