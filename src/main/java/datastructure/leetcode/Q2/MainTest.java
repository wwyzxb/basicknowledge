package datastructure.leetcode.Q2;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/8
 **/
public class MainTest {
    public static void printNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);

        ListNode cur1 = head1;
        cur1.next = new ListNode(9);
        cur1 = cur1.next;
        cur1.next = new ListNode(9);
        cur1 = cur1.next;
        cur1.next = new ListNode(3);
        cur1 = cur1.next;

        ListNode cur2 = head2;
        cur2.next = new ListNode(1);
        cur2 = cur2.next;
        cur2.next = new ListNode(6);
        cur2 = cur2.next;
        cur2.next = new ListNode(7);
        cur2 = cur2.next;
        cur2.next = new ListNode(9);
        cur2 = cur2.next;

        MySolution mySolution = new MySolution();
        printNode(mySolution.addTwoNumbers(head1.next, head2.next));

        TheirSolution mySolution2 = new TheirSolution();
        printNode(mySolution2.addTwoNumbers1(head1.next, head2.next));
    }
}
