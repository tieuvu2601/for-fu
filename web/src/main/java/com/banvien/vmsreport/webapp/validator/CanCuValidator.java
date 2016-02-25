package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.CanCuDTO;
import com.banvien.vmsreport.core.business.CanCuManagementLocalBean;
import com.banvien.vmsreport.webapp.command.CanCuCommand;
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
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class CanCuValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private CanCuManagementLocalBean cancuManagementLocalBean;

    @Override
    public boolean supports(Class<?> aClass) {
        return CanCuCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CanCuCommand command = (CanCuCommand)o;
        String crudaction = command.getCrudaction();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equalsIgnoreCase(Constants.INSERT_OR_UPDATE)){
            trimingField(command);
            checkRequiredFields(command, errors);
            checkUniqueCode(command, errors);
        }
    }

    private void checkRequiredFields(CanCuCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.maCanCu", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("cancu.manager.macancu")}, "non-empty value required.");
    }

    private void trimingField(CanCuCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getMaCanCu())){
            command.getPojo().setMaCanCu(command.getPojo().getMaCanCu().trim());
        }
    }
    private void checkUniqueCode(CanCuCommand command, Errors errors) {
        String code = command.getPojo().getMaCanCu();
        if(StringUtils.isNotBlank(code)){
            try{
                CanCuDTO dto = cancuManagementLocalBean.findByMaCanCu(code);
                if(dto != null){
                    errors.rejectValue("pojo.maCanCu", "errors.duplicated");
                }
            }catch (Exception e){}
        }
    }

}
