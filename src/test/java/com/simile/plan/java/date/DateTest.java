package com.simile.plan.java.date;

import java.text.SimpleDateFormat;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2023/08/24
 */
public class DateTest {

    /**
     * 日期型字符串转化为日期格式
     *
     * @param strDate
     * @param format
     * @return
     */
    public static String formatDateStr(long strDate, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(strDate);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Test
    public void name() {
        System.out.println(formatDateStr(199999999990L, "yyyy-MM-dd"));
    }
}
