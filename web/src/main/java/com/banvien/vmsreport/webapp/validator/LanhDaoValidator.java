package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.core.business.LanhdaoManagementLocalBean;
import com.banvien.vmsreport.webapp.command.LanhDaoCommand;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class LanhDaoValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private LanhdaoManagementLocalBean lanhdaoManagementLocalBean;

    @Override
    public boolean supports(Class<?> aClass) {
        return LanhDaoCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LanhDaoCommand command = (LanhDaoCommand)o;
        String crudaction = command.getCrudaction();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equalsIgnoreCase(Constants.INSERT_OR_UPDATE)){
            trimingField(command);
            checkRequiredFields(command, errors);
        }
    }

    private void checkRequiredFields(LanhDaoCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.tenlanhdao", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("lanhdao.manager.tenlanhdao")}, "non-empty value required.");
    }

    private void trimingField(LanhDaoCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getTenlanhdao())){
            command.getPojo().setTenlanhdao(command.getPojo().getTenlanhdao().trim());
        }
    }
}
