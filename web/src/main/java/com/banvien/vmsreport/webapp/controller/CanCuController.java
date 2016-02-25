package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.CanCuDTO;
import com.banvien.vmsreport.core.business.CanCuManagementLocalBean;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.CanCuCommand;
import com.banvien.vmsreport.webapp.validator.CanCuValidator;
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
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CanCuController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(getClass());
    @Autowired
    private CanCuManagementLocalBean canCuManagementLocalBean;

    @Autowired
    private CanCuValidator canCuValidator;

    @RequestMapping(value={"/admin/cancu/list.html", "/normal/cancu/list.html"})
    public ModelAndView list(@ModelAttribute(value = Constants.FORM_MODEL_KEY)CanCuCommand bean, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/cancu/list");
        String crudaction = bean.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)){
            try{
                this.canCuManagementLocalBean.deleteItems(bean.getCheckList());
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

    @RequestMapping(value={"/admin/cancu/edit.html", "/admin/cancu/add.html",
            "/normal/cancu/edit.html", "/normal/cancu/add.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)CanCuCommand command,
                             BindingResult bindingResult,HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/cancu/edit");
        String crudaction = command.getCrudaction();
        CanCuDTO pojo =  command.getPojo();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
            try {
                canCuValidator.validate(command,bindingResult);
                if(!bindingResult.hasErrors()) {
                    if(pojo.getCanCuId() != null && pojo.getCanCuId() > 0) {
                        pojo = this.canCuManagementLocalBean.updateItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                    } else {
                        pojo = this.canCuManagementLocalBean.addItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    command.setPojo(pojo);
                    mav.addObject("alertType", "success");
                }
            }catch (Exception e){

            }

        }

        if(pojo.getCanCuId() != null && pojo.getCanCuId() > 0){
            try {
                CanCuDTO dbItem = this.canCuManagementLocalBean.findById(pojo.getCanCuId());
                command.setPojo(dbItem);
            } catch (Exception e){
                logger.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
                mav.addObject(Constants.ALERT_TYPE, "error");
            }
        }
        return mav;
    }


    private void executeSearch(CanCuCommand bean, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, bean);
        Map<String, Object> properties = new HashMap<String, Object>();

        Object[] results = this.canCuManagementLocalBean.search(properties , bean.getSortExpression() , bean.getSortDirection() , bean.getFirstItem() , bean.getMaxPageItems());
        bean.setListResult((List<CanCuDTO>)results[1]);
        bean.setTotalItems(Integer.valueOf(results[0].toString()));
    }
}
