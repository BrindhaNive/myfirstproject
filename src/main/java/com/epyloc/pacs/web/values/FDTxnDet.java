package com.epyloc.pacs.web.values;

import java.util.Date;

import com.epyloc.pacs.constants.PACSConstant;
import com.epyloc.pacs.constants.TxnTypeEnum;
import com.epyloc.pacs.util.CommonUtil;

public class FDTxnDet {

	private Integer fdTxnId;
	private Date dateOfIntMaturity;
	private float intAmount;
	private float intCapitalized;
	private float fdBalance;
	private TxnTypeEnum fdTxnTypeEnum;

	public FDTxnDet(Date dateOfIntMaturity, float intAmount, float intCapitalized, float fdBalance, TxnTypeEnum fdTxnTypeEnum) {
		super();
		this.dateOfIntMaturity = dateOfIntMaturity;
		this.intAmount = intAmount;
		this.intCapitalized = intCapitalized;
		this.fdBalance = fdBalance;
		this.fdTxnTypeEnum = fdTxnTypeEnum;
	}

	public Integer getFdTxnId() {
		return fdTxnId;
	}

	public void setFdTxnId(Integer fdTxnId) {
		this.fdTxnId = fdTxnId;
	}

	public String getDateOfIntMaturity() {
		return CommonUtil.dateToString(dateOfIntMaturity, PACSConstant.YYYY_MM_DD);
	}

	public void setDateOfIntMaturity(Date dateOfIntMaturity) {
		this.dateOfIntMaturity = dateOfIntMaturity;
	}

	public float getIntAmount() {
		return intAmount;
	}

	public void setIntAmount(float intAmount) {
		this.intAmount = intAmount;
	}

	public float getIntCapitalized() {
		return intCapitalized;
	}

	public void setIntCapitalized(float intCapitalized) {
		this.intCapitalized = intCapitalized;
	}

	public float getFdBalance() {
		return fdBalance;
	}

	public void setFdBalance(float fdBalance) {
		this.fdBalance = fdBalance;
	}

	public String getFdTxnTypeEnum() {
		return fdTxnTypeEnum.getTxnTypName();
	}

	public void setFdTxnTypeEnum(TxnTypeEnum fdTxnTypeEnum) {
		this.fdTxnTypeEnum = fdTxnTypeEnum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FDTxnDet [fdTxnId=");
		builder.append(fdTxnId);
		builder.append(", dateOfIntMaturity=");
		builder.append(dateOfIntMaturity);
		builder.append(", intAmount=");
		builder.append(intAmount);
		builder.append(", intCapitalized=");
		builder.append(intCapitalized);
		builder.append(", fdBalance=");
		builder.append(fdBalance);
		builder.append(", fdTxnTypeEnum=");
		builder.append(fdTxnTypeEnum);
		builder.append("]");
		return builder.toString();
	}

}
