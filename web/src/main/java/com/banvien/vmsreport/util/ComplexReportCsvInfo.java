package com.banvien.vmsreport.util;

/**
 * User: vietpham
 * Date: 09/26/15
 * Time: 10:43 AM
 */
public interface ComplexReportCsvInfo {
    public String[] getRootHeaders();
    public String[] getRootCsvFields();
    public String getChildNodes();
    public String[] getHeaders();
    public String[] getCsvFields();
    public int getCsvFieldDecimalRound(String field);
    public int getFactor(String field);
    public String getSymbol(String field);
}
