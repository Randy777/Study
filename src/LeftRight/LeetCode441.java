package LeftRight;
/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * */
public class LeetCode441 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(arrangeCoins(n));
    }
    public static int arrangeCoins(int n) {
        if(n == 0){
            return 0;
        }
        if(3 > n){
            return 1;
        }
        int left = 1;
        int right = n;
        int count = 0;
        while (right - left > 1){
            count = (right + left + 1) / 2;
            if (n < (1 + count)*count/2){
                right = (left + right + 1)/2;
            }
            else if (n > (1 + count)*count/2){
                left = (right + left - 1)/2;
            }else {
                return count;
            }
        }
        return left;
    }
}
