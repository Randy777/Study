package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Sort.ListNodeTranfor.stringToListNode;

/**
 * @author  Randy
 *在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 * 思考：（1）要求n,log n 则快速排序、堆排序、归并排序。
 *         （2）由于链表，二分归并排序比较容易实现
 * Step1: 把大问题归约成 规模较小的子问题  。
 * Step2: 把子问题独立求解的过程。
 * Step3: 把所有子问题 综合解的过程。
 * 分治算法
 * **/
public class LeetCode148 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new LeetCode148().insertionSortList(head);

            String out = ListNodeTranfor.listNodeToString(ret);

            System.out.print(out);
        }
    }
    //例：[4,2,1,3]
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode listLeft = mergeSort(head);
        ListNode listRight = mergeSort(mid);

        ListNode prev = new ListNode(0);
        ListNode node = prev;

        while (listLeft != null && listRight != null){
            if (listLeft.val < listRight.val){
                node.next = listLeft;
                listLeft = listLeft.next;
            }else {
                node.next = listRight;
                listRight = listRight.next;
            }
            node = node.next;
        }
        node.next = listLeft != null ? listLeft : listRight;
        return prev.next;
    }

}
