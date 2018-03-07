package datastructure.leetcode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(0);
        ListNode result = head;
        boolean moreThenTen = false;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val;
            if (moreThenTen) {
                sum++;
            }
            if (sum >= 10) {
                result = new ListNode(sum % 10);
                moreThenTen = true;
            } else {
                result = new ListNode(sum);
                moreThenTen = false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            result = result.next;
        }

        solveRemian(result, cur1, moreThenTen);
        solveRemian(result, cur2, moreThenTen);

        return head.next;
    }

    public void solveRemian(ListNode result, ListNode node, boolean moreThenTen) {
        while (node != null) {
            if (moreThenTen) {
                result = new ListNode(node.val + 1);
                moreThenTen = false;
            } else {
                result = new ListNode(node.val);
            }
            node = node.next;
            result=result.next;
        }
    }


}
