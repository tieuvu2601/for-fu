package com.banvien.vmsreport.core.business;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/22/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface Report103ManagementLocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

}
