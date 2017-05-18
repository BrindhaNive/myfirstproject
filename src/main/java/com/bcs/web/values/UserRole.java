package com.bcs.web.values;

import java.util.ArrayList;
import java.util.List;

import com.bcs.constants.PrivilegeEnum;
import com.bcs.constants.RolesEnum;

public class UserRole {

	private UserRole(RolesEnum role) {
		setRole(role);
	}

	public static UserRole createUserRole(String role) {
		return new UserRole(RolesEnum.getEnumByRoleName(role));
	}

	public static UserRole createUserRole(RolesEnum roleEnum) {
		return new UserRole(roleEnum);
	}

	private RolesEnum role;
	private List<PrivilegeEnum> privileges = new ArrayList<PrivilegeEnum>();

	public void setRole(RolesEnum role) {
		this.role = role;
	}

	public RolesEnum getRole() {
		return role;
	}

	public void setPrivileges(List<PrivilegeEnum> privileges) {
		this.privileges = privileges;
	}

	public List<PrivilegeEnum> getPrivileges() {
		return privileges;
	}

	public void addPrivilege(PrivilegeEnum privilegeEnum) {
		if (this.privileges == null) {
			this.privileges = new ArrayList<PrivilegeEnum>();
		}
		this.privileges.add(privilegeEnum);
	}

}
