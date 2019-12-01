package Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author zy
 * @date 2019-11-29
 * @description Java 8中使用lambda表达式的Map和Reduce示例
 * 函数式编程概念map,它允许你将对象进行转换。
 *  reduce() 函数可以将所有值合并成一个。
 * */
public class Demo1 {

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
        System.out.println("=====================");
        test1(costBeforeTax);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
        System.out.println("=====================");
        test2(costBeforeTax);
    }

    private static void test2(List<Integer> costBeforeTax) {
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }

    private static void test1(List<Integer> costBeforeTax) {
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
    }

}
