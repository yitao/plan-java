package com.simile.plan.java.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * @Author yitao
 * @Created 2022/04/06
 */
public class ProcessExample {


    public static void main(String[] args) throws IOException, InterruptedException {
//        String[] cmds = {"pwd"};
//        String[] cmds = {"git", "push"};
        String[] cmds = {"git", "status"};
        Runtime runtime = Runtime.getRuntime();
        System.out.println("当前用户空间：" + System.getProperty("user.dir"));
//        Process process = runtime.exec(cmds);
        Process process = new ProcessBuilder(cmds).start();
//        Process process = runtime.exec(cmds, new String[]{}, new File("/Users/haizhi/Documents/workspace/work/"));
        process.waitFor(1, TimeUnit.MILLISECONDS);
//        process.waitFor();

        InputStream input = process.getInputStream();
        InputStream err = process.getErrorStream();


        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = null;
        System.out.println("标准流：");
        while ((line = reader.readLine()) != null) {
            System.out.println(System.currentTimeMillis() + ":" + line);
        }
        reader.close();
        input.close();

        BufferedReader errReader = new BufferedReader(new InputStreamReader(err));
        String errLine = null;
        System.out.println("异常流：");
        while ((errLine = errReader.readLine()) != null) {
            System.out.println(System.currentTimeMillis() + ":" + errLine);
        }
        errReader.close();
        err.close();



        int exitValue = process.exitValue();

        System.out.println(exitValue);
    }
}
