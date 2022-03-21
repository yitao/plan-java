package com.simile.plan.java.proxy;

/**
 * 静态代理示例
 *
 * @Author yitao
 * @Created 2022/03/21
 */
public class StaticProxyExample {

    public static void main(String[] args) {
        //构建代理类
        UserServiceProxy proxy = new UserServiceProxy();
        //构造被代理类
        UserService userService = new UserServiceImpl();
        //设置被代理类
        proxy.setUserService(userService);

        proxy.printName("tom");
    }


}
