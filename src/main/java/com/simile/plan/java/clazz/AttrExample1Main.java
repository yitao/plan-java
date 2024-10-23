package com.simile.plan.java.clazz;

/**
 * @Author yitao
 * @Created 2024/10/07
 */
public class AttrExample1Main {

    public static void main(String[] args) {
        AttrExample1 example1 = new AttrExample1();
        //编译报错
//        System.out.println(example1.name1);
        //以下都正常
        System.out.println(example1.name2);
        System.out.println(example1.name3);
        System.out.println(example1.name4);
    }
}
