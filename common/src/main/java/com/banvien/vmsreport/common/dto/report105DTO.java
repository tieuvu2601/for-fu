package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/24/15
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Report105DTO implements Serializable {
    private static final long serialVersionUID = 3503181071722316608L;

    private DepartmentDTO department;
    private NguonvonDTO nguonvon;
    private Integer CDT[];
    private Integer CHCT[];
    private Integer DTRR[];
    private Integer MSTT[];
    private Integer CGCT[];
    private Integer total[];
    private Integer totalPlug;

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public NguonvonDTO getNguonvon() {
        return nguonvon;
    }

    public void setNguonvon(NguonvonDTO nguonvon) {
        this.nguonvon = nguonvon;
    }

    public Integer[] getCDT() {
        return CDT;
    }

    public void setCDT(Integer[] CDT) {
        this.CDT = CDT;
    }

    public Integer[] getCHCT() {
        return CHCT;
    }

    public void setCHCT(Integer[] CHCT) {
        this.CHCT = CHCT;
    }

    public Integer[] getDTRR() {
        return DTRR;
    }

    public void setDTRR(Integer[] DTRR) {
        this.DTRR = DTRR;
    }

    public Integer[] getMSTT() {
        return MSTT;
    }

    public void setMSTT(Integer[] MSTT) {
        this.MSTT = MSTT;
    }

    public Integer[] getCGCT() {
        return CGCT;
    }

    public void setCGCT(Integer[] CGCT) {
        this.CGCT = CGCT;
    }

    public Integer[] getTotal() {
        return total;
    }

    public void setTotal(Integer[] total) {
        this.total = total;
    }

    public Integer getTotalPlug() {
        return totalPlug;
    }

    public void setTotalPlug(Integer totalPlug) {
        this.totalPlug = totalPlug;
    }
}
