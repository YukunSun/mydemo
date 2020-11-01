package net.coderdaily.io.netty.unittest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.http.util.Args;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * @author sunyk
 * <p>
 * 测试入站消息
 **/
public class FixedLengthFrameDecoderTest {

    /**
     * writeInbound,readInbound
     */
    @Test
    public void testFramesDecoded() {
        ByteBuf buf = Unpooled.buffer();
        //构建一个9字节的ByteBuf
        IntStream.range(0, 10).forEach(i -> buf.writeByte(i));
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        //write bytes
        ByteBuf input = buf.duplicate();
        assertTrue(channel.writeInbound(input.retain()));
        assertTrue(channel.finish());

        //read msg
        assertEquals(0, buf.readerIndex());
        ByteBuf read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();
        assertEquals(3, buf.readerIndex());

        read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();
        assertEquals(6, buf.readerIndex());

        read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();
        assertEquals(9, buf.readerIndex());

        assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void testFramesDecoded2() {
        ByteBuf buf = Unpooled.buffer();
        //构建一个9字节的ByteBuf
        IntStream.range(0, 10).forEach(i -> buf.writeByte(i));
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        //write bytes
        ByteBuf input = buf.duplicate();
        //TODO 这里返回false，因为没有凑够完整的一帧数据
        assertFalse(channel.writeInbound(input.readBytes(2)));
        assertTrue(channel.writeInbound(input.readBytes(7)));
        assertTrue(channel.finish());

        //同1
    }

    /**
     * @author sunyk
     * <p>
     * 给定足够的数据,这个实现将产生固定大小的帧。如果没有足够的数据可供读取,它将等待下一个数据块的到来,并将再次检查是否能够产生一个新的帧。
     **/
    class FixedLengthFrameDecoder extends ByteToMessageDecoder {
        private final int frameLength;

        public FixedLengthFrameDecoder(int frameLength) {
            Args.notNegative(frameLength, "frameLength");
            this.frameLength = frameLength;
        }

        @Override
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            while (byteBuf.readableBytes() >= frameLength) {
                //读取新的一帧
                ByteBuf buf = byteBuf.readBytes(frameLength);
                //将读取的一帧添加到已被解码的消息列表中
                list.add(buf);
            }
        }
    }
}

