package daily;
/**
 *给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * */
public class Leetcode152 {
    public static void main(String[] args) {
        int[] ints = {0,2};
        System.out.println(maxProduct(ints));
    }
    public static int maxProduct(int[] nums) {
        int minLast = nums[0],maxLast=nums[0],minCur,maxCur;
        int maxALL=nums[0];
        for(int i=1;i<nums.length;i++){
            maxCur = Math.max(nums[i],Math.max(maxLast*nums[i], minLast*nums[i]));
            minCur = Math.min(nums[i], Math.min(maxLast*nums[i], minLast*nums[i]));
            maxLast = maxCur;
            minLast = minCur;
            maxALL = Math.max(maxALL, maxCur);
        }
        return maxALL;
    }
}
