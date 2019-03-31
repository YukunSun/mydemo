package net.coderdaily.io.bio;

import net.coderdaily.io.ServerHandler;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-03-31 15:07
 * Blog: coderdaily.net
 * <p>
 * 伪异步IO，相当于阻塞IO的升级版，就是在其基础上，不用再每一个请求都创建一个线程，改用线程池的方式，减少创建线程池的开销，防止线程爆炸，但依然改变不了同步阻塞IO的本质。
 */
public class PseudoAIO {
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

        ServerHandlerThreadPool handler = new ServerHandlerThreadPool(10, 1000);
        while (true) {
            //阻塞方法
            socket = server.accept();
            handler.execute(new ServerHandler(socket));
        }
    }

    public class ServerHandlerThreadPool {
        private ExecutorService executorService;

        public ServerHandlerThreadPool(int maxPoolSize, int queueSize) {
            executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 20L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize));
        }

        public void execute(Runnable task) {
            executorService.execute(task);
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
