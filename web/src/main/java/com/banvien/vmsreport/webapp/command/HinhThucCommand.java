package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.HinhthucgtDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/20/15
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class HinhThucCommand extends AbstractCommand<HinhthucgtDTO> {
    public HinhThucCommand(){
        this.pojo = new HinhthucgtDTO();
    }
}
