package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.core.business.DepartmentManagementLocalBean;
import com.banvien.vmsreport.webapp.command.DepartmentCommand;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.ejb.ObjectNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 8/21/15
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DepartmentValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    DepartmentManagementLocalBean departmentService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        DepartmentCommand command = (DepartmentCommand)o;
        trimmingField(command);
        checkRequiredFields(command, errors);
        checkUniqueFields(command, errors);
    }

    private void trimmingField(DepartmentCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getCode())){
            command.getPojo().setCode(command.getPojo().getCode().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getName())){
            command.getPojo().setName(command.getPojo().getName().trim());
        }
    }

    private void checkRequiredFields(DepartmentCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.code", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("label.department.code")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.name", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("label.department.name")}, "non-empty value required.");
    }

    private void checkUniqueFields(DepartmentCommand command, Errors errors) {
        String code = command.getPojo().getCode();
        if(StringUtils.isNotBlank(code)){
            try {
                DepartmentDTO dto = departmentService.findByCode(code);
                if(command.getPojo().getDepartmentId() != null){
                    if(!dto.getDepartmentId().equals(command.getPojo().getDepartmentId())){
                        errors.rejectValue("pojo.code", "department.msg.duplicated_code.code", new String[] {this.getMessageSourceAccessor().getMessage("label.department.code")}, "Code has been existed!");
                    }
                }else{
                    errors.rejectValue("pojo.code", "department.msg.duplicated_code", new String[] {this.getMessageSourceAccessor().getMessage("label.department.code")}, "Code has been existed!");
                }
            } catch (ObjectNotFoundException oe){}
        }
    }
}
