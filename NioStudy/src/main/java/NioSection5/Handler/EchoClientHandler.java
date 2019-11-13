package NioSection5.Handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHandler extends ChannelHandlerAdapter {

    static final String ECHO_REQ = "Welcome to Netty.$_";

    private int counter;

    public EchoClientHandler(){

    }

    public void channelActive(ChannelHandlerContext channelHandlerContext){

        for (int i = 0; i < 10; i++){
            channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext,
                            Object msg){
        System.out.println(counter++ + ":" + msg);
        channelHandlerContext.flush();
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext){
        channelHandlerContext.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
