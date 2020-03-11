package LeetCode;

public class No19 {
    public static void main(String[] args) {
        int a = 7, b = -3;
        System.out.println(getShang(a, b));
    }

    private static int getShang(int dividend, int divisor) {
        if (Math.abs(dividend) > Integer.MAX_VALUE || Math.abs(divisor) > Integer.MAX_VALUE){
            return 2147483647;
        }
        int count = 0;
        if ( dividend == 0 ){
            return 0;
        }
        if ( dividend == divisor){
            return 1;
        }
        if ( dividend + divisor == 0){
            return -1;
        }
        if (divisor * dividend > 0){
            for (int i = Math.abs(divisor); i < Math.abs(dividend) ; i = (count + 1) * Math.abs(divisor)){
                count ++;
            }
        }else{
            for (int i = Math.abs(divisor); i < Math.abs(dividend) ; i = ((-count) + 1) * Math.abs(divisor)){
                count --;
            }
        }
        return count;
    }
}
