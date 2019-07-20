package Thread.ThreadTest.ProduceConsumer;


import Thread.ThreadMethod.Demo5Consumer;
import Thread.ThreadMethod.Demo5Producer;
import Thread.ThreadMethod.Demo5ResourceThread;

/*使用阻塞队列BlockingQueue解决生产者消费者
* https://www.cnblogs.com/fankongkong/p/7339848.html
* */
public class BlockingQueueConsumerProducer {

    public static void main(String[] args){

        Demo5ResourceThread demo5ResourceThread = new Demo5ResourceThread();

        Demo5Producer demo5Producer = new Demo5Producer(demo5ResourceThread);
        Demo5Consumer demo5Consumer1 = new Demo5Consumer(demo5ResourceThread);
        Demo5Consumer demo5Consumer2 = new Demo5Consumer(demo5ResourceThread);
        Demo5Consumer demo5Consumer3 = new Demo5Consumer(demo5ResourceThread);

        demo5Producer.start();
        demo5Consumer1.start();
        demo5Consumer2.start();
        demo5Consumer3.start();
    }
}
