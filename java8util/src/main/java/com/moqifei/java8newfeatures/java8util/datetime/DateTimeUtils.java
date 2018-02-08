package com.moqifei.java8newfeatures.java8util.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * <b>Description:Date/Time API (JSR 310):https://jcp.org/en/jsr/detail?id=310
 * </p>
 *
 * @author moqifei
 * @version 1.0.0
 * @since 2018年02月07日
 */
public abstract class DateTimeUtils {
	public static final DateTimeFormatter RETURN_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	public static final DateTimeFormatter HHMMSSSSS = DateTimeFormatter.ofPattern("HHmmssSSS");

	/**
	 * 获取本地日期
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static String getLocalDate(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
		if (dateTimeFormatter == null) {
			dateTimeFormatter = YYYYMMDD;
		}
		return localDateTime.format(dateTimeFormatter);
	}

	/**
	 * 获取本地时间
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static String getLocalTime(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
		if (dateTimeFormatter == null) {
			dateTimeFormatter = HHMMSSSSS;
		}
		return localDateTime.format(dateTimeFormatter);
	}

	/**
	 * 获取今天日期
	 * 
	 * @param dateFormatter
	 * @return
	 */
	public static String getTodayDate(String dateFormatter) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if (dateFormatter == null || "".equals(dateFormatter)) {
			dateTimeFormatter = YYYYMMDD;
		} else {
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatter);
		}
		return getLocalDate(now, dateTimeFormatter);
	}

	/**
	 * 获取昨天日期
	 * 
	 * @param dateFormatter
	 * @return
	 */
	public static String getYestertodayDate(String dateFormatter) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if (dateFormatter == null || "".equals(dateFormatter)) {
			dateTimeFormatter = YYYYMMDD;
		} else {
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatter);
		}
		return getLocalDate(now.minusDays(1), dateTimeFormatter);
	}

	/**
	 * 获取明天日期
	 * 
	 * @param dateFormatter
	 * @return
	 */
	public static String getTommorrowDate(String dateFormatter) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if (dateFormatter == null || "".equals(dateFormatter)) {
			dateTimeFormatter = YYYYMMDD;
		} else {
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatter);
		}
		return getLocalDate(now.plusDays(1), dateTimeFormatter);
	}

	/**
	 * 获取当前时间
	 * 
	 * @param timeFormatter
	 * @return
	 */
	public static String getNowTime(String timeFormatter) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if (timeFormatter == null || "".equals(timeFormatter)) {
			dateTimeFormatter = HHMMSSSSS;
		} else {
			dateTimeFormatter = DateTimeFormatter.ofPattern(timeFormatter);
		}
		return getLocalTime(now, dateTimeFormatter);
	}

	/**
	 * 获取某一天星期几
	 * 
	 * @param date
	 * @param dateformat
	 * @return
	 */
	public static String getDayofWeek(String date, String dateformat) {
		if (date == null || "".equals(date)) {
			return LocalDateTime.now().getDayOfWeek().toString();
		}
		if (dateformat == null || "".equals(dateformat)) {
			return LocalDate.parse(date, YYYYMMDD).getDayOfWeek().toString();
		}
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(dateformat)).getDayOfWeek().toString();
	}

	/**
	 * 获取某一天是某年的哪一天
	 * 
	 * @param date
	 * @param dateformat
	 * @return
	 */
	public static int getDayOfYear(String date, String dateformat) {
		if (date == null || "".equals(date)) {
			return LocalDateTime.now().getDayOfYear();
		}
		if (dateformat == null || "".equals(dateformat)) {
			return LocalDate.parse(date, YYYYMMDD).getDayOfYear();
		}
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(dateformat)).getDayOfYear();
	}

	/**
	 * 判断是否为闰年
	 * 
	 * @param year
	 * @param dateformat
	 * @return
	 */
	public static boolean isLeapYear(String year) {
		if (year == null || "".equals(year)) {
			return LocalDate.now().isLeapYear();
		}
		return LocalDate.of(Integer.parseInt(year), 1, 1).isLeapYear();
	}

	/**
	 * 判断今天是否是生日
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isBirthday(String birthday, String dateformat) {
		if (birthday == null || "".equals(birthday)) {
			return false;
		}
		LocalDate dateofBirth = null;
		MonthDay oldMonthDay = null;
		MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
		if (dateformat == null || "".equals(dateformat)) {
			dateofBirth = LocalDate.parse(birthday, YYYYMMDD);
			oldMonthDay = MonthDay.of(dateofBirth.getMonth(), dateofBirth.getDayOfMonth());
		} else {
			dateofBirth = LocalDate.parse(birthday, DateTimeFormatter.ofPattern(dateformat));
			oldMonthDay = MonthDay.of(dateofBirth.getMonth(), dateofBirth.getDayOfMonth());
		}

		if (oldMonthDay.equals(currentMonthDay)) {
			return true;
		}
		return false;
	}

	/**
	 * 计算两个日期的间隔天数
	 * @param date1
	 * @param date2
	 * @param dateformat
	 * @return
	 */
	public static long getPeriodofDays(String date1, String date2, String dateformat) {
		if (dateformat == null || "".equals(dateformat)) {
			return LocalDate.parse(date1, YYYYMMDD).toEpochDay() - LocalDate.parse(date2, YYYYMMDD).toEpochDay();
		} else {
			return LocalDate.parse(date1, DateTimeFormatter.ofPattern(dateformat)).toEpochDay()
					- LocalDate.parse(date2, DateTimeFormatter.ofPattern(dateformat)).toEpochDay();
		}
	}

	public static void main(String[] args) {
		System.out.println(getPeriodofDays("20000208", "20001209", "yyyyMMdd"));
	}

}
