package datastructure.leetcode.Q2;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/8
 **/
public class TheirSolution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int flow = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + flow;
            flow = sum / 10;//除来获得十位数

            curr.next = new ListNode(sum % 10);//取余获得个位数
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flow > 0) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }


    /**tips：
     * 1.在while循环中外面使用一个carry变量，既可以表示和也可以表示是否需要进位
     * 2.两个数相加可以使用除(/)获得十位数，取余(%)获得个位数
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            //如果l1不为null，则参与计算,使用carry累加求和
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            //如果l2不为null，则参与计算,使用carry累加求和
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);//取个位数来新建节点
            carry /= 10;//是否需要进位
            p = p.next;
        }
        return dummy.next;//返回新链表的头结点
    }
}
