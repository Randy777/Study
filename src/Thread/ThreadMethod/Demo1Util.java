package Thread.ThreadMethod;

public class Demo1Util {

    public static void methodOne(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 is end");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("thread2 is end");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 is end");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void methodTwo(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行完成");
            }
        };
            Thread t1 = new Thread(runnable,"thread1");
            Thread t2 = new Thread(runnable,"thread2");
            Thread t3 = new Thread(runnable,"thread3");
            try {
                t1.start();
                t1.join();
                t2.start();
                t2.join();
                t3.start();
                t3.join();
            }catch (Exception e){
                e.printStackTrace();
            }

    }

}
