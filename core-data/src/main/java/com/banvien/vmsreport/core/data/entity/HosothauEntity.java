package com.banvien.vmsreport.core.data.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: tantruong89
 * Date: 12/9/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "HOSOTHAU")
@Entity
public class HosothauEntity {
    private Long mshosothau;

    @javax.persistence.Column(name = "MSHOSOTHAU")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSOTHAU_SEQ")
    @SequenceGenerator(name="HOSOTHAU_SEQ", sequenceName="HOSOTHAU_SEQ", allocationSize=1)
    public Long getMshosothau() {
        return mshosothau;
    }

    public void setMshosothau(Long mshosothau) {
        this.mshosothau = mshosothau;
    }

    private GoithauNhathauEntity goithau_nhathau;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSGOITHAU_NT", referencedColumnName = "MSGOITHAU_NT")
    public GoithauNhathauEntity getGoithau_nhathau() {
        return goithau_nhathau;
    }

    public void setGoithau_nhathau(GoithauNhathauEntity goithau_nhathau) {
        this.goithau_nhathau = goithau_nhathau;
    }

    private DmNoidunghosoEntity noiDungHoSo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MSNOIDUNGHS", referencedColumnName = "MSNOIDUNGHS")
    public DmNoidunghosoEntity getNoiDungHoSo() {
        return noiDungHoSo;
    }

    public void setNoiDungHoSo(DmNoidunghosoEntity noiDungHoSo) {
        this.noiDungHoSo = noiDungHoSo;
    }

    private String ghichu;

    @javax.persistence.Column(name = "GHICHU")
    @Basic
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HosothauEntity that = (HosothauEntity) o;

        if (mshosothau != that.mshosothau) return false;
        if (ghichu != null ? !ghichu.equals(that.ghichu) : that.ghichu != null) return false;
        if (goithau_nhathau != null ? !goithau_nhathau.equals(that.goithau_nhathau) : that.goithau_nhathau != null) return false;
        if (noiDungHoSo != null ? !noiDungHoSo.equals(that.noiDungHoSo) : that.noiDungHoSo != null) return false;

        return true;
    }

}
