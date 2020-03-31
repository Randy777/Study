package TanXing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * */
public class LeetCode455 {
    public static void main(String[] args) {
        int[] g = {1,2};//孩子
        int[] s = {1,2,3};//糖果
        System.out.println(findContentChildren(g, s));
        System.out.println(findContentChildren1(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) { //超时，败笔
        int count = 0;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < s.length; i++){//糖果
            for (int j = count; j < g.length; j++){//孩子（孩子选糖果）
                if (s[i] >= g[j] && !list.contains(i)){
                    count++;
                    list.add(i);
                }
            }
        }
        return count;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        int count = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0,j = 0; i < g.length && j < s.length; ) {

            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else{
                j++;
            }
        }

        return count;
    }
}
