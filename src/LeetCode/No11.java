package LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * 动态规划
 *给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class No11 {
    public static void main(String[] args) {
        int[] num = {1,8,6,2,5,4,8,3,7};
        System.out.println(test(num));
    }
    private static int test(int[] num) {
//        List<Integer> list = Arrays.asList(num)
        int maxarea = 0, l = 0, r = num.length - 1; while (l < r) {
            maxarea = Math.max(maxarea, Math.min(num[l], num[r]) * (r - l));
            if (num[l] < num[r]) {
                l++;
            }
            else{
                r--;
            }
        }
        return maxarea;
    }
}
