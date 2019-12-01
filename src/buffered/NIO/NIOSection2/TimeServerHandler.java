package buffered.NIO.NIOSection2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader( new InputStreamReader(this.socket.getInputStream()));
            printWriter = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true){
                body = bufferedReader.readLine();
                if (body == null){
                    break;
                }
                System.out.println(body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?"11111":"22222222";
                System.out.println(currentTime);
            }
        }catch (IOException e){
            if ( bufferedReader != null ){
                try {
                    bufferedReader.close();
                }catch ( IOException e1){
                    e1.printStackTrace();
                }
            }
            if ( printWriter != null){
                printWriter.close();
                printWriter = null;
            }
            if ( this.socket != null){
                try {
                    this.socket.close();
                }catch ( IOException e2 ){
                    e2.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
