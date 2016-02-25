package com.banvien.vmsreport.core.data.session;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/28/15
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Report106LocalBean {
    public Object[] search(Map<String, Object> properties, String sortExpression, String sortDirection, int firstItem, int maxPageItems);
}
