package com.epyloc.pacs.cache;

import java.io.ObjectStreamException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import com.epyloc.pacs.cache.values.StatusCacheValue;
import com.epyloc.pacs.cache.values.StatusDetails;
import com.epyloc.pacs.exception.PacsCriticalException;
import com.epyloc.pacs.util.ApplicationContextProvider;
import com.epyloc.pacs.util.Pair;
import com.epyloc.pacs.wrapper.PACSCacheWrapper;

public class PACSCacheSingleton implements Relodable {

	private static Lock lock = new ReentrantLock();
	private static volatile PACSCacheSingleton instance;
	private static volatile PACSCacheSingleton _instance;
	private static final Logger logger = Logger.getLogger(PACSCacheSingleton.class);

	private Map<String, Integer> statusTypeMap;
	private Map<Integer, List<StatusDetails>> statusDtlMap;
	private Map<Integer, Map<String, Integer>> StatTypIdStatDescMap;
	private Map<Integer, Map<Integer, String>> StatTypIdStatIdMap;
	private Map<Integer, String> roleMap;
	private Map<Integer, Map<Integer, String>> acctIdSchemeMap;
	private Map<Integer, String> schemeProcMap;
	private Map<String, Integer> acctDescIdMap;
	private Map<Integer, String> acctIdDescMap;

	public static PACSCacheSingleton getInstance() {
		logger.debug("Inside getInstance");
		lock.lock();
		if (instance == null) {
			instance = new PACSCacheSingleton();
		}
		lock.unlock();
		return instance;
	}

	@Override
	public void clear() {
		lock.lock();
		try {
			_instance = instance;
			instance = null;
			instance = new PACSCacheSingleton();
		} catch (Exception e) {
			logger.error("Exception While clearing cache ", e);
		} finally {
			lock.unlock();
		}
	}

	public PACSCacheSingleton() {
		reloadCache();
	}

	private void reloadCache() {
		try {
			populateStatusDetails();
			populateRoleDetails();
			populateSchemeDtls();
			populateAcctTypeList();
			_instance = null;
		} catch (Exception e) {
			logger.error("Exception While Loading Master data ", e);
			instance = _instance;
		}
	}

	private void populateAcctTypeList() {
		PACSCacheWrapper pacsCacheWrapper = (PACSCacheWrapper) ApplicationContextProvider.getApplicationContext().getBean("pacsCacheWrapper");
		Pair<Map<String, Integer>, Map<Integer, String>> acctTypePair = pacsCacheWrapper.populateAcctTypeList();
		acctDescIdMap = acctTypePair.getFirstObject();
		acctIdDescMap = acctTypePair.getSecondObject();
		logger.debug("acctDescIdMap:" + acctDescIdMap);
		logger.debug("acctIdDescMap:" + acctIdDescMap);
	}

	private void populateSchemeDtls() {
		PACSCacheWrapper pacsCacheWrapper = (PACSCacheWrapper) ApplicationContextProvider.getApplicationContext().getBean("pacsCacheWrapper");
		Pair<Map<Integer, Map<Integer, String>>, Map<Integer, String>> schemePair = pacsCacheWrapper.populateSchemeDtls();
		acctIdSchemeMap = schemePair.getFirstObject();
		schemeProcMap = schemePair.getSecondObject();
		logger.debug("acctIdSchemeMap:" + acctIdSchemeMap);
		logger.debug("schemeProcMap:" + schemeProcMap);
	}

	public void populateStatusDetails() throws PacsCriticalException {
		PACSCacheWrapper pacsCacheWrapper = (PACSCacheWrapper) ApplicationContextProvider.getApplicationContext().getBean("pacsCacheWrapper");
		StatusCacheValue statusCacheValue = pacsCacheWrapper.populateStatusDtls();
		statusTypeMap = statusCacheValue.getStatusTypeMap();
		statusDtlMap = statusCacheValue.getStatusDtlMap();
		StatTypIdStatDescMap = statusCacheValue.getStatusTypeDtlDescMap();
		StatTypIdStatIdMap = statusCacheValue.getStatusTypeDtlIDMap();
	}

	public void populateRoleDetails() {
		PACSCacheWrapper pacsCacheWrapper = (PACSCacheWrapper) ApplicationContextProvider.getApplicationContext().getBean("pacsCacheWrapper");

		roleMap = pacsCacheWrapper.populateRoleList();
	}

	public Object readResolve() throws ObjectStreamException {
		return instance;
	}

	public Integer getStatusTypeIDByStatusTypeDesc(String statusTypeDesc) {
		return statusTypeMap.get(statusTypeDesc);
	}

	public Integer getStatusIdbyStatusTypeIDandStatusDesc(Integer statusTypeId, String statusDesc) {
		if (StatTypIdStatDescMap.get(statusTypeId) != null) {
			return StatTypIdStatDescMap.get(statusTypeId).get(statusDesc);
		}
		return null;
	}

	public String getStatusDescbyStatusIdandStatusTypeID(Integer statusTypeId, Integer statusId) {
		if (StatTypIdStatIdMap.get(statusTypeId) != null) {
			return StatTypIdStatIdMap.get(statusTypeId).get(statusId);
		}
		return null;
	}

	public String getRoleDescbyRoleID(Integer roleId) {
		return roleMap.get(roleId);
	}

	public String getAcctDescbyID(Integer acctId) {
		return acctIdDescMap.get(acctId);
	}

	public Integer getAcctIDbyDesc(String acctDs) {
		return acctDescIdMap.get(acctDs);
	}

	public Map<Integer, String> getScheDtlsbyAcctId(Integer acctId) {
		return acctIdSchemeMap.get(acctId);
	}

	public String getProcTypeBySchemeTypID(Integer schemeTypeId) {
		return schemeProcMap.get(schemeTypeId);
	}
}
