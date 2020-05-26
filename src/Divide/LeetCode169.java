package Divide;

import java.util.Arrays;

public class LeetCode169 {
    public static void main(String[] args) {
        int[] ints = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(ints));
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums[nums.length /2]];
    }
}
