package com.simile.plan.java.datastruct.integer;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2022/07/04
 */
public class IntegerExample {
    /**
     * Integer中的缓存
     * 在jdk1.8中Integer缓存了[-128,127)的值，故在此区间的值将使用同一个引用
     * 参考Integer.IntegerCache
     */
    @Test
    public void cache() {
        Integer a = -128;
        Integer b = -128;
        Integer a1 = -129;
        Integer b1 = -129;
        Integer c = 127;
        Integer d = 127;
        Integer e = 128;
        Integer f = 128;
        Integer g = Integer.valueOf(128);
        //output:true
        System.out.println(a == b);
        //output:true
        System.out.println(c == d);
        //output:false
        System.out.println(a1 == b1);
        //output:false
        System.out.println(e == f);
        /*
        实际上直接将 128 赋值给 f。和 Integer.valueOf(128) 赋值给 g 是一样的。
         */
        //output:false
        System.out.println(e == g);
    }


    @Test
    public void bound() {
        Integer i = Integer.MAX_VALUE;
        Integer i2 = Integer.MAX_VALUE;
        System.out.println(i + 1);
        System.out.println(i + i2);
    }

}
