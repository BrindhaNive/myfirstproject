package com.epyloc.pacs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epyloc.pacs.mappers.PrivMapper;
import com.epyloc.pacs.mappers.UserDetailsMapper;
import com.epyloc.pacs.web.values.Priv;
import com.epyloc.pacs.web.values.UserDetails;

@Repository
public class PACSDao {

	@Autowired
	public SqlSessionFactory sessionFactory;

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

}
