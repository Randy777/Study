package daily;

import java.util.*;

public class Leetcode347 {
    public static void main(String[] args) {
        int[] ttt = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(ttt, k));
    }
    //排序
    //dp
    //dp[i] = dp[i - 1] + (num[i] == num[i - 1]);
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] m = new int[k];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = 1;
                map.put(dp[i - 1],i);
            }
        }
        return dp;
    }
}
