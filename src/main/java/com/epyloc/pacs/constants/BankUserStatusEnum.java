package com.epyloc.pacs.constants;

public enum BankUserStatusEnum {

	ACTIVE("ACTIVE", "Active"), 
	INACTIVE("INACTIVE", "Active"), 
	PENDING_APPROVAL("PENDING APPROVAL", "Approval pending"),;

	private String statusDescription;
	private String statusGUIDescription;

	private BankUserStatusEnum(String statusDescription, String statusGUIDescription) {
		this.setStatusDescription(statusDescription);
		this.setStatusGUIDescription(statusGUIDescription);
	}

	public static String getStatusTypeDescription() {
		return "BANK USER STATUS";
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

	public static BankUserStatusEnum getEnumByStatusName(String statusDesc) {
		for (BankUserStatusEnum value : BankUserStatusEnum.values()) {
			if (value.getStatusDescription().equalsIgnoreCase(statusDesc)) {
				return value;
			}
		}
		return null;
	}

}
