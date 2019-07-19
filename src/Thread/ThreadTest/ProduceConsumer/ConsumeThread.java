package Thread.ThreadTest.ProduceConsumer;

import Thread.ThreadMethod.Demo4Consumer;

public class ConsumeThread extends Thread {

    private Demo4Consumer demo4Consumer;

    public ConsumeThread(Demo4Consumer demo4Consumer){
        this.demo4Consumer = demo4Consumer;
    }

    @Override
    public void run() {
        while(true){
            demo4Consumer.consumer();
        }
    }
}
