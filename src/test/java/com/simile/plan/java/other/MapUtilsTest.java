package com.simile.plan.java.other;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/12/07
 */
public class MapUtilsTest {

    @Test
    public void name() {
        Map<String, Object> value = new HashMap<>();
        value.put("value", "false");
        System.out.println(
                MapUtils.getBoolean(value, "value", true)
        );
    }
}
