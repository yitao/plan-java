package com.simile.plan.java.other;

import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

/**
 * @Author yitao
 * @Created 2023/03/24
 */
public class MathTest {

    @Test
    public void name() throws ParseException {
//        long et = DateUtils.parseDate("2023-03-24 14:52:49.999", "yyyy-MM-dd HH:mm:ss.SSS").getTime();
//        long st = DateUtils.parseDate("2023-03-24 14:52:46.000", "yyyy-MM-dd HH:mm:ss.SSS").getTime();
//        System.out.println((et / 1000 - st / 1000));
//        System.out.println((et / 1000 - st / 1000));

        double executeSpeed = (1.0D * 1000 / 84000 * 1000.0);
        System.out.println(Double.parseDouble(String.format("%.2f", executeSpeed)));
        System.out.println(executeSpeed);
        System.out.println(Math.round(executeSpeed));
    }
}
