package com.banvien.vmsreport.core.data.session;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/30/15
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface Report108LocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);

}
