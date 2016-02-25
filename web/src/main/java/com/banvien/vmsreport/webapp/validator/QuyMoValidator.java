package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.HinhthucgtDTO;
import com.banvien.vmsreport.common.dto.QuyMoDTO;
import com.banvien.vmsreport.core.business.HinhthucManagementLocalBean;
import com.banvien.vmsreport.core.business.QuyMoManagementLocalBean;
import com.banvien.vmsreport.webapp.command.HinhThucCommand;
import com.banvien.vmsreport.webapp.command.QuyMoCommand;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class QuyMoValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private QuyMoManagementLocalBean quyMoManagementLocalBean;

    @Override
    public boolean supports(Class<?> aClass) {
        return QuyMoCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        QuyMoCommand command = (QuyMoCommand)o;
        String crudaction = command.getCrudaction();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equalsIgnoreCase(Constants.INSERT_OR_UPDATE)){
            trimingField(command);
            checkRequiredFields(command, errors);
            checkUniqueCode(command, errors);
        }
    }

    private void checkRequiredFields(QuyMoCommand command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pojo.tenquimo", "errors.required", new Object[]{this.getMessageSourceAccessor().getMessage("quymo.manager.tenquymo")}, "non-empty value required.");
    }

    private void trimingField(QuyMoCommand command) {
        if(StringUtils.isNotBlank(command.getPojo().getTenquimo())){
            command.getPojo().setTenquimo(command.getPojo().getTenquimo().trim());
        }
    }

    private void checkUniqueCode(QuyMoCommand command, Errors errors) {
        String code = command.getPojo().getTenquimo();
        if(StringUtils.isNotBlank(code)){
            try{
                QuyMoDTO dto = quyMoManagementLocalBean.findByName(code);
                if(dto != null && ! dto.getMsquimo().equals(command.getPojo().getMsquimo())){
                    errors.rejectValue("pojo.tenquimo", "errors.duplicated");
                }
            }catch (Exception e){}
        }
    }
}
