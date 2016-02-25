package com.banvien.vmsreport.security;

import com.banvien.vmsreport.common.dto.LDAPUserDTO;

import java.util.List;

public interface LdapUserLookup {

	public boolean authenticate(String username, String password);
	public LDAPUserDTO getUser(String userName);
    public List<LDAPUserDTO> searchByDisplayName(String displayName);

    public List<LDAPUserDTO> searchByDepartment(String department);

}
