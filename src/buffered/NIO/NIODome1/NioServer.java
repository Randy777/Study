package buffered.NIO.NIODome1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioServer {

    private int port;
    private Selector selector;
    private ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        new NioServer(8080).start();
    }

    public NioServer(int port){
        this.port = port;
    }

    public void init(){
        ServerSocketChannel serverSocketChannel = null;
        try {
            /*打开serverSocketChannel（父管道），*/
            serverSocketChannel = ServerSocketChannel.open();
            /*设为非阻塞*/
            serverSocketChannel.configureBlocking(false);
            /*绑定监听端口*/
            serverSocketChannel.bind(new InetSocketAddress(port));
            /*创建Reactor线程，创建多路复用器并启动线程*/
            selector = Selector.open();
            /*将serverSocketChannel注册到Reactor线程的多路复用器上，监听ACCEPT事件*/
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("NioServer started ......");
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }
    }

    public void accept(SelectionKey key){
        try{
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            /*多路复用器监听到有新的客户端接入，处理新的请求，完成TCP三次握手，建立物理链路*/
            SocketChannel socketChannel = serverSocketChannel.accept();
            /*设置客户端链路为非阻塞*/
            socketChannel.configureBlocking(false);
            /*将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作，读取客户端发送的网络消息*/
            socketChannel.register(selector,SelectionKey.OP_READ);
            System.out.println("accept a client" + socketChannel.socket().getInetAddress().getHostName());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void  start(){
        this.init();
        while (true){
            try {
                int events = selector.select();
                if ( events > 0 ){
                    /*多路复用器在线程run方法的无限循环体内轮询就绪的Key*/
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                    while ( selectionKeys.hasNext()){
                        SelectionKey key = selectionKeys.next();
                        selectionKeys.remove();
                        if ( key.isAcceptable()){
                            accept(key);
                        }else {
                            service.submit(new NioServerHandler(key));
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
