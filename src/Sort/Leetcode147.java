package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Sort.ListNodeTranfor.listNodeToString;

/**
 * 对链表进行插入排序。
 * 插入排序算法：
 *
 *     插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     重复直到所有输入数据插入完为止。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * **/
public class Leetcode147 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = ListNodeTranfor.stringToListNode(line);

            ListNode ret = new Leetcode147().insertionSortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    public ListNode insertionSortList(ListNode head) {
        int len=0;
        for(ListNode p = head; p != null; p = p.next){
            for(ListNode q = p.next; q != null; q = q.next){
                if( p.val > q.val){
                    int temp = p.val;
                    p.val = q.val;
                    q.val = temp;
                }
            }
        }
        return head;
    }

}
