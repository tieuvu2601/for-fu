package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.HinhthucgtDTO;
import com.banvien.vmsreport.core.business.HinhthucManagementLocalBean;
import com.banvien.vmsreport.webapp.command.HinhThucCommand;
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
 * User: Huy
 * Date: 8/20/15
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HinhThucValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private HinhthucManagementLocalBean hinhThucManagementLocalBean;

    @Override
    public boolean supports(Class<?> aClass) {
        return HinhThucCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HinhThucCommand command = (HinhThucCommand)o;
//        checkIfAdminGroup(command, errors);
        String crudaction = command.getCrudaction();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equalsIgnoreCase(Constants.INSERT_OR_UPDATE)){
            trimingField(command);
            checkRequiredFields(command, errors);
            checkUniqueCode(command, errors);
        }
    }

    private void checkRequiredFields(HinhThucCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.mahinhthuc", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("hinhthuc.manager.mahinhthuc")}, "non-empty value required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.tenhinhthuc", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("hinhthuc.manager.tenhinhthuc")}, "non-empty value required.");
    }

    private void trimingField(HinhThucCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getMahinhthuc())){
            command.getPojo().setMahinhthuc(command.getPojo().getMahinhthuc().trim());
        }
        if(StringUtils.isNotBlank(command.getPojo().getTenhinhthuc())){
            command.getPojo().setTenhinhthuc(command.getPojo().getTenhinhthuc().trim());
        }
    }

    private void checkUniqueCode(HinhThucCommand command, Errors errors) {
        String code = command.getPojo().getMahinhthuc();
        if(StringUtils.isNotBlank(code)){
            try{
                HinhthucgtDTO dto = hinhThucManagementLocalBean.findByCode(code);
                if(dto != null && ! dto.getMshinhthuc().equals(command.getPojo().getMshinhthuc())){
                    errors.rejectValue("pojo.mahinhthuc", "errors.duplicated");
                }
            }catch (Exception e){}
        }
    }
}
