package buffered.NIO;

import java.util.Scanner;
/**
 * 求一个数是由哪几个2的幂组成的
 * */
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 29;
        int b = a;
        System.out.println(a%50==a);
        int count = 1;
        while ( b/2 >2){
            b = b/2;
            count++;
        }
        for (int i=count ; i>=0 ;i--){
            //System.out.println((int)Math.pow(2,count));
            if ( a % (int)Math.pow(2,i) != a){
                //System.out.println(a);
                a = a-(int) Math.pow(2, i);
                System.out.println((int) Math.pow(2, i));
            }
        }
    }
}
