package Thread.ThreadMethod;

import java.util.ArrayList;

/**
 * 自己编写代码,实现生产者-消费者模型功能.内容自由发挥,只需要表达思想.
 * 产生数据的模块，就形象地称为生产者；而处理数据的模块，就称为消费者。
 * 单单抽象出生产者和消费者，还够不上是生产者／消费者模式。
 * 该模式还需要有一个缓冲区处于生产者和消费者之间，作为一个中介。生产者把数据放入缓冲区，而消费者从缓冲区取出数据.
 *  在线程方式下，生产者和消费者各自是一个线程。生产者把数据写入队列头，消费者从队列尾部读出数据。当队列为空，消费者就稍息（稍事休息）；当队列满（达到最大长度），生产者就稍息。整个流程并不复杂。
 */
public class Demo4Product {


    public Object object;
    /*用list存放生产之后的数据，最大容量为1*/
    public ArrayList<Integer> list;

    public Demo4Product(Object object, ArrayList list){
        this.object = object;
        this.list = list;
    }

    public void produce(){

        synchronized (object){
            try {
                while (!list.isEmpty()){
                    System.out.println("生产者" + Thread.currentThread().getName() + "waiting");
                    object.wait();
                }
                int value = 9999;
                list.add(value);
                System.out.println("生产者" + Thread.currentThread().getName() + "Runnable");
                object.notifyAll();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
