package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.security.DesEncrypterUtils;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.BeanUtils;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.DepartmentCommand;
import com.banvien.vmsreport.webapp.validator.DepartmentValidator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ejb.DuplicateKeyException;
import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/18/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DepartmentController extends ApplicationObjectSupport{
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private DepartmentManagementLocalBean departmentService;
    @Autowired
    private DepartmentValidator departmentValidator;

    @RequestMapping(value={"/admin/department/edit.html", "/admin/department/add.html",
                            "/normal/department/add.html", "/normal/department/edit.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)DepartmentCommand command,
                             BindingResult bindingResult,
                             HttpServletRequest request,
                             RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView("/admin/department/edit");
        String crudaction = command.getCrudaction();
        DepartmentDTO pojo = command.getPojo();
        try{
            if (StringUtils.isNotBlank(crudaction) && Constants.INSERT_OR_UPDATE.equals(crudaction)){
                departmentValidator.validate(command, bindingResult);
                if(!bindingResult.hasErrors()) {
                    if(pojo.getDepartmentId() != null && pojo.getDepartmentId().compareTo(0L) > 0){
                        pojo = this.departmentService.updateItem (command.getPojo());
                        redirectAttributes.addFlashAttribute("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                    } else {
                        pojo = this.departmentService.addItem(command.getPojo());
                        redirectAttributes.addFlashAttribute("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                    if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                        return new ModelAndView("redirect:/admin/department/list.html");
                    }else{
                        return new ModelAndView("redirect:/normal/department/list.html");
                    }
                }
            }
            if(!bindingResult.hasErrors() && command.getPojo().getDepartmentId() != null && command.getPojo().getDepartmentId() != null){
                DepartmentDTO dbItem = this.departmentService.findId(command.getPojo().getDepartmentId());
                command.setPojo(dbItem);
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
            mav.addObject(Constants.ALERT_TYPE, "error");
        }
        return mav;
    }

    @RequestMapping(value={"/admin/department/list.html", "/normal/department/list.html"})
    public ModelAndView portalAdminView(@ModelAttribute(Constants.FORM_MODEL_KEY)DepartmentCommand command,
                                        HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView("/admin/department/list");
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)) {
            Integer totalDeleted = 0;
            try {
                totalDeleted = departmentService.deleteItems(command.getCheckList());
                redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.delete.successful", new Object[]{totalDeleted}));
                redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                    return new ModelAndView("redirect:/admin/department/list.html");
                }else{
                    return new ModelAndView("redirect:/normal/department/list.html");
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("general.exception.msg"));
                mav.addObject(Constants.ALERT_TYPE, "danger");
            }
        }
        executeSearch(command, request);
        mav.addObject("page", command.getPage() - 1);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    private void executeSearch(DepartmentCommand command, HttpServletRequest request){
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);

        Object[] results = this.departmentService.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<DepartmentDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(DepartmentCommand command){
        Map<String, Object> properties = new HashMap<String, Object>();

        if (StringUtils.isNotBlank(command.getPojo().getCode())) {
            properties.put("code", command.getPojo().getCode());
        }
        if (StringUtils.isNotBlank(command.getPojo().getName())) {
            properties.put("name", command.getPojo().getName());
        }
        return properties;
    }
}
