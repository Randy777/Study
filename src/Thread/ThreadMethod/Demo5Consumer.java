package Thread.ThreadMethod;

public class Demo5Consumer extends Thread{

    private Demo5ResourceThread demo5ResourceThread;

    public Demo5Consumer(Demo5ResourceThread demo5ResourceThread){
        this.demo5ResourceThread = demo5ResourceThread;
    }

    public void run(){
        while (true){
            try {
                Thread.sleep((long) (1000*Math.random()));
            }catch (Exception e){
                e.printStackTrace();
            }
            demo5ResourceThread.remove();
        }
    }
}
