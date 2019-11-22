package dP;

/**
 * @date 2019-11-22
 * @author zy
 * @description 动态规划 最大子段和
 * 原问题，子问题，状态，边界状态，状态转移方程
 * 1、原问题：求n个数结尾的最大子段和
 * 2、子问题：求第i个数为结尾的最大字段和（i<n-1）
 * 3、动态规划方程：
 * dp[j]=max{dp[j-1]+a[j],a[j]},1<=j<=n
 * */
public class MaxZiDuan {
    public static void main(String[] args) {
        int n=6;
        int[] a={0,-2,11,-4,13,-5,-2};
        MaxSum(n,a);
        System.out.println(MaxSum(n,a));
    }

    private static int MaxSum(int n, int[] a) {
        int sum=0,b=0;
        for(int i=1;i<=n;i++){
            if(b<0){
                b=a[i];
            }
            else{
                b=b+a[i];
            }
            if(b>sum){
                sum=b;
            }
        }
        return sum;
    }
}
