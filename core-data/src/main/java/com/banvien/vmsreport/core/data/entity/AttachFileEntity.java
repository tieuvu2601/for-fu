package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.lang.String;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ATTACH_FILE")
@Entity
public class AttachFileEntity {
    private Long attachid;

    @javax.persistence.Column(name = "ATTACHID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTACH_FILE_SEQ")
    @SequenceGenerator(name="ATTACH_FILE_SEQ", sequenceName="ATTACH_FILE_SEQ", allocationSize=1)
    public Long getAttachid() {
        return attachid;
    }

    public void setAttachid(Long attachid) {
        this.attachid = attachid;
    }


    private Integer mstailieu;

    @javax.persistence.Column(name = "MSTAILIEU")
    @Basic
    Integer getMstailieu() {
        return mstailieu;
    }

    void setMstailieu(Integer mstailieu) {
        this.mstailieu = mstailieu;
    }

    private String loai;

    @javax.persistence.Column(name = "LOAI")
    @Basic
    String getLoai() {
        return loai;
    }

    void setLoai(String loai) {
        this.loai = loai;
    }

    private String tengoc;

    @javax.persistence.Column(name = "TENGOC")
    @Basic
    String getTengoc() {
        return tengoc;
    }

    void setTengoc(String tengoc) {
        this.tengoc = tengoc;
    }

    private String tenupload;

    @javax.persistence.Column(name = "TENUPLOAD")
    @Basic
    String getTenupload() {
        return tenupload;
    }

    void setTenupload(String tenupload) {
        this.tenupload = tenupload;
    }

    private String duongdan;

    @javax.persistence.Column(name = "DUONGDAN")
    @Basic
    String getDuongdan() {
        return duongdan;
    }

    void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    private String kichthuoc;

    @javax.persistence.Column(name = "KICHTHUOC")
    @Basic
    String getKichthuoc() {
        return kichthuoc;
    }

    void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }

    private Integer userid;

    @javax.persistence.Column(name = "USERID")
    @Basic
    Integer getUserid() {
        return userid;
    }

    void setUserid(Integer userid) {
        this.userid = userid;
    }

    private BigInteger active;

    @javax.persistence.Column(name = "ACTIVE")
    @Basic
    BigInteger getActive() {
        return active;
    }

    void setActive(BigInteger active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachFileEntity that = (AttachFileEntity) o;

        if (attachid != that.attachid) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (duongdan != null ? !duongdan.equals(that.duongdan) : that.duongdan != null) return false;
        if (kichthuoc != null ? !kichthuoc.equals(that.kichthuoc) : that.kichthuoc != null) return false;
        if (loai != null ? !loai.equals(that.loai) : that.loai != null) return false;
        if (mstailieu != null ? !mstailieu.equals(that.mstailieu) : that.mstailieu != null) return false;
        if (tengoc != null ? !tengoc.equals(that.tengoc) : that.tengoc != null) return false;
        if (tenupload != null ? !tenupload.equals(that.tenupload) : that.tenupload != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

}
