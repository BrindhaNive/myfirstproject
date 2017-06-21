package com.epyloc.pacs.constants;

public enum FixedDepositStatusEnum {

	INITIATED("INITIATED", "INITIATED"), 
	APPROVAL_PENDING("APPROVAL PENDING", "APPROVAL PENDING"), 
	PROGRESS("PROGRESS", "PROGRESS"),
	MATURED("MATURED", "MATURED"),
	SETTLEMENT_INITIATED("SETTLEMENT INITIATED", "SETTLEMENT INITIATED"),
	SETTLED("SETTLED", "SETTLED"),
	PRECLOSURE_INITIATED("PRECLOSURE INITIATED", "PRECLOSURE INITIATED"),
	PRECLOSURE_PROCESSING("PRECLOSURE PROCESSING", "PRECLOSURE PROCESSING"),
	PRECLOSURE_APPROVAL_PENDING("PRECLOSURE APPROVAL PENDING", "PRECLOSURE APPROVAL PENDING"),
	PRECLOSURE_SETTLED("PRECLOSURE SETTLED", "PRECLOSURE SETTLED");
	
	private String statusDescription;
	private String statusGUIDescription;
	
	private FixedDepositStatusEnum(String statusDescription, String statusGUIDescription) {
		this.setStatusDescription(statusDescription);
		this.setStatusGUIDescription(statusGUIDescription);
	}

	public static String getStatusTypeDescription() {
		return "FD ACCOUNT STATUS";
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

	public static FixedDepositStatusEnum getEnumByStatusName(String statusDesc) {
		for (FixedDepositStatusEnum value : FixedDepositStatusEnum.values()) {
			if (value.getStatusDescription().equalsIgnoreCase(statusDesc)) {
				return value;
			}
		}
		return null;
	}

}
