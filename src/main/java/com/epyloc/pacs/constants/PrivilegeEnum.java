package com.epyloc.pacs.constants;

public enum PrivilegeEnum {

	ADD_MEMBERSHIP("Add Membership"), 
	EDIT_MEMBERSHIP("Edit Membership");

	private String privilegeName;

	private PrivilegeEnum(String privilegeName) {
		this.setPrivilegeName(privilegeName);
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public static PrivilegeEnum getEnumByPrivilegeName(String privilegeName) {
		for (PrivilegeEnum value : PrivilegeEnum.values()) {
			if (value.getPrivilegeName().equalsIgnoreCase(privilegeName)) {
				return value;
			}
		}
		return null;
	}

}
