package com.simile.plan.java.clazz;

/**
 * 类的基本格式
 * [修饰符（可选）] [关键词class] [类名，命名格式：下划线，$和字母，中文（不建议使用）开头，其他部分还可以用数字（驼峰，每个单词的首字母大写），非java关键词]
 *
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
 *
 * 扩展：以上哪些类名是符合规范（Java规范）
 *
 * 以下四种类有什么区别？（无修饰符，private,protected,public这四种修饰符在类前面的区别）
 * private class User1
 * protected class User2
 * public class User3
 * class User4
 *
 * public : 无论在哪个包下面都可以使用
 *
 * @Author yitao
 * @Created 2024/10/07
 */
public class ClassExample1 {
    //1、属性
    //2、构造方法（默认每个类都有一个无参的构造方法）
    //3、方法

}
