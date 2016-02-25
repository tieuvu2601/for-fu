/**
 * 
 */
package com.banvien.vmsreport.security;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.security.DesEncrypterUtils;
import com.banvien.vmsreport.core.business.UserACLManagementLocalBean;
import com.banvien.vmsreport.core.business.UserGroupManagementLocalBean;
import com.banvien.vmsreport.core.business.UserManagementLocalBean;
import com.banvien.vmsreport.core.business.UserRoleACLManagementLocalBean;
import com.banvien.vmsreport.security.util.MyUserDetail;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.WebCommonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ejb.ObjectNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyen Hai Vien
 *
 */
public class MyPasswordEncoder implements PasswordEncoder {
    private transient final Logger log = Logger.getLogger(getClass());

    private LdapUserLookup ldapUserLookup;
    private UserManagementLocalBean userService;

    public void setLdapUserLookup(LdapUserLookup ldapUserLookup) {
        this.ldapUserLookup = ldapUserLookup;
    }

    public void setUserService(UserManagementLocalBean userService) {
        this.userService = userService;
    }

    public String encodePassword(String password, Object salt)
			throws DataAccessException {
		return DesEncrypterUtils.getInstance().encrypt(password);
	}

	public boolean isPasswordValid(String encPass, String rawPass, Object salt)
			throws DataAccessException {
        boolean res = false;
        if(StringUtils.isNotEmpty(rawPass)) {
            String[] userPassArr = WebCommonUtil.splitUsernameAndPassword(encPass);
            String userName = userPassArr[0];
            String encryptPass = userPassArr[1];

            String encPass2 = DesEncrypterUtils.getInstance().encrypt(rawPass);
            res = encryptPass.equals(encPass2);

            if(!res){
                try{
                    res = ldapUserLookup.authenticate(userName, rawPass);
                    if(res){
                        userService.updatePasswordUserLDAP(userName, rawPass);
                    }
                }catch (Exception e){}
            }
        }
        return res;
    }

}
