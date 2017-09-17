package com.epyloc.pacs.web.commandform;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class AddMemberCommandForm {
	private BigInteger generatedId;
	private BigInteger membershipId;
	@NotNull
	private Integer membershipType;
	@NotNull
	private Integer salutation;
	@NotNull
	private Integer gender;
	@NotNull
	private Integer staff;
	@Size(min = 3, max = 30)
	private String memberName;
	@Size(min = 3, max = 30)
	private String surName;
	@Size(min = 3, max = 30)
	private String fatherName;
	private String husbandName;
	private String employeeNumber;
	private Integer seniorCitizen;
	private Integer seniorCitizenProof;
	private Integer occupation;
	private Integer religion;
	private Integer category;
	private Integer typeOfFarmer;
	@Past
	private Date dateOfBirth;
	private BigDecimal acres;
	private BigDecimal shareAmt;
	@NotNull
	private Integer shareType;

	public BigInteger getGeneratedId() {
		return generatedId;
	}

	public void setGeneratedId(BigInteger generatedId) {
		this.generatedId = generatedId;
	}

	public BigInteger getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(BigInteger membershipId) {
		this.membershipId = membershipId;
	}

	public Integer getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(Integer membershipType) {
		this.membershipType = membershipType;
	}

	public Integer getSalutation() {
		return salutation;
	}

	public void setSalutation(Integer salutation) {
		this.salutation = salutation;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getStaff() {
		return staff;
	}

	public void setStaff(Integer staff) {
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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Integer getSeniorCitizen() {
		return seniorCitizen;
	}

	public void setSeniorCitizen(Integer seniorCitizen) {
		this.seniorCitizen = seniorCitizen;
	}

	public Integer getSeniorCitizenProof() {
		return seniorCitizenProof;
	}

	public void setSeniorCitizenProof(Integer seniorCitizenProof) {
		this.seniorCitizenProof = seniorCitizenProof;
	}

	public Integer getOccupation() {
		return occupation;
	}

	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}

	public Integer getReligion() {
		return religion;
	}

	public void setReligion(Integer religion) {
		this.religion = religion;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getTypeOfFarmer() {
		return typeOfFarmer;
	}

	public void setTypeOfFarmer(Integer typeOfFarmer) {
		this.typeOfFarmer = typeOfFarmer;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getAcres() {
		return acres;
	}

	public void setAcres(BigDecimal acres) {
		this.acres = acres;
	}

	public BigDecimal getShareAmt() {
		return shareAmt;
	}

	public void setShareAmt(BigDecimal shareAmt) {
		this.shareAmt = shareAmt;
	}

	public Integer getShareType() {
		return shareType;
	}

	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddMemberCommandForm [generatedId=").append(generatedId).append(", membershipId=").append(membershipId).append(", membershipType=").append(membershipType).append(", salutation=").append(salutation).append(", gender=")
				.append(gender).append(", staff=").append(staff).append(", memberName=").append(memberName).append(", surName=").append(surName).append(", fatherName=").append(fatherName).append(", husbandName=").append(husbandName)
				.append(", employeeNumber=").append(employeeNumber).append(", seniorCitizen=").append(seniorCitizen).append(", seniorCitizenProof=").append(seniorCitizenProof).append(", occupation=").append(occupation).append(", religion=")
				.append(religion).append(", category=").append(category).append(", typeOfFarmer=").append(typeOfFarmer).append(", dateOfBirth=").append(dateOfBirth).append(", acres=").append(acres).append(", shareAmt=").append(shareAmt)
				.append(", shareType=").append(shareType).append("]");
		return builder.toString();
	}

}
