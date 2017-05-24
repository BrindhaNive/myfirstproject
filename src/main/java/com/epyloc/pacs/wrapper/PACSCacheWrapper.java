package com.epyloc.pacs.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epyloc.pacs.cache.values.StatusCacheValue;
import com.epyloc.pacs.cache.values.StatusDetails;
import com.epyloc.pacs.cache.values.StatusTypeDetails;
import com.epyloc.pacs.dao.CacheDataAccessor;
import com.epyloc.pacs.exception.PacsCriticalException;
import com.epyloc.pacs.util.Pair;

@Service("pacsCacheWrapper")
public class PACSCacheWrapper {

	@Autowired
	CacheDataAccessor cacheDataAccessor;
	private static final Logger logger = Logger.getLogger(PACSCacheWrapper.class);

	public StatusCacheValue populateStatusDtls() throws PacsCriticalException {

		StatusCacheValue statusCacheValue = new StatusCacheValue();
		List<StatusTypeDetails> statusDtlList = cacheDataAccessor.getStatusMap();

		Map<String, Integer> statusTypeMap = new HashMap<String, Integer>();
		Map<Integer, List<StatusDetails>> statusDtlMap = new HashMap<Integer, List<StatusDetails>>();
		Map<Integer, Map<String, Integer>> statusTypeDtlDescMap = new HashMap<Integer, Map<String, Integer>>();
		Map<Integer, Map<Integer, String>> statusTypeDtlIDMap = new HashMap<Integer, Map<Integer, String>>();
		for (StatusTypeDetails statusTypeDtl : statusDtlList) {

			if (statusTypeMap.get(statusTypeDtl.getStatusTypeDesc()) == null) {
				statusTypeMap.put(statusTypeDtl.getStatusTypeDesc(), statusTypeDtl.getStatusTypeId());
				statusDtlMap.put(statusTypeDtl.getStatusTypeId(), new ArrayList<StatusDetails>());
				statusTypeDtlDescMap.put(statusTypeDtl.getStatusTypeId(), new HashMap<String, Integer>());
				statusTypeDtlIDMap.put(statusTypeDtl.getStatusTypeId(), new HashMap<Integer, String>());
			}
			statusTypeDtlDescMap.get(statusTypeDtl.getStatusTypeId()).put(statusTypeDtl.getStatusDetails().getStatusDetDesc(), statusTypeDtl.getStatusDetails().getStatusDetId());
			statusTypeDtlIDMap.get(statusTypeDtl.getStatusTypeId()).put(statusTypeDtl.getStatusDetails().getStatusDetId(), statusTypeDtl.getStatusDetails().getStatusDetDesc());
			statusDtlMap.get(statusTypeDtl.getStatusTypeId()).add(statusTypeDtl.getStatusDetails());
		}

		statusCacheValue.setStatusDtlMap(statusDtlMap);
		statusCacheValue.setStatusTypeDtlDescMap(statusTypeDtlDescMap);
		statusCacheValue.setStatusTypeDtlIDMap(statusTypeDtlIDMap);
		statusCacheValue.setStatusTypeMap(statusTypeMap);

		logger.debug("statusCacheValue:" + statusCacheValue);
		return statusCacheValue;
	}

}
