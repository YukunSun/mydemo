package net.coderdaily.io.netty.definitiveguide2nd.chapter4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/11/1 22:39
 * Blog: bengle.me
 */
public class TimeClient {
    public void connect(int port, String host) {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new TimeClientHandlerV2());
                    }
                });
        try {
            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new TimeClient().connect(8080, "127.0.0.1");
    }
    /**
     * 1 expect:server 会收到100条“TimeServer rec order:query time order”
     *   actual：收到了2条如下的消息：“TimeServer rec order:query time orderquery time order...略”
     *
     * 2 既然服务端收到了两条，那么客户端也应该收到两条“Server return:bad order”
     *   而实际上只收到了一条连在一起的：“Server return:bad orderbad order”
     *
     * 这说明：发送时、收到回复时都发生了粘包
     */
}
