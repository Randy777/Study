package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 排序去重
 * */
public class No15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 3, 4, 5, 0};
        threeSum(nums);
    }

    private static void threeSum(int[] nums) {
        if (nums.length < 3){
            return;
        }
        int len = nums.length * (nums.length - 1) / 2;
//        int[] add = new int[len];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++){
            for ( int j = i + 1; j < nums.length - 1; j++){
                for (int t = j + 1 ; t < nums.length - 1; t++){
                    int count = 0;
                    count = nums[i] + nums[j] + nums[t];
                    if (count == 0){
                        list.add(Arrays.asList(nums[i],nums[j],nums[t]));
                        System.out.println(nums[i] + ":" + nums[j] + ":" + nums[t]);
                    }
                }
            }
        }
    }
}
