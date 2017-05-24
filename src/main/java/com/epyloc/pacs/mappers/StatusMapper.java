package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.cache.values.StatusTypeDetails;

public interface StatusMapper {
	@Results({
        @Result(property = "statusTypeId", column = "STAT_TYPE_ID"),
        @Result(property = "statusTypeDesc", column = "STAT_TYPE_DS"),
        @Result(property = "statusDetails.statusDetId", column = "STAT_DET_ID"),
		@Result(property = "statusDetails.statusDetDesc", column = "STAT_DET_DESC")

      })	
	@Select("SELECT ST.STATUS_ID AS STAT_TYPE_ID, ST.STATUS_DECRIPTION AS STAT_TYPE_DS, SD.STATUS_DET_ID AS STAT_DET_ID , SD.STATUS_DET_DESC  AS STAT_DET_DESC FROM PACS.STATUS_TYPE ST, PACS.STATUS_DETAILS SD where ST.STATUS_ID=SD.STATUS_ID")
	List<StatusTypeDetails> selectStatus();

}
