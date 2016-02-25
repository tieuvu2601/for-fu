package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.LanhdaoDTO;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class LanhDaoCommand extends AbstractCommand<LanhdaoDTO> {
    public LanhDaoCommand(){
        this.pojo = new LanhdaoDTO();
    }
}
