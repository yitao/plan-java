package com.simile.plan.java.proxy;

/**
 * @Author yitao
 * @Created 2022/03/21
 */
public class UserServiceProxy implements UserService {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void printName(String name) {
        userService.printName(name);
    }
}
