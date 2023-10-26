package com.simile.plan.java.datastruct.string;

/**
 * @Author yitao
 * @Created 2022/06/28
 */
public class StringExample {

    public static void main(String[] args) {
        String tableFieldName = "t1";
        String p = "\\$\\{" + tableFieldName + "\\}";
        String p2 = "\\$\\{" + tableFieldName + "}";
        System.out.println("${t1\\\\}11".replaceAll(p, ""));
        System.out.println("${t1\\\\}11".replaceAll(p2, ""));
    }
}
