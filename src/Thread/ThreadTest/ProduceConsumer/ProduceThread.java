package Thread.ThreadTest.ProduceConsumer;

import Thread.ThreadMethod.Demo4Product;

public class ProduceThread extends Thread {

    private Demo4Product demo4Product;

    public ProduceThread(Demo4Product demo4Product){
        this.demo4Product = demo4Product;
    }

    @Override
    public void run() {
        while (true){
            demo4Product.produce();
        }
    }
}
