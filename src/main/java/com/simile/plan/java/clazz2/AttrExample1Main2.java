package com.simile.plan.java.clazz2;

import com.simile.plan.java.clazz.AttrExample1;

/**
 * @Author yitao
 * @Created 2024/10/07
 */
public class AttrExample1Main2 {

    public static void main(String[] args) {
        AttrExample1 example1 = new AttrExample1();
        //编译报错
//        System.out.println(example1.name1);
        //编译报错
//        System.out.println(example1.name2);
        //以下正常，从规范上来说不建议使用
        System.out.println(example1.name3);
        //编译报错
//        System.out.println(example1.name4);
    }
}
