package datastructure.linkedlist;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: wuxiaobing
 * @Date 2018/7/2
 **/
public class LinkedListTest {


    LinkedList linkedList = new LinkedList();

    @Before
    public void setUp() throws Exception {
        linkedList.addNode(6);
        linkedList.addNode(2);
        linkedList.addNode(7);
        linkedList.addNode(9);
        linkedList.addNode(2);
        linkedList.addNode(5);
        linkedList.addNode(2);
        linkedList.addNode(1);
        linkedList.addNode(8);
        linkedList.addNode(4);
        linkedList.addNode(8);
        linkedList.addNode(3);
        linkedList.addNode(3);
    }

    @Test
    public void deleteNode() throws Exception {
        linkedList.print();
        System.out.println(linkedList.deleteNode(1));
        linkedList.print();
    }

    @Test
    public void orderList() throws Exception {
        linkedList.print();
        linkedList.orderList();
        linkedList.print();
    }

    @Test
    public void delDuplicate1() throws Exception {
        linkedList.print();
        linkedList.delDuplicate1();
        linkedList.print();
    }

    @Test
    public void delDuplicate2() throws Exception {
        linkedList.print();
        linkedList.delDuplicate2();
        linkedList.print();
    }

    @Test
    public void findReverseKElem() throws Exception {
        linkedList.print();
        Node node = linkedList.findReverseKElem(1);
        if (node != null) {
            System.out.println(node);
        } else {
            System.out.println("wrong k value");
        }
    }

    @Test
    public void reverseLinkedList() throws Exception {
        linkedList.print();
        linkedList.reverseLinkedList();
        linkedList.print();
    }

}