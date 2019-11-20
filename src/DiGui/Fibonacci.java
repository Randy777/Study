package DiGui;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *递归学习
 * @Author zy
 * @descript
 * */
public class Fibonacci {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入n");
            int n = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>(64);
            int number;
            list = fibonacci(n);
            number = fibonacciOne(n);
            System.out.println(list);
            System.out.println(number);
        }
    }

    private static int fibonacciOne(int n) {
        if (n < 2){
            return n == 0 ? 0:1;
        }
        return fibonacciOne(n-1)+fibonacciOne(n-2);
    }

    private static ArrayList<Integer> fibonacci(int n) {
        ArrayList<Integer> list = new ArrayList<>(64);
        int[] a = new int[64];
        a[0] = 0;
        a[1] = 1;
        list.add(a[0]);
        list.add(a[1]);
        for (int i = 2; i < n; i++){
            a[i] = a[i-1] + a[i-2];
            list.add(a[i]);
        }
        return list;
    }
}
