package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.core.business.HoSoThauManagementLocalBean;
import com.banvien.vmsreport.webapp.command.HoSoThauCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/18/15
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HoSoThauValidator extends ApplicationObjectSupport implements Validator {

    @Autowired
    private HoSoThauManagementLocalBean hoSoThauService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        HoSoThauCommand command = (HoSoThauCommand)o;
    }
}
