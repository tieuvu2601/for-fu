package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/28/16
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "StoreFile")
@Entity
public class StoreFileEntity {

    private Long storeFileId;
    private GoithauEntity goiThau;
    private String typeVar;
    private String fullPath;
    private Timestamp createTime;
    private Timestamp modifiedTime;

    @javax.persistence.Column(name = "storeFileId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StoreFile_SEQ")
    @SequenceGenerator(name="StoreFile_SEQ", sequenceName="StoreFile_SEQ", allocationSize=1)
    public Long getStoreFileId() {
        return storeFileId;
    }

    public void setStoreFileId(Long storeFileId) {
        this.storeFileId = storeFileId;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "msGoiThau", referencedColumnName = "msGoiThau", nullable = false)
    public GoithauEntity getGoiThau() {
        return goiThau;
    }

    public void setGoiThau(GoithauEntity goiThau) {
        this.goiThau = goiThau;
    }

    @javax.persistence.Column(name = "typeVar")
    @Basic
    public String getTypeVar() {
        return typeVar;
    }

    public void setTypeVar(String typeVar) {
        this.typeVar = typeVar;
    }

    @javax.persistence.Column(name = "fullPath")
    @Basic
    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    @javax.persistence.Column(name = "createTime")
    @Basic
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @javax.persistence.Column(name = "modifiedTime")
    @Basic
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreFileEntity that = (StoreFileEntity) o;

        if (storeFileId != null ? !storeFileId.equals(that.storeFileId) : that.storeFileId != null) return false;
        if (typeVar != null ? !typeVar.equals(that.typeVar) : that.typeVar != null) return false;
        if (fullPath != null ? !fullPath.equals(that.fullPath) : that.fullPath != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (modifiedTime != null ? !modifiedTime.equals(that.modifiedTime) : that.modifiedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeFileId != null ? storeFileId.hashCode() : 0;
        result = 31 * result + (typeVar != null ? typeVar.hashCode() : 0);
        result = 31 * result + (fullPath != null ? fullPath.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifiedTime != null ? modifiedTime.hashCode() : 0);
        return result;
    }

}
