package com.banvien.vmsreport.core.data.session;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface Report104LocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);
}
