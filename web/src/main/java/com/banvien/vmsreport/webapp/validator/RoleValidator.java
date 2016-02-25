package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.dto.RoleDTO;
import com.banvien.vmsreport.core.business.RoleManagementLocalBean;
import com.banvien.vmsreport.webapp.command.RoleCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RoleValidator extends ApplicationObjectSupport implements Validator {

    @Autowired
    private RoleManagementLocalBean roleService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        RoleCommand command = (RoleCommand)o;
        trimingRoleField(command);
        checkRequiredFields(command, errors);
        checkUniqueRoleCode(command, errors);
    }

    private void checkRequiredFields(RoleCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.code", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("role.label.code")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.name", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("role.label.name")}, "non-empty value required.");
    }

    private void trimingRoleField(RoleCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getCode())){
            command.getPojo().setCode(command.getPojo().getCode().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getName())){
            command.getPojo().setName(command.getPojo().getName().trim());
        }
    }

    private void checkUniqueRoleCode(RoleCommand command, Errors errors) {
        String roleCode = command.getPojo().getCode();
        if(StringUtils.isNotBlank(roleCode)){
            try {
                RoleDTO dto = roleService.findByCode(roleCode);
                if(dto != null && dto.getRoleId() != command.getPojo().getRoleId()){
                    errors.rejectValue("pojo.code", "role.duplicated_code", new String[] {this.getMessageSourceAccessor().getMessage("role.manager.code")}, "Code has been existed!");
                }
            } catch (Exception e){}
        }
    }
}
