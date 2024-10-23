package com.simile.plan.java.clazz;

/**
 * 类的构造方法示例类2
 * 显示声明无参构造方法
 *
 * @Author yitao
 * @Created 2024/10/07
 */
public class ConstructorExample4 {

    //1、属性
    private String name;
    private String addr;
    private int age;
    //2、构造方法（默认每个类都有一个无参的构造方法）
    //3、方法

    /**
     * 显式构造无参构造方法
     */
    public ConstructorExample4() {
    }

    //1个String类型参数的构造方法
    //有参构造方法，以参数的数量，类型来区分
//  全限定名称（唯一身份）：  public ConstructorExample4(String)
    public ConstructorExample4(String name) {
        this.name = name;
    }

    // 全限定名称（唯一身份）：   public ConstructorExample4(String)
    // 以下和上面的冲突的，不合法
//    public ConstructorExample4(String addr) {
//        this.addr = addr;
//    }

    //2个String类型参数的构造方法
    //全限定名称（唯一身份）： public ConstructorExample4(String,String)
    public ConstructorExample4(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    //String,String,int的构造方法
    public ConstructorExample4(String name, String addr, int age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }
}
