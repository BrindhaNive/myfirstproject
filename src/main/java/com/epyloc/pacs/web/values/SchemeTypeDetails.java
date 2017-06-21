package com.epyloc.pacs.web.values;

public class SchemeTypeDetails {

	private int schTypId;
	private int acctTypId;
	private String schemeCode;
	private String schemeDesc;
	private String processingType;

	public int getSchTypId() {
		return schTypId;
	}

	public void setSchTypId(int schTypId) {
		this.schTypId = schTypId;
	}

	public int getAcctTypId() {
		return acctTypId;
	}

	public void setAcctTypId(int acctTypId) {
		this.acctTypId = acctTypId;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getSchemeDesc() {
		return schemeDesc;
	}

	public void setSchemeDesc(String schemeDesc) {
		this.schemeDesc = schemeDesc;
	}

	public String getProcessingType() {
		return processingType;
	}

	public void setProcessingType(String processingType) {
		this.processingType = processingType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SchemeTypeDetails [schTypId=");
		builder.append(schTypId);
		builder.append(", acctTypId=");
		builder.append(acctTypId);
		builder.append(", schemeCode=");
		builder.append(schemeCode);
		builder.append(", schemeDesc=");
		builder.append(schemeDesc);
		builder.append(", processingType=");
		builder.append(processingType);
		builder.append("]");
		return builder.toString();
	}

}
