package dP;

import java.util.Scanner;

/**
 * i-coins[j] >= 0且dp[i-coins[j]]!= -1时
 * j=0~4;coins[j] = 1,2,5,7,10
 * dp[i] = getmin(dp[i-coins[j]])+1
 * @author zy
 * @date 2019-11-23
 * @description 找零钱动态规划
 * */
public class Coin {

    static int[] V = new int[]{1,2,5,7,10};

    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入面值：");
            int n = scanner.nextInt();
            dp(n);
        }
    }

    private static void dp(int n) {
        int[] minSV = new int[n + 1];
        minSV[0] = 0;
        boolean flag = true;
        //1-n的面值所有的dp()
        for (int i = 1; i <= n; i++){
            flag = true;
            for (int j = 0; j < V.length; j++){
                if ( V[j] <= i && flag){
                    minSV[i] = minSV[i - V[j]] + 1;
                    flag = false;
                }
                if ( V[j] <= i && minSV[i - V[j]] + 1 <  minSV[i]){
                    minSV[i] = minSV[i - V[j]] + 1;
                }
            }
        }
            System.out.println(minSV[n]);

    }
}
