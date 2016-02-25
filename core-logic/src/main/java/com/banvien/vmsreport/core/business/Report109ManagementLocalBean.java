package com.banvien.vmsreport.core.business;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/31/15
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface Report109ManagementLocalBean {

    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);
}
