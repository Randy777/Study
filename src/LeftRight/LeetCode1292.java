package LeftRight;
/**
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 *
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * */
public class LeetCode1292 {
    public static void main(String[] args) {
        int[][] ints = {{1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2}};
        int threshold = 4;
        System.out.println(maxSideLength(ints, threshold));
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int min = Math.min(n,m);
        if (threshold >= min){
            
        }
        return 1;
    }
}
