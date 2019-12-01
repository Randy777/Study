package NioSection10;

import NioSection10.Handler.HttpFileServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.util.HashMap;
import java.util.Map;

public class HttpFileServer {

    private static final String DEFAULT_URL = "";

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        String url = DEFAULT_URL;
        if (args.length > 1){
            url = args[1];
        }
        new HttpFileServer().run(port,url);
    }

    public void run(int port, final String url) {
        //NioEventLoopGroup(Reactor线程池)，负责调度和执行客户端的接入，网络读写时间的处理，用户自定义任务和定时人物的处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //初始化pipeline
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("http-decoder",
                                    new HttpRequestDecoder());
                            socketChannel.pipeline().addLast("http-aggregator",
                                    new HttpObjectAggregator(65536));
                            socketChannel.pipeline().addLast("http-encoder",
                                    new HttpResponseEncoder());
                            socketChannel.pipeline().addLast("http-chunked",
                                    new ChunkedWriteHandler());
                            socketChannel.pipeline().addLast("fileServerHandler",
                                    new HttpFileServerHandler(url));
                        }
                    });
        }catch (Exception e){

        }finally {

        }
    }

    private void test(){
        Map<String,Object> map = new HashMap<String, Object>(64);
        map.remove("");
    }
}
