package datastructure.linkedlist;

import lombok.Data;

/**
 * @Author: wuxiaobing
 * @Date 2018/7/2
 **/
@Data
public class Node {
    private int data;
    private Node next=null;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
