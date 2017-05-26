package com.epyloc.pacs.web.values;

public class FdMembershipDetails {

	private String membershipName;
	private String membershipAcctNum;
	private String membershipId;

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

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
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
