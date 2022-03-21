package com.simile.plan.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author yitao
 * @Created 2022/03/21
 */
public class JDKDynamicProxyExample {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        UserService userService = new UserServiceImpl();
        UserService proxy = getProxy(userService);
        proxy.printName("tom");
    }

    public static UserService getProxy(Object instance) {
        InvocationHandler handler = new SampleInvocationHandler(instance);
        return (UserService) Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), handler);
    }


    public static class SampleInvocationHandler implements InvocationHandler {
        Object instance;

        public SampleInvocationHandler(Object instance) {
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("handler before " + method.getName());
            Object result = method.invoke(instance, args);
            System.out.println("handler after " + method.getName());
            return result;
        }
    }

}
