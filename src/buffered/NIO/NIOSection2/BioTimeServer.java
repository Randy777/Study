package buffered.NIO.NIOSection2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioTimeServer {

//    private static final int port = 8080;
//    private ServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException {


        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }


        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(port);
            Socket socket = null;
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new
                    TimeServerHandlerExecutePool(50,10000);
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (serverSocket != null){
                serverSocket.close();
            }
        }

    }
}
