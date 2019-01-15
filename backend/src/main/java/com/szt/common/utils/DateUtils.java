/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.szt.common.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期处理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @return  返回yyyy-MM-dd格式日期
     */
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @param pattern  格式，如：DateUtils.DATE_TIME_PATTERN
     * @return  返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)){
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * 根据周数，获取开始日期、结束日期
     * @param week  周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return  返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date 日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date 日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date 日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date 日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date 日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date 日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }
    /**
     * 功能：判断字符串是否为日期格式
     *
     * @param strDate
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public static Date parseDate(String pattern)  {
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 获取指定日期对应的年份的第一天的日期
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, 1);// 设为日期为今年的第1天
        return setTimeFirst(calendar.getTime());
    }
    /**
     * 取系统当前时间:返回只值为如下形式 2002-10-30 20:24:39
     *
     * @return String
     */
    public static String getNow() {
        return getDateToString(new Date());
    }
    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
     * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
     *
     * @param time
     *            Date 日期<br>
     * @return String 字符串<br>
     */
    public static String getDateToString(Date time) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time = formatter.format(time);
        return Time;
    }
    /**
     * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)<br>
     * 如Sat May 11 17:23:22 CST 2002 to '2002-05-11 05:23:22 下午'<br>
     *
     * @param time
     *            Date 日期<br>
     * @param x
     *            int 任意整数如：1<br>
     * @return String 字符串<br>
     */
    public static String getDateToString(Date time, int x) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss a");
        String date = formatter.format(time);
        return date;
    }
    /**
     * 取系统当前时间:返回只值为如下形式 2002-10-30 08:28:56 下午
     *
     * @param hour
     *            为任意整数
     * @return String
     */
    public static String getNow(int hour) {
        return getDateToString(new Date(), hour);
    }
    /**
     * 获取指定日期对应的年份的最后一天的日期
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, 1);// 设为日期为今年的第1天
        calendar.add(Calendar.YEAR, 1);// 加上一年，到第二年的第一天
        calendar.add(Calendar.DATE, -1);// 减一天，今年的最后一天
        return setTimeLast(calendar.getTime());
    }

    /**
     * 获取指定日期对应的半年度的第一天的日期
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfHalfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        if (0 <= month && 5 >= month) {
            calendar.set(Calendar.MONDAY, 0);
        } else {
            calendar.set(Calendar.MONDAY, 6);
        }
        return getFirstDayOfMonth(calendar.getTime());
    }

    /**
     * 获取指定日期对应的半年度的最后一天的日期
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfHalfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        if (0 <= month && 5 >= month) {
            calendar.set(Calendar.MONDAY, 5);
        } else {
            calendar.set(Calendar.MONDAY, 11);
        }
        return getLastDayOfMonth(calendar.getTime());
    }

    /**
     * 获取指定日期对应的季度的第一天的日期
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        if (0 == month || 1 == month || 2 == month) {
            calendar.set(Calendar.MONDAY, 0);
        } else if (3 == month || 4 == month || 5 == month) {
            calendar.set(Calendar.MONDAY, 3);
        } else if (6 == month || 7 == month || 8 == month) {
            calendar.set(Calendar.MONDAY, 6);
        } else {
            calendar.set(Calendar.MONDAY, 9);
        }
        return getFirstDayOfMonth(calendar.getTime());
    }

    /**
     * 获取指定日期对应的季度的最后一天的日期
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        if (0 == month || 1 == month || 2 == month) {
            calendar.set(Calendar.MONDAY, 2);
        } else if (3 == month || 4 == month || 5 == month) {
            calendar.set(Calendar.MONDAY, 5);
        } else if (6 == month || 7 == month || 8 == month) {
            calendar.set(Calendar.MONDAY, 8);
        } else {
            calendar.set(Calendar.MONDAY, 11);
        }
        return getLastDayOfMonth(calendar.getTime());
    }

    /**
     * 获取指定日期对应的月份的第一天的日期
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);// 设为当前月的1号
        return setTimeFirst(calendar.getTime());
    }

    /**
     * 获取指定日期对应的月份的最后一天的日期
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);// 设为当前月的1号
        calendar.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
        calendar.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
        return setTimeLast(calendar.getTime());
    }

    /**
     * 获取指定日期对应的周的第一天的日期(按中国习惯星期一作为一周的第一天)
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        int dayOfWeek = getDayOfWeek(date);
        if (2 == dayOfWeek) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        while (true) {
            calendar.add(Calendar.DATE, -1);
            if (2 == getDayOfWeek(calendar.getTime())) {
                break;
            }
        }
        return setTimeFirst(calendar.getTime());
    }

    /**
     * 获取指定日期对应的周的最后一天的日期(按中国习惯星期天作为一周的最后一天)
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        int dayOfWeek = getDayOfWeek(date);
        if (1 == dayOfWeek) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        while (true) {
            calendar.add(Calendar.DATE, 1);
            if (1 == getDayOfWeek(calendar.getTime())) {
                break;
            }
        }
        return setTimeLast(calendar.getTime());
    }

    /**
     * 计算指定日期是该周中的第几天(星期天1~~~星期六7)
     *
     * @param date
     * @return
     */
    public static Integer getDayOfWeek(Date date) {
        if (null == date) {
            return 0;
        }
        return date2Calendar(date).get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取指定时间的第二天时间
     * @param date
     * @return
     */
    public static Date getNextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 获取指定时间的下一月时间
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     *
     * 获取指定时间的六个月后时间
     * @param date
     * @return
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    public static Date getSixMonthsLaterDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 6);
        return calendar.getTime();
    }

    /**
     *
     * 获取指定时间的12个月后时间
     * 功能详细描述
     * @param date
     * @return
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    public static Date getTwelveMonthsLaterDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 12);
        return calendar.getTime();
    }

    /**
     * Date转换为Calendar
     *
     * @param date
     * @return
     */
    public static Calendar date2Calendar(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 设置时间为 00:00:00.000
     *
     * @param calendar
     * @return
     */
    public static Date setTimeFirst(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 设置时间为 23:59:59
     *
     * @param calendar
     * @return
     */
    public static Date setTimeLast(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 判断两个日期是否为同一天
     *
     * @param day1
     * @param day2
     * @return
     */
    public static boolean isSameDay(Date day1, Date day2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ds1 = sdf.format(day1);
        String ds2 = sdf.format(day2);
        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 字符串转时间
     *
     * @param param
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String param) throws ParseException{
        SimpleDateFormat sdfSS = null;
        String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";
        Date reDate = null;
        if(StringUtils.isNotEmpty(param)){
            sdfSS = new SimpleDateFormat(pattern.substring(0,param.length()));
            reDate = sdfSS.parse(param);
        }
        return reDate;
    }

    public static Date formatDate(String date,SimpleDateFormat dateFormat){
        Date retDate = null;
        try{
            retDate = dateFormat.parse(date);;
        }
        catch(ParseException pe){
            pe.printStackTrace();
        }
        return retDate;
    }

    /**
     * 时间格式转换
     * @param date 时间对象
     * @param form 格式为:" yyyy年MM月dd日hh时mm分ss秒 "
     * @return
     */
    public static String dateToString(Date date,String form){
        //设置格式
        SimpleDateFormat sdf =   new SimpleDateFormat(form.trim());
        //格式转换
        String str =  sdf.format(date);
        sdf.clone();
        return str;
    }
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(d);
        System.out.println("现在的日期是：" + date);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MINUTE, 30);// 30为增加的天数，可以改变的
        d = ca.getTime();
        String backTime = format.format(d);
        System.out.println("增加天数以后的日期：" + backTime);

    }
    /**
     * 增加时间
     * @param date 当前时间
     * @param day 增加的数量
     * @param type 天数类型Calendard的常量值
     * @return
     */
    public static Date addDate(Date date,int day,final Integer type){
        Calendar ca = Calendar.getInstance();
        date = ca.getTime();
        ca.add(type, day);// 30为增加的天数，可以改变的
        return ca.getTime();
    }
}
