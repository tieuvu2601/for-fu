package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.UserGroupDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/20/15
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupCommand extends AbstractCommand<UserGroupDTO> {
    public UserGroupCommand(){
        this.pojo = new UserGroupDTO();
    }
}
