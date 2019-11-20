package DiGui;

import java.util.Scanner;

/**
 * @description 汉诺塔
 * @author zy
 * */
public class hanoi {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入n:");
            int n = scanner.nextInt();
            System.out.println(Math.pow(2, n - 1));
        }
    }
}
