package dP;

public class LeetCode1027 {
    public static void main(String[] args) {
        int[] A = {20,1,15,3,10,5,8};
        solution(A);
    }
    public  static int solution(int[] A){
        if(A == null || A.length < 3)
            return 0;
        int[][] dp = new int[A.length][20001];
        int max = 0;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                int distance = A[i] - A[j] + 10000;
                if(dp[j][distance] > 0){
                    dp[i][distance] = (dp[i][distance] > dp[j][distance]+1) ? dp[i][distance] : dp[j][distance]+1;
                }
                else{
                    dp[i][distance] = 2;
                }
                max = max > dp[i][distance] ? max : dp[i][distance];
            }
        }
        return max;
    }
}
