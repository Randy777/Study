package Divide;

import java.util.*;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * */
public class LeetCode973 {
    public static void main(String[] args) {
        int[][] ints = {{3,3},{5,-1},{-2,4}};
        kClosest(ints,2);
    }
    public static int[][] kClosest(int[][] points, int K) {
        if (K==0) return null;
        if (points.length<=K) return points;
        int [][]res=new int[K][2];
        Arrays.sort(points,(o1, o2) -> (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]));
        for (int i=0;i<K;i++){
            res[i]=points[i];
        }
        return res;
    }
}
