package com.simile.plan.java.system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/12/06
 */
public class UUIDTest {

    @Test
    public void gen() {
        List<String> uuids = new ArrayList<>();
        int size = 100;
        for (int i = 0; i < size; i++) {
            uuids.add(UUIDUtil.getFixLenUUID(16));
        }
        System.out.println(uuids.stream().distinct().count() == size);
        System.out.println(uuids.stream().distinct().count());
    }
}
