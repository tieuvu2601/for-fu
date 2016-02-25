package com.banvien.vmsreport.security;

import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRememberMeServices extends TokenBasedRememberMeServices {

    @Override
    protected void setCookie(String[] tokens,
                         int maxAge,
                         HttpServletRequest request,
                         HttpServletResponse response) {

        super.setCookie(tokens, maxAge, request, response);
    }

}
