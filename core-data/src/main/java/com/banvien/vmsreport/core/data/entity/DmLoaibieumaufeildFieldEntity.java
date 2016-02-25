package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/23/15
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DM_LOAIBIEUMAUFIELD_FIELD")
@Entity
public class DmLoaibieumaufeildFieldEntity {
    private int msBMFieldFeild;

    @javax.persistence.Column(name = "MSBMFIELDFIELD")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_LOAIBMFIELD_FIELD_SEQ")
    @SequenceGenerator(name="DM_LOAIBMFIELD_FIELD_SEQ", sequenceName="DM_LOAIBMFIELD_FIELD_SEQ", allocationSize=1)
    public int getMsBMFieldFeild() {
        return msBMFieldFeild;
    }

    public void setMsBMFieldFeild(int msBMFieldFeild) {
        this.msBMFieldFeild = msBMFieldFeild;
    }

    private DmLoaibieumaufeildEntity bieumaufield;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSBIEUMAUFIELD", referencedColumnName = "MSBIEUMAUFIELD")
    public DmLoaibieumaufeildEntity getBieumaufield() {
        return bieumaufield;
    }

    public void setBieumaufield(DmLoaibieumaufeildEntity bieumaufield) {
        this.bieumaufield = bieumaufield;
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

    private String getField;

    @javax.persistence.Column(name = "GETFIELD")
    @Basic
    public String getGetField() {
        return getField;
    }

    public void setGetField(String getField) {
        this.getField = getField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DmLoaibieumaufeildFieldEntity that = (DmLoaibieumaufeildFieldEntity) o;

        if (msBMFieldFeild != that.msBMFieldFeild) return false;
        if (getField != null ? !getField.equals(that.getField) : that.getField != null) return false;
        if (bieumaufield != null ? !bieumaufield.equals(that.bieumaufield) : that.bieumaufield != null)
            return false;
        if (fieldType != null ? !fieldType.equals(that.fieldType) : that.fieldType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = msBMFieldFeild;
        result = 31 * result + (bieumaufield != null ? bieumaufield.hashCode() : 0);
        result = 31 * result + (getField != null ? getField.hashCode() : 0);
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        return result;
    }
}
