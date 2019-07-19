package Thread.ThreadTest;

import Thread.ThreadMethod.DemoUtil3;


/**
* 设计四个线程,其中两个线程每次对变量i加1,另外两个线程每次对i减1.
* */
public class SynDemo3 {

    public static void main(String[] args){
        DemoUtil3 demoUtil3 = new DemoUtil3();
        demoUtil3.MainThread(5);
    }
}
