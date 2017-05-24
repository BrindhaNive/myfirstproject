package com.epyloc.pacs.cache.values;

public class StatusTypeDetails {

	private int statusTypeId;
	private String statusTypeDesc;
	private StatusDetails statusDetails;

	public int getStatusTypeId() {
		return statusTypeId;
	}

	public void setStatusTypeId(int statusTypeId) {
		this.statusTypeId = statusTypeId;
	}

	public String getStatusTypeDesc() {
		return statusTypeDesc;
	}

	public void setStatusTypeDesc(String statusTypeDesc) {
		this.statusTypeDesc = statusTypeDesc;
	}

	public StatusDetails getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(StatusDetails statusDetails) {
		this.statusDetails = statusDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusTypeDetails [statusTypeId=");
		builder.append(statusTypeId);
		builder.append(", statusTypeDesc=");
		builder.append(statusTypeDesc);
		builder.append(", statusDetails=");
		builder.append(statusDetails);
		builder.append("]");
		return builder.toString();
	}

}
