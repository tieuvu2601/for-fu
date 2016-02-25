package com.banvien.vmsreport.core.business;

import com.banvien.vmsreport.common.dto.KinhphiDTO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/16/15
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface KinhPhiManagementLocalBean {
    List<KinhphiDTO> findByGoiThau(Long msgoithau);
}
