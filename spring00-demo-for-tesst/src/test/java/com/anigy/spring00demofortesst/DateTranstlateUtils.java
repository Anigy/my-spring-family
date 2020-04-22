package com.anigy.spring00demofortesst;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jintao on 2017/8/25.
 */
public class DateTranstlateUtils {
    private static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static final String MIN_TIME = " 00:00:00";
    public static final String MAX_TIME = " 23:59:59";

    public static String dateToStr(Date date,String format){
        SimpleDateFormat simpleDateFormat = null;
        if(StringUtils.isEmpty(format)){
            simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        }
        else {
            simpleDateFormat = new SimpleDateFormat(format);
        }
        return simpleDateFormat.format(date);
    }

    public static Date strToDate(String date,String format) throws ParseException{
        if(date==null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = null;
        if(StringUtils.isEmpty(format)){
            simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        }
        else {
            simpleDateFormat = new SimpleDateFormat(format);
        }
        return simpleDateFormat.parse(date);

    }


}
