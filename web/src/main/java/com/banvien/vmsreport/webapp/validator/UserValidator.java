package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.common.utils.WebCommonUtil;
import com.banvien.vmsreport.core.business.UserManagementLocalBean;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.webapp.command.UserCommand;
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
public class UserValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    UserManagementLocalBean userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserCommand command = (UserCommand)o;
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equalsIgnoreCase(Constants.INSERT_OR_UPDATE)){
            if(command.getPojo().getUserId() != null){
                validateUserId(command, errors);
            }
            if(StringUtils.isBlank(command.getErrorMessage())){
                trimmingField(command);
                checkRequiredFields(command, errors);
                checkUniqueFields(command, errors);
                validateEmail(command, errors);
                validateAvatar(command, errors);
            }
        }else{
            validateUserId(command, errors);
        }
    }

    private void trimmingField(UserCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getUserName())){
            command.getPojo().setUserName(command.getPojo().getUserName().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getPassword())){
            command.getPojo().setEmail(command.getPojo().getEmail().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getDisplayName())){
            command.getPojo().setDisplayName(command.getPojo().getDisplayName().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getEmail())){
            command.getPojo().setEmail(command.getPojo().getEmail().trim());
        }
    }

    private void checkRequiredFields(UserCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.password", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("user.label.password")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.userName", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("user.manager.username")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.userGroup.userGroupId", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("user.manager.usergroup")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.displayName", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("user.manager.displayName")}, "non-empty value required.");
    }

    private void checkUniqueFields(UserCommand command, Errors errors) {
        String email = command.getPojo().getEmail();
        if(StringUtils.isNotBlank(email)){
            try {
                UserDTO dto = userService.findByEmail(email);
                if(command.getPojo().getUserId() != null){
                    if(dto.getUserId() != command.getPojo().getUserId()){
                        errors.rejectValue("pojo.email", "user.duplicated_email", new String[] {this.getMessageSourceAccessor().getMessage("user.manager.email")}, "Email has been existed!");
                    }
                }else{
                    errors.rejectValue("pojo.email", "user.duplicated_email", new String[] {this.getMessageSourceAccessor().getMessage("user.manager.email")}, "Email has been existed!");
                }
            } catch (ObjectNotFoundException oe){}
        }
        String userName = command.getPojo().getUserName();
        if(StringUtils.isNotBlank(userName)){
            try{
                UserDTO dto = userService.findAllAndFetchPermission(userName);
                if(command.getPojo().getUserId() != null){
                    if(dto.getUserId() != command.getPojo().getUserId()){
                        errors.rejectValue("pojo.userName", "user.duplicated_username", new String[] {this.getMessageSourceAccessor().getMessage("user.manager.username")}, "Duplicated UserName!");
                    }
                }else{
                    errors.rejectValue("pojo.userName", "user.duplicated_username", new String[] {this.getMessageSourceAccessor().getMessage("user.manager.username")}, "Duplicated UserName!");
                }
            }catch (ObjectNotFoundException oe){}
        }
    }

    private void validateEmail(UserCommand command, Errors errors) {
        if (org.apache.commons.lang.StringUtils.isNotEmpty(command.getPojo().getEmail()) && !WebCommonUtil.isValidEmail(command.getPojo().getEmail())) {
            errors.rejectValue("pojo.email", "user.invalid_email_format", new String[] {this.getMessageSourceAccessor().getMessage("user.manager.email")}, "Invalid format");
        }
    }

    private void validateUserId(UserCommand command, Errors errors){
            if(StringUtils.isNotBlank(command.getPojo().getUserId().toString()) && !SecurityUtils.getPrincipal().getUserId().equals(command.getPojo().getUserId())){
            command.setErrorMessage(this.getMessageSourceAccessor().getMessage("user.not.authorize.content"));
        }
    }

    private void validateAvatar(UserCommand command, Errors errors){
        if(command.getPojo().getAvatarFileItem() != null && StringUtils.isNotBlank(command.getPojo().getAvatarFileItem().getOriginalFilename()) && command.getPojo().getAvatarFileItem().getOriginalFilename().length() > 25){
            errors.rejectValue("pojo.avatarFileItem", "user.avatar.length.so_long", new String[] {this.getMessageSourceAccessor().getMessage("user.manager.avatar")}, "Invalid format");
        }

    }
}
