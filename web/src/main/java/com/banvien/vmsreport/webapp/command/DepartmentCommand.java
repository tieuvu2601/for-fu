package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.DepartmentDTO;
import com.banvien.vmsreport.common.dto.UserDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 8/21/15
 * Time: 8:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentCommand extends AbstractCommand<DepartmentDTO> {
    public DepartmentCommand() {
        this.pojo = new DepartmentDTO();
    }
}
