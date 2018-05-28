package datastructure.leetcode.Q2;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * @Author: wuxiaobing
 * @Date 2018/3/8
 **/
public class MySolution {
    boolean moreThenTen = false;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        /**
         * 链表的头结点，这里容易出错
         * */
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val;
            if (moreThenTen) {
                sum++;
            }
            if (sum >= 10) {
                moreThenTen = true;
            } else {
                moreThenTen = false;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        cur = solveRemian(cur, cur1);
        cur = solveRemian(cur, cur2);
        if (moreThenTen) {
            cur.next = new ListNode(1);
        }

        return head.next;
    }

    public ListNode solveRemian(ListNode result, ListNode node) {
        while (node != null) {
            int val = node.val;
            if (moreThenTen) {
                val++;
            }
            if (val >= 10) {
                moreThenTen = true;
            } else {
                moreThenTen = false;
            }
            result.next = new ListNode(val % 10);
            result = result.next;
            node = node.next;
        }
        return result;
    }
}