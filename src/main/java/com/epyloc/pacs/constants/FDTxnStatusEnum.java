package com.epyloc.pacs.constants;

public enum FDTxnStatusEnum {

	APPROVAL_PENDING("APPROVAL PENDING", "APPROVAL PENDING"), 
	PROGRESS("PROGRESS", "PROGRESS"),
	MATURED("MATURED", "MATURED"),
	SETTLEMENT_INITIATED("SETTLEMENT INITIATED", "SETTLEMENT INITIATED"),
	SETTLED("SETTLED", "SETTLED");
	
	private String statusDescription;
	private String statusGUIDescription;
	
	private FDTxnStatusEnum(String statusDescription, String statusGUIDescription) {
		this.setStatusDescription(statusDescription);
		this.setStatusGUIDescription(statusGUIDescription);
	}

	public static String getStatusTypeDescription() {
		return "FD TXN STATUS";
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

	public static FDTxnStatusEnum getEnumByStatusName(String statusDesc) {
		for (FDTxnStatusEnum value : FDTxnStatusEnum.values()) {
			if (value.getStatusDescription().equalsIgnoreCase(statusDesc)) {
				return value;
			}
		}
		return null;
	}

}
