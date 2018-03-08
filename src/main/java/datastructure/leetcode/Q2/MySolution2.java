package datastructure.leetcode.Q2;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/8
 **/
public class MySolution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int flow = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + flow;
            flow = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flow > 0) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}
