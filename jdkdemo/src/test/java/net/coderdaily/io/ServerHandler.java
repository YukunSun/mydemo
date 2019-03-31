package net.coderdaily.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-03-31 16:03
 * Blog: coderdaily.net
 */
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