package com.banvien.vmsreport.webapp.command;

import com.banvien.vmsreport.common.dto.CanCuDTO;

/**
 * Created with IntelliJ IDEA.
 * User: HauKute
 * Date: 2/22/16
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CanCuCommand extends AbstractCommand<CanCuDTO> {
    public CanCuCommand(){
        this.pojo = new CanCuDTO();
    }
}
