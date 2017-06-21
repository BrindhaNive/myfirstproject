package com.epyloc.pacs.web.commandform;

import java.util.List;

import com.epyloc.pacs.web.values.FDTxnDet;
import com.epyloc.pacs.web.values.FdAmountDetails;
import com.epyloc.pacs.web.values.FdMembershipDetails;
import com.epyloc.pacs.web.values.FdNomineeDetails;

public class FDCommandForm {

	private FdMembershipDetails fdMembershipDetails;
	private FdNomineeDetails fdNomineeDetails;
	private FdAmountDetails fdAmountDetails;
	private Integer selectedFdSchemeTypeId;

	public void createNewFDDepositBean() {
		this.setFdAmountDetails(new FdAmountDetails());
		this.setFdMembershipDetails(new FdMembershipDetails());
		this.setFdNomineeDetails(new FdNomineeDetails());
	}

	public FdMembershipDetails getFdMembershipDetails() {
		return fdMembershipDetails;
	}

	public void setFdMembershipDetails(FdMembershipDetails fdMembershipDetails) {
		this.fdMembershipDetails = fdMembershipDetails;
	}

	public FdNomineeDetails getFdNomineeDetails() {
		return fdNomineeDetails;
	}

	public void setFdNomineeDetails(FdNomineeDetails fdNomineeDetails) {
		this.fdNomineeDetails = fdNomineeDetails;
	}

	public FdAmountDetails getFdAmountDetails() {
		return fdAmountDetails;
	}

	public void setFdAmountDetails(FdAmountDetails fdAmountDetails) {
		this.fdAmountDetails = fdAmountDetails;
	}

	public Integer getSelectedFdSchemeTypeId() {
		return selectedFdSchemeTypeId;
	}

	public void setSelectedFdSchemeTypeId(Integer selectedFdSchemeTypeId) {
		this.selectedFdSchemeTypeId = selectedFdSchemeTypeId;
	}

	public String getMembershipName() {
		return this.fdMembershipDetails.getMembershipName();
	}

	public void setMembershipName(String membershipName) {
		this.fdMembershipDetails.setMembershipName(membershipName);
	}

	public String getMembershipAcctNum() {
		return this.fdMembershipDetails.getMembershipAcctNum();
	}

	public void setMembershipAcctNum(String membershipAcctNum) {
		this.fdMembershipDetails.setMembershipAcctNum(membershipAcctNum);
	}

	public Integer getMembershipId() {
		return this.fdMembershipDetails.getMembershipId();
	}

	public void setMembershipId(Integer membershipId) {
		this.fdMembershipDetails.setMembershipId(membershipId);
	}

	public String getFirstName() {
		return this.fdNomineeDetails.getFirstName();
	}

	public void setFirstName(String firstName) {
		this.fdNomineeDetails.setFirstName(firstName);
	}

	public String getLastName() {
		return this.fdNomineeDetails.getLastName();
	}

	public void setLastName(String lastName) {
		this.fdNomineeDetails.setLastName(lastName);
	}

	public String getRelationship() {
		return this.fdNomineeDetails.getRelationship();
	}

	public void setRelationship(String relationship) {
		this.fdNomineeDetails.setRelationship(relationship);
	}

	public String getAddressOne() {
		return this.fdNomineeDetails.getAddressOne();
	}

	public void setAddressOne(String addressOne) {
		this.fdNomineeDetails.setAddressOne(addressOne);
	}

	public String getAddressTwo() {
		return this.fdNomineeDetails.getAddressTwo();
	}

	public void setAddressTwo(String addressTwo) {
		this.fdNomineeDetails.setAddressTwo(addressTwo);
	}

	public String getCity() {
		return this.fdNomineeDetails.getCity();
	}

	public void setCity(String city) {
		this.fdNomineeDetails.setCity(city);
	}

	public String getState() {
		return this.fdNomineeDetails.getState();
	}

	public void setState(String state) {
		this.fdNomineeDetails.setState(state);
	}

	public String getPincode() {
		return this.fdNomineeDetails.getPincode();
	}

	public void setPincode(String pincode) {
		this.fdNomineeDetails.setPincode(pincode);
	}

	public String getAadharId() {
		return this.fdNomineeDetails.getAadharId();
	}

	public void setAadharId(String aadharId) {
		this.fdNomineeDetails.setAadharId(aadharId);
	}

	public int getFdId() {
		return this.fdAmountDetails.getFdId();
	}

	public void setFdId(int fdId) {
		this.fdAmountDetails.setFdId(fdId);
	}

	public String getFdAccountId() {
		return this.fdAmountDetails.getFdAccountId();
	}

	public void setFdAccountId(String fdAccountId) {
		this.fdAmountDetails.setFdAccountId(fdAccountId);
	}

	public String getPrincipalAmt() {
		return this.fdAmountDetails.getPrincipalAmt();
	}

	public void setPrincipalAmt(String principalAmt) {
		this.fdAmountDetails.setPrincipalAmt(principalAmt);
	}

	public String getDateOfDeposit() {
		return this.fdAmountDetails.getDateOfDeposit();
	}

	public void setDateOfDeposit(String dateOfDeposit) {
		this.fdAmountDetails.setDateOfDeposit(dateOfDeposit);
	}

	public String getMaturityDate() {
		return this.fdAmountDetails.getMaturityDate();
	}

	public void setMaturityDate(String maturityDate) {
		this.fdAmountDetails.setMaturityDate(maturityDate);
	}

	public String getAcctOpenDate() {
		return this.fdAmountDetails.getAcctOpenDate();
	}

	public void setAcctOpenDate(String acctOpenDate) {
		this.fdAmountDetails.setAcctOpenDate(acctOpenDate);
	}

	public String getDaysPeriod() {
		return this.fdAmountDetails.getDaysPeriod();
	}

	public void setDaysPeriod(String daysPeriod) {
		this.fdAmountDetails.setDaysPeriod(daysPeriod);
	}

	public String getMonthsPeriod() {
		return this.fdAmountDetails.getMonthsPeriod();
	}

	public void setMonthsPeriod(String monthsPeriod) {
		this.fdAmountDetails.setMonthsPeriod(monthsPeriod);
		;
	}

	public String getMaturityAmount() {
		return this.fdAmountDetails.getMaturityAmount();
	}

	public void setMaturityAmount(String maturityAmount) {
		this.fdAmountDetails.setMaturityAmount(maturityAmount);
		;
	}

	public String getRateOfInterest() {
		return this.fdAmountDetails.getRateOfInterest();
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.fdAmountDetails.setRateOfInterest(rateOfInterest);
		;
	}

	public List<FDTxnDet> getFdTxnDet() {
		return this.fdAmountDetails.getFdTxnDet();
	}

	public void setFdTxnDet(List<FDTxnDet> fdTxnDet) {
		this.fdAmountDetails.setFdTxnDet(fdTxnDet);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FDCommandForm [fdMembershipDetails=");
		builder.append(fdMembershipDetails);
		builder.append(", fdNomineeDetails=");
		builder.append(fdNomineeDetails);
		builder.append(", fdAmountDetails=");
		builder.append(fdAmountDetails);
		builder.append(", selectedFdSchemeTypeId=");
		builder.append(selectedFdSchemeTypeId);
		builder.append("]");
		return builder.toString();
	}

}
