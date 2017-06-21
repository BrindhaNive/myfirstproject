package com.epyloc.pacs.mappers;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ROIMapper {
	
	
	@Results({ 
	@Result(column = "RATE_OF_INTEREST") })
	
	@Select("Select RATE_OF_INTEREST from PACS.SCHEME_ROI_DTLS WHERE SCHEME_TYPE_ID= #{schemeTypeId}")
	String getROIDetails(Integer schemeTypeId);

}
