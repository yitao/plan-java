package com.simile.plan.java.clazz;

/**
 * 类属性演示1
 *
 * @Author yitao
 * @Created 2024/10/07
 */
public class AttrExample1 {

    //1、属性，定义的格式：[修饰符] [属性类型] [属性名称]
    /*
     * 修饰符：private,protected,public，不填等同于protected
     * private : 私有的，只能在当前类里面使用（赋值和访问）
     * protected : 受保护的，能在当前类以及子类，包下使用
     * public : 公开的，所有地方都能使用
     */
    //属性类型：
    /*
     * 属性名称：语法：等同于类名格式，规范（行业约定）：首字母小写
     * 以下哪些是合法的属性名称：
     * 1. class (关键词)
     * 2. Class （不符合规范，首字母需要小写）
     * 3. _class
     * 4. 1class （数字开头）
     * 5. 类
     * 6. $类Class
     * 7. ClassExample
     * 8. class_example
     * 9. User
     * 10. User*&&@ （非_$的特殊字符）
     * 扩展：以上哪些属性名是符合规范（Java规范）
     */

    //修饰符的演示
    private String name1;
    protected String name2;
    public String name3;
    String name4;

    //类型的演示（8种基础类型，以及其他的类都可以，哪些类不能被使用？(暂无)）
    private ClassExample4 classExample4;
    private int age;

    //属性名称的演示
    private String name;
    private String Name;


    //2、构造方法（默认每个类都有一个无参的构造方法）
    //3、方法


}
