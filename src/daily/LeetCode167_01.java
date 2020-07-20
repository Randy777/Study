package daily;
/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 *     返回的下标值（index1 和 index2）不是从零开始的。
 *     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *思路：二分
 * */
public class LeetCode167_01 {
    public static void main(String[] args) {
        int[] num = {2,3,4};
        int target = 6;
        System.out.println(twoSum(num, target).length);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] res = new int[2];
//        if (n < 2) return
        for (int i = 0; i < n; i++){
            int left = 0,right = n - 1,mid = 0,searchNum = 0;
            searchNum = target - numbers[i];
            if (searchNum < 0) break;
            while (right >= left){
                mid = (left + right + 1) / 2;
                if (searchNum > numbers[mid]){
                    //往右二分
                    left = mid + 1;
                }else if (searchNum < numbers[mid]){
                    //往左二分
                    right = mid - 1;
                }else {
                    if (mid != i){
                        res[0] = Math.min(i,mid) + 1;
                        res[1] = Math.max(i,mid) + 1;
                        return res;
                    }else {
                        if (mid > 0){
                            if (numbers[mid - 1] == numbers[i]){
                                res[0] = mid;
                                res[1] = mid + 1;
                                break;
                            }
                        }else if (mid < n){
                            if (numbers[mid + 1] == numbers[i]){
                                res[0] = mid;
                                res[1] = mid + 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
