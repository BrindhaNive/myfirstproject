package com.epyloc.pacs.cache.values;

public class StatusDetails {

	private int statusDetId;
	private String statusDetDesc;

	public int getStatusDetId() {
		return statusDetId;
	}

	public void setStatusDetId(int statusDetId) {
		this.statusDetId = statusDetId;
	}

	public String getStatusDetDesc() {
		return statusDetDesc;
	}

	public void setStatusDetDesc(String statusDetDesc) {
		this.statusDetDesc = statusDetDesc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusDetails [statusDetId=");
		builder.append(statusDetId);
		builder.append(", statusDetDesc=");
		builder.append(statusDetDesc);
		builder.append("]");
		return builder.toString();
	}

}
