package DiGui;

import java.util.Scanner;

/**
 * @description 汉诺塔
 * @author zy
 * */
public class hanoi {

    public static void main(String[] args) {
        while (true) {
            char a='a';
            char b='b';
            char c='c';

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入n:");
            int n = scanner.nextInt();
            move(n,a,b,c);
        }
    }

    private static void move(int n, char a, char b, char c) {
        if (1 == n){
            System.out.println(a + "-->" + c);
        }else {
            //将n-1个盘子从a借助c移到b上
            move(n-1,a,c,b);
            //将第n个盘子从a移到c上
            System.out.println(a + "-->" + c);
            //将n-1个盘子从b借助a移到c上
            move(n-1,b,a,c);
        }
    }


}
