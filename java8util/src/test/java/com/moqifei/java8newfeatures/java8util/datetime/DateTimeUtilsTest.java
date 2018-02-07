package com.moqifei.java8newfeatures.java8util.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import junit.framework.Assert;

/**
 * <p>
 * <b>DateTimeUtils测试工具类
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
		
		LocalDate date1 = currentTime.toLocalDate();
		
		String date = DateTimeUtils.getLocalDate(currentTime);
		
		Assert.assertEquals(date1.toString(), date);
	}
}
