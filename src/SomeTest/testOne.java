package SomeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>(10);
        List<Integer> list = new ArrayList<Integer>(10);
        list.add(0);
        for (int i = 0; i < 8; i++){
            int n = scanner.nextInt();
            list.add(n);
        }
        list.add(0);
        integerList = list;
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++){
            for (int j = 1; j <= 8; j++){
                int pre = list.get(j - 1);
                integerList.set(j,pre^list.get(j + 1));
            }
        }
        list.stream().map((no) -> no).forEach(System.out::print);
        integerList.stream().map((no) -> no).forEach(System.out::print);
    }
}
