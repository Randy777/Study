package LeftRight;
/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 * */
public class LeetCode704 {
    public static void main(String[] args) {
        int[] ints = {-1,0,3,5,9,12};
        int t = 9;
        System.out.println(search(ints, t));
    }
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
