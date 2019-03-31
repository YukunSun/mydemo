package net.coderdaily.io.bio;

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

    public class ServerHandler implements Runnable {
        private Socket socket;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                String body = null;
                while (true) {
                    body = in.readLine();
                    if (body != null) {
                        System.out.println(Thread.currentThread().getId() + ",server receive client's data:" + body);
                        out.println("response:" + body);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
