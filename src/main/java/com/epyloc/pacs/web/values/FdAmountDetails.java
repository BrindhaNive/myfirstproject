package com.epyloc.pacs.web.values;

public class FdAmountDetails {

	private String principalAmt;
	private String dateOfDeposit;
	private String maturityDate;
	private String acctOpenDate;
	private String daysPeriod;
	private String monthsPeriod;
	private String maturityAmount;
	private String rateOfInterest;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FdDepositInstallmentDetails [principalAmt=");
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
		builder.append("]");
		return builder.toString();
	}

}
