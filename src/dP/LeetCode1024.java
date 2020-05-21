package dP;

import java.lang.reflect.Array;
import java.util.*;

/**
 *你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 * */
public class LeetCode1024 {
    public static void main(String[] args) {
//        [[5,7],[1,8],[0,0],[2,3],[4,5],[0,6],[5,10],[7,10]]
        int[][] ints = {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
        int T = 5;
        System.out.println(videoStitching(ints, T));
    }
    public static int videoStitching(int[][] clips, int T) {
        int[] ints = new int[T + 1];
        int[] dp = new int[T + 1];
        for (int i = 0; i < clips.length; i++){
            if (clips[i][0] >= T){//clips[i][0]：下标大于T
                continue;
            }
            if (clips[i][1] - clips[i][0] > ints[clips[i][0]]){//二维数组转一维数组
                ints[clips[i][0]] = clips[i][1] - clips[i][0];
            }
        }
        for (int i = 0; i < T + 1; i++){
            dp[i] = -1;//初始化
            dp[0]  = 0;
            for (int j = 0; j < i; j++){
                if (j + ints[j] >= i && dp[i - 1] >= 0){
                    dp[i] = dp[j] + 1;//转移方程
                    break;
                }
            }
        }
        return dp[T];
    }
}
