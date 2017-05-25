package com.epyloc.pacs.web.values;

import com.epyloc.pacs.constants.BankUserStatusEnum;
import com.epyloc.pacs.constants.PrivilegeEnum;

public class PACSPortalUser {

	private PACSPortalUser(String role) {
		setUserRole(UserRole.createUserRole(role));
	}

	public static PACSPortalUser createNewUser(String role) {
		return new PACSPortalUser(role);
	}

	private Integer userId;
	private String username;
	private String fullName;
	private BankUserStatusEnum bankUserStatusEnum;
	private UserRole userRole;
	private Integer bankId;
	private Integer associatedAreaId;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BankUserStatusEnum getBankUserStatusEnum() {
		return bankUserStatusEnum;
	}

	public void setBankUserStatusEnum(BankUserStatusEnum bankUserStatusEnum) {
		this.bankUserStatusEnum = bankUserStatusEnum;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getAssociatedAreaId() {
		return associatedAreaId;
	}

	public void setAssociatedAreaId(Integer associatedAreaId) {
		this.associatedAreaId = associatedAreaId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public boolean validateIfAuthorized(PrivilegeEnum type) {
		return userRole.getPrivileges().contains(type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PACSPortalUser [userId=");
		builder.append(userId);
		builder.append(", username=");
		builder.append(username);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", bankUserStatusEnum=");
		builder.append(bankUserStatusEnum);
		builder.append(", userRole=");
		builder.append(userRole);
		builder.append(", bankId=");
		builder.append(bankId);
		builder.append(", associatedAreaId=");
		builder.append(associatedAreaId);
		builder.append("]");
		return builder.toString();
	}

}
