package Thread.ThreadTest;


import Thread.ThreadMethod.Demo2Util;

/**
 * 编写程序实现,子线程循环3次,接着主线程循环5次,接着再子线程循环3次,主线程循环5次,如此反复,循环3次.
 * 思路：主线程先循环三次，子线程再循环一直运行（while（true）），主线程运行的时候子线程不运行（有顺序的：join），等
 **/
public class JoinDome2 {

    public static void main(String[] args){
            try {
                for (int i=0 ; i <3 ;i++){
                    /*第一种方法Join*/
                    Demo2Util.MainThread();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*第二种方法未实现，需要先了解下static，Lock的机制*/
            Demo2Util.SecondMainThread();
            Demo2Util.SecondSalveThread();
    }
}
