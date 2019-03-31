package net.coderdaily.io.bio;

import net.coderdaily.io.ServerHandler;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-03-31 13:46
 * Blog: coderdaily.net
 * <p>
 * 同步阻塞IO，意味着每个请求都是阻塞的，服务端为客户端的每一个请求来创建一个线程进行处理数据
 */
public class BIOTest {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8080;

    /**
     * server
     *
     * @throws IOException
     */
    @Test
    public void testServer() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        Socket socket = null;
        System.out.println("server start...");
        while (true) {
            //阻塞方法
            socket = server.accept();
            new Thread(new ServerHandler(socket)).start();
        }
    }

    /**
     * client
     *
     * @throws IOException
     */
    @Test
    public void testClient() throws IOException {
        Socket socket = new Socket(HOST, PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        //向服务端发送数据
        for (int i = 0; i < 10; i++) {
            out.println(i);
        }

        String response = null;
        while ((response = in.readLine()) != null) {
            System.out.println("client receive server's data :" + response);
        }
    }
}
