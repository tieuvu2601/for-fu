package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.GoithaunhathauDTO;
import com.banvien.vmsreport.common.dto.HoSoThauDTO;
import com.banvien.vmsreport.common.dto.NoiDungHoSoDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.HoSoThauManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmNoidunghosoEntity;
import com.banvien.vmsreport.core.data.entity.GoithauNhathauEntity;
import com.banvien.vmsreport.core.data.entity.HosothauEntity;
import com.banvien.vmsreport.core.data.session.GoithauNhathauLocalBean;
import com.banvien.vmsreport.core.data.session.HoSoThauLocalBean;
import com.banvien.vmsreport.core.data.session.NoiDungHoSoLocalBean;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/17/15
 * Time: 9:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "HoSoThauManagementSessionEJB")
public class HoSoThauManagementSessionBean implements HoSoThauManagementLocalBean {
    @EJB
    private HoSoThauLocalBean hoSoThauService;
    @EJB
    private GoithauNhathauLocalBean goithauNhathauService;
    @EJB
    private NoiDungHoSoLocalBean noiDungHoSoService;

    @Override
    public List<HoSoThauDTO> findByGoiThau(Long msgoithau) {
        List<HosothauEntity> listEntities = this.hoSoThauService.findByGoiThau(msgoithau);
        List<HoSoThauDTO> res = new ArrayList<>();
        for(HosothauEntity entity : listEntities){
            res.add(DozerSingletonMapper.getInstance().map(entity, HoSoThauDTO.class));
        }
        return res;
    }

    @Override
    public void autoCreateHSNT(Long msgoithau) throws DuplicateKeyException {
        List<GoithauNhathauEntity> listGT_NT = this.goithauNhathauService.findByGoiThau(msgoithau);
        List<HosothauEntity> listHST = this.hoSoThauService.findByGoiThau(msgoithau);
        List<Long> listNTHasHST = new ArrayList<>();
        for(HosothauEntity hst : listHST){
            listNTHasHST.add(hst.getGoithau_nhathau().getMsgoithauNt());
        }

        for(GoithauNhathauEntity gt_nt : listGT_NT ){
            if(!listNTHasHST.contains(gt_nt.getMsgoithauNt())){
                createDefaultHST(gt_nt);
            }
        }
    }

    @Override
    public HoSoThauDTO findByGoiThauNhaThau(Long gt_nt) throws ObjectNotFoundException {
        return DozerSingletonMapper.getInstance().map(this.hoSoThauService.findByGoiThauNhaThau(gt_nt), HoSoThauDTO.class);
    }

    @Override
    public HoSoThauDTO insert(HoSoThauDTO pojo) throws ObjectNotFoundException, DuplicateKeyException {
        HosothauEntity hosothau = new HosothauEntity();
        hosothau.setGoithau_nhathau(this.goithauNhathauService.findById(pojo.getGoithau_nhathau().getMsgoithauNt()));
        hosothau.setNoiDungHoSo(this.noiDungHoSoService.save(DozerSingletonMapper.getInstance().map(pojo.getNoiDungHoSo(), DmNoidunghosoEntity.class)));
        hosothau = this.hoSoThauService.save(hosothau);
        return DozerSingletonMapper.getInstance().map(hosothau, HoSoThauDTO.class);
    }

    @Override
    public HoSoThauDTO update(HoSoThauDTO pojo) throws DuplicateKeyException {
        DmNoidunghosoEntity noidunghosoEntity = DozerSingletonMapper.getInstance().map(pojo.getNoiDungHoSo(), DmNoidunghosoEntity.class);
        pojo.setNoiDungHoSo(DozerSingletonMapper.getInstance().map(this.noiDungHoSoService.update(noidunghosoEntity), NoiDungHoSoDTO.class));
        return pojo;
    }

    private void createDefaultHST(GoithauNhathauEntity gt_nt) throws DuplicateKeyException {
        HosothauEntity hosothauEntity = new HosothauEntity();
        hosothauEntity.setGoithau_nhathau(gt_nt);
        hosothauEntity.setNoiDungHoSo(new DmNoidunghosoEntity());
        this.hoSoThauService.save(hosothauEntity);
    }
}
