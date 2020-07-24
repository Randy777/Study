package daily;
/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * */
public class LeetCode64 {
    public static void main(String[] args) {
        int[][] ints = {{1,2,5},{3,2,1}};
        System.out.println(minPathSum(ints));
    }
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int cow = grid[0].length;
        int[][] dp = new int[row][cow];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < row; j++){
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < cow; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++){
            for (int j = 1; j < cow; j++){
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][cow - 1];
    }
}
