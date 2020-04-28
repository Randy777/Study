package TanXing;

import java.util.ArrayList;
import java.util.List;

/**
 *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 思路（1）：先找到最大的第一个数，分左右两侧，
 * 左侧从左一开始遍历，只要有比前一个低的就有积水面积
 * 右侧从末尾开始遍历，只要有比右侧低的就有积水面积
 * 左右两侧分别算出积水面积
 * */
public class LeetCode42 {
    public static void main(String[] args) {
        int[] ints = {4,2,0,3,2,5};
        System.out.println(trap(ints));
    }
    public static int trap(int[] height) {
        if ( height.length < 3){
            return 0;
        }
        int arrIndex = getMaxIndex(height);
        int[] left = new int[arrIndex];
        int[] right = new int[height.length - arrIndex -1];
        int sL = 0,sR = 0,s = 0;
        if (height.length - arrIndex -1 < 2){ //右边
            sR = 0;
        }else {
            for (int i = 0; i < height.length - arrIndex -1; i++){
                right[i] = height[i + arrIndex + 1];
            }
            sR = getRightS(right);
        }
        if (arrIndex > 1){
            for (int i = 0; i < arrIndex; i++){
                left[i] = height[i];
            }
            sL = getLeftS(left);
        }else {
            sL = 0;
        }
        s = sL + sR;
        return s;
    }
    public static int getLeftS(int[] left){
        int s = 0;
        int height = left[0];
        for (int i = 1; i < left.length; i++){
            if (left[i] < height){
                s += (height - left[i]);
            }else {
                height = left[i];
            }
        }
        return s;
    }
    public static int getRightS(int[] right){
        int s = 0;
        int height = right[right.length - 1];
        for (int i = right.length - 2; i >= 0 ; i--){
            if (right[i] < height){
                s += (height - right[i]);
            }else {
                height = right[i];
            }
        }
        return s;
    }
    public static int getMaxIndex(int[] ints){
        int arrIndex = 0,arrMax = ints[0];
        for (int i = 1; i <= ints.length - 1; i++){
            if (ints[i] > arrMax){
                arrIndex = i ;
                arrMax = ints[i];
            }
        }
        return arrIndex;
    }
}
