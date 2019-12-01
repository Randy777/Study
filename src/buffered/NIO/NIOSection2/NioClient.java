package buffered.NIO.NIOSection2;

public class NioClient {

    public static void main(String[] args) {

        int port = 8080;
        if (args != null && args.length > 0){
            port = Integer.valueOf(args[0]);
        }
        new Thread(new TimeClientHandle("127.0.0.1",port),"TC-001").start();
    }
}
