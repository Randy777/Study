package NioSection3;

import NioSection3.Handle.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            port = Integer.valueOf(args[0]);
        }
        new TimeServer().bind(port);
    }

    public void bind(int port) {
        //配置服务端的nio线程组(Reactor线程组)，一个用于服务端接收客户端连接，一个用于进行SocketChannel的网络读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //netty'用于启动NIO服务端的辅助启动类（降低服务端的开发复杂度）
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup).
                    channel(NioServerSocketChannel.class).
                    option(ChannelOption.SO_BACKLOG, 1024).
                    childHandler(new ChildChannelHandler());
            //用于异步操作的回调通知
            ChannelFuture channelFuture = serverBootstrap.
                    bind(port).//绑定端口，同步等待成功
                    sync();
            channelFuture.
                    channel().
                    closeFuture().
                    sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放线程池资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
