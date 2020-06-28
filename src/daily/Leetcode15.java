package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * */
public class Leetcode15 {
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ints));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0,j=1,k = 2; k < nums.length - 2; i++){
            if (nums[k] == nums[j]){
                i = k;
            }

        }
        return res;
    }
}
