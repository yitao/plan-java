package com.simile.plan.java.clazz;

/**
 * @Author yitao
 * @Created 2024/10/07
 */
public class SubUser extends User {
    String name;

    public void setName(String name) {
        this.name = name;
        super.name = name;
        //编译报错
//        String name;
    }
}
