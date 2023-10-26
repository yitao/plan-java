package com.simile.plan.java.date;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @Author yitao
 * @Created 2022/09/13
 */
public class DateFormatExample {

    public static void main(String[] args) throws ParseException {
//        Date d = DateUtils.parseDate("2022-01-01T11:11:11.111+08", "yyyy-MM-dd'T'HH:mm:ss.SSSX");
//        System.out.println(Long.valueOf("2019-08-15 16:00:00 UTC"));
        Date d = DateUtils.parseDate("2019-08-15 16:00:00 UTC", "yyyy-MM-dd HH:mm:ss Z");
        System.out.println(d);

//      Date d = new Date();
//        System.out.println(new SimpleDateFormat("D").format(d));
//        System.out.println(new SimpleDateFormat("DD").format(d));
//        System.out.println(new SimpleDateFormat("DDD").format(d));
//        System.out.println(new SimpleDateFormat("DDDD").format(d));
//
//        System.out.println(new SimpleDateFormat("s").format(d));
//        System.out.println(new SimpleDateFormat("ss").format(d));
//        System.out.println(new SimpleDateFormat("sss").format(d));
//        System.out.println(new SimpleDateFormat("ssss").format(d));
//
//        System.out.println(new SimpleDateFormat("S").format(d));
//        System.out.println(new SimpleDateFormat("SS").format(d));
//        System.out.println(new SimpleDateFormat("SSS").format(d));
//        System.out.println(new SimpleDateFormat("SSSS").format(d));
//
//        System.out.println(new SimpleDateFormat("d").format(d));
//        System.out.println(new SimpleDateFormat("dd").format(d));
//        System.out.println(new SimpleDateFormat("ddd").format(d));
//        System.out.println(new SimpleDateFormat("dddd").format(d));
//
//        System.out.println(new SimpleDateFormat("M").format(d));
//        System.out.println(new SimpleDateFormat("MM").format(d));
//        System.out.println(new SimpleDateFormat("MMM").format(d));
//        System.out.println(new SimpleDateFormat("MMMM").format(d));
    }

}
