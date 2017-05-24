package com.epyloc.pacs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epyloc.pacs.cache.values.StatusTypeDetails;
import com.epyloc.pacs.mappers.StatusMapper;

@Repository
public class CacheDataAccessor {

	@Autowired
	public SqlSessionFactory sessionFactory;
	
	public List<StatusTypeDetails> getStatusMap() {
		SqlSession session = sessionFactory.openSession();
		StatusMapper maper = session.getMapper(StatusMapper.class);
		return maper.selectStatus();
	}

}
