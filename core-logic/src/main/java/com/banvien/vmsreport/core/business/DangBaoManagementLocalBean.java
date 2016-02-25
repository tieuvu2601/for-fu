package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.DangBaoDTO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface DangBaoManagementLocalBean {
    List<DangBaoDTO> findByGoiThau(Long msgoithau);
}
