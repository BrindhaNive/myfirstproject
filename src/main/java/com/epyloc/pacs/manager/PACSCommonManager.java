package com.epyloc.pacs.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epyloc.pacs.constants.PrivilegeEnum;
import com.epyloc.pacs.constants.RolesEnum;
import com.epyloc.pacs.dao.PACSDao;
import com.epyloc.pacs.util.CacheUtil;
import com.epyloc.pacs.web.values.PACSPortalUser;
import com.epyloc.pacs.web.values.Priv;
import com.epyloc.pacs.web.values.UserDetails;

@Component
public class PACSCommonManager {

	@Autowired
	private PACSDao pacsDao;

	private static final Logger logger = Logger.getLogger(PACSCommonManager.class);

	public PACSPortalUser getuserDetails(String userName) {

		UserDetails userDetails = pacsDao.getUserDetails(userName);
		PACSPortalUser pacsPortalUser = PACSPortalUser.createNewUser(CacheUtil.getRoleDescByID(userDetails.getRoleId()));
		pacsPortalUser.setUserId(userDetails.getUserId());
		pacsPortalUser.setBankUserStatusEnum(CacheUtil.getBankStatusEnumById(userDetails.getUserStatus()));
		pacsPortalUser.setFullName(userDetails.getFirstName() + " " + userDetails.getLastName());
		pacsPortalUser.setUsername(userName);
		RolesEnum roleEnum = pacsPortalUser.getUserRole().getRole();
		if (RolesEnum.BANK_USER == roleEnum) {
			pacsPortalUser.setBankId(userDetails.getBankId());
		} else if (RolesEnum.DISTRICT_USER == roleEnum) {
			pacsPortalUser.setAssociatedAreaId(userDetails.getDistId());
		} else if (RolesEnum.TALUK_USER == roleEnum) {
			pacsPortalUser.setAssociatedAreaId(userDetails.getTalukId());
		} else if (RolesEnum.STATE_USER == roleEnum) {
			pacsPortalUser.setAssociatedAreaId(userDetails.getStateId());
		}
		List<Priv> privList = pacsDao.getPrivbyRoleId(userDetails.getRoleId());
		for (Priv priv : privList) {
			pacsPortalUser.getUserRole().addPrivilege(PrivilegeEnum.getEnumByPrivilegeName(priv.getPriv()));
		}
		logger.debug("pacsPortalUser:" + pacsPortalUser);
		return pacsPortalUser;
	}
}
