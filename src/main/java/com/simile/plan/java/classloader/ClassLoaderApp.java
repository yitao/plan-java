package com.simile.plan.java.classloader;

/**
 * Created by yitao on 2021/03/17.
 */
public class ClassLoaderApp {

    public static void main(String[] args) throws Exception {
        LocalLibClassLoader cl = new LocalLibClassLoader(ClassLoader.getSystemClassLoader());
        Class clazz = cl.findClass("User");
        System.out.println(clazz == null);
        Object object = clazz.newInstance();
        if (object instanceof IUser) {
            IUser user = (IUser) object;
            user.setName("战三");
        }
        System.out.println(object);
    }
}
