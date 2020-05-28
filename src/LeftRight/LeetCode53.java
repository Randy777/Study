package LeftRight;
/**
 *一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * */
public class LeetCode53 {
    public static void main(String[] args) {
        int[] ints= {0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(ints));
    }
    public static int missingNumber(int[] nums) {
        int low=0,high=nums.length;
        while(low<high){
            int mid=(low+high)>>1;
            if(nums[mid]!=mid){
                high=mid;
            } else{
                low=mid+1;
            }
        }
        return low;
    }
}
