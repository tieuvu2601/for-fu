package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "DATA_ACTION")
@Entity
public class DmDataActionEntity {
    private Long msDataAction;
    private String phoneNumber;
    private String email;
    private String smsContent;
    private String emailContent;
    private Timestamp actionDate;
    private String tenNguoiNhan;
    private Integer izSMS;
    private Integer izEmail;
    private Integer flagSMS;
    private Integer flagEmail;
    private Timestamp dateSMS;
    private Timestamp dateMail;

    @Column(name = "MSDATAACTION")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_ACTION_SEQ")
    @SequenceGenerator(name="DATA_ACTION_SEQ", sequenceName="DATA_ACTION_SEQ", allocationSize=1)
    public Long getMsDataAction() {
        return msDataAction;
    }

    public void setMsDataAction(Long msDataAction) {
        this.msDataAction = msDataAction;
    }

    @Column(name = "PHONENUMBER")
    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "EMAIL")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "SMSCONTENT")
    @Basic
    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    @Column(name = "EMAILCONTENT")
    @Basic
    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    @Column(name = "ACTIONDATE")
    @Basic
    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    @Column(name = "TENNGUOINHAN")
    @Basic
    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    @Column(name = "IS_SMS")
    @Basic
    public Integer getIzSMS() {
        return izSMS;
    }

    public void setIzSMS(Integer izSMS) {
        this.izSMS = izSMS;
    }

    @Column(name = "IS_EMAILED")
    @Basic
    public Integer getIzEmail() {
        return izEmail;
    }

    public void setIzEmail(Integer izEmail) {
        this.izEmail = izEmail;
    }

    @Column(name = "FLAG_SMS")
    @Basic
    public Integer getFlagSMS() {
        return flagSMS;
    }

    public void setFlagSMS(Integer flagSMS) {
        this.flagSMS = flagSMS;
    }

    @Column(name = "FLAG_MAIL")
    @Basic
    public Integer getFlagEmail() {
        return flagEmail;
    }

    public void setFlagEmail(Integer flagEmail) {
        this.flagEmail = flagEmail;
    }

    @Column(name = "DATE_SMS")
    @Basic
    public Timestamp getDateSMS() {
        return dateSMS;
    }

    public void setDateSMS(Timestamp dateSMS) {
        this.dateSMS = dateSMS;
    }

    @Column(name = "DATE_MAIL")
    @Basic
    public Timestamp getDateMail() {
        return dateMail;
    }

    public void setDateMail(Timestamp dateMail) {
        this.dateMail = dateMail;
    }
}
