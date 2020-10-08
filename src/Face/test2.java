package Face;

public class test2 {
    public static void main(String[] args) {
        System.out.println(getOdd(4));
    }
    public static int getOdd(int n){
        if(n > 1){
            return getOdd(n - 1) * n;
        }
        return n;
    }
}
