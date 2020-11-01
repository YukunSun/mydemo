package net.coderdaily.io.netty.unittest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author sunyk
 * <p>
 * 测试异常处理
 **/
public class FrameChunkDecoderTest {
    @Test
    public void testFrameDecoded() {
        //写入9个字节
        ByteBuf buf = Unpooled.buffer();
        IntStream.range(0, 9).forEach(i -> buf.writeByte(i));

        ByteBuf input = buf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(3));
        assertTrue(channel.writeInbound(input.readBytes(2)));
        try {
            //预期这里会抛出 TooLongFrameException 异常，如果未抛出异常则会执行 Assert.fail();
            channel.writeInbound(input.readBytes(4));
            Assert.fail();
        } catch (TooLongFrameException e) {
//            e.printStackTrace();
        }
        //写入最后剩下的3个字节
        assertTrue(channel.writeInbound(input.readBytes(3)));
        //todo 标记完成
        assertTrue(channel.finish());
        //读第一帧
        ByteBuf read = channel.readInbound();
        assertEquals(buf.readSlice(2), read);
        read.release();
        //读第二帧
        read = channel.readInbound();
        assertEquals(buf.skipBytes(4).readSlice(3), read);

        read.release();
        buf.release();
    }

    class FrameChunkDecoder extends ByteToMessageDecoder {
        private final int maxFrameSize;

        public FrameChunkDecoder(int maxFrameSize) {
            this.maxFrameSize = maxFrameSize;
        }

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            int readableBytes = in.readableBytes();
            //丢弃该帧，并抛出异常
            if (readableBytes > maxFrameSize) {
                in.clear();
                throw new TooLongFrameException();
            }
            ByteBuf buf = in.readBytes(readableBytes);
            out.add(buf);
        }
    }
}