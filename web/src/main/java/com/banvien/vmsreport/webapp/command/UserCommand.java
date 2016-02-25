package com.banvien.vmsreport.webapp.command;


import com.banvien.vmsreport.common.dto.UserDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 8/21/15
 * Time: 8:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }

    private String confirmPassword;

    private String newPassword;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
