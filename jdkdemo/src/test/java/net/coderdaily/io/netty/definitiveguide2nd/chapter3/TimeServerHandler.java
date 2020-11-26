package net.coderdaily.io.netty.definitiveguide2nd.chapter3;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.util.Date;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/10/31 22:41
 * Blog: bengle.me
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, CharsetUtil.UTF_8);
        String body = (String) msg;
        System.out.println("TimeServer rec order:" + body);
        String currentTime = "query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad order";
        currentTime = currentTime + "\n";
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
