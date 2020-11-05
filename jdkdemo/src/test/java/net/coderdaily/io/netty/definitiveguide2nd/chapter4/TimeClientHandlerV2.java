package net.coderdaily.io.netty.definitiveguide2nd.chapter4;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.util.stream.IntStream;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/11/3 23:22
 * Blog: bengle.me
 */
public class TimeClientHandlerV2 extends ChannelHandlerAdapter {
    private byte[] req;

    public TimeClientHandlerV2() {
        req = "query time order".getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        IntStream.range(0, 100).forEach(i -> {
            ByteBuf msg = Unpooled.buffer(req.length);
            msg.writeBytes(req);
            ctx.writeAndFlush(msg);
        });
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, CharsetUtil.UTF_8);
        System.out.println("Server return:" + body + "\n");
    }
}