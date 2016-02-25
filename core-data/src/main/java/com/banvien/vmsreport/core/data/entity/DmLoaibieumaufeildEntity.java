package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/23/15
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_LOAIBIEUMAUFIELD")
@Entity
public class DmLoaibieumaufeildEntity {
    private int msbieumaufield;

    @javax.persistence.Column(name = "MSBIEUMAUFIELD")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_LOAIBIEUMAUFIELD_SEQ")
    @SequenceGenerator(name="DM_LOAIBIEUMAUFIELD_SEQ", sequenceName="DM_LOAIBIEUMAUFIELD_SEQ", allocationSize=1)
    public int getMsbieumaufield() {
        return msbieumaufield;
    }

    public void setMsbieumaufield(int msbieumaufield) {
        this.msbieumaufield = msbieumaufield;
    }

    private DmLoaibieumauEntity bieumau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSBIEUMAU", referencedColumnName = "MSBIEUMAU")
    public DmLoaibieumauEntity getBieumau() {
        return bieumau;
    }

    public void setBieumau(DmLoaibieumauEntity bieumau) {
        this.bieumau = bieumau;
    }

    private String fieldName;

    @javax.persistence.Column(name = "FIELDNAME")
    @Basic
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    private String fieldType;


    @javax.persistence.Column(name = "FIELDTYPE")
    @Basic
    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    private Long columnnum;

    @javax.persistence.Column(name = "COLUMNNUM")
    @Basic
    public Long getColumnnum() {
        return columnnum;
    }

    public void setColumnnum(Long columnnum) {
        this.columnnum = columnnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmLoaibieumaufeildEntity that = (DmLoaibieumaufeildEntity) o;

        if (msbieumaufield != that.msbieumaufield) return false;
        if (columnnum != null ? !columnnum.equals(that.columnnum) : that.columnnum != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (fieldType != null ? !fieldType.equals(that.fieldType) : that.fieldType != null) return false;
        if (bieumau != null ? !bieumau.equals(that.bieumau) : that.bieumau != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = msbieumaufield;
        result = 31 * result + (bieumau != null ? bieumau.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        result = 31 * result + (columnnum != null ? columnnum.hashCode() : 0);
        return result;
    }
}
