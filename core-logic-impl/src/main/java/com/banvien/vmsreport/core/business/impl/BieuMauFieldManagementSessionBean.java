package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.core.business.BieuMauFieldManagementLocalBean;
import com.banvien.vmsreport.core.data.session.BieuMauFieldLocalBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/23/15
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "BieuMauFieldManagementSessionEJB")
public class BieuMauFieldManagementSessionBean implements BieuMauFieldManagementLocalBean {
    private transient final Log log = LogFactory.getLog(getClass());

    @EJB
    private BieuMauFieldLocalBean bieuMauFieldService;
}
