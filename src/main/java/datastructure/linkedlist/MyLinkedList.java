package datastructure.linkedlist;

public class MyLinkedList {
    Node head = null;

    public static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public int getLength() {
        int length = 0;
        if (head == null) return length;
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        return length + 1;
    }

    public boolean deleteNode(int index) {
        if (head == null || index < 0 || index >= getLength()) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        int location = 1;
        Node preNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            if (location == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            location++;
        }
        return false;
    }

    public void print() {
        Node tmp = head;
        if (tmp == null) {
            System.out.println("Empty LinkedList");
        }

        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println("\r\n");
    }

    public void orderList() {
        Node curNode = head;
        Node nextNode = null;
        while (curNode.next != null) {
            nextNode = curNode.next;
            int min = curNode.data;
            while (nextNode != null) {
                if (min > nextNode.data) {
                    min = nextNode.data;
                    nextNode.data = curNode.data;
                    curNode.data = min;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        linkedList.add(0);
////        linkedList.add(1);
////        linkedList.add(2);
////        linkedList.add(3);
////        System.out.println(linkedList.getLength());
////        linkedList.print();
////        linkedList.deleteNode(0);
////        linkedList.print();
////        linkedList.deleteNode(0);
////        linkedList.print();
////        linkedList.deleteNode(1);
////        linkedList.print();

        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(0);
        linkedList.orderList();
        linkedList.print();
    }
}
