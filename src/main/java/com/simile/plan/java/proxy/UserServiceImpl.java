package com.simile.plan.java.proxy;

/**
 * @Author yitao
 * @Created 2022/03/21
 */
public class UserServiceImpl implements UserService {

    @Override
    public void printName(String name) {
        System.out.println("UserServiceImpl:" + name);
    }

}
