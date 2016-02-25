package com.banvien.vmsreport.webapp.validator;

import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.core.business.BidManagementLocalBean;
import com.banvien.vmsreport.core.business.DepartmentManagementLocalBean;
import com.banvien.vmsreport.webapp.command.BidCommand;
import com.banvien.vmsreport.webapp.command.BidCommand;
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
public class BidValidator extends ApplicationObjectSupport implements Validator {

    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    BidManagementLocalBean bidService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        BidCommand command = (BidCommand)o;
    }

}
