package com.epyloc.pacs.web.values;

import com.epyloc.pacs.constants.PrivilegeEnum;

public class PACSPortalUser {
	
	private PACSPortalUser(String role)	{
		setUserRole(UserRole.createUserRole(role));
	}
	
	public static PACSPortalUser createNewUser(String role){
		return new PACSPortalUser(role);
	}

	private Integer userId;
	private String username;
	private String firstName;
	private String lastName;
	private String status;
	private String emailId;
	private String designation;
	private String contactNumber;
	private UserRole userRole;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public boolean validateIfAuthorized(PrivilegeEnum type)	{
		return userRole.getPrivileges().contains(type);
	}
}
