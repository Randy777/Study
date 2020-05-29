package LeftRight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *
 * */
public class LeetCode658 {
    public static void main(String[] args) {
        int[] ints = {1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99};
        int[] ints1 = {1,3};
        int k1 = 1,x1 = 2;
        int k=3, x=13;
        System.out.println(findClosestElements(ints1, k1, x1));
        System.out.println(findClosestElements(ints, k, x));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (arr.length <= k){
            for (int a : arr){
                list.add(a);
            }
            return list;
        }
        int left = 0,right = arr.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                left = mid + 1;
            }else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                right = mid - 1;
            }
        }
        int count = 0;
        for (int i = left, j = left + 1; count < k;){
            if (i < 0){
                list.add(arr[j]);
                j++;
                count++;
                continue;
            }
            if (j >= arr.length){
                list.add(arr[i]);
                i--;
                count++;
                continue;
            }
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)){
                list.add(arr[i]);
                --i;
            }else {
                list.add(arr[j]);
                ++j;
            }
            count++;
        }
        Collections.sort(list,((o1, o2) -> o1 - o2));
        return list;
    }
}
