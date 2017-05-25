package com.epyloc.pacs.mappers;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.UserDetails;

public interface UserDetailsMapper {
	@Results({
        @Result(property = "userId", column = "USER_ID"),
        @Result(property = "userStatus", column = "USER_STATUS"),
        @Result(property = "roleId", column = "ROLE_ID"),
        @Result(property = "bankId", column = "BANK_ID"),
        @Result(property = "talukId", column = "TALUK_ID"),
        @Result(property = "distId", column = "DIST_ID"),
        @Result(property = "stateId", column = "STATE_ID"),
        @Result(property = "firstName", column = "FIRST_NAME"),
        @Result(property = "lastName", column = "LAST_NAME")
      })	
	@Select("Select USER_ID,USER_STATUS,ROLE_ID,BANK_ID,TALUK_ID,DIST_ID,STATE_ID,FIRST_NAME,LAST_NAME  from PACS.BANK_USER BU, PACS.BANK_USER_CTC_DETAILS BUC where BU.USER_ID= BUC.BANK_USER_ID and BU.USER_NAME= #{username}")
	UserDetails userDetails(String username);

}
