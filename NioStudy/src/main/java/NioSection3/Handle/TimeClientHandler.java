package NioSection3.Handle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

public class TimeClientHandler extends ChannelHandlerAdapter {

    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

    private int counter;

    private byte[] req;

    public void channelActive(ChannelHandlerContext channelHandlerAdapter){

        ByteBuf byteBuf = null;
        byteBuf = Unpooled.buffer(req.length);
        byteBuf.writeBytes(byteBuf);
        channelHandlerAdapter.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
