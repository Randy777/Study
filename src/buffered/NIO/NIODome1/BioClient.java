package buffered.NIO.NIODome1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BioClient {

//    private static final int port = 8080;

    public static void main(String[] args) {

        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try{
            socket = new Socket("127.0.0.1",port);
            bufferedReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()
            ));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("QUERY TIME ORDER");
            String resp = bufferedReader.readLine();
            System.out.println(resp);
        }catch (Exception e){

        }finally {
            try {
                printWriter.close();
                bufferedReader.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

}
