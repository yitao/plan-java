package com.simile.plan.java.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Author yitao
 * @Created 2022/03/21
 */
public class CGLibProxyExample {

    public static void main(String[] args) {
        proxyClass();
        System.out.println("--------");
        proxyInterface();
    }

    /**
     * 尝试代理一个类
     */
    public static void proxyClass() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("handler before " + method.getName());
                /*
                 * 为什么是 invokeSuper 而不是 invoke，因为你构造的是该类的一个子类，
                 * 而这段拦截的代码也是在执行子类的方法的时候被调用
                 * invoke 表示执行子类的中的方法，invokeSuper则是调用父类中的方法。
                 * 如果使用 invoke 则会不断的去调用子类的方法，然后被拦截，拦截后又调用子类的方法...，便无限循环了
                 */
//                Object result = methodProxy.invoke(o, args);
                Object result = methodProxy.invokeSuper(o, args);
                System.out.println("handler after " + method.getName());
                return result;
            }
        });
        /*
        以下代码实际上创建的是子类，即 UserServiceImpl 的子类。
        com.simile.plan.java.proxy.UserServiceImpl$$EnhancerByCGLIB$$108778f3@13805618
        所以这里构造出来的对象，只要是UserServiceImpl的父类都可以强转成功。
        比如：
            UserService userService = (UserService) enhancer.create();
        只不过调用的方法需要在父类中声明。否则则会报 NoSuchMethodError 错误
         */
        UserService userService = (UserService) enhancer.create();
//        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.printName("tom");
    }

    /**
     * 尝试代理一个接口
     */
    public static void proxyInterface() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("handler before " + method.getName());
                Object result = methodProxy.invokeSuper(o, args);
                System.out.println("handler after " + method.getName());
                return result;
            }
        });
        UserService userService = (UserService) enhancer.create();
        /*
        由于UserService是个接口，而接口的父类是Object，故执行以下方法printName，则会视为在父类Object中执行。
        故以下代码无法运行成功。
        假设你想要的是代理一个接口，则可以直接使用JDK提供的Proxy即可
         */
        userService.printName("tom");
    }


}
