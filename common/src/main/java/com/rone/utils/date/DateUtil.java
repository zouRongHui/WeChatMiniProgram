package com.rone.utils.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间、日期工具类
 *
 * @author rone
 **/
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取指定日期字符串，不指定日期则默认返回当天
     *
     * @param date   日期
     * @param format 格式
     * @return 日期字符串
     */
    public static String getDateStr(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 根据指定日期格式，将日期字符串解析成日期对象
     *
     * @param sDate  日期字符串
     * @param format 日期格式
     * @return 日期对象
     */
    public static Date strToDate(String sDate, String format) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            date = sdf.parse(sDate);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * 改变天数
     *
     * @param date 原始时间
     * @param days 改变的天数，>0为增加，<0为减少
     * @return 改变后的时间
     */
    public static Date changeDayOfMonth(Date date, int days) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}
