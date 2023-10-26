package com.simile.plan.java.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author yitao
 * @Created 2023/09/26
 */
public class FileThreadTest {

    public static void main(String[] args) {
        String p = "/Users/haizhi/Documents/workspace/work/plan-java/_workspace/1.txt";
        for (int i = 0; i < 10; i++) {
            int ii = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    File file = new File(p);
                    try (FileWriter fw = new FileWriter(file)){
                        fw.write(ii + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
