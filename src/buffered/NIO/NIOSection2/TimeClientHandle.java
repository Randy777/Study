package buffered.NIO.NIOSection2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;


    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            //异步非阻塞
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        }catch (IOException e){

        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!stop){
            try {
                //当有准备就绪的Channel时，执行handleInput(selectionKey);
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()){
                    selectionKey = iterator.next();
                    iterator.remove();
                    try{
                        handleInput(selectionKey);
                    }catch (Exception e){
                        if (selectionKey != null){
                            selectionKey.cancel();
                            if (selectionKey.channel() != null){
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (selector != null){
            try {
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        //根据selectionKey的操作位进行判断即可获知网络事件的类型
        if (selectionKey.isValid()){
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            if (selectionKey.isConnectable()){
                //连接成功，则将socketChannel注册到多路复用器上，注册SelectionKey.OP_READ操作位，监听网络读操作
                socketChannel.register(selector,SelectionKey.OP_READ);
                doWrite(socketChannel);
            }else {
                System.exit(1);
            }
            //用于读取客户端的请求消息
            if (selectionKey.isReadable()){
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(readBuffer);
                if (readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println(body);
                    this.stop = true;
                }else if (readBytes < 0){
                    selectionKey.cancel();
                    socketChannel.close();
                }else {
                    ;
                }
            }
        }
    }

    private void doConnect() throws IOException {
        //判断连接是否成功
        if (socketChannel.connect(new InetSocketAddress(host,port))){
            //将socketChannel注册到多路复用器上，注册SelectionKey.OP_READ
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel);
        }else {
            //没有连接成功，将SocketChannel注册到Selector上，注册SelectionKey.OP_CONNECT，
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(req.length);
        byteBuffer.put(req);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        if (!byteBuffer.hasRemaining()){
            System.out.println("success");
        }
    }
}
