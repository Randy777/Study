package NioSection5.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerHandler extends ChannelHandlerAdapter {

    int counter = 0;

    public void channelRead(ChannelHandlerContext channelHandlerContext,Object msg){
        String body = (String) msg;
        System.out.println(++counter+":"+body);
        //返回消息需要在消息尾部拼接分隔符（$_）
        body += "$_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        channelHandlerContext.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
