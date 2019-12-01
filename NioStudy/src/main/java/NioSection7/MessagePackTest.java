package NioSection7;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

public class MessagePackTest extends MessageToByteEncoder<Object> {

    //编码器
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf)
            throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(o);
        byteBuf.writeBytes(raw);
    }
}
