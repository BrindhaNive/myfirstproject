package com.epyloc.pacs.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.epyloc.pacs.constants.TxnTypeEnum;
import com.epyloc.pacs.web.values.FDTxnDet;

public class FixedDepositCalculator {

	public static float roundFloatValue(float value) {
		return (float) (Math.round(value * 100.0) / 100.0);
	}

	public static float getMonthlyFDvalue(int noOfDaysinMonth, float rateOfInt, int totalFDDays, float fdPrincipal) {
		float fdVal = (noOfDaysinMonth * rateOfInt * fdPrincipal) / (totalFDDays * 100);
		return (float) (Math.round(fdVal * 100.0) / 100.0);
	}

	public static int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static List<FDTxnDet> monthlyFDCalculator(Calendar effDepositDate, int noOfDays, int noOfMonths, float rateOfInt, float fdPrincipal) {

		Calendar maturityDate = (Calendar) effDepositDate.clone();
		maturityDate.add(Calendar.DAY_OF_YEAR, noOfDays);
		maturityDate.add(Calendar.MONTH, noOfMonths);
		System.out.println("effDepositDate:" + effDepositDate.getTime());
		System.out.println("maturityDate:" + maturityDate.getTime());

		float totIntAmount = 0;

		int totFDDays = daysBetween(effDepositDate.getTime(), maturityDate.getTime());
		int totDaysCalc = 0;
		// First month interest
		List<FDTxnDet> fdTxnDetList = new ArrayList<FDTxnDet>();

		int totalMonths = differenceInMonths(effDepositDate, maturityDate) + 1;
		Calendar currentMonth = (Calendar) effDepositDate.clone();
		for (int month = 1; month <= totalMonths; month++) {

			int daysinCurMon = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

			Calendar dateofIntMat = (Calendar) currentMonth.clone();
			dateofIntMat.set(Calendar.DAY_OF_MONTH, currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH));

			if (month == 1) {
				daysinCurMon = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH) - currentMonth.get(Calendar.DAY_OF_MONTH);
			} else if (month == totalMonths) {
				daysinCurMon = maturityDate.get(Calendar.DAY_OF_MONTH);
				dateofIntMat = maturityDate;
			}
			totDaysCalc += daysinCurMon;
			float monIntAmt = getMonthlyFDvalue(daysinCurMon, rateOfInt, totFDDays, fdPrincipal);
			if (monIntAmt != 0) {
				fdTxnDetList.add(new FDTxnDet(dateofIntMat.getTime(), monIntAmt, 0, monIntAmt + fdPrincipal, TxnTypeEnum.FD_INT_CREDIT));
				fdTxnDetList.add(new FDTxnDet(dateofIntMat.getTime(), monIntAmt, 0, fdPrincipal, TxnTypeEnum.FD_INT_DEBIT));
			}
			totIntAmount = totIntAmount + monIntAmt;
			currentMonth.add(Calendar.MONTH, 1);

		}

		System.out.println("fdTxnDetList:" + fdTxnDetList);
		System.out.println("totIntAmount:" + totIntAmount);
		System.out.println("totFDDays:" + totFDDays);
		System.out.println("totDaysCalc:" + totDaysCalc);

		return fdTxnDetList;
	}

	public static List<FDTxnDet> quaterlyFDCalculator(Calendar effDepositDate, int noOfDays, int noOfMonths, float rateOfInt, float fdPrincipal) {

		Calendar maturityDate = (Calendar) effDepositDate.clone();
		maturityDate.add(Calendar.DAY_OF_YEAR, noOfDays);
		maturityDate.add(Calendar.MONTH, noOfMonths);
		System.out.println("effDepositDate:" + effDepositDate.getTime());
		System.out.println("maturityDate:" + maturityDate.getTime());

		float totIntAmount = 0;
		float quartIntAmount = 0;

		int totFDDays = daysBetween(effDepositDate.getTime(), maturityDate.getTime());
		int totDaysCalc = 0;
		// First month interest
		List<FDTxnDet> fdTxnDetList = new ArrayList<FDTxnDet>();

		int totalMonths = differenceInMonths(effDepositDate, maturityDate) + 1;
		Calendar currentMonth = (Calendar) effDepositDate.clone();
		for (int month = 1; month <= totalMonths; month++) {
			float monIntAmt = 0;
			Calendar dateofIntMat = (Calendar) currentMonth.clone();
			dateofIntMat.set(Calendar.DAY_OF_MONTH, currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
			int daysinCurMon = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (month == 1) {
				daysinCurMon = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH) - currentMonth.get(Calendar.DAY_OF_MONTH);
			} else if (month == totalMonths) {
				daysinCurMon = maturityDate.get(Calendar.DAY_OF_MONTH);
				dateofIntMat = maturityDate;
			}
			totDaysCalc += daysinCurMon;
			monIntAmt = getMonthlyFDvalue(daysinCurMon, rateOfInt, totFDDays, fdPrincipal);
			quartIntAmount += monIntAmt;

			if (monIntAmt != 0)
				fdTxnDetList.add(new FDTxnDet(dateofIntMat.getTime(), monIntAmt, roundFloatValue(quartIntAmount), roundFloatValue(quartIntAmount + fdPrincipal), TxnTypeEnum.FD_INT_CREDIT));
			if ((month % 4 == 0 && monIntAmt != 0) || month == totalMonths) {
				float txnAmount = roundFloatValue(quartIntAmount);
				if (month == totalMonths) {
					txnAmount = roundFloatValue(quartIntAmount + fdPrincipal);
				}
				fdTxnDetList.add(new FDTxnDet(dateofIntMat.getTime(), roundFloatValue(quartIntAmount), roundFloatValue(quartIntAmount), txnAmount, TxnTypeEnum.FD_INT_DEBIT));
				quartIntAmount = 0;
			}
			totIntAmount = totIntAmount + monIntAmt;
			currentMonth.add(Calendar.MONTH, 1);

		}

		System.out.println("fdTxnDetList:" + fdTxnDetList);
		System.out.println("totIntAmount:" + totIntAmount);
		System.out.println("totFDDays:" + totFDDays);
		System.out.println("totDaysCalc:" + totDaysCalc);

		return fdTxnDetList;
	}

	public static List<FDTxnDet> annualFDCalculator(Calendar effDepositDate, int noOfDays, int noOfMonths, float rateOfInt, float fdPrincipal) {

		Calendar maturityDate = (Calendar) effDepositDate.clone();
		maturityDate.add(Calendar.DAY_OF_YEAR, noOfDays);
		maturityDate.add(Calendar.MONTH, noOfMonths);
		System.out.println("effDepositDate:" + effDepositDate.getTime());
		System.out.println("maturityDate:" + maturityDate.getTime());

		float totIntAmount = 0;

		int totFDDays = daysBetween(effDepositDate.getTime(), maturityDate.getTime());
		int totDaysCalc = 0;
		// First month interest
		List<FDTxnDet> fdTxnDetList = new ArrayList<FDTxnDet>();

		int totalMonths = differenceInMonths(effDepositDate, maturityDate) + 1;
		Calendar currentMonth = (Calendar) effDepositDate.clone();
		for (int month = 1; month <= totalMonths; month++) {
			float monIntAmt = 0;
			Calendar dateofIntMat = (Calendar) currentMonth.clone();
			dateofIntMat.set(Calendar.DAY_OF_MONTH, currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
			int daysinCurMon = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (month == 1) {
				daysinCurMon = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH) - currentMonth.get(Calendar.DAY_OF_MONTH);
			} else if (month == totalMonths) {
				daysinCurMon = maturityDate.get(Calendar.DAY_OF_MONTH);
				dateofIntMat = maturityDate;
			}
			totDaysCalc += daysinCurMon;
			monIntAmt = getMonthlyFDvalue(daysinCurMon, rateOfInt, totFDDays, fdPrincipal);
			totIntAmount = totIntAmount + monIntAmt;
			if (monIntAmt != 0)
				fdTxnDetList.add(new FDTxnDet(dateofIntMat.getTime(), monIntAmt, roundFloatValue(totIntAmount), roundFloatValue(totIntAmount + fdPrincipal), TxnTypeEnum.FD_INT_CREDIT));
			if (month == totalMonths) {
				fdTxnDetList.add(new FDTxnDet(dateofIntMat.getTime(), roundFloatValue(totIntAmount), roundFloatValue(totIntAmount), roundFloatValue(fdPrincipal + totIntAmount), TxnTypeEnum.FD_INT_DEBIT));
			}

			currentMonth.add(Calendar.MONTH, 1);

		}

		System.out.println("fdTxnDetList:" + fdTxnDetList);
		System.out.println("totIntAmount:" + totIntAmount);
		System.out.println("totFDDays:" + totFDDays);
		System.out.println("totDaysCalc:" + totDaysCalc);

		return fdTxnDetList;
	}

	private static Integer differenceInMonths(Calendar beginningDate, Calendar endingDate) {
		if (beginningDate == null || endingDate == null) {
			return 0;
		}
		int m1 = beginningDate.get(Calendar.YEAR) * 12 + beginningDate.get(Calendar.MONTH);
		int m2 = endingDate.get(Calendar.YEAR) * 12 + endingDate.get(Calendar.MONTH);
		return m2 - m1;
	}

	public static void main(String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// cal.set(Calendar.DAY_OF_MONTH, 30);
		List<FDTxnDet> list = quaterlyFDCalculator(cal, 0, 12, (float) 9.5, 50000);
		// List<FDTxnDet> list = annualFDCalculator(cal, 0, 12, (float) 9.5, 50000);
		System.out.println("List:" + list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("jsonInString:" + jsonInString);

		/*
		 * String testsDate = "17-Jun-2019"; String testDate = "17-Jun-2020"; DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); Date date = formatter.parse(testDate); Date sdate = formatter.parse(testsDate); Calendar cals =
		 * Calendar.getInstance(); cals.setTime(sdate); Calendar cale = Calendar.getInstance(); cale.setTime(date); System.out.println("Diff in Mont:" + differenceInMonths(cals, cale));
		 */

	}

}
