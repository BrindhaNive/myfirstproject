/**
 * 
 */
package com.epyloc.pacs.constants;


public enum MembershipOptionsEnum {
	
	MEMBERTYPE("MEMBER_TYPE", 1), SALUTATION("SALUTATION", 2), GENDER("GENDER", 3), STAFF("STAFF", 4), SENIORCITIZEN("SENIOR_CITIZEN", 5), PROOF("PROOF", 6), OCCUPATION("OCCUPATION", 7), RELIGION("RELIGION", 8), CATEGORY("CATEGORY",
			9), TOF("TYPE_OF_FARMER", 10);
	private String value;
	private int code;

	private MembershipOptionsEnum(String value, int code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public int getCode() {
		return code;
	}
	
		
}
