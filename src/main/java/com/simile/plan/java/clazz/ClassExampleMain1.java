package com.simile.plan.java.clazz;

import java.util.Scanner;

/**
 * @Author yitao
 * @Created 2024/10/07
 */
public class ClassExampleMain1 {

    public static void main(String[] args) {
        //使用无参构造方法初始化一个对象
        //example1是类ClassExample1的对象，即对象是类的实例化，new 类名()，new 类名(构造参数...)
        ConstructorExample1 example1 = new ConstructorExample1();
        //ClassExample1和ClassExample2都是只有无参的构造方法，区别在于，ClassExample1是没有显式的去声明无参构造
        // （不写就等同有一个默认的无参构造方法）
        ConstructorExample2 example2 = new ConstructorExample2();


    }
}
