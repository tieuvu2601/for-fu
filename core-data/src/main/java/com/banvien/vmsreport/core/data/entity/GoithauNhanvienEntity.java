package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "GOITHAU_NHANVIEN")
@Entity
public class GoithauNhanvienEntity {
    private Long msgoithauNv;

    @javax.persistence.Column(name = "MSGOITHAU_NV")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOITHAU_NHANVIEN_SEQ")
    @SequenceGenerator(name="GOITHAU_NHANVIEN_SEQ", sequenceName="GOITHAU_NHANVIEN_SEQ", allocationSize=1)
    public Long getMsgoithauNv() {
        return msgoithauNv;
    }

    public void setMsgoithauNv(Long msgoithauNv) {
        this.msgoithauNv = msgoithauNv;
    }


    private GoithauEntity goithau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSGOITHAU", referencedColumnName = "MSGOITHAU")
    public GoithauEntity getGoithau() {
        return goithau;
    }

    public void setGoithau(GoithauEntity goithau) {
        this.goithau = goithau;
    }


    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    private BigInteger ischutri;

    @javax.persistence.Column(name = "ISCHUTRI")
    @Basic
    public BigInteger getIschutri() {
        return ischutri;
    }

    public void setIschutri(BigInteger ischutri) {
        this.ischutri = ischutri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoithauNhanvienEntity that = (GoithauNhanvienEntity) o;

        if (msgoithauNv != that.msgoithauNv) return false;
        if (ischutri != null ? !ischutri.equals(that.ischutri) : that.ischutri != null) return false;

        return true;
    }
}
