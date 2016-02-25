package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.LoaibaoDTO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/11/15
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface LoaiBaoManagementLocalBean {
    public List<LoaibaoDTO> findAll();
}
