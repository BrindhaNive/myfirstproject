package com.epyloc.pacs.util;

import com.epyloc.pacs.cache.PACSCacheSingleton;
import com.epyloc.pacs.constants.BankUserStatusEnum;

public class CacheUtil {

	public static Integer getBankStatusIdByEnum(BankUserStatusEnum bankUserStatusEnum) {
		PACSCacheSingleton pacsCacheSingleton = PACSCacheSingleton.getInstance();
		int statusTypeID = pacsCacheSingleton.getStatusTypeIDByStatusTypeDesc(BankUserStatusEnum.getStatusTypeDescription());
		return pacsCacheSingleton.getStatusIdbyStatusTypeIDandStatusDesc(statusTypeID, bankUserStatusEnum.getStatusDescription());
	}
	
	
}
