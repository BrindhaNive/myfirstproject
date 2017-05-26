package com.epyloc.pacs.util;

import java.util.Map;

import com.epyloc.pacs.cache.PACSCacheSingleton;
import com.epyloc.pacs.constants.AcctTypeEnum;
import com.epyloc.pacs.constants.BankUserStatusEnum;

public class CacheUtil {

	public static Integer getBankStatusIdByEnum(BankUserStatusEnum bankUserStatusEnum) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(BankUserStatusEnum.getStatusTypeDescription());
		return pacsCacheSingleton.getStatusIdbyStatusTypeIDandStatusDesc(statusTypeID, bankUserStatusEnum.getStatusDescription());
	}

	public static BankUserStatusEnum getBankStatusEnumById(Integer stausId) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(BankUserStatusEnum.getStatusTypeDescription());
		return BankUserStatusEnum.getEnumByStatusName(pacsCacheSingleton.getStatusDescbyStatusIdandStatusTypeID(statusTypeID, stausId));
	}

	public static String getRoleDescByID(Integer roleId) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		return pacsCacheSingleton.getRoleDescbyRoleID(roleId);
	}

	public static Map<Integer, String> getSchemeMapByAcctTypeEnum(AcctTypeEnum acctTypeEnum) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		Integer acctTypeId = pacsCacheSingleton.getAcctIDbyDesc(acctTypeEnum.getAcctTypeDesc());
		return pacsCacheSingleton.getScheDtlsbyAcctId(acctTypeId);
	}
}
