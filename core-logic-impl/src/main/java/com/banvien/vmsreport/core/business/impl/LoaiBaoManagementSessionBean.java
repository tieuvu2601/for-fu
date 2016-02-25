package com.banvien.vmsreport.core.business.impl;

import com.banvien.vmsreport.common.dto.LoaibaoDTO;
import com.banvien.vmsreport.common.utils.DozerSingletonMapper;
import com.banvien.vmsreport.core.business.LoaiBaoManagementLocalBean;
import com.banvien.vmsreport.core.data.entity.DmLoaibaoEntity;
import com.banvien.vmsreport.core.data.session.LoaiBaoLocalBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/11/15
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "LoaiBaoManagementSessionEJB")
public class LoaiBaoManagementSessionBean implements LoaiBaoManagementLocalBean{

    @EJB
    private LoaiBaoLocalBean loaiBaoService;

    @Override
    public List<LoaibaoDTO> findAll() {
        List<DmLoaibaoEntity> entities = this.loaiBaoService.findAll();
        List<LoaibaoDTO> res = new ArrayList<>();
        for(DmLoaibaoEntity entity : entities){
            res.add(DozerSingletonMapper.getInstance().map(entity, LoaibaoDTO.class));
        }
        return res;
    }
}
