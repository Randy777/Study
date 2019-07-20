package Thread.ThreadMethod;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo5ResourceThread {


    private BlockingQueue blockingQueue = new LinkedBlockingQueue(10);

    public void add(){
        try {
            blockingQueue.put(1);
            System.out.println("生产者" + Thread.currentThread().getName() + "生产一件资源" + "当前资源池有" + blockingQueue.size() +"个");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void remove(){
        try {
            blockingQueue.take();
            System.out.println("消费者" + Thread.currentThread().getName() +
                                                "消耗一件资源," + "当前资源池有" + blockingQueue.size()
                                         + "个资源");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
