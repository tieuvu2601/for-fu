package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.HosolutruuDTO;
import com.banvien.vmsreport.common.dto.LanhdaoDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.BidLuuTruManagementLocalBean;
import com.banvien.vmsreport.core.business.LanhdaoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmLanhdaoEntity;
import com.banvien.vmsreport.core.data.entity.GoithauEntity;
import com.banvien.vmsreport.core.data.entity.HosoluutruEntity;
import com.banvien.vmsreport.core.data.entity.UserEntity;
import com.banvien.vmsreport.core.data.session.BidLocalBean;
import com.banvien.vmsreport.core.data.session.HosoluutruLocalBean;
import com.banvien.vmsreport.core.data.session.LanhdaoLocalBean;
import com.banvien.vmsreport.core.data.session.UserLocalBean;
import org.apache.commons.lang.StringUtils;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "BidLuuTruManagementSessionEJB")
public class BidLuuTruManagementSessionBean implements BidLuuTruManagementLocalBean {
    @EJB
    private HosoluutruLocalBean bidLuuTruService;
    @EJB
    private BidLocalBean bidService;
    @EJB
    private UserLocalBean userService;

    @Override
    public void updateHoSoLuuTru(Map<Long, HosolutruuDTO> mapBidSaves, Long userId) throws ObjectNotFoundException, DuplicateKeyException {
        UserEntity user = this.userService.findById(userId);
        if(mapBidSaves.size() < 1) return;
        for(Long key : mapBidSaves.keySet()){
            GoithauEntity bidEntity = this.bidService.findById(key);
            HosolutruuDTO hosolutruuDTO = mapBidSaves.get(key);
            if(hosolutruuDTO.getSoke() != null && hosolutruuDTO.getSoke().compareTo( BigDecimal.ZERO) > 0
                    && hosolutruuDTO.getSotu() != null && hosolutruuDTO.getSotu().compareTo( BigDecimal.ZERO) > 0 ){
                if(hosolutruuDTO.getMsluutru() != null && hosolutruuDTO.getMsluutru() > 0){
                    HosoluutruEntity entity = this.bidLuuTruService.findById(hosolutruuDTO.getMsluutru());
                    entity.setGoithau(bidEntity);
                    entity.setSotu(hosolutruuDTO.getSotu());
                    entity.setSoke(hosolutruuDTO.getSoke());
                    entity.setGhichu(hosolutruuDTO.getGhichu());

                    entity.setEditer(user.getDisplayName());
                    entity.setEdittime(new Timestamp(System.currentTimeMillis()));
                    this.bidLuuTruService.update(entity);
                }else{
                    HosoluutruEntity entity = new HosoluutruEntity();

                    entity.setGoithau(bidEntity);
                    entity.setSotu(hosolutruuDTO.getSotu());
                    entity.setSoke(hosolutruuDTO.getSoke());
                    entity.setGhichu(hosolutruuDTO.getGhichu());

                    entity.setCreatetime(new Timestamp(System.currentTimeMillis()));
                    entity.setCreater(user.getDisplayName());
                    this.bidLuuTruService.save(entity);
                }
            }
        }
    }
}
