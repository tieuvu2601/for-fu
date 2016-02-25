package com.banvien.vmsreport.webapp.controller;

import com.banvien.jcr.api.IJcrContent;
import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.common.security.DesEncrypterUtils;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.editor.CustomDateEditorSQL;
import com.banvien.vmsreport.editor.FileItemMultipartFileEditor;
import com.banvien.vmsreport.editor.PojoEditor;
import com.banvien.vmsreport.security.util.SecurityUtils;
import com.banvien.vmsreport.util.BeanUtils;
import com.banvien.vmsreport.util.RequestUtil;
import com.banvien.vmsreport.webapp.command.UserACLCommand;
import com.banvien.vmsreport.webapp.command.UserCommand;
import com.banvien.vmsreport.webapp.validator.UserValidator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class UserController extends ApplicationObjectSupport{
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private UserManagementLocalBean userService;
    @Autowired
    private UserGroupManagementLocalBean userGroupService;
    @Autowired
    private UserACLManagementLocalBean userACLService;
    @Autowired
    private UserRoleACLManagementLocalBean userRoleACLService;
    @Autowired
    private RoleManagementLocalBean roleService;
    @Autowired
    private PermissionManagementLocalBean permissionService;
    @Autowired
    private DepartmentManagementLocalBean departmentService;
    @Autowired
    private IJcrContent jcrContent;
    @Autowired
    private UserValidator userValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditorSQL("dd-mm-yyyy"));
        binder.registerCustomEditor(UserDTO.class, new PojoEditor(UserDTO.class, "userId", Long.class));
        binder.registerCustomEditor(FileItem.class, new FileItemMultipartFileEditor());
    }

    @RequestMapping(value={"/admin/user/edit.html", "/admin/user/add.html",
                            "/normal/user/add.html", "/normal/user/edit.html"})
    public ModelAndView edit(@ModelAttribute(value = Constants.FORM_MODEL_KEY)UserCommand command,
                             BindingResult bindingResult,
                             HttpServletRequest request,
                             RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView("/admin/user/edit");
        String crudaction = command.getCrudaction();
        UserDTO pojo = command.getPojo();
        if(!SecurityUtils.getAuthorities().contains("ADMIN") && !SecurityUtils.getAuthorities().contains("TP") ){
            return mav;
        }
        try{
            if (StringUtils.isNotBlank(crudaction) && Constants.INSERT_OR_UPDATE.equals(crudaction)){
                userValidator.validate(command, bindingResult);
                if(!bindingResult.hasErrors()) {
                    extractAvatarFileUpload(command);
                    if(pojo.getUserId() != null && pojo.getUserId() > 0){
                        pojo = this.userService.updateItem(command.getPojo());
                        redirectAttributes.addFlashAttribute("messageResponse", this.getMessageSourceAccessor().getMessage("database.update.successful"));
//                        if(command.getPojo().getAvatarFileItem() != null){
//                            SecurityUtils.getPrincipal().setAvatar(command.getPojo().getAvatar());
//                        }
                    } else {
                        pojo = this.userService.addItem(command.getPojo());
                        redirectAttributes.addFlashAttribute("messageResponse", this.getMessageSourceAccessor().getMessage("database.add.successful"));
                    }
                    redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                    if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                        return new ModelAndView("redirect:/admin/user/list.html");
                    }else{
                        return new ModelAndView("redirect:/normal/user/list.html");
                    }
                }
            }
            if(!bindingResult.hasErrors()&& command.getPojo().getUserId() != null && command.getPojo().getUserId() > 0) {
                command.setPojo(this.userService.findById(pojo.getUserId()));
                command.getPojo().setPassword(DesEncrypterUtils.getInstance().decrypt(command.getPojo().getPassword()));
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
            mav.addObject(Constants.ALERT_TYPE, "error");
        }
        referenceData(command, mav);
        return mav;
    }

    @RequestMapping(value = {"/admin/user/profileedit.html", "/normal/user/profileedit.html"})
    public ModelAndView editprofile(@ModelAttribute(Constants.FORM_MODEL_KEY)UserCommand command, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws DuplicateKeyException, ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/user/editprofile");
        String crudaction = command.getCrudaction();
        UserDTO pojo = command.getPojo();
        try {
            userValidator.validate(command, bindingResult);
            if (!bindingResult.hasErrors() && StringUtils.isBlank(command.getErrorMessage())) {
                if (StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)) {
                    try{

                        extractAvatarFileUpload(command);
                        if (pojo.getUserId() != null && pojo.getUserId() > 0) {
                            pojo = this.userService.updateProfileItem(command.getPojo());
                            if (command.getPojo().getAvatarFileItem() != null) {
                                SecurityUtils.getPrincipal().setAvatar(command.getPojo().getAvatar());
                            }
                        }
                        redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                        redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("user.profile.update_successfully"));
                        if (SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)) {
                            return new ModelAndView("redirect:/admin/user/profileedit.html?pojo.userId=" + command.getPojo().getUserId());
                        } else {
                            return new ModelAndView("redirect:/normal/user/profileedit.html?pojo.userId=" + command.getPojo().getUserId());
                        }
                    } catch (Exception e){
                        redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "danger");
                        redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("user.profile.update_exception"));
                    }

                }
            else{
                if (!bindingResult.hasErrors() && command.getPojo().getUserId() != null && command.getPojo().getUserId() > 0) {
                    command.setPojo(this.userService.findById(pojo.getUserId()));
                    command.getPojo().setPassword(DesEncrypterUtils.getInstance().decrypt(command.getPojo().getPassword()));
                }
            }
        } else {
                if (StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.INSERT_OR_UPDATE)) {
                    if(StringUtils.isNotBlank(command.getErrorMessage())){
                        mav.addObject(Constants.ALERT_TYPE, "danger");
                        mav.addObject(Constants.MESSAGE_RESPONSE_MODEL_KEY, command.getErrorMessage());
                    }
                }else{
                    redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "danger");
                    redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, command.getErrorMessage());
                    return new ModelAndView("redirect:/dashboard.html");
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("database.exception"));
            mav.addObject(Constants.ALERT_TYPE, "error");
        }


//        referenceData(command, mav);

        return mav;
    }

    private void extractAvatarFileUpload(UserCommand command){
        if(command.getPojo().getAvatarFileItem() != null &&  StringUtils.isNotBlank(command.getPojo().getAvatarFileItem().getOriginalFilename())){
            com.banvien.jcr.api.FileItem fileItem = BeanUtils.toJcrFileItem(command.getPojo().getAvatarFileItem());
            command.getPojo().setAvatar(jcrContent.write(Constants.CONTENT_PATH_JCR_AVATAR, fileItem));
        }
    }

    @RequestMapping(value={"/admin/user/list.html", "/normal/user/list.html"})
    public ModelAndView portalAdminView(@ModelAttribute(Constants.FORM_MODEL_KEY)UserCommand command,
                                        HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView("/admin/user/list");
        String crudaction = command.getCrudaction();
        if(!SecurityUtils.getAuthorities().contains("ADMIN") && !SecurityUtils.getAuthorities().contains("TP") ){
            return mav;
        }
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals(Constants.ACTION_DELETE)) {
            Integer totalDeleted = 0;
            try {
                totalDeleted = userService.deleteItems(command.getCheckList());
                redirectAttributes.addFlashAttribute(Constants.MESSAGE_RESPONSE_MODEL_KEY, this.getMessageSourceAccessor().getMessage("database.delete.successful", new Object[]{totalDeleted}));
                redirectAttributes.addFlashAttribute(Constants.ALERT_TYPE, "success");
                if(SecurityUtils.userHasAuthority(Constants.ADMIN_ROLE)){
                    return new ModelAndView("redirect:/admin/user/list.html");
                }else{
                    return new ModelAndView("redirect:/normal/user/list.html");
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                mav.addObject("messageResponse", this.getMessageSourceAccessor().getMessage("general.exception.msg"));
                mav.addObject(Constants.ALERT_TYPE, "danger");
            }
        }
        executeSearch(command, request);
        referenceData(command, mav);
        mav.addObject("page", command.getPage() - 1);
        mav.addObject(Constants.LIST_MODEL_KEY, command);
        return mav;
    }

    @RequestMapping(value={"/admin/user/permission.html", "/normal/user/permission.html"})
    public ModelAndView listPermission(@ModelAttribute(Constants.FORM_MODEL_KEY)UserACLCommand command,
                                       HttpServletRequest request) throws ObjectNotFoundException {
        ModelAndView mav = new ModelAndView("/admin/user/permission");
        UserACLDTO pojo = command.getPojo();
        String crudaction = command.getCrudaction();
        if(StringUtils.isNotBlank(crudaction)){
            try{
                if(crudaction.equals("update")){
                    if(command.getRoleFilterType().equals(Constants.IS_MANAGING)){
                        if(command.getUserRoleACLIds() != null && command.getUserRoleACLIds().length > 0){
                            userRoleACLService.update(pojo.getUsers().getUserId(), command.getUserRoleACLIds());
                        }else{
                            userRoleACLService.deleteAllByUser(pojo.getUsers().getUserId());
                        }
                    }else{
                        if(command.getRoleIds() != null && command.getRoleIds().length > 0){
                            userRoleACLService.insert(pojo.getUsers().getUserId(), command.getRoleIds());
                        }
                        command.setRoleFilterType(Constants.IS_MANAGING);
                    }
                    if(command.getPermissionFilterType().equals(Constants.IS_MANAGING)){
                        if(command.getUserACLIds() != null && command.getUserACLIds().length > 0){
                            userACLService.update(pojo.getUsers().getUserId(), command.getUserACLIds());
                        }else{
                            userACLService.deleteAllByUser(pojo.getUsers().getUserId());
                        }
                    }else{
                        if(command.getPermissionIds() != null && command.getPermissionIds().length > 0){
                            userACLService.insert(pojo.getUsers().getUserId(), command.getPermissionIds());
                            command.setPermissionFilterType(Constants.IS_MANAGING);
                        }
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

        permissionUserReference(command, mav);
        return mav;
    }

    private void permissionUserReference(UserACLCommand command, ModelAndView mav) throws ObjectNotFoundException{
        String crudaction = command.getCrudaction();
        Long userId = command.getPojo().getUsers().getUserId();
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals("search-role")){
            List<RoleDTO> roles = this.roleService.findRolesNotInUser(userId, command.getRoleFilterCode(), command.getRoleFilterName());
            mav.addObject("rolesNotInUser", roles);
        }else{
            List<RoleDTO> userRoleACLs = this.roleService.findRolesInUser(userId, command.getRoleFilterCode(), command.getRoleFilterName());
            mav.addObject("userRoleACLs", userRoleACLs);
        }
        if(StringUtils.isNotBlank(crudaction) && crudaction.equals("search-permission")){
            List<PermissionDTO> permissions = this.permissionService.findPermissionsNotInUser(userId, command.getPermissionFilterCode(), command.getPermissionFilterName());
            mav.addObject("permissionsNotInUser", permissions);
        }else{
            List<PermissionDTO> userACLs = this.permissionService.findPermissionsInUser(userId, command.getPermissionFilterCode(), command.getPermissionFilterName());
            mav.addObject("userACLs", userACLs);
        }

        UserDTO userDTO = this.userService.findById(userId);
        mav.addObject("userInfo", userDTO);
    }

    private void referenceData(UserCommand command, ModelAndView mav){
        List<UserGroupDTO> userGroups = userGroupService.findAll();

        userGroups = removeGroup(userGroups, Constants.GROUP_THAMDINH);
        userGroups = removeGroup(userGroups, Constants.GROUP_XETTHAU);
        if(!SecurityUtils.getAuthorities().contains(Constants.GROUP_ADMIN)){
            userGroups = removeGroup(userGroups, Constants.GROUP_ADMIN);
            userGroups = removeGroup(userGroups, Constants.GROUP_TRUONGPHONG);
        }
        mav.addObject("userGroups", userGroups);
        UserGroupDTO groupNV = null;
        for(UserGroupDTO userGroupDTO : userGroups){
            if(userGroupDTO.getCode().equals(Constants.GROUP_NHANVIEN)){
                groupNV = userGroupDTO;
                break;
            }
        }

        List<DepartmentDTO> departmentList = this.departmentService.findDepartmentActive();
        mav.addObject("departmentList", departmentList);
        if(StringUtils.isNotBlank(command.getPojo().getUserName())){

            UserGroupDTO userGroupDTO = command.getPojo().getUserGroup();
            if(userGroupDTO != null && userGroupDTO.getUserGroupId() != null && userGroupDTO.getUserGroupId() > 0l){
                if(userGroupDTO.getCode().equals(Constants.GROUP_XETTHAU)) {
                    command.getPojo().setXt(true);
                    if(groupNV != null){
                        command.getPojo().setUserGroup(groupNV);
                    }
                }
                if(userGroupDTO.getCode().equals(Constants.GROUP_THAMDINH)) {
                    command.getPojo().setTd(true);
                    if(groupNV != null){
                        command.getPojo().setUserGroup(groupNV);
                    }
                }
            }

            List<UserRoleACLDTO> listRoles = this.userRoleACLService.findByUserName(command.getPojo().getUserName());
            if(listRoles != null && listRoles.size() > 0){
                for(UserRoleACLDTO role : listRoles){
                    if(role.getRole().getCode().equals(Constants.XET_THAU)){
                        command.getPojo().setXt(true);
                    }
                    if(role.getRole().getCode().equals(Constants.THAM_DINH)){
                        command.getPojo().setTd(true);
                    }
                }
            }
        }
    }

    private List<UserGroupDTO> removeGroup(List<UserGroupDTO> userGroups, String codeGroup){
        int i = 0;
        boolean flag = false;
        for(;i<userGroups.size(); i++){
            if(userGroups.get(i).getCode().equals(codeGroup)){
                flag = true;
                break;
            }
        }
        if(flag){
            userGroups.remove(i);
        }
        return userGroups;
    }

    private void executeSearch(UserCommand command, HttpServletRequest request){
        RequestUtil.initSearchBean(request, command);
        Map<String, Object> properties = buildProperties(command);
        Object[] results = this.userService.search(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<UserDTO>)results[1]);
        command.setTotalItems(Integer.valueOf(results[0].toString()));
    }

    private Map<String, Object> buildProperties(UserCommand command){
        Map<String, Object> properties = new HashMap<String, Object>();

        if (StringUtils.isNotBlank(command.getPojo().getUserName())) {
            properties.put("userName", command.getPojo().getUserName());
        }
        if (StringUtils.isNotBlank(command.getPojo().getDisplayName())) {
            properties.put("displayName", command.getPojo().getDisplayName());
        }

        if (StringUtils.isNotBlank(command.getPojo().getEmail())) {
            properties.put("email", command.getPojo().getEmail());
        }

        if(command.getPojo().getStatus() != null){
            properties.put("status", command.getPojo().getStatus());
        }

        if(command.getPojo().getUserGroup() != null && command.getPojo().getUserGroup().getUserGroupId() != null && command.getPojo().getUserGroup().getUserGroupId() > 0){
            properties.put("userGroup.userGroupId", command.getPojo().getUserGroup().getUserGroupId());
        }

        return properties;
    }

    @RequestMapping("/error/403.html")
    public ModelAndView errorPage(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("web/error/403");
        return mav;
    }
}
