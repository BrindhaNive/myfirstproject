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
import com.epyloc.pacs.web.values.AcctType;
import com.epyloc.pacs.web.values.Role;
import com.epyloc.pacs.web.values.SchemeTypeDetails;

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

	public Map<Integer, String> populateRoleList() {
		List<Role> roleList = cacheDataAccessor.getRoleList();
		Map<Integer, String> roleMap = new HashMap<Integer, String>();
		for (Role role : roleList) {
			roleMap.put(role.getId(), role.getRole());
		}
		logger.debug("RoleMap:" + roleMap);
		return roleMap;
	}

	public Pair<Map<Integer, Map<Integer, String>>, Map<Integer, String>> populateSchemeDtls() {
		List<SchemeTypeDetails> schemeDtlList = cacheDataAccessor.getSchemeDtls();
		Pair<Map<Integer, Map<Integer, String>>, Map<Integer, String>> pair = getSchemePairObject();
		Map<Integer, Map<Integer, String>> acctSchemeDtlMap = new HashMap<Integer, Map<Integer, String>>();
		Map<Integer, String> schemeProcMap = new HashMap<Integer, String>();
		for (SchemeTypeDetails schemeTypeDtls : schemeDtlList) {

			if (acctSchemeDtlMap.get(schemeTypeDtls.getAcctTypId()) == null) {
				acctSchemeDtlMap.put(schemeTypeDtls.getAcctTypId(), new HashMap<Integer, String>());
			}
			schemeProcMap.put(schemeTypeDtls.getSchTypId(), schemeTypeDtls.getProcessingType());
			acctSchemeDtlMap.get(schemeTypeDtls.getAcctTypId()).put(schemeTypeDtls.getSchTypId(), schemeTypeDtls.getSchemeDesc());

		}
		pair.setFirstObject(acctSchemeDtlMap);
		pair.setSecondObject(schemeProcMap);
		return pair;
	}

	public Pair<Map<String, Integer>, Map<Integer, String>> populateAcctTypeList() {
		List<AcctType> acctTypeList = cacheDataAccessor.getAcctTypeDtls();

		Map<String, Integer> acctTypeDescMap = new HashMap<String, Integer>();
		Map<Integer, String> acctTypeIdMap = new HashMap<Integer, String>();

		for (AcctType acctType : acctTypeList) {
			acctTypeDescMap.put(acctType.getAcctDesc(), acctType.getId());
			acctTypeIdMap.put(acctType.getId(), acctType.getAcctDesc());
		}

		Pair<Map<String, Integer>, Map<Integer, String>> acctPair = getAcctPairObject();
		acctPair.setFirstObject(acctTypeDescMap);
		acctPair.setSecondObject(acctTypeIdMap);
		return acctPair;
	}

	public static Pair<Map<String, Integer>, Map<Integer, String>> getAcctPairObject() {
		Pair<Map<String, Integer>, Map<Integer, String>> pairImpl = new Pair<Map<String, Integer>, Map<Integer, String>>() {
			private Map<String, Integer> acctTypeDescMap = new HashMap<String, Integer>();
			private Map<Integer, String> acctTypeIdMap = new HashMap<Integer, String>();

			@Override
			public void setFirstObject(Map<String, Integer> t) {
				acctTypeDescMap = t;
			}

			@Override
			public Map<String, Integer> getFirstObject() {
				return acctTypeDescMap;
			}

			@Override
			public void setSecondObject(Map<Integer, String> v) {
				acctTypeIdMap = v;

			}

			@Override
			public Map<Integer, String> getSecondObject() {
				return acctTypeIdMap;
			}

		};
		return pairImpl;
	}

	public static Pair<Map<Integer, Map<Integer, String>>, Map<Integer, String>> getSchemePairObject() {
		Pair<Map<Integer, Map<Integer, String>>, Map<Integer, String>> pairImpl = new Pair<Map<Integer, Map<Integer, String>>, Map<Integer, String>>() {
			private Map<Integer, Map<Integer, String>> acctSchemeDtlMap = new HashMap<Integer, Map<Integer, String>>();
			private Map<Integer, String> schemeProcMap = new HashMap<Integer, String>();

			@Override
			public void setFirstObject(Map<Integer, Map<Integer, String>> t) {
				acctSchemeDtlMap = t;
			}

			@Override
			public Map<Integer, Map<Integer, String>> getFirstObject() {
				return acctSchemeDtlMap;
			}

			@Override
			public void setSecondObject(Map<Integer, String> v) {
				schemeProcMap = v;

			}

			@Override
			public Map<Integer, String> getSecondObject() {
				return schemeProcMap;
			}

		};
		return pairImpl;
	}

}
