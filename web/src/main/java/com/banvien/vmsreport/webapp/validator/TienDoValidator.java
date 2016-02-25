package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import com.banvien.vmsreport.webapp.command.TienDoCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TienDoValidator extends ApplicationObjectSupport implements Validator {

    @Autowired
    private TienDoManagementLocalBean tienDoService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        TienDoCommand command = (TienDoCommand)o;
    }

}
