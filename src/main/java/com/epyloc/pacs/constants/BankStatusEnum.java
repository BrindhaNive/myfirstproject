package com.epyloc.pacs.constants;

public enum BankStatusEnum {

	ACTIVE("ACTIVE", "Active"), 
	INACTIVE("INACTIVE", "Active");

	private String statusDescription;
	private String statusGUIDescription;

	private BankStatusEnum(String statusDescription, String statusGUIDescription) {
		this.setStatusDescription(statusDescription);
		this.setStatusGUIDescription(statusGUIDescription);
	}

	public static String getStatusTypeDescription() {
		return "BANK STATUS";
	}
	
	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescrip) {
		statusDescription = statusDescrip;
	}

	public String getStatusGUIDescription() {
		return statusGUIDescription;
	}

	public void setStatusGUIDescription(String statusGUIDescrin) {
		statusGUIDescription = statusGUIDescrin;
	}

	public static BankStatusEnum getEnumByStatusName(String statusDesc) {
		for (BankStatusEnum value : BankStatusEnum.values()) {
			if (value.getStatusDescription().equalsIgnoreCase(statusDesc)) {
				return value;
			}
		}
		return null;
	}

}
