package com.epyloc.pacs.web.values;

public class FdMembershipDetails {

	private String membershipName;
	private String membershipAcctNum;
	private Integer membershipId;
	private String memDispName;

	public String getMembershipName() {
		return membershipName;
	}

	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}

	public String getMembershipAcctNum() {
		return membershipAcctNum;
	}

	public void setMembershipAcctNum(String membershipAcctNum) {
		this.membershipAcctNum = membershipAcctNum;
	}

	public Integer getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Integer membershipId) {
		this.membershipId = membershipId;
	}

	public String getMemDispName() {
		return this.membershipAcctNum + "--" + this.membershipName;
	}

	public void setMemDispName(String memDispName) {
		this.memDispName = memDispName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FdMembershipDetails [membershipName=");
		builder.append(membershipName);
		builder.append(", membershipAcctNum=");
		builder.append(membershipAcctNum);
		builder.append(", membershipId=");
		builder.append(membershipId);
		builder.append("]");
		return builder.toString();
	}

}
