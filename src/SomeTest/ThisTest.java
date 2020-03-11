package SomeTest;

public class  ThisTest {

    public void jump(){
        System.out.println("jump");
    }

    public void run(){
        // 使用this引用调用run()方法的对象
        synchronized (this){
            this.jump();
        }

    }

    public static void main(String[] args) {
        ThisTest thisTest = new ThisTest();
        thisTest.run();
    }
}
