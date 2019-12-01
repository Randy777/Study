package buffered.NIO.NIODome1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {

    private static final String host = "127.0.0.1";
    private static final int port = 8080;
    private Selector selector;

    public static void main(String[] args) {

        for (int i=0 ; i<3 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    NioClient client = new NioClient();
                    client.connect(host,port);
                    client.listen();
                }
            });
        }
    }

    private void listen() {
        while (true){
            try {
                int events = selector.select();
                if ( events>0 ){
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                    while ( selectionKeyIterator.hasNext() ){
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        selectionKeyIterator.remove();
                        if ( selectionKey.isConnectable() ){
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            if ( socketChannel.isConnectionPending() ){
                                socketChannel.finishConnect();
                            }
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector,SelectionKey.OP_READ);
                            socketChannel.write(ByteBuffer.wrap(("Hello this is " + Thread.currentThread().getName()).getBytes()));
                        }else if ( selectionKey.isReadable() ){
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            socketChannel.read(byteBuffer);
                            byteBuffer.flip();
                            System.out.println("收到服务端的数据："+new String(byteBuffer.array()));
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void connect(String host, int port) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            this.selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress(host,port));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
