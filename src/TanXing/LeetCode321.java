package TanXing;
/**
* 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LeetCode321 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        maxNumber(nums1,nums2,k);
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int temp1 = 0,temp2 = 0,local1 = 0,local2 = 0;
        for (int i = 0; i < nums1.length; i++){
            temp1 = Math.max(nums1[i],temp1);
        }
        for (int i = 0; i < nums2.length; i++){
            temp2 = Math.max(nums2[i],temp2);
        }
        for (int i = 0; i < nums1.length; i++){
            if (temp1 == nums1[i]){
                local1 = i;
                break;
            }
        }
        for (int i = 0; i < nums2.length; i++){
            if (temp1 == nums2[i]){
                local2 = i;
                break;
            }
        }
        if (temp1 == temp2){

        }else if (temp1 > temp2){
            if (nums1.length - local1 + nums2.length >= k){

            }else {

            }
        }else {

        }
        return nums1;
    }
}
