package com.epyloc.pacs.web.commandform;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class AddMemberCommandForm {
	
	@Size(min=1, max=1)@NotEmpty
	private String membershipType;
	@Size(min=1, max=1)@NotEmpty
	private String salutation;
	@Size(min=1, max=1)@NotEmpty
	private String gender;
	@Size(min=1, max=1)@NotEmpty
	private String staff;
	@Size(min=3, max=30)@NotEmpty
	private String memberName;
	@Size(min=3, max=30)@NotEmpty
	private String surName;
	@Size(min=3, max=30)@NotEmpty
	private String fatherOrHusbandName;
	private String employeeNumber;
	private String seniorCitizen;
	private String seniorCitizenProof;
	private String occupation;
	private String religion;
	private String category;
	private String typeOfFarmer;
	@DateTimeFormat(pattern="MM/dd/yyyy")
    @Past @NotNull
	private Date dateOfBirth;
	@Digits(fraction = 0, integer = 2,message="jbakbkabskbk kaskaisgui kasgigausig")
	private Integer acres;
	
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFatherOrHusbandName() {
		return fatherOrHusbandName;
	}
	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getSeniorCitizen() {
		return seniorCitizen;
	}
	public void setSeniorCitizen(String seniorCitizen) {
		this.seniorCitizen = seniorCitizen;
	}
	public String getSeniorCitizenProof() {
		return seniorCitizenProof;
	}
	public void setSeniorCitizenProof(String seniorCitizenProof) {
		this.seniorCitizenProof = seniorCitizenProof;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTypeOfFarmer() {
		return typeOfFarmer;
	}
	public void setTypeOfFarmer(String typeOfFarmer) {
		this.typeOfFarmer = typeOfFarmer;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getAcres() {
		return acres;
	}
	public void setAcres(Integer acres) {
		this.acres = acres;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddMemberCommandForm [membershipType=").append(membershipType).append(", salutation=").append(salutation).append(", gender=").append(gender).append(", staff=").append(staff).append(", memberName=").append(memberName)
				.append(", surName=").append(surName).append(", fatherOrHusbandName=").append(fatherOrHusbandName).append(", employeeNumber=").append(employeeNumber).append(", seniorCitizen=").append(seniorCitizen).append(", seniorCitizenProof=")
				.append(seniorCitizenProof).append(", occupation=").append(occupation).append(", religion=").append(religion).append(", category=").append(category).append(", typeOfFarmer=").append(typeOfFarmer).append(", dateOfBirth=")
				.append(dateOfBirth).append(", acres=").append(acres).append("]");
		return builder.toString();
	}
		
	
}
