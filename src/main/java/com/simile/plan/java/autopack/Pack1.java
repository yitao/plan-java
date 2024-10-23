package com.simile.plan.java.autopack;

/**
 * @author yitao
 * @since 2020-12-03
 */
public class Pack1 {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        // 以下代码输出：true
        System.out.println(c == d);
        // 以下代码输出：false
        System.out.println(e == f);
        // 以下代码输出：true
        System.out.println(c == (a + b));
        // 以下代码输出：true
        System.out.println(c.equals(a + b));
        // 以下代码输出：true
        System.out.println(g == (a + b));
        // 以下代码输出：false
        System.out.println(g.equals(a + b));

    }
}
