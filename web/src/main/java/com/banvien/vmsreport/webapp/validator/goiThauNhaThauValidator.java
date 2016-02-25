package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.core.business.GoiThauNhaThauManagementLocalBean;
import com.banvien.vmsreport.webapp.command.GoiThauNhaThauCommand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/15/15
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class GoiThauNhaThauValidator extends ApplicationObjectSupport implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Autowired
    private GoiThauNhaThauManagementLocalBean goiThauNhaThauManagementLocalBean;

    @Override
    public void validate(Object o, Errors errors) {
        GoiThauNhaThauCommand command = (GoiThauNhaThauCommand)o;
        trimingRoleField(command);
        checkRequiredFields(command, errors);
        checkUniqueNhaThauCode(command, errors);
    }

    private void trimingRoleField(GoiThauNhaThauCommand command) {
        //To change body of created methods use File | Settings | File Templates.
    }
    private void checkRequiredFields(GoiThauNhaThauCommand command, Errors errors) {
        //To change body of created methods use File | Settings | File Templates.
    }
    private void checkUniqueNhaThauCode(GoiThauNhaThauCommand command, Errors errors) {
    }
}
