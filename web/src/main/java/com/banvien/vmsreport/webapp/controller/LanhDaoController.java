package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.LanhdaoDTO;
import com.banvien.vmsreport.core.business.LanhdaoManagementLocalBean;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.LanhDaoCommand;
import com.banvien.vmsreport.webapp.validator.LanhDaoValidator;
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
 * User: HauKute
 * Date: 2/22/16
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LanhDaoController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(getClass());
    @Autowired
    private LanhdaoManagementLocalBean lanhdaoManagementLocalBean;

    @Autowired
    private LanhDaoValidator lanhDaoValidator;

    @RequestMapping(value={"/admin/lanhdao/list.html", "/normal/lanhdao/list.html"})
    public ModelAndView list(@ModelAttribute(value = Constants.FORM_MODEL_KEY)LanhDaoCommand bean, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/lanhdao/list");
        String crudaction = bean.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)){
            try{
                this.lanhdaoManagementLocalBean.deleteItems(bean.getCheckList());
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

    @RequestMapping(value={"/admin/lanhdao/edit.html", "/admin/lanhdao/add.html",
            "/normal/lanhdao/edit.html", "/normal/lanhdao/add.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)LanhDaoCommand command,
                             BindingResult bindingResult,HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/lanhdao/edit");
        String crudaction = command.getCrudaction();
        LanhdaoDTO pojo =  command.getPojo();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
            try {
                lanhDaoValidator.validate(command,bindingResult);
                if(!bindingResult.hasErrors()) {
                    if(pojo.getMslanhdao() != null && pojo.getMslanhdao() > 0) {
                        pojo = this.lanhdaoManagementLocalBean.updateItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                    } else {
                        pojo = this.lanhdaoManagementLocalBean.addItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    command.setPojo(pojo);
                    mav.addObject("alertType", "success");
                }
            }catch (Exception e){

            }

        }

        if(pojo.getMslanhdao() != null && pojo.getMslanhdao() > 0){
            try {
                LanhdaoDTO dbItem = this.lanhdaoManagementLocalBean.findById(pojo.getMslanhdao());
                command.setPojo(dbItem);
            } catch (Exception e){
                logger.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
                mav.addObject(Constants.ALERT_TYPE, "error");
            }
        }
        return mav;
    }


    private void executeSearch(LanhDaoCommand bean, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, bean);
        Map<String, Object> properties = new HashMap<String, Object>();

        Object[] results = this.lanhdaoManagementLocalBean.search(properties , bean.getSortExpression() , bean.getSortDirection() , bean.getFirstItem() , bean.getMaxPageItems());
        bean.setListResult((List<LanhdaoDTO>)results[1]);
        bean.setTotalItems(Integer.valueOf(results[0].toString()));
    }
}
