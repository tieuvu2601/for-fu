package com.banvien.vmsreport.webapp.controller;

import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.exception.DuplicateKeyException;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.UserGroupCommand;
import com.banvien.vmsreport.webapp.command.UserGroupRoleACLCommand;
import com.banvien.vmsreport.webapp.validator.UserGroupValidator;
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
import javax.ejb.RemoveException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
public class UserGroupController extends ApplicationObjectSupport {
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private UserGroupManagementLocalBean userGroupService;

    @Autowired
    private PermissionManagementLocalBean permissionService;

    @Autowired
    private UserGroupACLManagementLocalBean userGroupACLService;

    @Autowired
    private UserGroupRoleACLManagementLocalBean  userGroupRoleACLService;

    @Autowired
    private UserGroupValidator userGroupValidator;

    @Autowired
    private RoleManagementLocalBean roleService;

    @RequestMapping(value={"/admin/usergroup/list.html", "/normal/usergroup/list.html"})
    public ModelAndView list(@ModelAttribute(value = Constants.FORM_MODEL_KEY)UserGroupCommand bean, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/admin/usergroup/list");
        executeSearch(bean,request);
        mav.addObject(Constants.LIST_MODEL_KEY, bean) ;
        return mav;
    }

    @RequestMapping(value={"/admin/usergroup/edit.html", "/admin/usergroup/add.html",
            "/normal/usergroup/edit.html", "/normal/usergroup/add.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)UserGroupCommand command,
                             BindingResult bindingResult,HttpServletRequest request, RedirectAttributes redirectAttributes) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/usergroup/edit");
        UserGroupDTO pojo =  command.getPojo();
        userGroupValidator.validate(command,bindingResult);
        if(StringUtils.isBlank(command.getWarningMsg()) && !bindingResult.hasErrors()){
            String crudaction = command.getCrudaction();
            try {
                if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
                    if(!bindingResult.hasErrors() && StringUtils.isBlank(command.getWarningMsg())) {
                        if(pojo.getUserGroupId() != null && pojo.getUserGroupId() > 0) {
                            this.userGroupService.updateItem(command.getPojo());
                            redirectAttributes.addFlashAttribute("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
                        } else {
                            this.userGroupService.addItem(command.getPojo());
                            redirectAttributes.addFlashAttribute("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                        }
                        redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                        if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                            return new ModelAndView("redirect:/admin/usergroup/list.html");
                        }else{
                            return new ModelAndView("redirect:/normal/usergroup/list.html");
                        }
                    }
                }else{
                    command.setPojo(this.userGroupService.findById(pojo.getUserGroupId()));
                }
            } catch (Exception e){
                logger.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
                mav.addObject(Constants.ALERT_TYPE, "error");
            }
        }else{
            if(StringUtils.isNotBlank(command.getWarningMsg())){
                redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "warning");
                redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, command.getWarningMsg());
                if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                    return new ModelAndView("redirect:/admin/usergroup/list.html");
                }else{
                    return new ModelAndView("redirect:/normal/usergroup/list.html");
                }
            }
        }
        return mav;
    }

    @RequestMapping(value = {"/admin/usergroup/role.html", "/normal/usergroup/role.html"})
    public ModelAndView listRole(@ModelAttribute(value = Constants.FORM_MODEL_KEY)UserGroupRoleACLCommand command,
                                 BindingResult bindingResult) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView();
        String crudaction = command.getCrudaction();
        UserGroupRoleACLDTO pojo = command.getPojo();
        if(pojo.getUserGroup().getUserGroupId() != null && pojo.getUserGroup().getUserGroupId() > 0){
            UserGroupDTO dto = this.userGroupService.findById(pojo.getUserGroup().getUserGroupId());
            if(dto.getCode().equals(Constants.ADMIN_ROLE)){
                 mav = new ModelAndView("redirect:/admin/usergroup/list.html");
                return mav;
            }
            else {
                mav = new ModelAndView("/admin/usergroup/roles");
                if(StringUtils.isNotBlank(crudaction)){
                    try{
                        if(crudaction.equals("update")){
                            if(command.getRoleFilterType().equals(Constants.IS_MANAGING)){
                                if(command.getRoleIds() != null && command.getRoleIds().length > 0){
                                    userGroupRoleACLService.updateRole(pojo.getUserGroup().getUserGroupId(), command.getUserGroupRoleACLIds());
                                }else{
                                    userGroupRoleACLService.deleteAllByUserGroup(pojo.getUserGroup().getUserGroupId());
                                }
                            }else{
                                if(command.getRoleIds() != null && command.getRoleIds().length > 0){
                                    userGroupRoleACLService.insert(pojo.getUserGroup().getUserGroupId(), command.getRoleIds());
                                }
                                command.setRoleFilterType(Constants.IS_MANAGING);
                            }
                            mav.addObject(Constants.ALERT_TYPE, "success");
                            mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, getMessageSourceAccessor().getMessage("database.update.successful"));
                        }
                    }catch (Exception e){
                        log.error(e.getMessage(), e);
                        mav.addObject(Constants.ALERT_TYPE, "danger");
                        mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, getMessageSourceAccessor().getMessage("database.exception"));
                    }
                }
                referenceData(command, mav);
            }
        }
        return mav;
    }

    private void referenceData(UserGroupRoleACLCommand command, ModelAndView mav) throws ObjectNotFoundException {
        String crudaction = command.getCrudaction();
        Long userGroupId = command.getPojo().getUserGroup().getUserGroupId();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals("search-role")){
            List<RoleDTO> listRoles = this.roleService.findRolesNotInUserGroups(userGroupId, command.getRoleFilterCode(), command.getRoleFilterName());
            mav.addObject("roleNotInUserGroup", listRoles);
        }else {
            List<RoleDTO> roles = this.roleService.findRolesInUserGroups(userGroupId, command.getRoleFilterCode(), command.getRoleFilterName());
            mav.addObject("roleInUserGroup", roles);
        }
        UserGroupDTO userGroupDTO = this.userGroupService.findById(userGroupId);
        mav.addObject("userGroupInfo", userGroupDTO);
    }


    @RequestMapping(value={"/admin/usergroup/permission.html"})
    public ModelAndView listpermission(@ModelAttribute(value=Constants.FORM_MODEL_KEY)UserGroupCommand usergroupCommand,BindingResult bindingResult ,HttpServletRequest request) throws DuplicateKeyException, RemoveException, ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/flatformadmin/usergroup/listpermission");
        UserGroupDTO pojo = usergroupCommand.getPojo();
        String crudaction = usergroupCommand.getCrudaction();
        try {
            Object[] results = this.permissionService.searchByProperties(new HashMap<String, Object>(),null,null,0,0);
            mav.addObject("permissions", (List<PermissionDTO>)results[1]);
            mav.addObject("totalItem", Integer.valueOf(results[0].toString()));

            if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)){
                if(usergroupCommand.getCheckList() != null){
                    try{
                    userGroupACLService.updatePermission(pojo.getUserGroupId(), usergroupCommand.getCheckList());
                    mav.addObject(Constants.ALERT_TYPE, "success");
                    mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, getMessageSourceAccessor().getMessage("database.update.successful"));
                    }catch (Exception e){
                       log.error(e.getMessage());
                       mav.addObject(Constants.ALERT_TYPE, "error");
                    }
                }
            }
            if(!bindingResult.hasErrors()&& pojo.getUserGroupId() != null && pojo.getUserGroupId() > 0) {

                List<UserGroupACLDTO> userGroupACLs = this.userGroupService.searchByUserGroupId(pojo.getUserGroupId());
                List<Long> listPermission = new ArrayList<>();
                for (UserGroupACLDTO userGroupACLDTO : userGroupACLs){
                    if (userGroupACLDTO.getPermission() != null && userGroupACLDTO.getPermission().getPermissionId() != null){
                        listPermission.add(userGroupACLDTO.getPermission().getPermissionId());
                    }
                }
                mav.addObject("userGroupACLs",listPermission);
        }
        }catch (Exception e) {
            logger.error(e.getMessage());
        }
        mav.addObject(Constants.FORM_MODEL_KEY, usergroupCommand);
        return  mav;
    }

    private void executeSearch(UserGroupCommand bean, HttpServletRequest request) {
        RequestUtil.initSearchBean(request, bean);
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(bean.getPojo().getCode())) {
            properties.put("code", bean.getPojo().getCode());
        }
        if (StringUtils.isNotBlank(bean.getPojo().getName())) {
            properties.put("name", bean.getPojo().getName());
        }
        Object[] results = this.userGroupService.search(properties , bean.getSortExpression() , bean.getSortDirection() , bean.getFirstItem() , bean.getMaxPageItems());
        bean.setListResult((List<UserGroupDTO>)results[1]);
        bean.setTotalItems(Integer.valueOf(results[0].toString()));
    }
}