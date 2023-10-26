package com.simile.plan.java.datastruct;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yitao
 * @Created 2021/08/27
 */
public class MapExample {
	private Map map;
	private HashMap hashMap;
	private LinkedHashMap linkedHashMap;
	private TreeMap treeMap;
	private Hashtable hashtable;

	private ConcurrentHashMap concurrentHashMap;

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put("C", "C");
        String[] ss = {"A","B","C"};
        for (String s : ss) {
            if(map.containsKey(s)){
                map.remove(s);
            }
        }
        System.out.println(map.size());
    }
}
