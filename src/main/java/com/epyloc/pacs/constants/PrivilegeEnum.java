package com.epyloc.pacs.constants;

public enum PrivilegeEnum {

	VIEW_DETAILS("SELECT"), 
	CREATE_DETAILS("CREATE"),
	UPDATE_DETAILS("UPDATE"),
	APPROVE_DETAILS("APPROVE");

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
