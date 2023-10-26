package com.simile.plan.java.nio;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @Author yitao
 * @Created 2023/01/29
 */
public class LineNumberExample {

    public static void main(String[] args) throws IOException {
        String path = "/Users/haizhi/Documents/workspace/work/plan-java/src/main/java/com/simile/plan/java/date/CalendarExample.java";
        LineNumberReader reader = new LineNumberReader(new FileReader(path));
        String temp = null;
//        reader.setLineNumber(10);
        //跳过多少个字符
//        reader.skip(10);
        while ((temp = reader.readLine()) != null) {
//            System.out.println(temp);
        }
        System.out.println(reader.getLineNumber());
    }
}
