package com.epyloc.pacs.cache.values;

import java.util.List;
import java.util.Map;

public class StatusCacheValue {

	private Map<String, Integer> statusTypeMap;
	private Map<Integer, List<StatusDetails>> statusDtlMap;
	private Map<Integer, Map<String, Integer>> statusTypeDtlDescMap;
	private Map<Integer, Map<Integer, String>> statusTypeDtlIDMap;

	public Map<String, Integer> getStatusTypeMap() {
		return statusTypeMap;
	}

	public void setStatusTypeMap(Map<String, Integer> statusTypeMap) {
		this.statusTypeMap = statusTypeMap;
	}

	public Map<Integer, List<StatusDetails>> getStatusDtlMap() {
		return statusDtlMap;
	}

	public void setStatusDtlMap(Map<Integer, List<StatusDetails>> statusDtlMap) {
		this.statusDtlMap = statusDtlMap;
	}

	public Map<Integer, Map<String, Integer>> getStatusTypeDtlDescMap() {
		return statusTypeDtlDescMap;
	}

	public void setStatusTypeDtlDescMap(Map<Integer, Map<String, Integer>> statusTypeDtlDescMap) {
		this.statusTypeDtlDescMap = statusTypeDtlDescMap;
	}

	public Map<Integer, Map<Integer, String>> getStatusTypeDtlIDMap() {
		return statusTypeDtlIDMap;
	}

	public void setStatusTypeDtlIDMap(Map<Integer, Map<Integer, String>> statusTypeDtlIDMap) {
		this.statusTypeDtlIDMap = statusTypeDtlIDMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusCacheValue [statusTypeMap=");
		builder.append(statusTypeMap);
		builder.append(", statusDtlMap=");
		builder.append(statusDtlMap);
		builder.append(", statusTypeDtlDescMap=");
		builder.append(statusTypeDtlDescMap);
		builder.append(", statusTypeDtlIDMap=");
		builder.append(statusTypeDtlIDMap);
		builder.append("]");
		return builder.toString();
	}

}
