package DiGui;

import java.util.Scanner;

import static sun.misc.Version.print;

/**
 * 回溯算法
 * @author zy
 * @description 八皇后问题
 * */
public class EightQueen {
    private static final int MAX = 8;
    static int[] arr = new int[MAX];

    public static void main(String[] args) {
        queen(0);
    }

    public static void queen(int n) {
        if (n == MAX){
            overMothed();
            return;
        }
        for (int i = 0; i < MAX; i++){
            arr[n] = i;
            if (judge(n)){
                queen(n + 1);
            }
        }
    }

    private static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private static void overMothed() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + 1 + " ");
        }
        System.out.println();
    }
}
