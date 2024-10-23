package com.simile.plan.java.clazz;

/**
 * 类的基本格式
 * [修饰符（可选）] [关键词class] [类名，命名格式：下划线，$和字母，中文（不建议使用）开头，其他部分还可以用数字（驼峰，每个单词的首字母大写），非java关键词]
 * <p>
 * 以下哪些的类名是合法(符合语法)的？
 * 1. class (关键词)
 * 2. Class
 * 3. _class
 * 4. 1class （数字开头）
 * 5. 类
 * 6. $类Class
 * 7. ClassExample
 * 8. class_example
 * 9. User
 * 10. User*&&@ （非_$的特殊字符）
 * <p>
 * 扩展：以上哪些类名是符合规范（Java规范）
 * <p>
 * 以下四种类有什么区别？（无修饰符，private,protected,public这四种修饰符在类前面的区别）
 * private class User1
 * protected class User2
 * public class User3
 * class User4
 * <p>
 * public : 无论在哪个包下面都可以使用
 *
 * @Author yitao
 * @Created 2024/10/07
 */
public class MethodExample1 {
    //1、属性
    //2、构造方法（默认每个类都有一个无参的构造方法）
    //3、方法，定义的格式：[修饰符] [返回值类型] [方法名称]
    /*
     * 修饰符：private,protected,public，不填等同于protected
     * private : 私有的，只能在当前类里面使用（赋值和访问）
     * protected : 受保护的，能在当前类以及子类，包下使用
     * public : 公开的，所有地方都能使用
     */
    //返回值类型：void标识无值返回，要么return;要么不写return，其他的都是根据return后面的值的类型来写
    /*
     * 方法名称：语法：等同于类名格式，规范（行业约定）：首字母小写
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
    public void printHello() {
        System.out.println("hello");
    }

}
