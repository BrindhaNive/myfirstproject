package com.epyloc.pacs.util;

import java.util.Map;

import com.epyloc.pacs.cache.PACSCacheSingleton;
import com.epyloc.pacs.constants.AcctTypeEnum;
import com.epyloc.pacs.constants.BankUserStatusEnum;
import com.epyloc.pacs.constants.FDTxnStatusEnum;
import com.epyloc.pacs.constants.FixedDepositStatusEnum;

public class CacheUtil {

	public static Integer getBankUserStatusIdByEnum(BankUserStatusEnum bankUserStatusEnum) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(BankUserStatusEnum.getStatusTypeDescription());
		return pacsCacheSingleton.getStatusIdbyStatusTypeIDandStatusDesc(statusTypeID, bankUserStatusEnum.getStatusDescription());
	}

	public static BankUserStatusEnum getBankUserStatusEnumById(Integer stausId) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(BankUserStatusEnum.getStatusTypeDescription());
		return BankUserStatusEnum.getEnumByStatusName(pacsCacheSingleton.getStatusDescbyStatusIdandStatusTypeID(statusTypeID, stausId));
	}

	public static Integer getFDStatusIdByEnum(FixedDepositStatusEnum fixedDepositStatusEnum) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(FixedDepositStatusEnum.getStatusTypeDescription());
		return pacsCacheSingleton.getStatusIdbyStatusTypeIDandStatusDesc(statusTypeID, fixedDepositStatusEnum.getStatusDescription());
	}

	public static Integer getFDTxnStatusIdByEnum(FDTxnStatusEnum fdTxnStatusEnum) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(FDTxnStatusEnum.getStatusTypeDescription());
		return pacsCacheSingleton.getStatusIdbyStatusTypeIDandStatusDesc(statusTypeID, fdTxnStatusEnum.getStatusDescription());
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

	public static String getProcTypeBySchemeTypID(Integer schemeTypeID) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		return pacsCacheSingleton.getProcTypeBySchemeTypID(schemeTypeID);
	}
}
