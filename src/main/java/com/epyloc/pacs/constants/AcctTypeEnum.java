package com.epyloc.pacs.constants;

public enum AcctTypeEnum {

	FIXED_DEPOSIT("FIXED DEPOSIT"), 
	RECURRING_DEPOSIT("RECURRING DEPOSIT"), 
	SAVINGS_ACCOUNT("SAVINGS ACCOUNT"), 
	CURRENT_ACCOUNT("CURRENT ACCOUNT");

	private String acctTypeDesc;

	private AcctTypeEnum(String acctTypeDesc) {
		this.setAcctTypeDesc(acctTypeDesc);
	}

	public String getAcctTypeDesc() {
		return acctTypeDesc;
	}

	public void setAcctTypeDesc(String acctTypeDesc) {
		this.acctTypeDesc = acctTypeDesc;
	}

	public static AcctTypeEnum getEnumByPrivilegeName(String acctTypeDesc) {
		for (AcctTypeEnum value : AcctTypeEnum.values()) {
			if (value.getAcctTypeDesc().equalsIgnoreCase(acctTypeDesc)) {
				return value;
			}
		}
		return null;
	}

}
