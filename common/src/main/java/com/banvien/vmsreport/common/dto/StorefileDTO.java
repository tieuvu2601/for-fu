package com.banvien.vmsreport.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 1/28/16
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreFileDTO implements Serializable {
    private static final long serialVersionUID = 6732738117315703785L;

    private Long storeFileId;
    private BidDTO GoiThau;
    private String typeVar;
    private String fullPath;
    private Timestamp createTime;
    private Timestamp modifiedTime;

    public Long getStoreFileId() {
        return storeFileId;
    }

    public void setStoreFileId(Long storeFileId) {
        this.storeFileId = storeFileId;
    }

    public BidDTO getGoiThau() {
        return GoiThau;
    }

    public void setGoiThau(BidDTO goiThau) {
        GoiThau = goiThau;
    }

    public String getTypeVar() {
        return typeVar;
    }

    public void setTypeVar(String typeVar) {
        this.typeVar = typeVar;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
