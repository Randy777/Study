package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * */
public class LeetCode350 {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1};
        System.out.println(intersect(nums1, nums2).length);
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return null;
        int n1 = nums1.length;
        int n2 = nums2.length;
        quickSort(nums1,0,nums1.length - 1);
        quickSort(nums2,0,nums2.length - 1);
        return n1 > n2 ? divideArr(nums1,nums2) : divideArr(nums2,nums1);
    }
    //arr1长，arr2短
    public static int[] divideArr(int[] arr1,int[] arr2){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++){
            int left = 0,right = arr1.length - 1,mid;
            while (right >= left){
                mid = (right + left + 1) / 2;
                if (arr1[mid] == arr2[i]){
                    list.add(arr1[mid]);
                    break;
                }else if (arr1[mid] > arr2[i]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static void quickSort(int[] arr,int low,int high){
        int temp,i,j,t;
        i = low;
        j = high;
        if (low > high){
            return;
        }
        temp = arr[low];
        while (i < j){
            while (temp <= arr[j] && j > i){
                j--;
            }
            while (temp >= arr[i] && j > i){
                i++;
            }
            if (j > i){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr,low,j - 1);
        quickSort(arr,j + 1,high);
//        return arr;
    }
}
