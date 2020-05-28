package Divide;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 *
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 *
 * 那么数组 A 是漂亮数组。
 因此我们将所有的奇数放在 left 部分，所有的偶数放在 right 部分，这样可以保证等式恒不成立。
 对于 [1..N] 的排列，left 部分包括 (N + 1) / 2 个奇数，right 部分包括 N / 2 个偶数。
 对于 left 部分，我们进行 k = 1/2, b = 1/2 的仿射变换，把这些奇数一一映射到不超过 (N + 1) / 2 的整数。
 对于 right 部分，我们进行 k = 1/2, b = 0 的仿射变换，把这些偶数一一映射到不超过 N / 2 的整数。
 经过映射，left 和 right 部分变成了和原问题一样，但规模减少一半的子问题，这样就可以使用分治算法解决了。
 * */
public class LeetCode932 {
    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x: f((N+1)/2))  // odds
                ans[t++] = 2*x - 1;
            for (int x: f(N/2))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }
}
