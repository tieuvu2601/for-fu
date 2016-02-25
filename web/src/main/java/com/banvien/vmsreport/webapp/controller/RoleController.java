package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.PermissionDTO;
import com.banvien.vmsreport.common.dto.RoleDTO;
import com.banvien.vmsreport.core.business.PermissionGroupManagenmentLocalBean;
import com.banvien.vmsreport.core.business.PermissionManagementLocalBean;
import com.banvien.vmsreport.core.business.RoleACLManagementLocalBean;
import com.banvien.vmsreport.core.business.RoleManagementLocalBean;
import com.banvien.vmsreport.editor.CustomDateEditor;
import com.banvien.vmsreport.editor.PojoEditor;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.RoleCommand;
import com.banvien.vmsreport.webapp.validator.RoleValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.ejb.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vovanphuc0810
 * Date: 8/18/15
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class RoleController extends ApplicationObjectSupport{
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private RoleManagementLocalBean roleService;

    @Autowired
    private RoleACLManagementLocalBean roleACLService;

    @Autowired
    private PermissionManagementLocalBean permissionService;

    @Autowired
    private  PermissionGroupManagenmentLocalBean permissionGroupService;

    @Autowired
    private RoleValidator roleValidator;

    @Autowired
    private MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor());
        binder.registerCustomEditor(RoleDTO.class, new PojoEditor(RoleDTO.class, "roleId", Long.class));
    }


    @RequestMapping(value={"/admin/role/list.html", "/normal/role/list.html"})
    public ModelAndView portalAdminView(@ModelAttribute(value = Constants.FORM_MODEL_KEY)RoleCommand command,
                                        HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/admin/role/list");
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)){
            try {
                roleService.deleteItem(command.getPojo().getRoleId());
                mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.delete.successful", new Object[]{}));
                mav.addObject(Constants.ALERT_TYPE, "success");
            }catch (Exception e) {
                log.error(e.getMessage(),e);
                mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.exception"));
                mav.addObject(Constants.ALERT_TYPE, "danger");
            }
        }
        executeSearch(command,request);
        mav.addObject("page", command.getPage() - 1);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    private void executeSearch(RoleCommand command, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getCode())) {
            properties.put("code", command.getPojo().getCode());
        }
        if (StringUtils.isNotBlank(command.getPojo().getName())) {
            properties.put("name", command.getPojo().getName());
        }
        Object[] results = this.roleService.search(properties , command.getSortExpression() , command.getSortDirection() , command.getFirstItem() , command.getMaxPageItems());
        command.setListResult((List<RoleDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    @RequestMapping(value={"/admin/role/edit.html", "/admin/role/add.html",
                            "/normal/role/edit.html", "/normal/role/add.html"})
    public ModelAndView portalAdminEdit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)RoleCommand command,
                                        HttpServletRequest request,
                                        RedirectAttributes redirectAttributes,
                                        BindingResult result) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/role/edit");
        String crudaction = command.getCrudaction();
        if (StringUtils.isNotBlank(crudaction)){
            if (crudaction.equals(Constants.INSERT_OR_UPDATE)){
                try{
                    roleValidator.validate(command, result);
                    if (!result.hasErrors()) {
                        if (command.getPojo().getRoleId() == null){
                            command.setPojo(roleService.addItem(command.getPojo()));
                            redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, messageSource.getMessage("role.manager.add.successfully", null, null));
                        } else {
                            command.setPojo(roleService.updateItem(command.getPojo()));
                            redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, messageSource.getMessage("role.manager.update.successfully", null, null));
                        }
                        redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");

                        if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                            return new ModelAndView("redirect:/admin/role/list.html");
                        }else{
                            return new ModelAndView("redirect:/normal/role/list.html");
                        }
                    }
                } catch (Exception e){
                    log.error(e.getMessage(), e);
                    mav.addObject(Constants.ALERT_TYPE, "danger");
                    mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.exception"));
                }
            }
        }
        if(command.getPojo().getRoleId() != null){
            RoleDTO dbItem = this.roleService.findById(command.getPojo().getRoleId());
            command.setPojo(dbItem);
        }
        mav.addObject(Constants.FORM_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value={"/admin/role/permission.html", "/normal/role/permission.html"})
    public ModelAndView listPermission(@ModelAttribute(Constants.FORM_MODEL_KEY)RoleCommand command) throws ObjectNotFoundException{
        ModelAndView mav = new ModelAndView("/admin/role/permission");
        String crudaction = command.getCrudaction();
        RoleDTO pojo = command.getPojo();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
            try{
                if(command.getRoleFilterType().equals(Constants.IS_MANAGING)){
                    if(command.getPermissionIds() != null && command.getPermissionIds().length > 0){
                        roleACLService.update(command.getPojo().getRoleId(), command.getPermissionIds());
                        mav.addObject(Constants.ALERT_TYPE, "success");
                        mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, getMessageSourceAccessor().getMessage("database.update.successful"));
                    }else{
                        roleACLService.deleteAllByRole(command.getPojo().getRoleId());
                    }
                }else{
                    roleACLService.insert(pojo.getRoleId(), command.getPermissionIds());
                    command.setRoleFilterType(Constants.IS_MANAGING);
                }
                mav.addObject(Constants.ALERT_TYPE, "success");
                mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.update.successful"));
            }catch (Exception e){
                log.error(e.getMessage(), e);
                mav.addObject(Constants.ALERT_TYPE, "danger");
                mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.exception"));
            }
        }
        referenceData(command, mav);
        return mav;
    }

    private void referenceData(RoleCommand command, ModelAndView mav) throws ObjectNotFoundException {
        RoleDTO dbItem = this.roleService.findById(command.getPojo().getRoleId());
        command.setPojo(dbItem);

        Long roleId = command.getPojo().getRoleId();
        Long permissionGroupId = command.getPermissionGroupId();
        Integer roleFilterType = command.getRoleFilterType();
        List<PermissionDTO> permissionDTOList = null;
        if(roleFilterType.equals(Constants.IS_MANAGING)){
            permissionDTOList = this.permissionService.findByRole(roleId, permissionGroupId);
        }else{
            permissionDTOList = this.permissionService.findNotInRole(roleId, permissionGroupId);
        }
        mav.addObject("permissionList", permissionDTOList);

        mav.addObject("permissionGroups", this.permissionGroupService.findAll());
    }
}
