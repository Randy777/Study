package dP;

import java.util.Scanner;

/**
 * @author zy
 * @date 2019-11-23
 * @description 三角形路径和最小
 * dp[i][j] = min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
 * */
public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int[][] numArr = new int[numCount][];
        for (int i = 0; i < numCount; i++){
            int l = scanner.nextInt();
            numArr[i] = new int[l];
            for (int j = 0; j < l; j++){
                numArr[i][j] = scanner.nextInt();
            }
        }
    }
}
