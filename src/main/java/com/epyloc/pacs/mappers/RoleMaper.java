package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.Role;

public interface RoleMaper {
	
	
	@Results({ 
	@Result(property = "id", column = "ROLE_ID"), 
	@Result(property = "role", column = "ROLE_DESC") })
	
	@Select("Select ROLE_ID,ROLE_DESC from PACS.ROLE")
	List<Role> getRoleDetails();

}
