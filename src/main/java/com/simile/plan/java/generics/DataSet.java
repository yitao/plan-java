package com.simile.plan.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yitao on 2020/03/27
 */
public class DataSet<T> {

    public T data;
    public List<T> list = new ArrayList<T>();

    public DataSet() {
    }

    public DataSet(T data) {
        this.data = data;
    }

    public T print(T t){
        System.out.println(t.getClass());
        return t;
    }

    public static <T> void printInMethodNoRes(T t){
        System.out.println(t.getClass());
    }

    public static <T> T printInMethod(T t){
        System.out.println(t.getClass());
        return t;
    }

    public static <T> DataSet<T> instance(){
        return new DataSet<T>();
    }

    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }

    public void addItem(T t){
        this.list.add(t);
    }
}
