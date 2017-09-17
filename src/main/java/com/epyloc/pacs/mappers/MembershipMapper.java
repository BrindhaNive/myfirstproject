package com.epyloc.pacs.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.commandform.AddMemberCommandForm;
import com.epyloc.pacs.web.values.MasterValueOptions;

public interface MembershipMapper {

	@Results({ @Result(property = "mstrValcode", column = "MSTR_REFER_VAL_CD"), @Result(property = "mstrTypecode", column = "MSTR_REFER_TYPE_CD"), @Result(property = "description", column = "MSTR_REFER_VAL_DS") })
	@Lang(MybatisExtendedLanguageDriver.class)
	@Select("SELECT MSTR_REFER_TYPE_CD,MSTR_REFER_VAL_CD,MSTR_REFER_VAL_DS FROM PACS.MSTR_REFER_VAL WHERE MSTR_REFER_TYPE_CD IN (SELECT MSTR_REFER_TYPE_CD FROM PACS.MSTR_REFER_TYPE WHERE MSTR_REFER_TYPE_DS In (#{requiredFields}))")
	@MapKey("mstrValcode")
	Map<Integer, MasterValueOptions> fetchoptions(@Param("requiredFields") List<String> requiredFields);

	@Insert("INSERT INTO PACS.MEMBERSHIP_DETAILS (MEMBERSHIP_NUMBER, MEMBERSHIP_TYPE, SALUTATION, MEMBERSHIP_NAME, MEMBERSHIP_SURNAME, GENDER, FATHER_NAME, HUSBAND_NAME, DATE_OF_BIRTH, STAFF, EMPLOYEE_NUMBER, SENIOR_CITIZEN, OCCUPATION, RELIGION, CATEGORY, ACRES, TYPE_OF_FARMER, SHARE_AMT, SHARE_TYPE, SENIOR_CITIZEN_PROOF) VALUES (#{membershipId,jdbcType=INTEGER},#{membershipType,jdbcType=INTEGER},#{salutation,jdbcType=INTEGER},#{memberName,jdbcType=VARCHAR},#{surName,jdbcType=VARCHAR},#{gender,jdbcType=INTEGER},#{fatherName,jdbcType=VARCHAR},#{husbandName,jdbcType=VARCHAR},#{dateOfBirth,jdbcType=DATE},#{staff,jdbcType=INTEGER},#{employeeNumber,jdbcType=VARCHAR},#{seniorCitizen,jdbcType=INTEGER},#{occupation,jdbcType=INTEGER},#{religion,jdbcType=INTEGER},#{category,jdbcType=INTEGER},#{acres,jdbcType=DECIMAL},#{typeOfFarmer,jdbcType=INTEGER},#{shareAmt,jdbcType=DECIMAL},#{shareType,jdbcType=INTEGER},#{seniorCitizenProof,jdbcType=INTEGER})")
	@Options(useGeneratedKeys = true, keyProperty = "generatedId", keyColumn = "MEMBERSHIP_ID")
	void insertMembershipdetails(AddMemberCommandForm addMemberCommandForm) throws Exception;
}
