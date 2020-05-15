package daily;
/**
 *给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 《ERROR》
 * */
public class LeetCode560 {
    public static void main(String[] args) {
        int[] ints = {1};
        int k = 0;
        System.out.println(subarraySum(ints, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int temp = 0;
        if (nums.length < 1 || nums.equals(null)){
            return 0;
        }else if (nums.length == 1){
            return nums[0] == k ? 1 : 0;
        }
        int count = 0;
        temp = nums[0];
        for (int i = 0,j = 0; i < nums.length; i++){
            while (temp < k && j < nums.length - 1){
                ++j;
                temp += nums[j];
                if (j >= nums.length){
                    break;
                }
            }
            if (temp == k){
                count ++;
                temp = temp - nums[i];
            }else if (temp > k){
                if (temp != nums[i]){
                    temp = temp - nums[i];
                    j--;
                }else {
                    j++;
                    temp = nums[j];
                }
            }else if (temp < k){
                j--;
            }
        }
        return count;
    }
}
