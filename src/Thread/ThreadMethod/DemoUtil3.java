package Thread.ThreadMethod;

/**
 * 在private void ChangeOneMethod(boolean flag){}中原来参数是（int i;boolean flag）(错误i由mainThread传入是一个形参我们无法改变它的值)
 * */
public class DemoUtil3 {

    public void MainThread(int i) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                ChangeOneMethod(false);
                System.out.println("线程一执行 i = :" + i);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ChangeOneMethod(false);
                System.out.println("线程二执行 i = :" + i);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                ChangeOneMethod(true);
                System.out.println("线程三执行 i = :" + i);
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {

                ChangeOneMethod(true);
                System.out.println("线程四执行i = :" + i);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private void ChangeOneMethod(boolean flag){

        int i = 0;
        synchronized (this){
            if (flag){
                i++;
                System.out.println(Thread.currentThread().getName() + "i = " + i);
            }else {
                i--;
                System.out.println(Thread.currentThread().getName() + "i = " + i);
            }
        }
    }

}
