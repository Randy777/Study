package TanXing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：因为身高高的排序不受身高低的人的影响，所以先将数组排序再逐步插入列表
 * Comparator学习
 * 列表的插入
 * add(int index, E element)
 * 将指定的元素插入此列表中的指定位置（可选操作）。
* */
public class LeetCode406 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare (int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1]:o2[0] - o1[0];
            }
        });
        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1],person);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
