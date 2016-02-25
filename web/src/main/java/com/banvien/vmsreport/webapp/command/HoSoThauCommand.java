package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.HoSoThauDTO;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 12/18/15
 * Time: 8:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class HoSoThauCommand extends AbstractCommand<HoSoThauDTO>{
    public HoSoThauCommand(){
        this.pojo = new HoSoThauDTO();
    }
}
