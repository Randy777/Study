package LeftRight;
/**
 *给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 *
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 *
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 *
 * 题目保证一定有解。
 **/
public class LeetCode1283 {
    public static void main(String[] args) {
        int[] ints = {2,3,5,7,11};
        int t = 6;
        smallestDivisor(ints,t);
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        return 1;
    }
}
