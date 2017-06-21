package com.epyloc.pacs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epyloc.pacs.cache.values.StatusTypeDetails;
import com.epyloc.pacs.mappers.AcctTypeMapper;
import com.epyloc.pacs.mappers.RoleMaper;
import com.epyloc.pacs.mappers.SchemeDtlsMapper;
import com.epyloc.pacs.mappers.StatusMapper;
import com.epyloc.pacs.web.values.AcctType;
import com.epyloc.pacs.web.values.Role;
import com.epyloc.pacs.web.values.SchemeTypeDetails;

@Repository
public class CacheDataAccessor {

	@Autowired
	public SqlSessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(CacheDataAccessor.class);

	public SqlSessionTemplate getsessionTemplate() {
		try {
			return new SqlSessionTemplate(sessionFactory);
		} catch (Exception e) {
			logger.error("Error during SQL session creation:", e);
		}
		return null;
	}

	public List<StatusTypeDetails> getStatusMap() {
		StatusMapper maper = getsessionTemplate().getMapper(StatusMapper.class);
		return maper.selectStatus();
	}

	public List<Role> getRoleList() {
		RoleMaper maper = getsessionTemplate().getMapper(RoleMaper.class);
		return maper.getRoleDetails();
	}

	public List<SchemeTypeDetails> getSchemeDtls() {
		SchemeDtlsMapper maper = getsessionTemplate().getMapper(SchemeDtlsMapper.class);
		return maper.getSchemeDetails();
	}

	public List<AcctType> getAcctTypeDtls() {
		AcctTypeMapper maper = getsessionTemplate().getMapper(AcctTypeMapper.class);
		return maper.getAcctTypeDetails();
	}
}
