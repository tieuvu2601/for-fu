package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.QuyMoDTO;
import com.banvien.vmsreport.core.business.QuyMoManagementLocalBean;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.QuyMoCommand;
import com.banvien.vmsreport.webapp.validator.HinhThucValidator;
import com.banvien.vmsreport.webapp.validator.QuyMoValidator;
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

@Controller
public class QuyMoController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private QuyMoManagementLocalBean quyMoManagementLocalBean;

    @Autowired
    private QuyMoValidator quyMoValidator;

    @RequestMapping(value={"/admin/quymo/list.html", "/normal/quymo/list.html"})
    public ModelAndView list(@ModelAttribute(value = Constants.FORM_MODEL_KEY)QuyMoCommand bean, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/quymo/list");
        String crudaction = bean.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)){
            try{
                this.quyMoManagementLocalBean.deleteItems(bean.getCheckList());
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

    @RequestMapping(value={"/admin/quymo/edit.html", "/admin/quymo/add.html",
            "/normal/quymo/edit.html", "/normal/quymo/add.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)QuyMoCommand command,
                             BindingResult bindingResult,HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/quymo/edit");
        String crudaction = command.getCrudaction();
        QuyMoDTO pojo =  command.getPojo();

        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
            try {
                quyMoValidator.validate(command,bindingResult);
                if(!bindingResult.hasErrors()) {
                    if(pojo.getMsquimo() != null && pojo.getMsquimo() > 0) {
                        pojo = this.quyMoManagementLocalBean.updateItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                    } else {
                        pojo = this.quyMoManagementLocalBean.addItem(command.getPojo());
                        mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    command.setPojo(pojo);
                    mav.addObject("alertType", "success");
                }
            }catch (Exception e){

            }

        }

        if(pojo.getMsquimo() != null && pojo.getMsquimo() > 0){
            try {
                QuyMoDTO dbItem = this.quyMoManagementLocalBean.findById(pojo.getMsquimo());
                command.setPojo(dbItem);
            } catch (Exception e){
                logger.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
                mav.addObject(Constants.ALERT_TYPE, "error");
            }
        }
        return mav;
    }


    private void executeSearch(QuyMoCommand bean, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, bean);
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(bean.getPojo().getTenquimo())) {
            properties.put("tenquimo", bean.getPojo().getTenquimo());
        }
        Object[] results = this.quyMoManagementLocalBean.search(properties , bean.getSortExpression() , bean.getSortDirection() , bean.getFirstItem() , bean.getMaxPageItems());
        bean.setListResult((List<QuyMoDTO>)results[1]);
        bean.setTotalItems(Integer.valueOf(results[0].toString()));
    }
}