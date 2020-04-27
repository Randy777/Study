package TanXing;
/**
 *给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 思路：（1）判断每个点的路径是否大于数组长度(贪心)，路径小于数组长度则结束。
 *      （2）从后往前遍历，前一个能到达后一个则去掉后一个，不能则再往前（分治）
 * */
public class LeetCode55 {
    public static void main(String[] args) {
        int[] ints = {2,3,1,1,4};
        canJump(ints);
//        canJump2(ints);
    }
    public static boolean canJump(int[] nums) {
        //贪心算法
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i] + i, temp);
            if(temp >= nums.length - 1) {
                return true;
            }
            if(temp <= i) {
                return false;
            }
        }
        return false;
    }
}
