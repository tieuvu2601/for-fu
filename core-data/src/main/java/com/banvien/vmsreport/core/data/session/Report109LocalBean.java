package com.banvien.vmsreport.core.data.session;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/31/15
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Report109LocalBean {
    Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);
}
