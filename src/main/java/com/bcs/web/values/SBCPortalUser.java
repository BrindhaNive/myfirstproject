/**
 * 
 */
package com.bcs.web.values;

import com.bcs.constants.PrivilegeEnum;

public class SBCPortalUser {
	
	private SBCPortalUser(String role)	{
		setUserRole(UserRole.createUserRole(role));
	}
	
	public static SBCPortalUser createNewUser(String role){
		return new SBCPortalUser(role);
	}

	private String id;
	private String firstName;
	private String lastName;
	private String status;
	private String emailId;
	private String designation;
	private String contactNumber;
	private UserRole userRole;
	private String guid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName()	{
		return firstName+lastName;
	}

	public void setUserRole(UserRole userRole) {
		
		this.userRole = userRole;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public boolean validateIfAuthorized(PrivilegeEnum type)	{
		return userRole.getPrivileges().contains(type);
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return guid;
	}
}
