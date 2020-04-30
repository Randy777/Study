package LeftRight;
/**
 *传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * 思路（1）：最小运载能力肯定大于等于最大的数，循环求解
 * 思路（2）：DP
 * */
public class LeetCode1011 {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(shipWithinDays1(ints, D));//思路一
        System.out.println(shipWithinDays2(ints, D));//思路二
    }
    public static int shipWithinDays1(int[] weights, int D) {
        if(weights.length == 0){
            return 0;
        }
        if(D > weights.length){
            return weights[weights.length - 1];
        }
        int index = 0,temp = weights[0];
        for(int i = 1; i < weights.length; i++){
            if (temp < weights[i]){
                temp = weights[i];
                index = i;
            }
        }
        int count = 0;
        int n = 0;
        count = getIndex(index,weights,n);
        while (count > D){
            ++n;
            count = getIndex(index,weights,n);
        }
        return weights[index] + n;
    }
    public static int getIndex(int index,int[] weight,int n){
        int count = 1;int t = 0;
        for (int i = 0; i < weight.length; i++){
            if ((t + weight[i]) <= weight[index] + n){
                t += weight[i];
            }else {
                count ++;
                t = weight[i];
            }
        }
        return count;
    }
    public static int shipWithinDays2(int[] weights, int D) {
        int[] sum = new int[weights.length];
        int[] dp = new int[weights.length];
        sum[0] = weights[0];
        dp[0] = sum[0];
        for (int i = 1; i < weights.length; i++) {
            sum[i] = sum[i - 1] + weights[i];
            dp[i] = sum[i];
        }
        for (int i=1;i<D;i++) {
            for(int j=weights.length-1;j>i-1;j--) {
                for (int k=i-1;k<j;k++) {
                    dp[j] = Math.min(Math.max(dp[k], sum[j] - sum[k]), dp[j]);
                }
            }
        }
        return dp[weights.length-1];
    }
}
