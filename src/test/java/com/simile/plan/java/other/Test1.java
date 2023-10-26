package com.simile.plan.java.other;

/**
 * @Author yitao
 * @Created 2023/05/11
 */
public class Test1 {

    public static void main(String[] args) {
        //+优先三目
        System.out.println(1 == 1 ? "1" : "2" + "3");
        long st = 9000123;
        long et = 9000123;
//        st = (st / 1000) * 1000;
//        et = (et / 1000) * 1000 + 999;
        st = st - st % 1000;
        et = et - et % 1000 + 999;
        System.out.println(st);
        System.out.println(et);
    }
}
