package com.simile.plan.java.date;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @Author yitao
 * @Created 2023/01/29
 */
public class CalendarExample {

    public static void main(String[] args) {
        Calendar cl = new java.util.GregorianCalendar(TimeZone.getDefault());
        cl.set(Calendar.MINUTE, 62);
        cl.get(Calendar.MINUTE);
        System.out.println(cl.getTime());
    }
}
