package daily;
/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * */
public class LeetCode202 {
    public static void main(String[] args) {
        int n = 19;
        isHappy(n);
    }
    public static boolean isHappy(int n) {
        int a = n;
        while (a!=1){
            a = getNum(a);
        }
        return true;
    }
    public static int getNum(int n){
        int t = 0;
        for(int i = n; i > 0; ){
            t += Math.pow(i % 10,2);
            i = i / 10;
        }
//        System.out.println(t);
        return t;
    }
}
