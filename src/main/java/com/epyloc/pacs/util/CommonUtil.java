package com.epyloc.pacs.util;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.epyloc.pacs.web.controller.FixedDepositController;

public class CommonUtil {

	private static final Logger logger = Logger.getLogger(FixedDepositController.class);

	public static String dateToString(Date date, String Format) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(Format);
			return formatter.format(date);
		} else {
			return null;
		}
	}

	public static String dateToEmptyString(Date date, String Format) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(Format);
			return formatter.format(date);
		} else {
			return " ";
		}
	}

	public static Date stringToDate(String dateString, String dateFormat) {
		Date date = null;
		try {
			if (dateString != null) {
				DateFormat formatter;
				formatter = new SimpleDateFormat(dateFormat);
				date = (Date) formatter.parse(dateString);
			}
		} catch (ParseException e) {
		}
		return date;
	}

	public static Date xmlGregorianCalToDate(XMLGregorianCalendar xmlGregCal) {
		Date date = null;
		if (xmlGregCal != null) {
			date = xmlGregCal.toGregorianCalendar().getTime();
		}
		return date;
	}

	public static XMLGregorianCalendar dateToXMLGregorianCal(Date date) {
		if (date == null) {

			return null;
		} else {
			try {
				DatatypeFactory df = DatatypeFactory.newInstance();
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(date.getTime());
				return df.newXMLGregorianCalendar(gc);
			} catch (Exception e) {
				logger.info("Exception while converting date to xmlGregorianCalendar");
				return null;
			}
		}
	}

	public static boolean isEmpty(String str) {
		return StringUtils.isBlank(str);
	}

	public static boolean isStringEmptyorStringNull(String str) {
		if (StringUtils.isBlank(str) || "null".equals(str)) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Collection coll) {
		return (coll == null || coll.isEmpty());
	}

	public static boolean isAlphaMandatory(String str) {
		if (StringUtils.isBlank(str) || !StringUtils.isAlpha(str)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isAlphaSpaceBlankMandatory(String str) {
		if (StringUtils.isBlank(str) || !StringUtils.isAlphaSpace(str)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isAlphaNumericMandatory(String str) {
		if (StringUtils.isBlank(str) || !StringUtils.isAlphanumeric(str)) {
			return false;
		}
		return true;
	}

	public static String trim(String comment, int maxLength) {
		if (comment != null && !comment.isEmpty() && comment.length() > maxLength) {
			comment = comment.substring(0, maxLength);
		}
		return comment;
	}

	public static String toLower(String strValue) {
		if (strValue != null) {
			strValue = strValue.toLowerCase();
		}
		return strValue;
	}

	public static Integer stringToInteger(String value) {
		Integer strValue = null;
		if (!isEmpty(value)) {
			strValue = Integer.parseInt(value);
		}
		return strValue;
	}

	public static Float stringToFloat(String value) {
		Float strValue = null;
		if (!isEmpty(value)) {
			strValue = Float.parseFloat(value);
		}
		return strValue;
	}
	public static String utf8truncate(String input, int length) {
		if (input != null) {
			return StringUtils.left(input, length);
		} else {
			return null;
		}
	}

	public static boolean isNumeric(String str) {
		if (str != null) {
			return StringUtils.isNumeric(str);
		}
		return true;
	}

	public static boolean isNumericMandatory(String str) {
		if (!StringUtils.isEmpty(str)) {
			return StringUtils.isNumeric(str);
		}
		return false;
	}

	public static boolean isAlphaOptional(String str) {
		if (!StringUtils.isBlank(str) && !StringUtils.isAlpha(str)) {
			return false;
		}
		return true;
	}

	public static boolean isAlphaSpaceOptional(String str) {
		if (!StringUtils.isBlank(str) && !StringUtils.isAlphaSpace(str)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isAlphaNumericSpaceMandatory(String str) {
		if (StringUtils.isBlank(str) || !StringUtils.isAlphanumericSpace(str)) {
			return false;
		} else {
			return true;
		}
	}

	public static String removeLastCharFromString(String stringValue) {
		return stringValue.substring(0, stringValue.length() - 1);
	}

	public static String removeLastCharFromStringBuffer(StringBuffer stringValue) {
		return stringValue.substring(0, stringValue.length() - 1);
	}

	public static String removeLastCharFromStringBuilder(StringBuilder stringValue) {
		return stringValue.substring(0, stringValue.length() - 1);
	}

	public static boolean checkLength(String str, int length) {
		if (str != null) {
			if (str.length() <= length) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public static Calendar resetTime(Calendar timeStamp, int hour, int minutes, int seconds) {
		Calendar resetDate = Calendar.getInstance();
		resetDate = timeStamp;
		resetDate.set(Calendar.HOUR_OF_DAY, hour);
		resetDate.set(Calendar.MINUTE, minutes);
		resetDate.set(Calendar.SECOND, seconds);
		return timeStamp;

	}

	public static void getEntryMethod() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String methodName = stackTraceElements[3].getMethodName();
		String className = stackTraceElements[3].getClassName();
		logger.debug("Entering method: " + methodName + " of Class: " + className);
	}

	public static void getExitMethod() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String methodName = stackTraceElements[3].getMethodName();
		String className = stackTraceElements[3].getClassName();
		logger.debug("Exiting method: " + methodName + " of Class: " + className);
	}

	public static boolean validateRegexMandatory(String regex, String value) {
		if (!StringUtils.isBlank(value)) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return false;
	}

	public static boolean validateRegexOptional(String regex, String value) {
		if (!StringUtils.isBlank(value)) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
		return true;
	}

	final static Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	public static boolean validateEmailAddress(String str) {
		boolean tmp = false;
		if (str != null) {
			final Matcher matcher = emailPattern.matcher(str);
			tmp = matcher.matches();
		}
		return tmp;
	}

	public static boolean isNumberChar(String text) {
		boolean ret = false;
		for (int i = 0; i < text.length(); i++) {
			int c = text.charAt(i);
			if ((48 <= c) && (c <= 57)) {
				ret = true;
				break;
			}
			ret = false;
		}
		return ret;
	}

	public static Date getSLAExpiredDate(int slaDays, int hoursToAdd, int minsToAdd) {
		Calendar cal = Calendar.getInstance();

		TimeZone z = cal.getTimeZone();
		int offset = z.getRawOffset();
		if (z.inDaylightTime(new Date())) {
			offset = offset + z.getDSTSavings();
		}
		int offsetHrs = offset / 1000 / 60 / 60;
		int offsetMins = offset / 1000 / 60 % 60;

		cal.add(Calendar.HOUR_OF_DAY, (-offsetHrs));
		cal.add(Calendar.MINUTE, (-offsetMins));
		cal.add(Calendar.HOUR_OF_DAY, hoursToAdd);
		cal.add(Calendar.MINUTE, minsToAdd);
		cal.add(Calendar.DATE, slaDays);

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static Double stringToDouble(String value) {
		Double dblValue = null;
		if (value != null && !value.isEmpty()) {
			dblValue = Double.parseDouble(value);
		}
		return dblValue;
	}

	public static Long stringToLong(String value) {
		Long dblValue = null;
		try {
			dblValue = Long.parseLong(value);
		} catch (Exception e) {
		}
		return dblValue;
	}

	public static void logRequestValue(HttpServletRequest request) {

		try {
			String tempName = null;
			Enumeration tempEnum = request.getHeaderNames();
			while (tempEnum.hasMoreElements()) {
				tempName = String.valueOf(tempEnum.nextElement());
				logger.debug("Header: " + tempName + " - Value: " + request.getHeader(tempName));
			}
			tempEnum = request.getAttributeNames();
			while (tempEnum.hasMoreElements()) {
				tempName = String.valueOf(tempEnum.nextElement());
				if (tempName.contains("ConversionService")) {
					continue;
				}
				logger.debug("Attribute: " + tempName + " - Value: " + request.getAttribute(tempName));
			}
			tempEnum = request.getParameterNames();
			while (tempEnum.hasMoreElements()) {
				tempName = String.valueOf(tempEnum.nextElement());
				logger.debug("Parameter: " + tempName + " - Value: " + request.getParameter(tempName));
			}
			for (Cookie c : request.getCookies()) {
				logger.debug("Cookie Name: " + c.getName() + " - Value: " + c.getValue());
			}
		} catch (Exception e) {
		}

	}

	public static void logSessionValues(HttpSession session) {
		try {
			Enumeration sessEnums = session.getAttributeNames();
			String tempName;
			while (sessEnums.hasMoreElements()) {
				tempName = sessEnums.nextElement().toString();
				logger.debug("Attribute: " + tempName + " - Value: " + session.getAttribute(tempName));
			}
		} catch (Exception e) {
		}
	}

	public static String getCookieValue(HttpServletRequest aobjRequest, String cookieName) {

		if (aobjRequest.getCookies() == null) {
			logger.debug("cookieName " + cookieName);
			logger.debug("Cookie name is null or request cookies null, returning null...");
			return null;
		}
		for (Cookie cookie : aobjRequest.getCookies()) {
			if (cookie.getName().equals(cookieName)) {
				logger.debug("Cookie value [" + cookie.getName() + "]: " + cookie.getValue());
				logger.debug("Exiting method");
				return cookie.getValue();
			}
		}
		return null;
	}

	public static Date getFromDate(String date, String format) {
		Date fromDate = null;
		if (!CommonUtil.isEmpty(date)) {
			Date convDate = stringToDate(date, format);
			Calendar cal = Calendar.getInstance();
			cal.setTime(convDate);
			cal.set(Calendar.HOUR_OF_DAY, 00);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			cal.set(Calendar.MILLISECOND, 000);
			fromDate = cal.getTime();
		}
		return fromDate;
	}

	public static Date getToDate(String date, String format) {
		Date toDate = null;
		if (!CommonUtil.isEmpty(date)) {
			Date convDate = stringToDate(date, format);
			Calendar cal = Calendar.getInstance();

			cal.setTime(convDate);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
			toDate = cal.getTime();
		}
		return toDate;
	}

	private static ExecutorService executorService = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {

		public synchronized Thread newThread(Runnable r) {
			return new Thread(r, "FPCAsyncThread");
		}
	});

	public static Future executeAsynchronous(Callable callable) {
		return executorService.submit(callable);
	}

	public static void executeAsynchronous(Runnable runnable) {
		executorService.execute(runnable);
	}

	public static ExecutorService getExecutorService() {
		return executorService;
	}

	public static Integer objToInt(Object param, Integer defVal) {
		Integer retVal = defVal;
		try {
			retVal = Integer.parseInt(StringUtils.trim(String.valueOf(param)));
		} catch (NumberFormatException e) {

		}
		return retVal;
	}

	public static int bigDecimalToInt(BigDecimal bigDecimal) {
		int intVal = 0;
		if (null != bigDecimal) {
			intVal = bigDecimal.intValue();
		}
		return intVal;
	}

	public static String bigDecimalToString(BigDecimal bigDecimal) {
		String strVal = null;
		if (null != bigDecimal) {
			strVal = bigDecimal.toString();
		}
		return strVal;
	}

	public static long bigDecimalToLong(BigDecimal bigDecimal) {
		if (null != bigDecimal) {
			return bigDecimal.longValue();
		}
		return 0;
	}

	public static boolean isLocalURL(String serverURL) {
		boolean retVal = false;
		InetAddress address;
		try {
			int temp = serverURL.lastIndexOf(":");
			serverURL = serverURL.substring(serverURL.indexOf("//") + 2, temp);
			address = InetAddress.getLocalHost();
			if ("localhost".equalsIgnoreCase(serverURL) || serverURL.equalsIgnoreCase(address.getHostAddress()) || serverURL.equalsIgnoreCase(address.getHostName()) || serverURL.equalsIgnoreCase(address.getCanonicalHostName())) {
				retVal = true;
			}
		} catch (UnknownHostException e) {
			logger.error("UnknownHostException ", e);
		} catch (Exception e) {
			logger.error("MalformedURLException ", e);
		}
		return retVal;
	}

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	public static void logMemoryDetails() {
		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		logger.debug("Total Memory " + bytesToMegabytes(runtime.totalMemory()));
		logger.debug("Free Memory " + bytesToMegabytes(runtime.freeMemory()));
		logger.debug("Used Memory  " + bytesToMegabytes(memory));
	}

	public static void burstMemory() {
		try {
			final SoftReference allocated = new SoftReference(new LinkedList());
			boolean finished = false;

			while (!finished) {
				byte[] data = new byte[10 * 1000 * 1000];
				List tmp = (List) allocated.get();
				if (tmp != null) {
					tmp.add(data);
					logger.debug("reference is added current list size " + tmp.size());
					CommonUtil.logMemoryDetails();

				} else {
					logger.debug("reference has been collected, finishing");
					finished = true;
					CommonUtil.logMemoryDetails();
				}
			}
		} catch (OutOfMemoryError t) {
			logger.debug("out of memory reached, releasing memory");
		}

	}

	public static Calendar currentTimeinIST() {
		TimeZone timeZone = TimeZone.getTimeZone("IST");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		format.setTimeZone(timeZone);
		Calendar currentISTTime = new GregorianCalendar();
		currentISTTime.setTime(CommonUtil.stringToDate(format.format(new Date()), "yyyy-MM-dd HH:mm:ss.SSSSSS"));
		return currentISTTime;
	}

}
