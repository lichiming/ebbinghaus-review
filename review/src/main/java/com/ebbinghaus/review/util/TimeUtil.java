package com.ebbinghaus.review.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {




    /**
     * 增加多少分钟
     * */
    public static String getTime(Integer unit,Integer time){
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        //calendar.add(Calendar.MINUTE, 20);
        calendar.add(unit, time);
        // 这个时间就是日期往后推一天的结果
        date = calendar.getTime();

        SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd HH:mm:ss");
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }


    /**获取那天的日期*/
    public static String getDate(Integer unit,Integer time){
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        //calendar.add(Calendar.MINUTE, 20);
        calendar.add(unit, time);
        // 这个时间就是日期往后推一天的结果
        date = calendar.getTime();

        SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd");
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
