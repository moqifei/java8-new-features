package com.moqifei.java8newfeatures.java8util.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	 * @param dateFormatter
	 * @return
	 */
	public static String getTodayDate(String dateFormatter){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if(dateFormatter == null || "".equals(dateFormatter)){
			dateTimeFormatter = YYYYMMDD;
		}else{
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatter);
		}
		return getLocalDate(now, dateTimeFormatter);
	}
	
	/**
	 * 获取昨天日期
	 * @param dateFormatter
	 * @return
	 */
	public static String getYestertodayDate(String dateFormatter){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if(dateFormatter == null || "".equals(dateFormatter)){
			dateTimeFormatter = YYYYMMDD;
		}else{
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatter);
		}
		return getLocalDate(now.minusDays(1), dateTimeFormatter);
	}
	
	/**
	 * 获取明天日期
	 * @param dateFormatter
	 * @return
	 */
	public static String getTommorrowDate(String dateFormatter){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if(dateFormatter == null || "".equals(dateFormatter)){
			dateTimeFormatter = YYYYMMDD;
		}else{
			dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatter);
		}
		return getLocalDate(now.plusDays(1), dateTimeFormatter);
	}
	
	/**
	 * 获取当前时间
	 * @param timeFormatter
	 * @return
	 */
	public static String getNowTime(String timeFormatter){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = null;
		if(timeFormatter == null || "".equals(timeFormatter)){
			dateTimeFormatter = HHMMSSSSS;
		}else{
			dateTimeFormatter = DateTimeFormatter.ofPattern(timeFormatter);
		}
		return getLocalTime(now,dateTimeFormatter);
	}
	
	/**
	 * 获取某一天星期几
	 * @param date
	 * @param dateformat
	 * @return
	 */
	public static String getDayofWeek(String date, String dateformat){
		if(date == null || "".equals(date)){
			return LocalDateTime.now().getDayOfWeek().toString();
		}
		if(dateformat == null || "".equals(dateformat)){
			return LocalDate.parse(date, YYYYMMDD).getDayOfWeek().toString();
		}
		return LocalDate.parse(date,DateTimeFormatter.ofPattern(dateformat)).getDayOfWeek().toString();
	}

	public static void main(String[] args) {
		System.out.println(getDayofWeek("2018-02-06",""));
		System.out.println(getDayofWeek("20180206","yyyyMMdd"));
	}

}
