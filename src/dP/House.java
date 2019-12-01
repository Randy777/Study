package dP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2019-11-22
 * @author zy
 * @description 动态规划
 * 原问题，子问题，状态，边界状态，状态转移方程
 * 1、原问题：求n个房间的最优解
 * 2、子问题：求前i个房间的最优解（i<n-1）
 * 3、确认状态：第i个状态即为前i个房间能获得的最大财宝（最优解）
 * 4、确认边界值：
 *    前1个房间的最优解，第一个房间的财宝
 *    前2个房间的最优解，第1，2个房间较大的财宝
 * 5、确定状态转移方程：
 *    a、选择第i个房间:第i个房间+前i-2个房间的最优解
 *    b、不选择第i个房间：前i-1个房间的最优解
 * 6、动态规划方程：
 * dp[i] = max(dp[i-1],dp[i-2]+nums[i]);(i>=3)
 * */
public class House {
    public static void main(String[] args) {
        int[] q = {1,23,4,5,6,7,8,45,62,6,7,3};
        dp(q);
    }

    private static boolean dp(int[] q) {
        int[] opt = new int[q.length];
        List<List<String>> list;
        if (q.length == 0){
            return false;
        }else if (q.length == 2){
            opt[0] = q[0];
            opt[1] = Math.max(q[0],q[1]);
            return true;
        }else {
            list = new ArrayList<List<String>>();
            opt[0] = q[0];
            opt[1] = Math.max(q[0],q[1]);
            List<String> q1 = Arrays.asList(String.valueOf(q[0]));
            List<String> q2;
            if (q[0] >= q[1]){
                q2 = Arrays.asList(String.valueOf(q[0]));
            }else {
                q2 = Arrays.asList(String.valueOf(q[1]));
            }
            list.add(q1);
            list.add(q2);
            for(int i = 2;i<q.length;i++) {
                List<String> res = new ArrayList<String>();
                if(opt[i-2]+q[i]>=opt[i-1]) {
                    opt[i] = opt[i-2]+q[i];
                    res.addAll(list.get(i-2));
                    res.add(String.valueOf(i+1)+":"+String.valueOf(q[i]));
                    list.add(res);
                }
                else {
                    opt[i] = opt[i-1];
                    res.addAll(list.get(i-1));
                    list.add(res);
                }
            }
            System.out.println("前N和任务的最大值："+Arrays.toString(opt));
            System.out.println("总任务最大值："+opt[opt.length-1]);
            System.out.println("总任务最大值选择："+list.get(list.size()-1).toString());
            return true;
        }
    }

}
