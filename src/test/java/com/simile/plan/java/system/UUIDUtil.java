package com.simile.plan.java.system;

import java.util.UUID;

/**
 * @author zhaoxiaotong
 * @version 1.0
 * @description UUIDUtil
 * @date 2021/8/12
 * @time 2:06 PM
 */
@SuppressWarnings("HideUtilityClassConstructor")
public class UUIDUtil {

    public UUIDUtil() {

    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * (获取指定长度uuid)
     *
     * @return
     */
    public static String getFixLenUUID(int len) {
        if (0 >= len) {
            return null;
        }
        String uuid = getUUID();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            str.append(uuid.charAt(i));
        }
        return str.toString();
    }
}
