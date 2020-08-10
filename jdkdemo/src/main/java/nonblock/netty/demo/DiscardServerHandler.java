package nonblock.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/8/10 22:05
 * Blog: bengle.me
 * <p>
 * The most simplistic protocol in the world is not 'Hello, World!' but DISCARD. It's a protocol that discards any received data without any response.
 * <p>
 * https://tools.ietf.org/html/rfc863
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ((ByteBuf) msg).release();
//        try {
//            System.out.println(111);
//            // Do something with msg
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
