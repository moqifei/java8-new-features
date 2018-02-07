package com.moqifei.java8newfeatures.java8util.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * <b>Description:Date/Time API (JSR 310):https://jcp.org/en/jsr/detail?id=310
 * </p>
 *
 * @author   moqifei
 * @version  1.0.0
 * @since    2018年02月07日
 */
public abstract class DateTimeUtils {
    public static final DateTimeFormatter RETURN_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter HHMMSS = DateTimeFormatter.ofPattern("HHmmss");
    
    /**
     * 获取本地日期
     * @param localDateTime
     * @return
     */
    public static String getLocalDate(LocalDateTime localDateTime){
    	return localDateTime.toLocalDate().toString();
    }
}
