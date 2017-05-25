package com.epyloc.pacs.web.values;

public class UserDetails {

	private Integer userId;
	private Integer userStatus;
	private Integer roleId;
	private Integer bankId;
	private Integer talukId;
	private Integer distId;
	private Integer stateId;
	private String firstName;
	private String lastName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getTalukId() {
		return talukId;
	}

	public void setTalukId(Integer talukId) {
		this.talukId = talukId;
	}

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distrId) {
		distId = distrId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
