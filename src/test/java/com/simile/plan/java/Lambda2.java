package com.simile.plan.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://zhuanlan.zhihu.com/p/39215520
 *
 * @Author yitao
 * @Created 2022/01/24
 */
public class Lambda2 {

    public static void main(String[] args) {
        System.out.println(Lambda2.getName());
    }

    static {
        Lambda2.getName();
    }

    private static String getName() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add("a" + i);
        }
        datas = datas.parallelStream()
                .filter(s -> s.equalsIgnoreCase("a9"))
                .collect(Collectors.toList());
//        datas = datas.stream().filter(s -> s.equalsIgnoreCase("a9")).collect(Collectors.toList());
        return datas.get(0);
    }
}
