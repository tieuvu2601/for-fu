package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.NhaThauDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 12/11/15
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class NhaThauCommand extends AbstractCommand<NhaThauDTO> {
    public NhaThauCommand(){
        this.pojo = new NhaThauDTO();
    }
}
