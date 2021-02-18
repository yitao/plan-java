package com.simile.plan.java.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yitao
 * @since 2021/1/12
 */
public class GroupByMain {
    public static void main(String[] args) {
        List<Map<String, Object>> records = new ArrayList<>();
        Map<String, Object> r1 = new HashMap<>();
        r1.put("key", "1");
        r1.put("type", "2");
        records.add(r1);

        Map<String, Object> r2 = new HashMap<>();
        r2.put("key", "2");
        r2.put("type", "2");
        records.add(r2);

        Map<String, Object> r12 = new HashMap<>();
        r12.put("key", "1");
        r12.put("type", "1");
        records.add(r12);

        Map<String, Object> r22 = new HashMap<>();
        r22.put("key", "2");
        r22.put("type", "1");
        records.add(r22);

        LinkedHashMap<String,List<Map<String,Object>>> maps = records.stream().collect(
                Collectors.groupingBy(
                        m ->(String) m.get("key"),
                        LinkedHashMap::new,
                        Collectors.<Map<String,Object>>toList()
                )
        );
        System.out.println(maps);
    }
}
