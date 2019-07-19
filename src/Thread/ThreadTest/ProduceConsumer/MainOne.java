package Thread.ThreadTest.ProduceConsumer;

import Thread.ThreadMethod.Demo4Consumer;
import Thread.ThreadMethod.Demo4Product;

import java.util.ArrayList;

public class MainOne {

    public static void main(String[] args){

        Object object = new Object();
        ArrayList<Integer> arrayList = new ArrayList<>();

        Demo4Product demo4Product = new Demo4Product(object,arrayList);
        Demo4Consumer demo4Consumer = new Demo4Consumer(object,arrayList);

        ProduceThread[] produceThreads = new ProduceThread[2];
        ConsumeThread[] consumeThreads = new ConsumeThread[2];

        for (int i=0 ; i<2 ;i++){
            produceThreads[i] = new ProduceThread(demo4Product);
            produceThreads[i].setName("生产者" + (i + 1));
            consumeThreads[i] = new ConsumeThread(demo4Consumer);
            consumeThreads[i].setName("消费者" + ("消费者" + (i + 1)));
            produceThreads[i].start();
            consumeThreads[i].start();
        }
    }
}
