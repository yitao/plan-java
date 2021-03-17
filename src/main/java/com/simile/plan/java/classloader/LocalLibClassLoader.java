package com.simile.plan.java.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by yitao on 2021/03/17.
 */
public class LocalLibClassLoader extends ClassLoader {

    public LocalLibClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        try {
            clazz = super.findClass(name);
        } catch (ClassNotFoundException e) {
        }
        if (clazz != null) {
            return clazz;
        }
        byte[] data = new byte[0];
        try {
            data = getClassData(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (data != null) {
            return defineClass(name, data, 0, data.length);
        }
        return null;
    }

    private byte[] getClassData(String name) throws IOException {
        File file = new File("/Users/haizhi/Desktop/work/plan-java/lib/User.class");
        byte[] data = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            int size = fis.available();
            data = new byte[size];
            fis.read(data);
        }
        return data;
    }


}
