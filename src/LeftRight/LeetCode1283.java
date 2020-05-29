package LeftRight;

import java.util.Arrays;

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
        int[] ints = {1,2,5,9};
        int t = 6;
        System.out.println(smallestDivisor(ints, t));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 0;
        int right = nums.length;
        if (right == 1){
            return nums[0] % threshold==0 ? nums[0] / threshold : nums[0] / threshold + 1;
        }
        Arrays.sort(nums);
        while (left < right){
            int mid = (left + right) / 2;
            int target = getNum(mid,nums);
            if (target > threshold){
                left = mid + 1;
            }else if (target < threshold){
                right = mid;
            }else {
                left = mid;
                break;
            }
        }
        return nums[left];
    }
    public static int getNum(int mid,int[] nums){
        int s = 0,k = 0;
        for (int i = 0; i < nums.length; i++){
            k = nums[mid];
            if (nums[i] % k == 0){
                s += nums[i] / k;
            }else {
                s += nums[i] / k + 1;
            }
        }
        return s;
    }
}
