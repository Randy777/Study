package dP;
/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 原问题:求m*n的矩阵的正方形数
 * 子问题:求i*j的矩阵的正方形数
 * */
public class LeetCode1277 {
    public static void main(String[] args) {
        int[][] ints = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        countSquares(ints);
    }
    public static int countSquares(int[][] matrix) {

        return 1;
    }
}
