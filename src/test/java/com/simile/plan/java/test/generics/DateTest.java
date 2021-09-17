package com.simile.plan.java.test.generics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by yitao on 2021/03/12.
 */
public class DateTest {

    public static void main(String[] args) {

        String s1 = "2020-09-15T12:30:00+00:00";
        String s2 = "2020-09-15T12:30:00+08:00";

        String pattern = "yyyy-MM-dd'T'HH:mm:ss+z";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        System.out.println(LocalDate.parse(s1, formatter));
        System.out.println(LocalDate.parse(s2, formatter));


    }
}
