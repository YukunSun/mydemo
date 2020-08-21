package netty.diff;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sunyk
 **/
public class PlainNioServer {
    public void serve(int port) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        ServerSocket serverSocket = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        serverSocket.bind(address);
        Selector selector = Selector.open();
        //将 ServerSocket 注册到 Selector 来接受新的连接
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer msg = ByteBuffer.wrap(">>>PlainNioServer send data...\n".getBytes());
        //wrap msg
        while (true) {
            try {
                //block until next event
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            //所有接收事件的 SelectionKey 实例
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //todo
                iterator.remove();
                try {
//                    if (key.isReadable()) {
//                        System.out.println("key is readable...");
//                    }
//                    if (key.isConnectable()) {
//                        System.out.println("key is connectable...");
//                    }
                    //检查事件是否是一个新的已经就绪可以被接受的连接
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        //接受客户端并将它注册到选择器
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());

                        System.out.println(">>>accepted connection from " + client);
                    }
                    //检查 socket 是否已经准备好写数据
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        while (buffer.hasRemaining()) {
                            //写数据到客户端
                            if (client.write(buffer) == 0) {
                                break;
                            }
                        }
                        client.close();
                    }
                } catch (Exception e) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PlainNioServer nioServer = new PlainNioServer();
        nioServer.serve(8081);
    }
}
