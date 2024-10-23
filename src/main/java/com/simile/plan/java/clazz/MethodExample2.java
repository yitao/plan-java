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
public class MethodExample2 {
    //1、属性
    //2、构造方法（默认每个类都有一个无参的构造方法）
    //3、方法，定义的格式：[修饰符] [返回值类型] [方法名称]
    // 方法的全限定名称(签名，身份标识，在当前类下唯一)的格式：方法名称(参数类型...）

    private String name;

    //get方法，获取属性的方法
    // 全限定名称（唯一身份）：getName()
    public String getName() {
        return name;
    }

    //set方法，给属性赋值的方法
    // 全限定名称（唯一身份）：setName(String)
    public void setName(String name) {
        //this指代自己的对象，暂用
        this.name = name;
    }

    //编译报错，和上面的冲突
    // 全限定名称（唯一身份）：setName(String)
//    public int setName(String name) {
//        this.name = name;
//        return 1;
//    }

    public int setName(String name, int age) {
        this.name = name;
        return 1;
    }


}
