package net.coderdaily.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/6/9 下午7:10
 * Blog: coderdaily.net
 */
public class NIOTest {
    @Test
    public void test() throws IOException {
        //1.write a file
        FileChannel channel = new FileOutputStream("/Users/sunyk/test/data.txt").getChannel();
        channel.write(ByteBuffer.wrap(("some text\n").getBytes()));
        channel.close();

        //2.在文件的末尾添加一些东西
        channel = new RandomAccessFile("/Users/sunyk/test/data.txt", "rw").getChannel();
        //移动到末尾
        channel.position(channel.size());
        channel.write(ByteBuffer.wrap(("some thing\n").getBytes()));
        channel.close();

        //3.读取内容
        channel = new FileInputStream("/Users/sunyk/test/data.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        //把指针移到开始位置，将Buffer从写模式切换到读模式
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
    }
}
