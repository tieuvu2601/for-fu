package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.core.business.BieuMauFieldFieldManagementLocalBean;
import com.banvien.vmsreport.core.data.session.BieuMauFieldFieldLocalBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/23/15
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "BieuMauFieldFieldManagementSessionEJB")
public class BieuMauFieldFieldManagementSessionBean implements BieuMauFieldFieldManagementLocalBean {
    private transient final Log log = LogFactory.getLog(getClass());

    @EJB
    private BieuMauFieldFieldLocalBean bieuMauFieldFieldService;
}
