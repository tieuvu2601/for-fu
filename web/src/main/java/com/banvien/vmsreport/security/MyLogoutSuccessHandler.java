/**
 * 
 */
package com.banvien.vmsreport.security;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.util.RequestUtil;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nguyen Hai Vien
 *
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    private transient final Logger logger = Logger.getLogger(getClass());
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private String logoutSuccessUrl = "/login.html?action=logout";

	/**
	 * @param logoutSuccessUrl the logoutSuccessUrl to set
	 */
	public void setLogoutSuccessUrl(String logoutSuccessUrl) {
		this.logoutSuccessUrl = logoutSuccessUrl;
	}
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
        String myLocalLogoutSuccessUrl = this.logoutSuccessUrl;


		Cookie terminate = new Cookie(Constants.REPORT_REMEMBER_ME_COOKIE_KEY, null);
		String contextPath = request.getContextPath();
		terminate.setPath(contextPath != null && contextPath.length() > 0 ? contextPath : "/");
		terminate.setMaxAge(0);
		response.addCookie(terminate);
		/**
		 * Delete user's cookies for content security 
		 */
		RequestUtil.deleteCookie(response, new Cookie(Constants.LOGIN_USER_ID_COOKIE, null), "/");
		RequestUtil.deleteCookie(response, new Cookie(Constants.LOGIN_CHECKSUM, null), "/");
		/**
		 * Invalidate session
		 */
		if (request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}
        SecurityContextHolder.clearContext();
        request.getSession(true); //Create new session
		redirectStrategy.sendRedirect(request, response, myLocalLogoutSuccessUrl);
	}

}
