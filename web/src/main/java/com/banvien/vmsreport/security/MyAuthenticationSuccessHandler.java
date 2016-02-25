/**
 * 
 */
package com.banvien.vmsreport.security;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.UserDTO;
import com.banvien.vmsreport.core.business.UserManagementLocalBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nguyen Hai Vien
 *
 */
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private transient final Logger log = Logger.getLogger(getClass());

    @Autowired
    private UserManagementLocalBean userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

        try{
            UserDTO account = userService.findAllAndFetchPermission(authentication.getName());
            if(account.getLDAP().equals(Constants.USER_LDAP)){
                userService.updatePasswordUserLDAP(authentication.getName(), authentication.getCredentials().toString());
            }
        }catch (Exception e){log.error(e.getMessage(), e);}

        if (isAlwaysUseDefaultTargetUrl() || StringUtils.hasText(request.getParameter(getTargetUrlParameter()))) {
        	clearAuthenticationAttributes(request);
            
            logger.debug("Redirecting to DefaultSavedRequest Url: " + getDefaultTargetUrl());
            getRedirectStrategy().sendRedirect(request, response, getDefaultTargetUrl());
            return;
        }
    }
}
