package daily;

import java.util.Arrays;

/**
*给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
* */
public class LeetCode209 {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(s, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        if ( nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++){
            //前缀和数组
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        for (int i = 1; i <= nums.length; i++){
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums,target);
            if (bound < 0){
                bound = -bound - 1;
            }
            if (bound <= nums.length){
                result = Math.min(result,bound - (i - 1));
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
