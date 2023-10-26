package com.simile.plan.java.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2023/10/23
 */
public class HashTest {

    @Test
    public void testHash() {
        System.out.println("123".toCharArray());
        System.out.println("123".hashCode());
        System.out.println("132".hashCode());

        Map<String, List<String>> tmp = new HashMap<>();
        tmp.values();
    }
}
