package com.simile.plan.java.clazz;

/**
 * 类的构造方法示例类2
 * 显示声明无参构造方法
 *
 * @Author yitao
 * @Created 2024/10/07
 */
public class ConstructorExample3 {

    //1、属性
    private String name;
    //2、构造方法（默认每个类都有一个无参的构造方法）
    //3、方法

    /**
     * 显式构造无参构造方法
     */
    public ConstructorExample3() {
    }

    //有参构造方法，以参数的类型来区分
    public ConstructorExample3(String name) {
        this.name = name;
    }

}
