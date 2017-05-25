package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.Priv;

public interface PrivMapper {

	@Results({ 
		@Result(property = "id", column = "PRIV_ID"), 
		@Result(property = "priv", column = "PRIV_DESC") })

	@Select("Select RP.PRIV_ID,P.PRIV_DESC from PACS.PRIV P,PACS.ROLE_PRIV RP where P.PRIV_ID=RP.PRIV_ID AND RP.ROLE_ID = #{roleId}")
	List<Priv> getPrivDetails(int roleId);

}
