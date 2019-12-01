package NioSection3;

import NioSection3.Handle.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/***
 * P73
 */
public class TimeClient {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args != null && args.length > 0){
            port = Integer.valueOf(args[0]);
        }
        new TimeClient().connect(port,"127.0.0.1");
    }

    public void connect(int port, String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel
                                .pipeline()
                                .addLast(new LineBasedFrameDecoder(1024));
                        socketChannel
                                .pipeline()
                                .addLast(new StringDecoder());
                        socketChannel
                                .pipeline()
                                .addLast(new TimeClientHandler());
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
