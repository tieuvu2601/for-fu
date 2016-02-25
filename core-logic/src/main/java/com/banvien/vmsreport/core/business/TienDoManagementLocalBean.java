package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.data.entity.TiendoEntity;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Local;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import java.text.ParseException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/9/15
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface TienDoManagementLocalBean {
    public TienDoDTO updateItem(TienDoDTO dto, Long userId, List<KinhphiDTO> list_kp, List<DangBaoDTO> list_ndb) throws ObjectNotFoundException, DuplicateKeyException, RemoveException;
    public TienDoDTO addItem(TienDoDTO dto, Long userId, List<KinhphiDTO> list_kp, List<DangBaoDTO> list_ndb) throws ObjectNotFoundException, DuplicateKeyException, RemoveException;
    public TienDoDTO findByGoiThauId(Long goiThauId);

    public TinhtrangDTO getTinhTrangFromTienDoAndGoiThau(TienDoDTO tienDo, BidDTO goiThau) throws ObjectNotFoundException;

    public void updateTinhTrangForAllGoiThau() throws ObjectNotFoundException, DuplicateKeyException;

    public void updateTinhTrangForGoiThauDangMoiThau();

    public void autoSendMessageForRelativeUser();

    TienDoDTO findByMaGoiThau(String maGoiThau) throws ObjectNotFoundException;
}
