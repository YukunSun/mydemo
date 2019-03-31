package net.coderdaily.io.nio;

import org.junit.Test;

import java.io.PrintWriter;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/6/9 下午6:45
 * Blog: coderdaily.net
 */
public class PrintStreamTest {
    /**
     * System.out 是一个PrintStream
     */
    @Test
    public void test() {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hello");
    }
}
