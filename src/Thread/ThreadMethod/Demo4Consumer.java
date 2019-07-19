package Thread.ThreadMethod;

import java.util.ArrayList;

/**
 * 消费者
 * */
public class Demo4Consumer {

    public Object object;
    public ArrayList<Integer> list;

    public Demo4Consumer(Object object, ArrayList list){
        this.object = object;
        this.list = list;
    }

    public void consumer(){
        synchronized (object){
            try {
                while (list.isEmpty()){
                    System.out.println("消费者" + Thread.currentThread().getName() + "waiting");
                    object.wait();
                }
                list.clear();
                System.out.println("消费者" + Thread.currentThread().getName() + "Runnable");
                object.notifyAll();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
