package buffered.NIO.NIOSection2;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;

public class NioTimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        MultplexerTimeServer timeServer = new MultplexerTimeServer(port);

//
        new Thread(timeServer,"NIO-MTS-001").start();
    }
}
