package com.banvien.vmsreport.core.data.session;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/21/15
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface Report102LocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

}
