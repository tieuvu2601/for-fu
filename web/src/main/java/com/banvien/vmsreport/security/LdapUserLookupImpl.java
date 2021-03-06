package com.banvien.vmsreport.security;

import com.banvien.vmsreport.common.dto.LDAPUserDTO;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LookupAttemptingCallback;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.ldap.filter.OrFilter;

import javax.naming.Name;
import java.util.List;

public class LdapUserLookupImpl implements LdapUserLookup{
	private LdapTemplate ldapTemplate;
    private String userDNPrefix;
    private String lastNameAttribute;
    private String userObjectClasses;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}
	public boolean authenticate(String username, String password){
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", this.userObjectClasses)).and(new EqualsFilter(userDNPrefix, username));

        return ldapTemplate.authenticate(buildDn(), filter.toString(), password, new LookupAttemptingCallback());
	}

    private Name buildDn() {
        DistinguishedName dn = new DistinguishedName();

        return dn;

    }

    public LDAPUserDTO getUser(String userName){
		AndFilter andFilter = new AndFilter();
		andFilter.and(new EqualsFilter("objectclass", this.userObjectClasses));
		andFilter.and(new EqualsFilter(userDNPrefix,userName));
		List list = ldapTemplate.search(DistinguishedName.EMPTY_PATH, andFilter.encode(),new UserAttributeMapper(userDNPrefix));
		if(list != null && list.size() > 0) {
			return (LDAPUserDTO)list.get(0);
		}
		return null;
	}

    public List<LDAPUserDTO> searchByDisplayName(String displayName){
        AndFilter andFilter = new AndFilter();
        andFilter.and(new EqualsFilter("objectclass", this.userObjectClasses));

        OrFilter orFilter = new OrFilter();
        orFilter.or(new LikeFilter("displayName", "*"+displayName+"*"));
        orFilter.or(new LikeFilter("mail", "*"+displayName+"*"));
        andFilter.append(orFilter);

        List<LDAPUserDTO> list = (List<LDAPUserDTO>)ldapTemplate.search(DistinguishedName.EMPTY_PATH, andFilter.encode(), new UserAttributeMapper(userDNPrefix));
        return list;
    }

    @Override
    public List<LDAPUserDTO> searchByDepartment(String department) {
        AndFilter andFilter = new AndFilter();
        andFilter.and(new EqualsFilter("objectclass", this.userObjectClasses));

        OrFilter orFilter = new OrFilter();
        orFilter.or(new LikeFilter("title", "*"+department+"*"));
        andFilter.append(orFilter);

        List<LDAPUserDTO> list = (List<LDAPUserDTO>)ldapTemplate.search(DistinguishedName.EMPTY_PATH, andFilter.encode(), new UserAttributeMapper(userDNPrefix));
        return list;
    }


    public String getUserDNPrefix() {
        return userDNPrefix;
    }

    public void setUserDNPrefix(String userDNPrefix) {
        this.userDNPrefix = userDNPrefix;
    }

    public String getLastNameAttribute() {
        return lastNameAttribute;
    }

    public void setLastNameAttribute(String lastNameAttribute) {
        this.lastNameAttribute = lastNameAttribute;
    }

    public String getUserObjectClasses() {
        return userObjectClasses;
    }

    public void setUserObjectClasses(String userObjectClasses) {
        this.userObjectClasses = userObjectClasses;
    }

}
