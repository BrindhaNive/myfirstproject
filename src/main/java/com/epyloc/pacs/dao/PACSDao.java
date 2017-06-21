package com.epyloc.pacs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epyloc.pacs.mappers.FixedDepositMapper;
import com.epyloc.pacs.mappers.PrivMapper;
import com.epyloc.pacs.mappers.ROIMapper;
import com.epyloc.pacs.mappers.SchemeDtlsMapper;
import com.epyloc.pacs.mappers.UserDetailsMapper;
import com.epyloc.pacs.util.CommonUtil;
import com.epyloc.pacs.web.commandform.FDCommandForm;
import com.epyloc.pacs.web.values.FDTxnDet;
import com.epyloc.pacs.web.values.FdMembershipDetails;
import com.epyloc.pacs.web.values.PrefixDet;
import com.epyloc.pacs.web.values.Priv;
import com.epyloc.pacs.web.values.UserDetails;

@Repository
public class PACSDao {

	@Autowired
	public SqlSessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(PACSDao.class);

	public UserDetails getUserDetails(String username) {
		SqlSession session = sessionFactory.openSession();
		UserDetailsMapper maper = session.getMapper(UserDetailsMapper.class);
		return maper.userDetails(username);
	}

	public List<Priv> getPrivbyRoleId(int roleId) {
		SqlSession session = sessionFactory.openSession();
		PrivMapper maper = session.getMapper(PrivMapper.class);
		return maper.getPrivDetails(roleId);
	}

	public String getSchemeROIbyType(int schmeTypeID) {
		SqlSession session = sessionFactory.openSession();
		ROIMapper maper = session.getMapper(ROIMapper.class);
		return maper.getROIDetails(schmeTypeID);
	}

	public synchronized PrefixDet getPrefixCodeAcc(int bankid, int schemeTypeId) {
		logger.debug("Inside get prefix");
		logger.debug("bankid:" + bankid);
		logger.debug("schemeTypeId:" + schemeTypeId);
		SqlSession session = sessionFactory.openSession();
		SchemeDtlsMapper maper = session.getMapper(SchemeDtlsMapper.class);
		PrefixDet prefixDet = maper.getPrefixCodeAcc(bankid, schemeTypeId);
		logger.debug("prefixDet:" + prefixDet.getPrefixCode());
		logger.debug("prefixDet:" + prefixDet.getAccCounter());
		if (null != prefixDet && !CommonUtil.isEmpty(prefixDet.getPrefixCode())) {
			prefixDet.setAccCounter(prefixDet.getAccCounter() + 1);
			maper.updatePrefixAccCounter(bankid, schemeTypeId, prefixDet.getAccCounter());
			return prefixDet;
		}
		return null;
	}

	public Integer persistFDmaster(FDCommandForm fdCommandForm, int bankid, int bankUserID, int fdStatus) {
		Integer persistId = null;
		try {
			SqlSession session = sessionFactory.openSession();
			FixedDepositMapper maper = session.getMapper(FixedDepositMapper.class);
			persistId = maper.insertFDMaster(fdCommandForm.getFdMembershipDetails(), fdCommandForm.getFdAmountDetails(), bankid, bankUserID, fdStatus);
			logger.debug("FD_ID:" + fdCommandForm.getFdId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error during persist:", e);
		}
		return persistId;
	}

	public Integer persistFDNominee(FDCommandForm fdCommandForm) {
		Integer persistId = null;
		try {
			SqlSession session = sessionFactory.openSession();
			FixedDepositMapper maper = session.getMapper(FixedDepositMapper.class);
			persistId = maper.insertFDNominee(fdCommandForm.getFdId(), fdCommandForm.getFdNomineeDetails());
			logger.debug("FD_ID:" + fdCommandForm.getFdAmountDetails().getFdId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error during persist:", e);
		}
		return persistId;
	}

	public Integer persistFDtxnDtl(int fdID, int fdTxnStatus, FDTxnDet fdTxnDet) {
		Integer persistID = null;
		try {
			SqlSession session = sessionFactory.openSession();
			FixedDepositMapper maper = session.getMapper(FixedDepositMapper.class);
			persistID = maper.insertFDTxnDtls(fdID, fdTxnStatus, fdTxnDet);
			logger.debug("FD_TXN_ID:" + fdTxnDet.getFdTxnId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error during persist:", e);
		}
		return persistID;
	}

	public List<FdMembershipDetails> getMemSuggestions(String searchValue) {
		SqlSession session = sessionFactory.openSession();
		FixedDepositMapper maper = session.getMapper(FixedDepositMapper.class);
		logger.debug("searchValue b:"+searchValue);
		searchValue="%"+searchValue+"%";
		logger.debug("searchValue a:"+searchValue);
		return maper.getMemSuggestions(searchValue);
	}

}
