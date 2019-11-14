package NioSection5;

import NioSection3.Handle.TimeClientHandler;
import NioSection5.Handler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        new EchoClient().connect(port,"127.0.0.1");
    }

    public void connect(int port, String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        io.netty.bootstrap.Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //分隔符“$_”解决拆包/粘包问题
                        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                        socketChannel
                                .pipeline()
                                .addLast(new DelimiterBasedFrameDecoder(1024,
                                        delimiter));
                        //固定长度解码器，解决拆包/粘包问题
//                        socketChannel
//                                .pipeline()
//                                .addLast(new FixedLengthFrameDecoder(20));
                        socketChannel
                                .pipeline()
                                .addLast(new StringDecoder());
                        socketChannel
                                .pipeline()
                                .addLast(new EchoClientHandler());
                    }
                });
        //发起异步连接操作
        ChannelFuture channelFuture = bootstrap
                .connect(host,port)
                .sync();
        //等待客户端链路关闭
        channelFuture
                .channel()
                .closeFuture()
                .sync();
        //优雅退出，释放NIO线程组
        group.shutdownGracefully();
    }
}
