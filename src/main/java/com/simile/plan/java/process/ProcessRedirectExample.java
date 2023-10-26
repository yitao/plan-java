package com.simile.plan.java.process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author yitao
 * @Created 2022/04/06
 */
public class ProcessRedirectExample {


    public static void main(String[] args) throws IOException, InterruptedException {
//        String[] cmds = {"pwd"};
//        String[] cmds = {"git", "push"};
//        String[] cmds = {"git", "status"};
        String[] cmds = {"mvn", "--version"};
        Runtime runtime = Runtime.getRuntime();
        String userDirPath = System.getProperty("user.dir");
        System.out.println("当前用户空间：" + userDirPath);
        System.err.println("error");
        File userDir = new File(userDirPath);
//        Process process = runtime.exec(cmds);
        ProcessBuilder pb = new ProcessBuilder(cmds);
        File logFile = new File(userDir, "process_redirect_example.log");
        System.out.println("文件是否存在：" + logFile.exists());
        if (!logFile.exists()) {
            FileWriter fw = new FileWriter(logFile);
            fw.append("").flush();
            fw.close();
        }
        //重定向异常输出流
//        pb.redirectError(ProcessBuilder.Redirect.appendTo(logFile));
        //重定向标准输出流
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(logFile));
        //通过重定向输出流，可以将很方便的将异常和标准流中的日志信息合并到一起

        //重定向输入流，注意该流不是用来输出的！
//        pb.redirectInput(logFile);

        Process process = pb.start();
//        process.waitFor(1, TimeUnit.MILLISECONDS);
        process.waitFor();

        int exitValue = process.exitValue();

        System.out.println(exitValue);
    }
}
