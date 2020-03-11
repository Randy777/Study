package Base;

public class YiWei {

    public static void main(String[] args) {
        //右移>>和>>>
        System.out.println(4>>1); //二进制100 高位补0
        System.out.println(4>>>1);
        System.out.println((-4)>>1);//二进制100取反011  高位补1 => 101 取反 -010
        System.out.println((-4)>>>1);//结果是Integer.MAX_VALUE
        int a = 1;
        int b = 2;
        b = (a >> 31);
    }

    class A{
        public void fun(){
            System.out.println("我是内部类");
        }
    }

}
