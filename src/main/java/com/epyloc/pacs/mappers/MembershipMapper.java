package com.epyloc.pacs.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.MasterValueOptions;

public interface MembershipMapper {

	@Results({ @Result(property = "mstrValcode", column = "MSTR_REFER_VAL_CD"), @Result(property = "mstrTypecode", column = "MSTR_REFER_TYPE_CD"), @Result(property = "description", column = "MSTR_REFER_VAL_DS") })
	@Lang(MybatisExtendedLanguageDriver.class)
	@Select("SELECT MSTR_REFER_TYPE_CD,MSTR_REFER_VAL_CD,MSTR_REFER_VAL_DS FROM PACS.MSTR_REFER_VAL WHERE MSTR_REFER_TYPE_CD IN (SELECT MSTR_REFER_TYPE_CD FROM PACS.MSTR_REFER_TYPE WHERE MSTR_REFER_TYPE_DS In (#{requiredFields}))")
	@MapKey("mstrValcode")
	Map<Integer, MasterValueOptions> fetchoptions(@Param("requiredFields") List<String> requiredFields);

}
