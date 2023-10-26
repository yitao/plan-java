package com.simile.plan.java.datastruct.string;

/**
 * @author yitao
 * @since 2020-12-03
 */
public class String3 {

    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 100; i++) {
            s = s + i + "";
        }
        System.out.println(s);
    }
}
