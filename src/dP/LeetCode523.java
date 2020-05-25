package dP;

/**
 * 给定一个包含非负数的数组和一个目标整数 k，
 * 编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * */
public class LeetCode523 {
    public static void main(String[] args) {
        int[] ints = {0,0};
        int k = 0;
        System.out.println(0 % -1);
        System.out.println(checkSubarraySum(ints, k));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        boolean[] dp = new boolean[nums.length + 1];
        if (nums.length == 1){
            return false;
        }
        int temp;
        for (int i = nums.length - 1; i >= 0; i--){
            dp[i] = false;
            temp = nums[i];
            for (int j = i - 1; j >= 0; j--){
                temp += nums[j];
                if(temp == 0){
                    return true;
                }
                if(k == 0){
                    if(temp == 0){
                        return true;
                    }
                }else if(temp % k == 0 && temp != 0){
                    return true;
                }
            }
        }
        return false;
    }
}
