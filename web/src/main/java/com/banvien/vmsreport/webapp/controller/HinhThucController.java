package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.HinhThucCommand;
import com.banvien.vmsreport.webapp.validator.HinhThucValidator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Huy
 * Date: 8/20/15
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HinhThucController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private HinhthucManagementLocalBean hinhThucManagementLocalBean;

    @Autowired
    private HinhThucValidator hinhThucValidator;


    @RequestMapping(value={"/admin/hinhthuc/list.html", "/normal/hinhthuc/list.html"})
    public ModelAndView list(@ModelAttribute(value = Constants.FORM_MODEL_KEY)HinhThucCommand bean, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/hinhthuc/list");
        String crudaction = bean.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)){
            try{
                this.hinhThucManagementLocalBean.deleteItems(bean.getCheckList());
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.delete.successful"));
                mav.addObject("alertType", "success");
            }catch (Exception e){
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.delete.unsuccessful"));
                mav.addObject("alertType", "error");
            }
        }
        executeSearch(bean,request);
        mav.addObject(Constants.LIST_MODEL_KEY, bean) ;
        return mav;
    }

    @RequestMapping(value={"/admin/hinhthuc/edit.html", "/admin/hinhthuc/add.html",
            "/normal/hinhthuc/edit.html", "/normal/hinhthuc/add.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)HinhThucCommand command,
                             BindingResult bindingResult,HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/hinhthuc/edit");
        String crudaction = command.getCrudaction();
        HinhthucgtDTO pojo =  command.getPojo();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
            try {
                hinhThucValidator.validate(command,bindingResult);
                if(!bindingResult.hasErrors()) {
                    if(pojo.getMshinhthuc() != null && pojo.getMshinhthuc() > 0) {
                        pojo = this.hinhThucManagementLocalBean.updateItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                    } else {
                        pojo = this.hinhThucManagementLocalBean.addItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    command.setPojo(pojo);
                    mav.addObject("alertType", "success");
                }
            }catch (Exception e){  }
        }

        if(pojo.getMshinhthuc() != null && pojo.getMshinhthuc() > 0){
            try {
                HinhthucgtDTO dbItem = this.hinhThucManagementLocalBean.findById(pojo.getMshinhthuc());
                command.setPojo(dbItem);
            } catch (Exception e){
                logger.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
                mav.addObject(Constants.ALERT_TYPE, "error");
            }
        }
        return mav;
    }


    private void executeSearch(HinhThucCommand bean, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, bean);
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(bean.getPojo().getMahinhthuc())) {
            properties.put("code", bean.getPojo().getMahinhthuc());
        }
        if (StringUtils.isNotBlank(bean.getPojo().getTenhinhthuc())) {
            properties.put("name", bean.getPojo().getTenhinhthuc());
        }
        Object[] results = this.hinhThucManagementLocalBean.search(properties , bean.getSortExpression() , bean.getSortDirection() , bean.getFirstItem() , bean.getMaxPageItems());
        bean.setListResult((List<HinhthucgtDTO>)results[1]);
        bean.setTotalItems(Integer.valueOf(results[0].toString()));
    }
}