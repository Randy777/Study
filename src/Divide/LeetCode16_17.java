package Divide;
/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * */
public class LeetCode16_17 {
    public static void main(String[] args) {
        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(ints));
    }
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            if (temp < dp[i]){
                temp = dp[i];
            }
        }
        return temp;
    }
}
