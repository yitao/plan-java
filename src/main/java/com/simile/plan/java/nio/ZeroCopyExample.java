package com.simile.plan.java.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.Instant;

/**
 * @Author yitao
 * @Created 2023/01/29
 */
public class ZeroCopyExample {



    public static void main(String[] args) throws IOException {
        Instant t1 = Instant.now();
        sendFile2();
        System.out.println(Instant.now().toEpochMilli() - t1.toEpochMilli());
    }

    public static void sendFile() throws IOException {
        String path = "/Users/haizhi/Documents/workspace/work/plan-java/src/main/java/com/simile/plan/java/datastruct/MapExample.java";
        String out = "/Users/haizhi/Documents/workspace/work/plan-java/_workspace/MapExample2.java";
        FileChannel readChannel = new FileInputStream(path).getChannel();
        FileChannel writeChannel = new FileOutputStream(out).getChannel();

        readChannel.transferTo(readChannel.position(), readChannel.size(), writeChannel);
        writeChannel.close();
        readChannel.close();
    }

    public static void sendFile2() throws IOException {
        String path = "/Users/haizhi/Documents/workspace/work/plan-java/src/main/java/com/simile/plan/java/datastruct/MapExample.java";
        String out = "/Users/haizhi/Documents/workspace/work/plan-java/_workspace/MapExample3.java";
        FileChannel readChannel = new FileInputStream(path).getChannel();
        FileChannel writeChannel = new FileOutputStream(out).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        int pos = readChannel.read(buffer);
        while (pos != readChannel.size()) {
            System.out.println(pos);
            writeChannel.write(buffer, pos);
            pos = readChannel.read(buffer, pos);
//            pos = buffer.position();
        }
        buffer.clear();
        writeChannel.close();
        readChannel.close();
    }


}
