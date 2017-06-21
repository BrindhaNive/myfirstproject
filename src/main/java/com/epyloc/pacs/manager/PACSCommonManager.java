package com.epyloc.pacs.manager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epyloc.pacs.constants.FDTxnStatusEnum;
import com.epyloc.pacs.constants.FixedDepositStatusEnum;
import com.epyloc.pacs.constants.PACSConstant;
import com.epyloc.pacs.constants.PrivilegeEnum;
import com.epyloc.pacs.constants.RolesEnum;
import com.epyloc.pacs.dao.PACSDao;
import com.epyloc.pacs.util.CacheUtil;
import com.epyloc.pacs.util.CommonUtil;
import com.epyloc.pacs.util.FixedDepositCalculator;
import com.epyloc.pacs.web.commandform.FDCommandForm;
import com.epyloc.pacs.web.values.FDTxnDet;
import com.epyloc.pacs.web.values.FdMembershipDetails;
import com.epyloc.pacs.web.values.PACSPortalUser;
import com.epyloc.pacs.web.values.PrefixDet;
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
		pacsPortalUser.setBankUserStatusEnum(CacheUtil.getBankUserStatusEnumById(userDetails.getUserStatus()));
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

	public String getSchemeROIbyType(int schmeTypeID) {
		return pacsDao.getSchemeROIbyType(schmeTypeID);
	}

	public void persistFDDetails(FDCommandForm fdCommandForm, PACSPortalUser pacsPortalUser) {

		logger.debug("pacsDao:" + pacsDao);
		logger.debug("pacsPortalUser:" + pacsPortalUser);
		logger.debug("fdCommandForm:" + fdCommandForm);
		PrefixDet prefixDet = pacsDao.getPrefixCodeAcc(pacsPortalUser.getBankId(), fdCommandForm.getSelectedFdSchemeTypeId());
		fdCommandForm.setFdAccountId(prefixDet.getPrefixCode() + prefixDet.getAccCounter());
		int fdStatusId = CacheUtil.getFDStatusIdByEnum(FixedDepositStatusEnum.APPROVAL_PENDING);
		pacsDao.persistFDmaster(fdCommandForm, pacsPortalUser.getBankId(), pacsPortalUser.getUserId(), fdStatusId);
		pacsDao.persistFDNominee(fdCommandForm);
		int fdTxnStatId = CacheUtil.getFDTxnStatusIdByEnum(FDTxnStatusEnum.APPROVAL_PENDING);

		for (FDTxnDet txndtl : fdCommandForm.getFdTxnDet()) {
			pacsDao.persistFDtxnDtl(fdCommandForm.getFdId(), fdTxnStatId, txndtl);
		}
	}

	public void processFDTxnDetails(FDCommandForm fdCommandForm) {
		List<FDTxnDet> txnDtlList = null;
		try {
			String procType = CacheUtil.getProcTypeBySchemeTypID(fdCommandForm.getSelectedFdSchemeTypeId());
			logger.debug("procType:" + procType);
			DateFormat formatter = new SimpleDateFormat(PACSConstant.YYYY_MM_DD);
			Date effDepositDate;

			effDepositDate = formatter.parse(fdCommandForm.getDateOfDeposit());

			int daysperiod = CommonUtil.stringToInteger(fdCommandForm.getDaysPeriod());
			int monthsPeriod = CommonUtil.stringToInteger(fdCommandForm.getMonthsPeriod());
			float rateOfInt = CommonUtil.stringToFloat(fdCommandForm.getRateOfInterest());
			float principalAmt = CommonUtil.stringToFloat(fdCommandForm.getPrincipalAmt());

			Calendar effDepositCal = Calendar.getInstance();
			effDepositCal.setTime(effDepositDate);

			if (PACSConstant.FD_PROC_TYPE_MONTHLY.equals(procType)) {
				txnDtlList = FixedDepositCalculator.monthlyFDCalculator(effDepositCal, daysperiod, monthsPeriod, rateOfInt, principalAmt);
			} else if (PACSConstant.FD_PROC_TYPE_QUARTERLY.equals(procType)) {
				txnDtlList = FixedDepositCalculator.quaterlyFDCalculator(effDepositCal, daysperiod, monthsPeriod, rateOfInt, principalAmt);
			} else if (PACSConstant.FD_PROC_TYPE_REINVESTMENT.equals(procType)) {
				txnDtlList = FixedDepositCalculator.annualFDCalculator(effDepositCal, daysperiod, monthsPeriod, rateOfInt, principalAmt);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fdCommandForm.setFdTxnDet(txnDtlList);
	}

	public List<FdMembershipDetails> getMemSuggestions(String searchValue) {
		return pacsDao.getMemSuggestions(searchValue);

	}

}
