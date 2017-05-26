package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.AcctType;

public interface AcctTypeMapper {
	
	
	@Results({ 
	@Result(property = "id", column = "ACCT_TYPE_ID"), 
	@Result(property = "acctDesc", column = "ACCT_TYPE_DESC") })
	
	@Select("Select ACCT_TYPE_ID,ACCT_TYPE_DESC from PACS.ACCOUNT_TYPE")
	List<AcctType> getAcctTypeDetails();

}
