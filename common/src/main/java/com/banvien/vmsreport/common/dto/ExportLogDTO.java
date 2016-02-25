package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: VanPhuc
 * Date: 11/12/15
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExportLogDTO implements Serializable {

    private String logExportId;
    private String userName;
    private Date startDateFilter;
    private Date endDateFilter;
    private Date createdDate;
    private String reportName;

    public String getLogExportId() {
        return logExportId;
    }

    public void setLogExportId(String logExportId) {
        this.logExportId = logExportId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getStartDateFilter() {
        return startDateFilter;
    }

    public void setStartDateFilter(Date startDateFilter) {
        this.startDateFilter = startDateFilter;
    }

    public Date getEndDateFilter() {
        return endDateFilter;
    }

    public void setEndDateFilter(Date endDateFilter) {
        this.endDateFilter = endDateFilter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
}
