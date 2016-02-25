package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.UserGroupDTO;
import com.banvien.vmsreport.core.business.UserGroupManagementLocalBean;
import com.banvien.vmsreport.webapp.command.UserGroupCommand;
import org.apache.commons.lang.StringUtils;
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
 * User: Huy
 * Date: 8/20/15
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserGroupValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private UserGroupManagementLocalBean userGroupService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserGroupCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserGroupCommand command = (UserGroupCommand)o;
        checkIfAdminGroup(command, errors);
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equalsIgnoreCase(Constants.INSERT_OR_UPDATE)){
            trimingField(command);
            checkRequiredFields(command, errors);
            checkUniqueCode(command, errors);
        }
    }

    private void checkIfAdminGroup(UserGroupCommand command, Errors error){
        if(command.getPojo() != null && command.getPojo().getUserGroupId() != null){
            try{
                UserGroupDTO dto = this.userGroupService.findById(command.getPojo().getUserGroupId());
                if(dto.getCode().equalsIgnoreCase(Constants.ADMIN_ROLE)){
                    command.setWarningMsg(this.getMessageSourceAccessor().getMessage("usergroup.manager.not_allow_edit_system_group"));
                }
            }catch (ObjectNotFoundException oe){
                command.setWarningMsg(this.getMessageSourceAccessor().getMessage("usergroup.manager.not_found_user_group"));
            }
        }
    }

    private void checkRequiredFields(UserGroupCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.code", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("usergroup.manager.code")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.name", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("usergroup.manager.name")}, "non-empty value required.");
    }

    private void trimingField(UserGroupCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getCode())){
            command.getPojo().setCode(command.getPojo().getCode().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getName())){
            command.getPojo().setName(command.getPojo().getName().trim());
        }
    }

    private void checkUniqueCode(UserGroupCommand command, Errors errors) {
        String code = command.getPojo().getCode();
        if(StringUtils.isNotBlank(code)){
            try{
                UserGroupDTO dto = userGroupService.findByCode(code);
                if(dto != null && ! dto.getUserGroupId().equals(command.getPojo().getUserGroupId())){
                    errors.rejectValue("pojo.code", "errors.duplicated");
                }
            }catch (Exception e){}
        }
    }

}
