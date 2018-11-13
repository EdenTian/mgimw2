package com.mgi.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
     * 作者：L_X
     */
    public class DateUtil{
        private final static Logger log = Logger.getLogger(DateUtil.class);
        private static String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";
        /***
         * 时间格式：yyyy/MM/dd HH:mm:ss
         * **/
        public static final String YYYYMMDDHHMMSS = "yyyy/MM/dd HH:mm:ss";
        /***
         * 时间格式：yyyy/MM/dd
         * **/
        public static final String YYYYMMDD = "yyyy/MM/dd";
        /***
         * 时间格式：yyyy MM dd HH:mm:ss
         * **/
        public static final String YYYY_MM_DD_HH_MM_SS = "yyyy MM dd HH:mm:ss";
/***
 * 时间格式：yyyyMMddHHmmss
 * **/
        /***
         * 时间格式：yyyyMMddHHmmssSSSS
         * **/
        public static final String YYYY_MM_DD_HH_MM_SS_SSSS = "yyyyMMddHHmmssSSSS";
        /***
         * 时间格式：yyyyMMdd
         * **/
        public static final String strYyyyMmDd = "yyyyMMdd";


        /***
         * 时间格式：yyyy-MM-dd HH:mm:ss
         * **/
        public static final String STR_YYYY_MM_DD_TMP = "yyyy-MM-dd HH:mm:ss";


        /***
         * 时间格式：yyyyMM
         * **/
        public static final String STR_YYYY_MM = "yyyyMM";
        /***
         * 时间格式：yyyy-MM-dd
         * **/
        public static final String STR_YYYY_MM_DD = "yyyy-MM-dd";


        /***
         * 时间格式：yyyyMM
         * **/
        public static final String STR_YYYY_MM_DD_STR = "yyyy年MM月dd日";


        /***
         * 时间格式：ddMMMyy
         * **/
        public static final String STR_DDMMMYY = "ddMMMyy";


        /***
         * 时间格式：HH:mm
         * **/
        public static final String STR_HH_MM = "HH:mm";

        /***
         * 时间格式：HHmm
         * **/
        public static final String STR_HHMM = "HHmm";


        /***
         * 时间格式：yyyy-MM-dd HH:mm
         * **/
        public static final String STR_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
        /**
         * 时间格式：HH:mm:ss
         */
        public static final String STR_HH_MM_SS = "HH:mm:ss";


        public static String getDefaultDatePattern()
        {
            return DateUtil.defaultDatePattern;
        }


        /**
         * 当前时间
         *
         * @return
         */
        public static String getNow()
        {
            final Date now = new Date();
            return DateUtil.format(now);
        }


        /**
         * Date转为字符串 格式：2011-01-11 17:30:30
         *
         * @param date
         * @return
         */
        public static String format(final Date date)
        {
            return DateUtil.format(date, DateUtil.getDefaultDatePattern());
        }


        public static String getYear()
        {
            final Date now = new Date();
            final String pat = "yyyy";
            final SimpleDateFormat sdf = new SimpleDateFormat(pat);
            return sdf.format(now);
        }


        /**
         * Date转为字符串
         *
         * @param date
         * @param pattern
         * @return
         */
        public static String format(final Date date, final String pattern)
        {
            String returnValue = "";
// System.out.println(pattern);
// System.out.println(date);
            if (null != date)
            {
                final SimpleDateFormat df = new SimpleDateFormat(pattern);
                returnValue = df.format(date);
            }


            return returnValue;
        }


        public static String format(final Date date, final String pattern, Locale local)
        {
            String returnValue = "";
// System.out.println(pattern);
// System.out.println(date);
            if (null != date)
            {
                final SimpleDateFormat df = new SimpleDateFormat(pattern, local);
                returnValue = df.format(date);
            }


            return returnValue;
        }


        /**
         * 字符串转为Date 默认的时间格式"yyyy-MM-dd HH:mm:ss"
         *
         * @param strDate
         * @return
         * @throws ParseException
         */
        public static Date parse(final String strDate)
        {
            return DateUtil.parse(strDate, DateUtil.getDefaultDatePattern());
        }


        /**
         * 字符串转为Date 指定时间格式
         *
         * @param strDate
         * @param pattern
         * @return
         * @throws ParseException
         */
        public static Date parse(final String strDate, final String pattern)
        {
            if (strDate == null)
            {
                return null;
            }
            final SimpleDateFormat df = new SimpleDateFormat(pattern);
            try
            {
//                String format = df.format(strDate);
                return df.parse(strDate);
            } catch (final ParseException e)
            {
                System.out.println("时间字符串和时间格式不匹配");
                return null;
            }
        }



        /**
         * 加n年
         *
         * @param date
         * @param n
         * @return
         */
        public static Date addYear(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.YEAR, n);
            return cal.getTime();
        }


        /**
         * 加n月
         *
         * @param date
         * @param n
         * @return
         */
        public static Date addMonth(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, n);
            return cal.getTime();
        }


        /**
         * 加n天
         *
         * @param date
         * @param n
         * @return
         */
        public static Date addDay(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_YEAR, n);
            return cal.getTime();
        }
 /**
         * 减n天
         *
         * @param date
         * @param n
         * @return
         */
        public static Date Day(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_YEAR,n);
            return cal.getTime();
        }


        /**
         * 加n分
         *
         * @param date
         * @param n
         * @return
         */
        public static Date addMinute(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MINUTE, n);
            return cal.getTime();
        }


        /**
         * 加n时
         *
         * @param date
         * @param n
         * @return
         */
        public static Date addHour(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR_OF_DAY, n);
            return cal.getTime();
        }


        /**
         * 加n秒
         *
         * @param date
         * @param n
         * @return
         */
        public static Date addSecond(final Date date, final int n)
        {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.SECOND, n);
            return cal.getTime();
        }


        /**
         * 获取当前时间ms
         *
         * @return
         */
        public static long getCurrentTimes()
        {
            return System.currentTimeMillis();
        }


        /**
         * 将Date转化为Timestamp
         *
         * @param date
         * @return
         */
        public static Timestamp dateToTimestamp(final Date date)
        {
            final Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        }


        /**
         * 当前时间早于比较时间
         *
         * @param date
         * @return
         */
        public static boolean before(Date date)
        {
            Calendar future = Calendar.getInstance();
            future.setTime(date);
            return Calendar.getInstance().before(future);
        }


        /**
         * 当前时间晚于比较时间
         *
         * @param date
         * @return
         */
        public static boolean after(Date date)
        {
            Calendar future = Calendar.getInstance();
            future.setTime(date);
            return Calendar.getInstance().after(future);
        }


        /**
         * date1时间晚于比较时间date2
         *
         * @param
         * @return
         */
        public static boolean after(Date date1, Date date2)
        {
            Calendar cal = Calendar.getInstance();
            Calendar future = Calendar.getInstance();
            cal.setTime(date1);
            future.setTime(date2);
            return cal.after(future);
        }


        /**
         * date1时间早于比较时间date2
         *
         * @param
         * @return
         */
        public static boolean before(Date date1, Date date2)
        {
            Calendar cal = Calendar.getInstance();
            Calendar future = Calendar.getInstance();
            cal.setTime(date1);
            future.setTime(date2);
            return cal.before(future);
        }

        /**
         * date1时间晚于或扽股比较时间date2
         *
         * @param
         * @return
         */
        public static boolean afterOrEquals(Date date1, Date date2)
        {
            Calendar cal = Calendar.getInstance();
            Calendar future = Calendar.getInstance();
            cal.setTime(date1);
            future.setTime(date2);

            return cal.after(future)||cal.equals(future);
        }


        /**
         * date1时间早于比较时间date2
         *
         * @param
         * @return
         */
        public static boolean beforeOrEquals(Date date1, Date date2)
        {
            Calendar cal = Calendar.getInstance();
            Calendar future = Calendar.getInstance();
            cal.setTime(date1);
            future.setTime(date2);
            return cal.before(future)||cal.equals(future);
        }


        /**
         * date1早于date2,date2时间早于date3
         *
         * @param
         * @return
         */
        public static boolean between(Date date1, Date date2, Date date3)
        {
            Calendar cal = Calendar.getInstance();
            Calendar mid = Calendar.getInstance();
            Calendar future = Calendar.getInstance();
            cal.setTime(date1);
            mid.setTime(date2);
            future.setTime(date3);
            int compareToBefore = mid.compareTo(cal);
            int compareToAfter = mid.compareTo(future);
            return (compareToBefore >= 0) && (compareToAfter <= 0);//大于等于and小于等于
// return cal.before(mid)&&mid.before(future);//大于and小于
        }


        public static Long daysBetween(String date1, String date2)
        {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
            Long day = Long.valueOf(0);
            Calendar cal = Calendar.getInstance();
            try
            {
                cal.setTime(sdfDate.parse(date1));
                long time1 = cal.getTimeInMillis();
                cal.setTime(sdfDate.parse(date2));
                long time2 = cal.getTimeInMillis();
                long between_days = (time2 - time1) / 86400000L;
                day = Long.valueOf(between_days);
            } catch (ParseException e)
            {
// TODO Auto-generated catch block
                log.error("DateUtil操作错误:",e);
            }
            return day;
        }


        /**
         * 时间天数差
         * @param date1
         * @param date2
         * @return
         * @Luoml
         */
        public static Long daysDiffer(Date date1, Date date2)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(date2);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / 86400000L;
            Long day = Long.valueOf(between_days);
            return day;
        }


        /**
         * 时间间隔分钟数
         * @param date1
         * @param date2
         * @return
         * @Luoml
         */
        public static Long daysDifferMinute(Date date1, Date date2)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(date2);
            long time2 = cal.getTimeInMillis();
            long betweenDays = (time2 - time1) / (1000 * 60);
            Long minute = Long.valueOf(betweenDays);
            return minute;
        }


        public static String dateStringToHost(String str, String format, String hostFormat, Locale locale)
        {
            if (StringUtils.isEmpty(str))
            {
                return null;
            }
            if (StringUtils.isEmpty(format))
            {
                format = STR_DDMMMYY;
            }
            if (locale == null)
            {
                locale = Locale.US;
            }
            Date date = parse(str, format);
            String res = format(date, hostFormat, locale);
            if (StringUtils.isNotEmpty(res))
            {
                res = res.toUpperCase();
            }


            return res;
        }


        /**
         * 星期
         * @param date
         * @return
         * @Luoml
         */
        public static String getWeek(Date date)
        {
            String[] weekDays =
                    { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        }


        public static int getIntWeek(Date date)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return w;
        }


        /**
         * @Function: org.platform.utils.date.DateUtil.getBirthDay
         * @Description: 根据身份证号码获得 出生日期
         * @param idCardNo
         * @return
         * @version:v1.0
         * @author:桂银
         * @date:2016年9月27日 上午10:44:06
         */
        public static Date getBirthDay(String idCardNo)
        {
            Date birthDay = null;
            try{
                if (!StringUtils.isNotEmpty(idCardNo)) {
                } else {
                    idCardNo = idCardNo.substring(6, 14);
                    birthDay = DateUtil.parse(idCardNo, DateUtil.strYyyyMmDd);
                }
            }catch(Exception e){

            }

            return birthDay;
        }


        public static String getBirthDayStr(String idCardNo)
        {
            String birthDay = null;
            if (StringUtils.isNotEmpty(idCardNo))
            {
                birthDay = idCardNo.substring(6, 14);
            }
            return birthDay;
        }


        public static long minsDiffer(String date1, String date2)
        {
            long time2 = DateUtil.parse(date2, STR_YYYY_MM_DD_HH_MM).getTime();
            long time1 = DateUtil.parse(date1, STR_YYYY_MM_DD_HH_MM).getTime();
            long between_min = (time2 - time1) / (1000 * 60);
            return between_min;
        }


        public static long hoursDiffer(String date1, String date2)
        {
            long time2 = DateUtil.parse(date2, STR_YYYY_MM_DD_HH_MM).getTime();
            long time1 = DateUtil.parse(date1, STR_YYYY_MM_DD_HH_MM).getTime();
            long between_hour = (time2 - time1) / (1000 * 60 * 60);
            return between_hour;
        }


        /**
         * @Function: org.platform.utils.date.DateUtil.formatTrans
         * @Description: 两个格式转换
         * @param dateStr
         * @param format1 原格式
         * @param format2 目标格式
         * @return
         * @version:v1.0
         * @author:GuiY
         * @date:2017年7月4日 下午12:39:53
         */
        public static String formatTrans(String dateStr, String format1, String format2)
        {
            if (StringUtils.isNotEmpty(dateStr))
            {
                Date date = DateUtil.parse(dateStr, format1);
                return DateUtil.format(date, format2);
            }
            return "";
        }
        public static String formatTrans(String dateStr, String format1, String format2,Locale local)
        {
            if (StringUtils.isNotEmpty(dateStr))
            {
                Date date = DateUtil.parse(dateStr, format1);
                return DateUtil.format(date, format2,local);
            }
            return "";
        }
        /**
         *
         * @Title: isValidDate 判断时间格式是否为指定格式
         * @Author: lizhenglong 2017年7月28日 下午5:05:50
         * @param str
         * @param formatPattern
         * @return
         */
        public static boolean isValidDate(String str, String formatPattern)
        {
            DateFormat formatter = new SimpleDateFormat(formatPattern);
            try
            {
                Date date = formatter.parse(str);
                return str.equals(formatter.format(date));
            } catch (Exception e)
            {
                return false;
            }
        }


        /**
         * 时区时间转换
         * @param dateStr
         * @return
         */
        public static String areaDateFormat(String dateStr){
            //此格式只有  jdk 1.7才支持  yyyy-MM-dd'T'HH:mm:ss.SSSXXX
            DateFormat df2 = null;
            Date date1 = null;
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");  //yyyy-MM-dd'T'HH:mm:ss.SSSZ
                Date date = df.parse(dateStr);
                SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                date1 =  df1.parse(date.toString());
                df2 = new SimpleDateFormat(STR_YYYY_MM_DD);
            } catch (ParseException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            return df2.format(date1);
        }

        /**
         * 获取前一天23:00:00时间
         * @return
         */
        public static String getStartTime(int day,int hour,int min,int sec,int millsecond){
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR,day);
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, min);
            c.set(Calendar.SECOND, sec);
            c.set(Calendar.MILLISECOND, millsecond);
            return DateUtil.format(DateUtil.parse(DateUtil.format(c.getTime(),DateUtil.YYYYMMDDHHMMSS),
                    DateUtil.YYYYMMDDHHMMSS));
        }

    /**
     * 获取当天22:59:59时间
     * @return
     */
    public static String getEndTime(int hour,int min,int sec,int millsecond){
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_YEAR,1);
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, min);
            c.set(Calendar.SECOND, sec);
            c.set(Calendar.MILLISECOND, millsecond);
            return  DateUtil.format(DateUtil.parse(DateUtil.format(c.getTime(),DateUtil.YYYYMMDDHHMMSS),
                    DateUtil.YYYYMMDDHHMMSS));
        }

    
    }


