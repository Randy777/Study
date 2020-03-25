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



    public ListNode insertionSortList(ListNode head) {
        if ( head == null || head.next == null){
            return head;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        //分治
        ListNode listS = head;
        ListNode listT = head;
        //遍历，对链表二分
        while (listS.next.next != null){
            listS = listS.next;
            listT = listT.next.next;
        }
        return head;
    }

}
