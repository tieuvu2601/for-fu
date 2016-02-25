package com.banvien.vmsreport.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/17/15
 * Time: 8:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class HoSoThauDTO implements Serializable {

    private Long mshosothau;
    private GoithaunhathauDTO goithau_nhathau;
    private NoiDungHoSoDTO noiDungHoSo;
    private String ghichu;

    public HoSoThauDTO(){

    }

    public Long getMshosothau() {
        return mshosothau;
    }

    public void setMshosothau(Long mshosothau) {
        this.mshosothau = mshosothau;
    }

    public GoithaunhathauDTO getGoithau_nhathau() {
        return goithau_nhathau;
    }

    public void setGoithau_nhathau(GoithaunhathauDTO goithau_nhathau) {
        this.goithau_nhathau = goithau_nhathau;
    }

    public NoiDungHoSoDTO getNoiDungHoSo() {
        return noiDungHoSo;
    }

    public void setNoiDungHoSo(NoiDungHoSoDTO noiDungHoSo) {
        this.noiDungHoSo = noiDungHoSo;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
