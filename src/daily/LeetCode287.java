package daily;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * other：（二分，双指针）
 * */
public class LeetCode287 {
    public static void main(String[] args) {
        int[] ints = {1,3,4,2,2};
        System.out.println(findDuplicate(ints));
    }
    public static int findDuplicate(int[] nums) {
        int[] t = nums;
        Arrays.sort(t);
        int temp = nums[0];
        for (int i = 1; i < t.length; i++){
            if (temp == t[i]){
                return temp;
            }
            temp = t[i];
        }
        return temp;
    }
}
