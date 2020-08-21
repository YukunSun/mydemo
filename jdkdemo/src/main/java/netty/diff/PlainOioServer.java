package netty.diff;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author sunyk
 * <p>
 * 普通的阻塞 IO
 **/
public class PlainOioServer {
    public void serve(int port) throws IOException {
        ServerSocket socket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = socket.accept();
            new Thread(() -> {
                OutputStream out = null;
                try {
                    out = clientSocket.getOutputStream();
                    out.write("PlainOioServer send data....\n".getBytes(Charset.forName("UTF-8")));
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        PlainOioServer oioServer = new PlainOioServer();
        oioServer.serve(8080);
        //telnet localhost 8080
    }
}
