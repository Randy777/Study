package Thread.ThreadMethod;

import Thread.ThreadTest.ProduceConsumer.ProduceThread;

public class Demo5Producer extends Thread{

    private Demo5ResourceThread demo5ResourceThread;

    public Demo5Producer(Demo5ResourceThread demo5ResourceThread){
        this.demo5ResourceThread = demo5ResourceThread;
    }

    @Override
    public void run(){
        while (true){
            try{
                Thread.sleep((long) (1000*Math.random()));
            }catch (Exception e){
                e.printStackTrace();
            }
            demo5ResourceThread.add();
        }
    }
}
