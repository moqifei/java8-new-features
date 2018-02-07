package com.moqifei.java8newfeatures.java8util.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import junit.framework.Assert;

/**
 * <p>
 * <b>DateTimeUtils测试类
 * </p>
 *
 * @author   moqifei
 * @version  1.0.0
 * @since    2018年02月07日
 */
public class DateTimeUtilsTest {
	@Test
	public void testgetLocalDate() throws Exception{
		LocalDateTime currentTime = LocalDateTime.now();
		String date = DateTimeUtils.getLocalDate(currentTime,null);
		LocalDate date1 = LocalDate.now();
		Assert.assertEquals(date, date1.toString());
	}
	
	@Test
	public void testgetLocalTime() throws Exception{
		LocalDateTime currentTime = LocalDateTime.now();
		String time = DateTimeUtils.getLocalTime(currentTime, DateTimeFormatter.ofPattern("HHmmss"));
		LocalTime time1 = LocalTime.now();
		
		Assert.assertEquals(time,time1.format(DateTimeFormatter.ofPattern("HHmmss")));
	}
	
	@Test
	public void testgetTodayDate() throws Exception{
		String today = DateTimeUtils.getTodayDate("");
		LocalDate today1 = LocalDate.now();
		Assert.assertEquals(today, today1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
	
	@Test
	public void testgetYestertodayDate() throws Exception{
		String yestertoday = DateTimeUtils.getYestertodayDate("");
		LocalDate yestertoday1 = LocalDate.now();
		Assert.assertEquals(yestertoday, yestertoday1.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
	
	@Test
	public void testgetTommorrowDate() throws Exception{
		String tommorrow = DateTimeUtils.getTommorrowDate("");
		LocalDate tommorrow1 = LocalDate.now();
		Assert.assertEquals(tommorrow, tommorrow1.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
	
	@Test
	public void testgetDayofWeek() throws Exception{
		String dayofWeek = LocalDate.now().getDayOfWeek().toString();
		Assert.assertEquals(dayofWeek, DateTimeUtils.getDayofWeek("", ""));
		String dayofWeek1 = LocalDate.parse("2018-02-07").getDayOfWeek().toString();
		Assert.assertEquals(dayofWeek1, DateTimeUtils.getDayofWeek("2018-02-07", ""));
		String dayofWeek2 = LocalDate.parse("20180207", DateTimeFormatter.ofPattern("yyyyMMdd")).getDayOfWeek().toString();
		Assert.assertEquals(dayofWeek2, DateTimeUtils.getDayofWeek("20180207", "yyyyMMdd"));
		
	}
	
}
