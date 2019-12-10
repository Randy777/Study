package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        test1(costBeforeTax);
        System.out.println("==========test1===========");
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
        test2(costBeforeTax);
        System.out.println("==========test2===========");
        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eeee");
        test3(stringList);
    }

    //流提供了一个 filter() 方法，接受一个 Predicate 对象，即可以传入一个lambda表达式作为过滤逻辑。
    private static void test3(List<String> costBeforeTax) {
        List<String> filtered = costBeforeTax.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        filtered.stream().map(str -> str).forEach(System.out::println);
    }

    private static void test2(List<Integer> costBeforeTax) {
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }

    private static void test1(List<Integer> costBeforeTax) {
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
    }

}
