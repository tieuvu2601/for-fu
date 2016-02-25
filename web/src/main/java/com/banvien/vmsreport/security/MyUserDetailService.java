package com.banvien.vmsreport.security;


import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.dto.*;
import com.banvien.vmsreport.core.business.*;
import com.banvien.vmsreport.security.util.MyUserDetail;
import com.banvien.vmsreport.util.WebCommonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.ejb.ObjectNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @author Nguyen Hai Vien
 * 
 */

public class MyUserDetailService implements UserDetailsService {
    private transient final Logger log = Logger.getLogger(getClass());

	protected UserCache userCache = null;

	private UserManagementLocalBean userService;
    private UserGroupManagementLocalBean userGroupService;
    private UserRoleACLManagementLocalBean userRoleACLService;


    private LdapUserLookup ldapUserLookup;

    public void setLdapUserLookup(LdapUserLookup ldapUserLookup) {
        this.ldapUserLookup = ldapUserLookup;
    }

    public void setUserGroupService(UserGroupManagementLocalBean userGroupService) {
        this.userGroupService = userGroupService;
    }

    public void setUserService(UserManagementLocalBean userService) {
        this.userService = userService;
    }

    public void setUserRoleACLService(UserRoleACLManagementLocalBean userRoleACLManagementLocalBean) {
        this.userRoleACLService = userRoleACLManagementLocalBean;
    }

    /**
	 * Creates new instance of MyUserDetailService
	 */
	public MyUserDetailService() {

	}

	/**
	 * Set UserCache
	 *
	 * @param userCache
	 *            user cache to set
	 */
	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	/**
	 * Locates the user based on the username. In the actual implementation, the
	 * search may possibly be case insensitive, or case insensitive depending on
	 * how the implementaion instance is configured. In this case, the
	 * <code>UserDetails</code> object that comes back may have a username
	 * that is of a different case than what was actually requested..
	 *
	 * @param passUserName
	 *            the username presented to the {@link
	 *            org.springframework.security.authentication.dao.DaoAuthenticationProvider}
	 * @return a fully populated user record (never <code>null</code>)
	 * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
	 *             if the user could not be found or the user has no
	 *             GrantedAuthority
	 * @throws org.springframework.dao.DataAccessException
	 *             if user could not be found for a repository-specific reason
	 */
	public UserDetails loadUserByUsername(String passUserName)
			throws UsernameNotFoundException, DataAccessException {
        String[] userPassArr = WebCommonUtil.splitUsernameAndPassword(passUserName);
        String username = userPassArr[0];
        String password = userPassArr[1];

        UserDTO account = null;
        List<UserRoleACLDTO> userRoleACLDTOs = null;
        List<UserACLDTO> userACLDTOs = null;
        List<UserGroupRoleACLDTO> userGroupRoleACLDTOs = null;
        UserGroupDTO userGroup = null;
        //Check from LDAP
        LDAPUserDTO userDTO = null;

        try{
            try{
                account = this.userService.findByUsername(username);
            }catch (ObjectNotFoundException oe){}

            if(account == null){
                boolean res = ldapUserLookup.authenticate(username, password);
                if(res){
                    userDTO = ldapUserLookup.getUser(username);
                    if (userDTO != null) {
                        account = new UserDTO();
                        account.setUserName(username);
                        account.setPassword(password);
                        account.setDisplayName(userDTO.getDisplayName());
                        account.setStatus(Constants.USER_ACTIVE);
                        account.setLDAP(Constants.USER_LDAP);
                        account.setDisplayName(userDTO.getDisplayName());
                        UserGroupDTO userGroupDTO = this.userGroupService.findByCode(Constants.USER_ROLE);
                        userGroupDTO.setCode(Constants.USER_ROLE);
                        account.setUserGroup(userGroupDTO);
                        account = userService.addItem(account);

                        // cheat for check login with DAP
                        account.setPassword(password);
                    }
                }
            }
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        }


        if (account == null) {
            throw new UsernameNotFoundException("UserProcessingFilter.usernameNotFound:" + username);
        }else{
            try {
                if(account.getUserGroup().getCode() != null){
                    if(!account.getUserGroup().getCode().equals(Constants.ADMIN_ROLE)){

                        account = this.userService.findAllAndFetchPermission(username);
                    }
                }
            } catch (ObjectNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (account.getStatus() == null) {
            throw new UsernameNotFoundException("UserProcessingFilter.usernameNotFound:" + username + ".Status is NULL");
        }else if (!account.getStatus().equals(Constants.USER_ACTIVE)) {
            if (account.getStatus().equals(Constants.USER_INACTIVE)) {
                throw new LockedException("User is in-active:" + username);
            }else {
                throw new UsernameNotFoundException("UserProcessingFilter.usernameNotFound:" + username + ".Status not available.");
            }
        }
        //this line of code is used to check whether the user has login or not
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(Constants.LOGON_ROLE));

        if (account.getLDAP().equals(Constants.USER_LDAP)){
            authorities.add(new SimpleGrantedAuthority(Constants.USER_PHONG_BAN_KHAC));
        }else {
            if(account.getUserGroup().getCode().equals(Constants.ADMIN_ROLE)){
                authorities.add(new SimpleGrantedAuthority(Constants.ADMIN_ROLE));
            }else {
                authorities.add(new SimpleGrantedAuthority(Constants.USER_ROLE));
                boolean allowFetchPermission = false;
                if (account.getUserGroup().getCenter().equals(Constants.CENTER_USER_GROUP)){
                    authorities.add(new SimpleGrantedAuthority(Constants.CENTER_ROLE));
                    authorities.add(new SimpleGrantedAuthority(Constants.HAS_GRANTED_DISTRICTS));
                    allowFetchPermission = true;
                }

                if(allowFetchPermission){
                    if (account.getPermissions() != null && account.getPermissions().size() > 0) {
                        for (PermissionDTO permission : account.getPermissions()) {
                            authorities.add(new SimpleGrantedAuthority(permission.getCode()));
                        }
                    }
                }else{
                    try {
                        UserDTO account1 = this.userService.getPermissionListByPermissionSystem(username);
                        if (account1.getPermissions() != null && account1.getPermissions().size() > 0) {
                            for (PermissionDTO permission : account1.getPermissions()) {
                                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
                            }
                        }
                    } catch (ObjectNotFoundException e) {}
                }
            }

        }
        try {
            authorities.add(new SimpleGrantedAuthority(account.getUserGroup().getCode()));
            List<UserGroupACLDTO> listGroupACL = this.userGroupService.searchByUserGroupId(account.getUserGroup().getUserGroupId());
            for (UserGroupACLDTO userGroupACLDTO : listGroupACL) {
                authorities.add(new SimpleGrantedAuthority(userGroupACLDTO.getPermission().getCode()));
            }
        } catch (ObjectNotFoundException e) {

        }


        List<UserRoleACLDTO> listRoleACL = this.userRoleACLService.findByUserName(account.getUserName());

        for (UserRoleACLDTO userRoleACLDTO : listRoleACL) {
            authorities.add(new SimpleGrantedAuthority(userRoleACLDTO.getRole().getCode()));
        }


        MyUserDetail loginUser = new MyUserDetail(username, username + Constants.SECURITY_CREDENTIAL_DELIMITER + account.getPassword(), account.getDisplayName(), true, true, true, true, authorities);
        if(account.getDepartment() != null) {
            loginUser.setDepartmentId(account.getDepartment().getDepartmentId());
        }

        if(StringUtils.isNotBlank(account.getAvatar())){
            loginUser.setAvatar(account.getAvatar());
        }
		BeanUtils.copyProperties(account, loginUser);
		return loginUser;
	}
}
