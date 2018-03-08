package datastructure.leetcode;

public class Q2 {
    static boolean moreThenTen = false;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

        cur=solveRemian(cur, cur1);
        cur= solveRemian(cur, cur2);
        if(moreThenTen){
            cur.next=new ListNode(1);
        }

        return head.next;
    }

    public static ListNode solveRemian(ListNode result, ListNode node) {
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
            result.next = new ListNode(val%10);
            result = result.next;
            node = node.next;
        }
        return result;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode head1=new ListNode(0);
        ListNode head2=new ListNode(0);

        ListNode cur1=head1;
        cur1.next=new ListNode(9);
        cur1=cur1.next;
        cur1.next=new ListNode(9);
        cur1=cur1.next;
//        cur1.next=new ListNode(3);
//        cur1=cur1.next;

        ListNode cur2=head2;
        cur2.next=new ListNode(1);
        cur2=cur2.next;
//        cur2.next=new ListNode(6);
//        cur2=cur2.next;
//        cur2.next=new ListNode(4);
//        cur2=cur2.next;

        ListNode result=addTwoNumbers(head1.next,head2.next);
        printNode(result);
//        printNode(head1.next);
//        printNode(head2.next);
    }

    public static void printNode(ListNode node){
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
