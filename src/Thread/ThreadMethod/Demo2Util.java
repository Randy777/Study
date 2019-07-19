package Thread.ThreadMethod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* Lock和synchronized的选择
 *
 * 　　总结来说，Lock和synchronized有以下几点不同：
 *
 * 　　1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
 *
 * 　　2）synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
 *
 * 　　3）Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
 *
 * 　　4）通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
 *
 * 　　5）Lock可以提高多个线程进行读操作的效率。
 *
 * 　　在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），此时Lock的性能要远远优于synchronized。所以说，在具体使用时要根据适当情况选择。
*
* */

public class Demo2Util {

    public static void MainThread() throws InterruptedException {

        Runnable thread1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i < 5 ; i++){
                    System.out.println("MainThread 运行的第:" + i + "次" );
                }
            }
        };
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<3 ; i++){
                    System.out.println("SlaveThread 运行的第：" + i + "次");
                }
            }
        };
        Thread t1 = new Thread(thread1,"t1");
        Thread t2 = new Thread(thread2,"t2");

        t2.start();
        t2.join();
        t1.start();
        t1.join();
    }


    public static void SecondMainThread(){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        boolean flag = false;
        lock.lock();
        try {
            while (!flag) {
                for (int i=0 ; i < 5 ; i++){
                    System.out.println("MainThread 运行的第:" + i + "次" );
                }
                flag = true;
                condition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void SecondSalveThread(){

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        try {
            System.out.println("子线程等待");
            condition.await();
            for (int i=0 ; i<3 ; i++){
                System.out.println("SlaveThread 运行的第：" + i + "次");
            }
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
