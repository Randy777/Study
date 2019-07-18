package Thread.ThreadTest;

import Thread.ThreadMethod.Demo1Util;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * join
 * **/

public class JoinDemoI {
    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Demo1Util.methodOne();
                Demo1Util.methodTwo();
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");

        try {
            t1.start();
            t1.join(100_000);
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
