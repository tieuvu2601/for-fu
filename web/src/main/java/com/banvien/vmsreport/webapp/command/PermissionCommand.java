package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.PermissionDTO;

/**
 * Created with IntelliJ IDEA.
 * User: KhanhTran
 * Date: 8/18/15
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermissionCommand extends AbstractCommand<PermissionDTO> {
    public PermissionCommand() {
        this.pojo = new PermissionDTO();
    }
}
