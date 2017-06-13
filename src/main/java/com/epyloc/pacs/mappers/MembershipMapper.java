package com.epyloc.pacs.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.Category;
import com.epyloc.pacs.web.values.Gender;
import com.epyloc.pacs.web.values.MasterValueOptions;
import com.epyloc.pacs.web.values.MembershipType;
import com.epyloc.pacs.web.values.Occupation;
import com.epyloc.pacs.web.values.Religion;
import com.epyloc.pacs.web.values.Salutation;

public interface MembershipMapper {
	
	@Results({ 
		@Result(property = "memberTypeId", column = "MEMBER_TYPE_ID"), 
		@Result(property = "memberTypeDesc", column = "MEMBER_TYPE_DESC") })	
	@Select("SELECT MEMBER_TYPE_ID, MEMBER_TYPE_DESC FROM PACS.MEMBER_TYPE")
	@MapKey("memberTypeId")
	Map<Integer,MembershipType> fetchMemberTypes();
	
	@Results({ 
		@Result(property = "genderId", column = "GENDER_ID"), 
		@Result(property = "genderDesc", column = "GENDER_DESC") })	
	@Select("SELECT GENDER_ID, GENDER_DESC FROM PACS.GENDER")
	@MapKey("genderId")
	Map<Integer,Gender> fetchGenderTypes();
	
	@Results({ 
		@Result(property = "categoryId", column = "CATEGORY_ID"), 
		@Result(property = "categoryDesc", column = "CATEGORY_DESC") })	
	@Select("SELECT CATEGORY_ID, CATEGORY_DESC FROM PACS.CATEGORY")
	@MapKey("categoryId")
	Map<Integer,Category> fetchCategory();
	
	@Results({ 
		@Result(property = "occupationId", column = "OCCUPATION_ID"), 
		@Result(property = "occupationDesc", column = "OCCUPATION_DESC") })	
	@Select("SELECT OCCUPATION_ID, OCCUPATION_DESC FROM PACS.OCCUPATION")
	@MapKey("occupationId")
	Map<Integer,Occupation> fetchOccupation();
	
	@Results({ 
		@Result(property = "religionId", column = "RELIGION_ID"), 
		@Result(property = "religionDesc", column = "RELIGION_DESC") })	
	@Select("SELECT RELIGION_ID, RELIGION_DESC FROM PACS.RELIGION")
	@MapKey("religionId")
	Map<Integer,Religion> fetchReligion();
	
	@Results({ 
		@Result(property = "salutationId", column = "SALUTATION_ID"), 
		@Result(property = "salutationDesc", column = "SALUTATION_DESC") })	
	@Select("SELECT SALUTATION_ID, SALUTATION_DESC FROM PACS.SALUTATION")
	@MapKey("salutationId")
	Map<Integer,Salutation> fetchSalutation();
	
	
	@Results({ 
		@Result(property = "mstrValcode", column = "MSTR_REFER_VAL_CD"), 
		@Result(property = "mstrTypecode", column = "MSTR_REFER_TYPE_CD"), 
		@Result(property = "description", column = "MSTR_REFER_VAL_DS") })	
	@Lang(MybatisExtendedLanguageDriver.class)
	@Select("SELECT MSTR_REFER_TYPE_CD,MSTR_REFER_VAL_CD,MSTR_REFER_VAL_DS FROM PACS.MSTR_REFER_VAL WHERE MSTR_REFER_TYPE_CD IN (SELECT MSTR_REFER_TYPE_CD FROM PACS.MSTR_REFER_TYPE WHERE MSTR_REFER_TYPE_DS In (#{requiredFields}))")
	@MapKey("mstrValcode")
	Map<Integer,MasterValueOptions> fetchoptions(@Param("requiredFields") List<String> requiredFields);
	
	
	
	

}
