package buffered.NIO.NIODome1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

    public static void main(String[] args) throws IOException {
        String src = "";
        String dst = "";
        copyFileUseNIO(src,dst);
    }

    public static void  copyFileUseNIO(String src,String dst) throws IOException {
        /*声明源文件和目标文件*/
        FileInputStream fileInputStream = new FileInputStream(new File(src));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inFileChannel = fileInputStream.getChannel();
        FileChannel outFileChannel = fileOutputStream.getChannel();
        //获得容器buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true){
            int eof = inFileChannel.read(byteBuffer);
            //判断是否读完文件
            if ( eof==-1 ){
                break;
            }
            /*重设一下buffer的position=0，limit=position*/
            byteBuffer.flip();
            //开始写
            outFileChannel.write(byteBuffer);
            //写完要重置buffer，重设position=0,limit=capacity
            byteBuffer.clear();
        }
        inFileChannel.close();
        outFileChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
