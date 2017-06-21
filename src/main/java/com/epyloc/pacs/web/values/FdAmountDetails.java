package com.epyloc.pacs.web.values;

import java.util.List;

public class FdAmountDetails {

	private int fdId;
	private String fdAccountId;
	private String principalAmt;
	private String dateOfDeposit;
	private String maturityDate;
	private String acctOpenDate;
	private String daysPeriod;
	private String monthsPeriod;
	private String maturityAmount;
	private String rateOfInterest;
	private List<FDTxnDet> fdTxnDet;

	
	public int getFdId() {
		return fdId;
	}

	public void setFdId(int fdId) {
		this.fdId = fdId;
	}

	public String getFdAccountId() {
		return fdAccountId;
	}

	public void setFdAccountId(String fdAccountId) {
		this.fdAccountId = fdAccountId;
	}

	public String getPrincipalAmt() {
		return principalAmt;
	}

	public void setPrincipalAmt(String principalAmt) {
		this.principalAmt = principalAmt;
	}

	public String getDateOfDeposit() {
		return dateOfDeposit;
	}

	public void setDateOfDeposit(String dateOfDeposit) {
		this.dateOfDeposit = dateOfDeposit;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getAcctOpenDate() {
		return acctOpenDate;
	}

	public void setAcctOpenDate(String acctOpenDate) {
		this.acctOpenDate = acctOpenDate;
	}

	public String getDaysPeriod() {
		return daysPeriod;
	}

	public void setDaysPeriod(String daysPeriod) {
		this.daysPeriod = daysPeriod;
	}

	public String getMonthsPeriod() {
		return monthsPeriod;
	}

	public void setMonthsPeriod(String monthsPeriod) {
		this.monthsPeriod = monthsPeriod;
	}

	public String getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(String maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public List<FDTxnDet> getFdTxnDet() {
		return fdTxnDet;
	}

	public void setFdTxnDet(List<FDTxnDet> fdTxnDet) {
		this.fdTxnDet = fdTxnDet;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FdAmountDetails [principalAmt=");
		builder.append(principalAmt);
		builder.append(", dateOfDeposit=");
		builder.append(dateOfDeposit);
		builder.append(", maturityDate=");
		builder.append(maturityDate);
		builder.append(", acctOpenDate=");
		builder.append(acctOpenDate);
		builder.append(", daysPeriod=");
		builder.append(daysPeriod);
		builder.append(", monthsPeriod=");
		builder.append(monthsPeriod);
		builder.append(", maturityAmount=");
		builder.append(maturityAmount);
		builder.append(", rateOfInterest=");
		builder.append(rateOfInterest);
		builder.append(", fdTxnDet=");
		builder.append(fdTxnDet);
		builder.append("]");
		return builder.toString();
	}

}
