package com.simile.plan.java.test.generics;

import com.simile.plan.java.generics.DataSet;
import org.junit.Test;

/**
 * created by yitao on 2020/03/27
 */
public class GenericsTest {

    @Test
    public void testCase1(){
        Integer i = DataSet.<Integer>printInMethod(1);
        Integer i2 = DataSet.printInMethod(1);
        String s3 = DataSet.printInMethod("s1");
        DataSet.<Integer>printInMethodNoRes(1);
        DataSet.printInMethodNoRes("s1");

        Object o = DataSet.getMiddle("s1",2,"s3","s4","s5");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void testCase2(){
        DataSet dataSet = new DataSet();
        dataSet.addItem(1);
        dataSet.addItem("s2");
        dataSet.list.add(3);
        dataSet.list.add("s4");
        dataSet.list.stream().forEach(o->{
            System.out.println(o.getClass());
            System.out.println(o);
        });
    }
}
