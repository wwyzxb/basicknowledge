package datastructure.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wuxiaobing
 * @Date 2018/7/2
 **/
public class LinkedList {
    private Node head = null;

    /**
     * 添加节点
     *
     * @param data
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node curNode = head;
        //判断是否到达尾节点（尾节点的next指针为null）
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
        }
        //在尾节点插入新的节点
        curNode.setNext(newNode);

    }

    public int getSize() {
        int size = 0;
        Node curNode = head;
        while (curNode != null) {
            size++;
            curNode = curNode.getNext();
        }
        return size;
    }

    public boolean deleteNode(int index) {
        //检查index合法性
        if (head == null || index < 0 || index >= getSize()) {
            return false;
        }

        //处理头结点
        if (index == 0) {
            head = head.getNext();
            return true;
        }

        //需要preNode和curNode来控制节点删除
        Node preNode = head;
        Node curNode = head.getNext();
        //已经处理了头结点，所以location从索引1开始
        int location = 1;
        while (curNode != null) {
            if (location == index) {
                preNode.setNext(curNode.getNext());
                return true;
            }
            preNode = curNode;
            curNode = curNode.getNext();
            location++;
        }
        return false;
    }

    public void print() {
        List<Integer> list = new ArrayList<>();
        Node curNode = head;
        if (curNode == null) {
            System.out.println("Empty LinkedList!");
        }
        while (curNode != null) {
            list.add(curNode.getData());
            curNode = curNode.getNext();
        }
        System.out.println(list);
    }

    /**
     * 使用简单选择排序
     */
    public void orderList() {
        Node curNode = head;
        Node nextNode;
        while (curNode != null) {
            //当前遍历的节点的值为最小值(前面的节点为已排序)
            int min = curNode.getData();
            nextNode = curNode.getNext();
            while (nextNode != null) {
                //每遍历一个节点，都要比较当前节点和最小节点的值
                if (min > nextNode.getData()) {
                    min = nextNode.getData();
                    nextNode.setData(curNode.getData());
                    curNode.setData(min);
                }
                nextNode = nextNode.getNext();
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * 删除重复节点:O(n^2)
     */
    public void delDuplicate1() {
        Node curNode = head;
        while (curNode != null) {
            Node innerPreNode = curNode;
            Node innerCurNode = curNode.getNext();
            while (innerCurNode != null) {
                if (curNode.getData() == innerCurNode.getData()) {
                    innerPreNode.setNext(innerCurNode.getNext());
                }
                innerPreNode = innerCurNode;
                innerCurNode = innerCurNode.getNext();
            }
            curNode = curNode.getNext();
        }
    }

    /**
     * 删除重复节点:O(n)
     */
    public void delDuplicate2() {
        Set<Integer> dataSet = new HashSet<>();
        if (head == null) return;

        Node preNode = head;
        Node curNode = preNode.getNext();
        dataSet.add(preNode.getData());

        while (curNode != null) {
            if (dataSet.contains(curNode.getData())) {
                preNode.setNext(curNode.getNext());
            }
            dataSet.add(curNode.getData());
            preNode = curNode;
            curNode = curNode.getNext();
        }
    }

    /**
     * 找出链表中倒数第k个元素
     *
     * @param k
     * @return
     */
    public Node findReverseKElem(int k) {
        //设置两个节点
        Node curNode = head;
        Node tempNode = curNode;

        if (k <= 0 || k > getSize()) {
            return null;
        }
        //第二个节点比第一个节点先走k步
        for (int i = 0; i < k; i++) {
            tempNode = tempNode.getNext();
        }

        //接着两个节点一起向后遍历
        while (tempNode != null) {
            curNode = curNode.getNext();
            tempNode = tempNode.getNext();
        }
        return curNode;
    }

    /**
     * 翻转链表
     */
    public void reverseLinkedList() {
        //当前节点
        Node curNode = head;
        //前一个节点为null
        Node preNode = null;
        while (curNode != null) {
            //下一个节点
            Node nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode=curNode;
            curNode = nextNode;
        }
        head = preNode;
    }
}
