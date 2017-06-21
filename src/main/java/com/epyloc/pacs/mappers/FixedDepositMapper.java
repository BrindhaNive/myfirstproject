package com.epyloc.pacs.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.epyloc.pacs.web.values.FDTxnDet;
import com.epyloc.pacs.web.values.FdAmountDetails;
import com.epyloc.pacs.web.values.FdMembershipDetails;
import com.epyloc.pacs.web.values.FdNomineeDetails;

public interface FixedDepositMapper {
	@Insert("INSERT INTO PACS.FIXED_DEPOSIT_MASTER ( BANK_FD_ACCOUNT_ID, BANK_ID, MEMBERSHIP_ID, FD_AMOUNT, RATE_OF_INTEREST, FD_STATUS, EFF_DEPOSIT_DATE, DEPOSIT_DAYS, DEPOSIT_MONTH, MATURITY_DATE, MATURITY_AMOUNT, BANK_CREAT_USR_ID) VALUES (#{fdAmtDet.fdAccountId}, #{bankId}, #{fdmemDet.membershipId}, #{fdAmtDet.principalAmt}, #{fdAmtDet.rateOfInterest}, #{fdStatus}, #{fdAmtDet.dateOfDeposit}, #{fdAmtDet.daysPeriod}, #{fdAmtDet.monthsPeriod}, #{fdAmtDet.maturityDate}, #{fdAmtDet.maturityAmount}, #{bankUserID})")
	@Options(useGeneratedKeys = true, keyProperty = "fdAmtDet.fdId")
	int insertFDMaster(@Param("fdmemDet") FdMembershipDetails fdMembershipDetails, @Param("fdAmtDet") FdAmountDetails fdAmountDetails, @Param("bankId") int bankId, @Param("bankUserID") int bankUserID, @Param("fdStatus") int fdStatus);

	@Insert("INSERT INTO PACS.FD_NOMINEE_DETAILS (FD_ID, FIRST_NAME, LAST_NAME, RELATIONSHIP, ADDRESS_ONE, ADDRESS_TWO, CITY, STATE, PINCODE, AADHAR_ID) VALUES (#{fdId}, #{fdnominee.firstName},  #{fdnominee.lastName}, #{fdnominee.relationship}, #{fdnominee.addressOne}, #{fdnominee.addressTwo}, #{fdnominee.city}, #{fdnominee.state}, #{fdnominee.pincode}, #{fdnominee.aadharId})")
	int insertFDNominee(@Param("fdId") int fdId, @Param("fdnominee") FdNomineeDetails fdNomineeDetails);

	@Insert("INSERT INTO PACS.FIXED_DEPOSIT_TXN_DTLS (FD_ID, TXN_DT, TXN_TYPE, TXN_STATUS, INTEREST, AMOUNT, ACCUM_INT) VALUES (#{fdId}, #{fdTxnDet.dateOfIntMaturity}, #{fdTxnDet.fdTxnTypeEnum}, #{fdTxnStatus}, #{fdTxnDet.intAmount}, #{fdTxnDet.fdBalance}, #{fdTxnDet.intCapitalized})")
	@Options(useGeneratedKeys = true, keyProperty = "fdTxnDet.fdTxnId")
	int insertFDTxnDtls(@Param("fdId") int fdId, @Param("fdTxnStatus") int fdTxnStatus, @Param("fdTxnDet") FDTxnDet fdTxnDet);

	
	@Results({ 
		@Result(property = "membershipId", column = "MEMBERSHIP_ID"), 
		@Result(property = "membershipAcctNum", column = "MEMBERSHIP_NUMBER"), 
		@Result(property = "membershipName", column = "MEMBERSHIP_NAME")})
		@Select("SELECT MEMBERSHIP_ID,MEMBERSHIP_NUMBER,MEMBERSHIP_NAME FROM PACS.MEMBERSHIP_DETAILS where LOWER(MEMBERSHIP_NAME) like #{memName}")
		List<FdMembershipDetails> getMemSuggestions(@Param("memName")String memName);

}
