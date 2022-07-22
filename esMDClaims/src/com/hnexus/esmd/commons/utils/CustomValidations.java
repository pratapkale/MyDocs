/**
 * 
 */
package com.hnexus.esmd.commons.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author user
 * 
 */
public class CustomValidations {
	
	private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$";
	private static final String STRCONSTANT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.-";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9]+)*@" + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static boolean isInteger(String value) {
		value = value.trim();
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean emailValidation(final String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}

	public static boolean isNotNull(final String string) {
		return string != null && !string.isEmpty() && !string.trim().isEmpty();
	}

	public static boolean isBlankOrNull(Object object) {
		return isBlankOrNull(object, true);
	}

	public static boolean isBlankOrNull(Object object, boolean trim) {
		boolean result = false;
		if (object == null) {
			result = true;
		} else if ((object instanceof String)) {
			String string = (String) object;
			if (trim) {
				string = string.trim();
			}

			result = string.length() == 0;
		}

		return result;
	}

	public static boolean equals(Object object1, Object object2) {
		return (object1 == object2)
				|| ((object1 != null) && (object1.equals(object2)));
	}

	public static boolean isEmail(String address) {
		boolean result = true;
		try {
			InternetAddress[] addresses = InternetAddress.parse(address);
			if (addresses.length > 1) {
				result = false;
			} else
				result = hasNameAndDomain(address);
		} catch (AddressException e) {
			result = false;
		}
		return result;
	}

	private static boolean hasNameAndDomain(String address) {
		int index = address.indexOf('@');

		return (index >= 0) && (index < address.length() - 1);
	}
	
	public static String getRandomString(int length) {
		Random rand = new Random(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= length; i++) {
			int pos = rand.nextInt(CHARSET.length());
			sb.append(CHARSET.charAt(pos));
		}
		return sb.toString();
	}

	public static String strip(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (STRCONSTANT.indexOf(s.charAt(i)) >= 0)
				result += s.charAt(i);
		}
		result = result.toLowerCase();
		return result;
	}

	public static String capitalizeFirstCharacter(final String string) {
		if (string == null)
			throw new NullPointerException("string");
		if (string.equals(""))
			throw new NullPointerException("string");

		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}

	public static int calculateNumberOfDaysBetween(Date startDate, Date endDate) {

		long startDateTime = startDate.getTime();
		long endDateTime = endDate.getTime();
		long milPerDay = 1000 * 60 * 60 * 24;

		int numOfDays = (int) ((endDateTime - startDateTime) / milPerDay); //calculate vacation duration in  days
		 
		return (numOfDays + 1); // add one day to include start date in interval
	}
	
	private static final String DOMAIN_START_END_PATTERN_STRING = "^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,65}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$";

	public static boolean domainValidation(String domainName) {
		return domainName.matches(DOMAIN_START_END_PATTERN_STRING);
	}

	private static final String USERNAME_PATTERN = "^(?=(.*[a-zA-Z]))[a-zA-Z0-9-_.]{3,50}$";

	public static boolean userNameValidation(String userName) {
		return userName.matches(USERNAME_PATTERN);
	}

	private static final String ADDRESS_PATTERN = "(?=(.*[a-zA-Z]){1,})^[a-zA-Z0-9# .,].+[a-zA-Z0-9# .,]{1,15}$";

	public static boolean addressValidation(String address) {
		return address.matches(ADDRESS_PATTERN);
	}

	private static final String FAX_PATTERN = "\\d{3}-\\d{7}";

	public static boolean faxValidation(String fax) {
		return fax.matches(FAX_PATTERN);
	}
	
	private static final String PHONE_PATTERTN = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$"; 
	
	public static boolean phoneValidation(String phone) {
		return phone.matches(PHONE_PATTERTN);
	}
	
	public static long generateUinqueId() {
		Date date = new Date();
		Calendar oCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		oCalendar.setTime(date);
		long proUID = oCalendar.getTimeInMillis();
		return proUID;
	}
}
