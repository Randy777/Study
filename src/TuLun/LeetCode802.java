package TuLun;

import java.util.ArrayList;
import java.util.List;

/**
 * 在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。
 * 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。
 * 更具体地说, 存在一个自然数 K,  无论选择从哪里开始行走, 我们走了不到 K 步后必能停止在一个终点。
 */
public class LeetCode802 {
    public static void main(String[] args) {
        int[][] ints = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(ints));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    public static boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;
        for (int nei: graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }
        color[node] = 2;
        return true;
    }
}
