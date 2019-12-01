package buffered.NIO.NIOSection2;





import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultplexerTimeServer implements Runnable{

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    /*构造方法，资源初始化
    * 创建多路复用器Selector，ServerSockerChannel
    * 将ServerSocketChannel注册到Seletor，监听SelectorKey.OP_ACCOPT操作为
    * 如果资源初始化失败，则退出
    * */
    public MultplexerTimeServer(int port){
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println(port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }


    @Override
    public void run() {
        while (!stop){
            try {
                //循环遍历selector，无论有无读写事件，selector每1s都被唤醒一次
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()){
                    selectionKey = iterator.next();
                    iterator.remove();
                    try {
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
            }catch (Throwable e){
                e.printStackTrace();
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
            if (selectionKey.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                //通过ServerSocketChannel的accept()接收客户端的连接请求并创建socketChannel实列（相当于完成TCP三次握手）
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            //用于读取客户端的请求消息
            if (selectionKey.isReadable()){
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
//                ServerSocketChannel serverSocketChannel = socketChannel
                //创建缓冲区
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                /*
                * read非阻塞
                * 返回值readBytes
                * >0,读到了字节，对字节进行编码
                * =0,没有读到字节，属于正常场景，忽略
                * -1,链路已经关闭，需要关闭socketChannel，释放资源。
                * */
                int readBytes = socketChannel.read(byteBuffer);
                if (readBytes > 0){
                    /*读到字节码后*/
                    //将缓冲区当前的limit设置为position，position设置为0,用于后续对缓冲区的操作
                    byteBuffer.flip();
                    //然后根据缓冲区可读的字节个数创建字节数组
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    //调用ByteBuffer的get操作将缓冲区可读的字节数组复制到新创建的数组中
                    byteBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println(body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?"11111":"22222222";
                    System.out.println(currentTime);
                    doWrite(socketChannel,currentTime);
                }else if (readBytes < 0 ){
                    selectionKey.cancel();
                    socketChannel.close();
                }else {
                    ;
                }
            }
        }
    }
    /*将应答消息异步发送给客户端*/
    private void doWrite(SocketChannel socketChannel, String currentTime) throws IOException {

        if (currentTime != null && currentTime.trim().length() > 0){
            //将字符串编码成字节数组
            byte[] bytes = currentTime.getBytes();
            //根据字节数组的容量创建ByteBuffer
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //调用ByteBuffer的put()将字节数组复制到缓冲区
            writeBuffer.put(bytes);
            //然后对缓冲区进行flip操作
            writeBuffer.flip();
            //将缓冲区的字节数组发送出去。
            socketChannel.write(writeBuffer);
        }
    }
}
