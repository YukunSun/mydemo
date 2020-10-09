package net.coderdaily.io.netty.unittest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * @author sunyk
 * <p>
 * 测试出站消息
 **/
public class AbsIntegerEncoderTest {
    @Test
    public void testEncoded() {
        ByteBuf buf = Unpooled.buffer();
        IntStream.range(-9, 0).forEach(i -> buf.writeInt(i));
        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());

        assertTrue(channel.writeOutbound(buf));
        assertTrue(channel.finish());
        for (int i = 9; i > 0; i--) {
            assertEquals(channel.readOutbound(), Integer.valueOf(i));
        }
        assertNull(channel.readOutbound());
    }

    class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {

        @Override
        protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
            while (msg.readableBytes() >= 4) {
                int value = Math.abs(msg.readInt());
                out.add(value);
            }
        }
    }
}
