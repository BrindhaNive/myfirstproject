package com.epyloc.pacs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epyloc.pacs.cache.values.StatusTypeDetails;
import com.epyloc.pacs.mappers.RoleMaper;
import com.epyloc.pacs.mappers.StatusMapper;
import com.epyloc.pacs.web.values.Role;

@Repository
public class CacheDataAccessor {

	@Autowired
	public SqlSessionFactory sessionFactory;

	public List<StatusTypeDetails> getStatusMap() {
		StatusMapper maper = sessionFactory.openSession().getMapper(StatusMapper.class);
		return maper.selectStatus();
	}

	public List<Role> getRoleList() {
		RoleMaper maper = sessionFactory.openSession().getMapper(RoleMaper.class);
		return maper.getRoleDetails();
	}

}
