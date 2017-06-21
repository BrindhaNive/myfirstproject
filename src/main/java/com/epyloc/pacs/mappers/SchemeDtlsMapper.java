package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.epyloc.pacs.web.values.PrefixDet;
import com.epyloc.pacs.web.values.SchemeTypeDetails;

public interface SchemeDtlsMapper {
	
	@Results({ 
	@Result(property = "schTypId", column = "SCHEME_TYPE_ID"), 
	@Result(property = "acctTypId", column = "ACCT_TYPE_ID"), 
	@Result(property = "schemeCode", column = "SCHEME_TYPE_CODE"), 
	@Result(property = "schemeDesc", column = "SCHEME_TYPE_DESCRIPTION"),
	@Result(property = "processingType", column = "SCHEME_TYPE_PROC")})
	
	@Select("Select SCHEME_TYPE_ID,ACCT_TYPE_ID,SCHEME_TYPE_CODE,SCHEME_TYPE_DESCRIPTION,SCHEME_TYPE_PROC from PACS.SCHEME_TYPE")
	List<SchemeTypeDetails> getSchemeDetails();

	
	@Results({ 
		@Result(property = "prefixCode", column = "PREFIX_CODE"), 
		@Result(property = "accCounter", column = "ACCOUNT_COUNTER") })
	@Select("Select PREFIX_CODE,ACCOUNT_COUNTER from PACS.BANK_ACCT_PREFIX WHERE BANK_ID= #{bankid} AND SCHEME_TYPE_ID= #{schemeTypeId}")
	PrefixDet getPrefixCodeAcc(@Param("bankid") int bankid,@Param("schemeTypeId") int schemeTypeId);
	
	@Update("UPDATE PACS.BANK_ACCT_PREFIX SET ACCOUNT_COUNTER=#{accountCounter} WHERE BANK_ID= #{bankid} AND SCHEME_TYPE_ID= #{schemeTypeId}")
	void updatePrefixAccCounter(@Param("bankid") int bankid,@Param("schemeTypeId") int schemeTypeId, @Param("accountCounter") int accountCounter);
}
