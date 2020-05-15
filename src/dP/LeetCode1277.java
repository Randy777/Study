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
 *
 * class Solution:
 *     def countSquares(self, matrix: List[List[int]]) -> int:
 *         m = len(matrix)
 *         n = len(matrix[0])
 *         dp = [[0]*n for _ in range(m)]
 *         res = 0
 *         for i in range(m):
 *             for j in range(n):
 *                 if matrix[i][j] == 1:
 *                     if i == 0 or j == 0:
 *                         dp[i][j] = 1
 *                     else:
 *                         dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
 *                 res += dp[i][j]
 *         return res
 * */
public class LeetCode1277 {
    public static void main(String[] args) {
        int[][] ints = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(ints));
    }
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 1){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
