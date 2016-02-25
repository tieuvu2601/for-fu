package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.security.util.SecurityUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: viennh
 * Date: 8/7/15
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController extends ApplicationObjectSupport {
    @RequestMapping(value={"/", "/home.*", "/index.*"})
    public ModelAndView home(HttpServletRequest request) {
        String target = "/";
//        String prefix = "/";
//        if(request.isUserInRole(Constants.ADMIN_ROLE)){
//            target = "redirect:/admin/user/list.html";
//        }else{
//            target = "redirect:/dashboard.html";
//        }
        target = "redirect:/dashboard.html";
        return new ModelAndView(target);
    }

    @RequestMapping(value = {"/dashboard.html", "/welcome.html"})
    public ModelAndView dashboard(@RequestParam(value = "firstLogin", required = false)String firstLogin){
        if(StringUtils.isNotBlank(firstLogin)){
            ModelAndView mav = new ModelAndView("/user/dashboard");
            mav.addObject("firstLogin", true);
            return mav;
        }else{
            return new ModelAndView("/user/dashboard");
        }
    }
}
