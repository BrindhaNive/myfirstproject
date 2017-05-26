package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.SchemeTypeDetails;

public interface SchemeDtlsMapper {
	
	@Results({ 
	@Result(property = "schTypId", column = "SCHEME_TYPE_ID"), 
	@Result(property = "acctTypId", column = "ACCT_TYPE_ID"), 
	@Result(property = "schemeCode", column = "SCHEME_TYPE_CODE"), 
	@Result(property = "schemeDesc", column = "SCHEME_TYPE_DESCRIPTION") })
	
	@Select("Select SCHEME_TYPE_ID,ACCT_TYPE_ID,SCHEME_TYPE_CODE,SCHEME_TYPE_DESCRIPTION from PACS.SCHEME_TYPE")
	List<SchemeTypeDetails> getSchemeDetails();

}
