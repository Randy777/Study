package NioSection3.Handle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;
import java.io.UnsupportedEncodingException;

public class TimeServerHandle extends ChannelHandlerAdapter {

    public void channelRead(ChannelHandlerContext channelHandlerContext,
                            Object msg) throws UnsupportedEncodingException {
        String aaa;
        ByteBuf byteBuffer = (ByteBuf) msg;
        byte[] req = new byte[byteBuffer.readableBytes()];
        byteBuffer.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println(body);
        if (!StringUtil.isNullOrEmpty(body)){
             aaa = "aaa";
        }else {
             aaa = "bbb";
        }
        ByteBuf resp = Unpooled.copiedBuffer(aaa.getBytes());
        channelHandlerContext.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
